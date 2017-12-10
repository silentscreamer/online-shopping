package com.saquib.onlineshopping.Utils;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtility {

	private static final String ABS_PATH = "/Users/saquibali/online-shopping/onlineshopping/src/main/webapp/assets/images/";
	private static String REAL_PATH = "";

	private static final Logger log = LoggerFactory.getLogger(FileUploadUtility.class);

	public static void uploadFile(HttpServletRequest request, MultipartFile file, String name) {
		// TODO Auto-generated method stub
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");

		log.info(REAL_PATH);

		if (!new File(ABS_PATH).exists()) {

			new File(ABS_PATH).mkdirs();

		}
		if (!new File(REAL_PATH).exists()) {

			new File(REAL_PATH).mkdirs();

		}

		try {
			file.transferTo(new File(ABS_PATH + name +".jpg"));
			file.transferTo(new File(REAL_PATH +name+".jpg"));
			
			
		} catch (IOException e) {
			// TODO: handle exception
		}
		
		
	}

}
