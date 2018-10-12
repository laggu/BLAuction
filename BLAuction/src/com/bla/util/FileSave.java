package com.bla.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.web.multipart.MultipartFile;

public class FileSave {
	public static void save(String dir, MultipartFile mp, String imgname) {
		byte[] data;
		try {
			data = mp.getBytes();
			File f = new File(dir);
			if(!f.exists()) {
				f.mkdirs();
			}
			File f2 = new File(dir+"\\"+imgname);
			FileOutputStream out = new FileOutputStream(f2);
			out.write(data);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
