package com.identityE2E.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.tika.Tika;

import com.identityE2E.persistence.repositories.ExcelFileReader;

public class FileUtility {
	
	final static Logger LOGGER = Logger.getLogger(FileUtility.class);
	
	private Tika tikaObj = new Tika();


	public String getMimeType(File file) {
		LOGGER.info("In FileUtility getMimeType of" + file.getName());
		String mimeType;
		try {
			mimeType = tikaObj.detect(file);
			if(mimeType.equals("application/octet-stream")){
				mimeType = "application/vnd.ms-excel";
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
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
		return "\n"+"File: name: "+ fileName +"\n"+ " extension: " + fileExtension + "\n" +" size: " + fileSize +"\n" + " mime-type: " + mimeType + "" ; 
	}
	
	public String convertFilesListToString(List<File> filesList){
		String stringifiedFilesList = "";
		
		for(File file: filesList) {
			stringifiedFilesList += getAllInfo(file) + "\n";
		}
		
		return stringifiedFilesList;
	}
}
