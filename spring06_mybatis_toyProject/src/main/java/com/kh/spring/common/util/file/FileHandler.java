package com.kh.spring.common.util.file;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.file.FileSystems;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.PathResource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


public class FileHandler {

	
	@GetMapping("/download")
	public ResponseEntity<UrlResource> downloadFile(FileDTO file) throws UnsupportedEncodingException, URISyntaxException, MalformedURLException {
		
		UrlResource resource = new UrlResource(new URI(file.getLink()));
		
		
		ResponseEntity<UrlResource> response =
				ResponseEntity.ok().header("Content-Disposition","attachement; filename=" +URLEncoder.encode(file.getOriginFileName() ,"UTF-8"))
				.body(resource);
				
		
		
		return response;
	}
}
