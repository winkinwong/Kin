package com.kin.web.myphoto.pc.photoWall.controller;


import com.kin.web.myphoto.exception.Error;
import com.kin.web.myphoto.exception.UserException;
import com.kin.web.myphoto.global.ResultBean;


import com.kin.web.myphoto.global.ThreadLocalHelper;
import com.kin.web.myphoto.pc.accountManager.entity.User;
import com.kin.web.myphoto.pc.photoWall.req.UploadImgReq;
import com.kin.web.myphoto.pc.photoWall.service.IImagesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.kin.web.myphoto.base.BaseController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Kin
 * @since 2020-02-02
 */
@RestController
@RequestMapping("/photoWall/images")
public class ImagesController extends BaseController {
    private static final Logger logger= LoggerFactory.getLogger(ImagesController.class);

    @Resource
    private IImagesService imagesService;
    //1.上传图片
    @PostMapping("/uploadImg")
    public ResultBean uploadImg(UploadImgReq req, HttpServletRequest request){
        logger.info("图片上传,files[]=",req.getFiles());
        User user =ThreadLocalHelper.getSessionUser();
        if (user==null){
            throw new UserException(Error.USER_LOGOUT);
        }
        req.setUserId(user.getUserId());
        req.setUserName(user.getUserName());
        req.setUploaderIp(request.getRemoteAddr());
        return imagesService.uploadImgHandle(req);
    }
    //2.展示所有图片
    //3.展示个人上传图片（既个人照片墙）
    //4.删除图片
}
