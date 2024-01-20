package com.hdfc.fileUpload;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

	private static String UPLOADED_FOLDER = "D:\\myproject\\onlineinternetbanking\\src\\main\\resources\\";

	public void store(MultipartFile file) throws IOException {
		
		//to get the current working directory
		//String userDirectory = System.getProperty("user.dir");
        //System.err.println(userDirectory);
		
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes);

	}

}