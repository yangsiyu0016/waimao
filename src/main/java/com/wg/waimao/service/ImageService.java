package com.wg.waimao.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wg.waimao.controller.ProductController;
@Service
public class ImageService {
	
	 protected static final Logger logger = LoggerFactory.getLogger(ImageService.class);
		

	public List<String> uploadFile(MultipartFile[] files) {
		logger.info("图片数量：" + files.length);
		List<String> results = new ArrayList<>();
		try {
			   //创建文件在服务器端存放路径
			   String dir = "/java/upload";
			   File fileDir = new File(dir);
			   if(!fileDir.exists()) {
			    fileDir.mkdirs();
			   }
			   //生成文件在服务器端存放的名字
			   for(int i=0;i<files.length;i++) {
			   String fileSuffix = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().lastIndexOf("."));
			   String fileName=UUID.randomUUID().toString()+fileSuffix;
			   
			   File file = new File(fileDir+"/"+fileName);
			   //上传
			   files[i].transferTo(file);
			   results.add(file.getName());
			   logger.info("图片路径：" + file.getName());
			   }
			   
			  } catch (Exception e) {
			   e.printStackTrace();
			   return null;
			  }
			  return results;

		
	}

}
