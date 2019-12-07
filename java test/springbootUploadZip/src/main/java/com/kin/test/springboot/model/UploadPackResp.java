package com.kin.test.springboot.model;

import lombok.Data;

import java.util.List;

/**
 * @Author WinKinWong
 * @Description 上传压缩包返回参数模板
 * @Date 2019/11/13 10:33
 **/
@Data
public class UploadPackResp {
    /**
     * 返回添加的所有goodsId文件名
     */
    private String[] goodsFiles;

    /**
     * 返回添加文件中存在重复的文件夹名
     */
    private List<String> reGoodsFiles;

    /**
     * 返回解压的临时路径
     */
    private String momentPath;

    /**
     * 返回区域id
     */
    private Integer partionId;

    /**
     * 上传的商品总数
     */
    private Integer goodsTotal;

}
