package com.kin.test.springboot.service.imp;



import com.kin.test.springboot.base.UploadBaseResp;
import com.kin.test.springboot.base.FileTypeEnum;
import com.kin.test.springboot.model.UploadPackReq;
import com.kin.test.springboot.model.UploadPackResp;
import com.kin.test.springboot.service.FileUploadService;
import com.kin.test.springboot.util.UUIDUtil;
import com.kin.test.springboot.util.UnPackeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.ArrayUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author WinKinWong
 * @Description 上传压缩包实现类
 * @Date 2019/11/12 16:46
 **/
@Service
@Slf4j
public class FileUploadServiceImpl implements FileUploadService {


    //接收参数需求： 区域号 partion_id ,解压密码（可以为空）
    @Override
    public UploadBaseResp<UploadPackResp> handlerUpload(MultipartFile zipFile, UploadPackReq req) {
        String zipFileName = zipFile.getOriginalFilename();
        zipFileName = zipFileName.substring(0,zipFileName.indexOf("."));
        System.out.println(zipFileName);
        //先创建临时路径存放上传的压缩包(临时路径使用UUID)方法结束需要返回临时路径名,确认接口需要从该文件夹复制文件并执行删除操作
        String pathName=UUIDUtil.getUUIDString();
        //String momentPath = "E:\\Kin\\desktop\\uploadFileMoment\\"+pathName;
        String momentPath =System.getProperty("user.dir")+File.separator+pathName;
        //用于存放有重复的文件夹名
        List<String>reGoodsFiles=new ArrayList<>();
        //创建临时路径
        File momentFile = new File(momentPath);
        if(!momentFile.exists()){
            momentFile.mkdir();
        }
        //解压压缩包
        if (null == zipFile) {
            return UploadBaseResp.createFail("请上传压缩文件!");
        }
        boolean isZipPack = true;
        String fileContentType = zipFile.getContentType();
        //将压缩包保存在指定路径
        String packFilePath = momentPath + File.separator + zipFile.getOriginalFilename();
        if (FileTypeEnum.FILE_TYPE_ZIP.type.equals(fileContentType)) {
            //zip解压缩处理
        } else if (FileTypeEnum.FILE_TYPE_RAR.type.equals(fileContentType)) {
            //rar解压缩处理
            isZipPack = false;
        } else {
            return UploadBaseResp.createFail("上传的压缩包格式不正确,仅支持rar和zip压缩文件!");
        }
        File packfile = new File(packFilePath);
        try {
            zipFile.transferTo(packfile);
        } catch (IOException e) {
            log.error("zip file save to " + momentPath + " error", e.getMessage(), e);
            return UploadBaseResp.createFail("保存压缩文件到:" + momentPath + " 失败!");
        }
        if (isZipPack) {
            //zip压缩包
            UnPackeUtil.unPackZip(packfile, req.getPassword(), momentPath);
            //解压完成后删除压缩包
            packfile.delete();
        } else {
            //rar压缩包
            UnPackeUtil.unPackRar(packfile,momentPath);
            //删除压缩包
            packfile.delete();
        }
        //判断解压出来每张图片大小是否超过100k，若有则直接返回错误信息提示用户重新打包（遍历所有文件判断大小是否超过100kb）
        try {
            UnPackeUtil.readfile(momentPath+File.separator+ req.getPartionId());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取压缩包子父级目录文件夹名即goodsId
        File partionFile = new File(momentPath+File.separator+ req.getPartionId());
        String[] goodsFiles = partionFile.list();
        //先判断是否存在目标文件夹,若无则新建目标文件夹
        File destFile = new File(req.getDestPath()+File.separator+ req.getPartionId());
        if(!destFile.exists()){
            destFile.mkdir();
        }else {
            //若存在目标文件夹,则比较目标文件夹下是否存在相同goodsId文件夹,若有则存放到列表中记录,并且作出标记提示是否需要覆盖(复制操作需调用后续确认接口完成)
            String[] destlist = destFile.list();
            if(destlist.length>0){
                for(String file:goodsFiles){
                    if(ArrayUtils.contains(destlist,file)){
                        reGoodsFiles.add(file);
                    }
                }
            }
        }
        //封装返回参数
        UploadPackResp resp = new UploadPackResp();
        //若没有存在相同goodsId文件夹,则也需返回需要添加的文件名(便于数据库记录，无论是否有重复值都需要记录添加记录goodsFiles)(这里其实判断reFileName长度即可知道是否存在重复值)
        if (reGoodsFiles.size()>0){
            resp.setReGoodsFiles(reGoodsFiles);
        }
        resp.setGoodsFiles(goodsFiles);
        resp.setGoodsTotal(goodsFiles.length);
        resp.setMomentPath(momentPath);
        //TODO 无论是否存在重复文件夹名都不执行复制操作,统一在确认接口执行
        return UploadBaseResp.createSuccess("解压成功",resp);
    }

    @Override
    public UploadBaseResp<String> readFile(UploadPackReq param) throws IOException {
        UnPackeUtil.readfile(param.getDestPath());
        return UploadBaseResp.createSuccess("读取成功","success");
    }
}