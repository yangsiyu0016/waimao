package com.wg.waimao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wg.waimao.config.UserLoginToken;
import com.wg.waimao.service.ImageService;

/**
 * 上传图片接口
 * @author zhanghaicheng
 *
 */
@RestController
@RequestMapping("image")
public class ImagController {
	
	@Autowired
	private ImageService imageService;
	
	
	/**
	 * 
	 * @param file 文件对象
	 * @param table 表名
	 * @param col  对应字段 （多张图片的表使用，单张图片不使用该参数）
	 */
//	@UserLoginToken
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public List<String> uploadFile(@RequestBody MultipartFile[] files) {
		
		return imageService.uploadFile(files);
	}


}
