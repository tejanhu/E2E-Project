package com.identityE2E.persistence.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class File {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String fileName;
	private String mimeType;
	private String fileExtension;
	
	public File() {
		
	}
	
	public String getFileName() {
		return fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public String getFileExtension() {
		return fileExtension;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public void setFileExtension(String fileExtension) {
		this.fileExtension = fileExtension;
	}

	
	
}
