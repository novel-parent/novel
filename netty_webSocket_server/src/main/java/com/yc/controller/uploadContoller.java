package com.yc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class uploadContoller {
	
	public Object UploadFile(@RequestParam("")MultipartFile file) {
		
		System.out.println(file.getOriginalFilename()+"====================================");
		
		return "";
	}
}
