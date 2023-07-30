package com.websitedungcuthethao.util;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

@Component
public class LuuAnh {
	public void luuAnh(CommonsMultipartFile multipartFile,HttpSession session ) throws IOException {
		ServletContext context= session.getServletContext();
		String fileName= multipartFile.getOriginalFilename();
		String path= context.getRealPath("/resources/images/user/sanpham");
		String filePath= path+ File.separator+fileName;
		byte[] bytes= multipartFile.getBytes();
		BufferedOutputStream stream;
		try {
			stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
			stream.write(bytes);
			stream.flush();
			stream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
