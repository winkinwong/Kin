package com.kin.web.myphoto.pc.photoWall.service;

import com.kin.web.myphoto.global.ResultBean;
import com.kin.web.myphoto.pc.photoWall.entity.Images;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kin.web.myphoto.pc.photoWall.req.UploadImgReq;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Kin
 * @since 2020-02-02
 */
public interface IImagesService extends IService<Images> {
    ResultBean uploadImgHandle(UploadImgReq req);
}
