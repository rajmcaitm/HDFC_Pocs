package com.hdfc.Controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.hdfc.entities.FileDB;
import com.hdfc.message.ResponseFile;
import com.hdfc.message.ResponseMessage;
import com.hdfc.service.FileStorageService;

@Controller
@CrossOrigin("http://localhost:8081")
public class FileController {

  @Autowired
  private FileStorageService storageService;

  @PostMapping("/upload/{refNo}")
  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,@PathVariable String refNo) {
    String message = "";
    try {
    	
      storageService.store(file,refNo);
      message = "Uploaded the file successfully: " + file.getOriginalFilename();
      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
    } catch (Exception e) {
      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
      return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(new ResponseMessage(message));
    }
  }

  @GetMapping("/files")
  public ResponseEntity<List<ResponseFile>> getListFiles() {
    List<ResponseFile> files = storageService.getAllFiles().map(dbFile -> {
      String fileDownloadUri = ServletUriComponentsBuilder
          .fromCurrentContextPath()
          .path("/files/")
         // .path(dbFile.getId())   String.valueOf(i)
          .path(String.valueOf(dbFile.getId()))
          .toUriString();

      return new ResponseFile(
          dbFile.getName(),
          fileDownloadUri,
          dbFile.getType(),
          dbFile.getData().length);
    }).collect(Collectors.toList());

    return ResponseEntity.status(HttpStatus.OK).body(files);
  }

  @GetMapping("/files/{id}")
  public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
	  FileDB fileDB = storageService.getFile(id);
    return ResponseEntity.ok()
        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
        .body(fileDB.getData());
  }
  
	@GetMapping("/refNo")
	public ResponseEntity<String> generateRefNo() {

		String refNo = this.generate();
		return new ResponseEntity<String>(refNo, HttpStatus.CREATED);

	}

	public int generateLeadId() {
		Random random = new Random();
		return random.nextInt(10000);
	}

	public String generate() {
		return "N" + this.generateLeadId();
	}
}