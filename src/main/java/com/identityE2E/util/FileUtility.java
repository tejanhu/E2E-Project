package com.identityE2E.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileUtility {

	public String getMimeType(File file) {
		String mimeType;
		try {
			mimeType= Files.probeContentType(file.toPath());
		}
		catch (IOException ex){
			mimeType = null;
		}
		return mimeType;
	}
	
	public String getFileName(File file) {
		return file.getName();
	}
	
	public String getFileSize(File file) {
		String size = "" + file.length() + "bytes";
		return size;
	}
	
	public String getFileExtension(File file) {
		String fileExtension = "";

		int i = file.getName().lastIndexOf('.');
		if (i > 0) {
			fileExtension = file.getName().substring(i+1);
		}
		return fileExtension;
	}
	
	public String getAllInfo(File file) {
		String fileName = getFileName(file);
		String fileExtension = getFileExtension(file);
		String fileSize = getFileSize(file);
		String mimeType = getMimeType(file);
		
//		return "File: name: '"+ fileName + "' extension: '" + fileExtension + "' size: '" + fileSize + "' mime-type: '" + mimeType + "'" ; 
		return "File: name: "+ fileName + " extension: " + fileExtension + " size: " + fileSize + " mime-type: " + mimeType + "" ; 
	}
	
	public String convertFilesListToString(List<File> filesList){
		String stringifiedFilesList = "";
		
		for(File file: filesList) {
			stringifiedFilesList += getAllInfo(file) + "\n";
		}
		
		return stringifiedFilesList;
	}
}
