package com.kin.web.myphoto.pc.photoWall.controller;


import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import com.kin.web.myphoto.base.BaseController;

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

    //1.上传图片
    //2.展示所有图片
    //3.展示个人上传图片（既个人照片墙）
    //4.删除图片
}
