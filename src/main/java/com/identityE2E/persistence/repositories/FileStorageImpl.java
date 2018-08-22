package com.identityE2E.persistence.repositories;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

import com.identityE2E.util.FileUtility;




public class FileStorageImpl implements FileStorage{

	final static Logger LOGGER = Logger.getLogger(FileStorage.class);
	private FileUtility fileUtility = new FileUtility();
	
	private enum Paths {
	    TEST_FILES("src/main/resources/FilesToBeTested");
		
		private final String fileName;

		private Paths(String s) {
			fileName = s;
		}
	    public String toString() {
	        return this.fileName;
	    }
	}
	  
	private List<File> filesLoaded;


	public List<File> getAllFiles(){
		String path = Paths.TEST_FILES.toString();
	
		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("In getAllFiles loading from " + path);
		}
		
		File directory = new File(path);
		
		filesLoaded = Arrays.asList(directory.listFiles());

		if(LOGGER.isDebugEnabled()){
			LOGGER.debug("In getAllFiles the following files were loaded: " + fileUtility.convertFilesListToString(filesLoaded));
		}
		return filesLoaded;
	}
	
	public List<File> getLoadedFiles(){
		return filesLoaded;
	}
	

	public List<File> getByMimeType(String mimeType){
		if(getLoadedFiles().size() == 0) {
			getAllFiles();
		}
		List<File> allFiles = getLoadedFiles();
		
		LOGGER.debug("the following files were loaded: " + fileUtility.convertFilesListToString(allFiles));
		
		LOGGER.debug("searching for files with mimeType : " + mimeType);
		List<File> filesWithMimeType = new ArrayList<File>();
		
		for(File file: allFiles) {
			String fileMimeType = fileUtility.getMimeType(file);
			LOGGER.debug("searching : " + file + ": mime type: " + fileUtility.getMimeType(file));
			if(fileMimeType.equals(mimeType)){
				filesWithMimeType.add(file);
			}
		}
		
		LOGGER.debug("the following files wtih mime type returned are : "+ filesWithMimeType);
		return filesWithMimeType;
	}
	

	public List<File> getExcelFiles(){
		List<File> excelFiles = new ArrayList<File>();
		
		excelFiles.addAll(getByMimeType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
		excelFiles.addAll(getByMimeType("application/vnd.ms-excel"));
		excelFiles.addAll(getByMimeType("application/msexcel"));
		excelFiles.addAll(getByMimeType("application/x-msexcel"));
		excelFiles.addAll(getByMimeType("application/octet-stream"));
		
		LOGGER.debug("the excel files returned are :" + excelFiles);
		return excelFiles;

	}

	public List<File> getByFileExtension(String fileExtension){
		List<File> allFiles;
		allFiles = getAllFiles(); 
		 
		List<File> filesWithExtension = new ArrayList<File>();
		
		for(File file: allFiles) {
			if(fileUtility.getFileExtension(file).equals(fileExtension)) {
				filesWithExtension.add(file);
			}	
		}
		
		return filesWithExtension;
	}
	
	
}
