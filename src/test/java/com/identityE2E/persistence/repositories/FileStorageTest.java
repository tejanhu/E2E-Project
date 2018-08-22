package com.identityE2E.persistence.repositories;

import java.io.File;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.identityE2E.constants.*;


public class FileStorageTest {
	private FileStorageImpl fStorage;
	final static Logger LOGGER = Logger.getLogger(FileStorageTest.class);

	
	
	
	
	@Before
	public void setup() {
		fStorage = new FileStorageImpl();
	}  
	
	@Test
	public void evaluateTotalFileSize() {
		Assert.assertEquals(Constants.TOTAL_NO_FILES, fStorage.getAllFiles().size());
	}
	 

	private boolean evaluateFileNameFound(String fileName) {
		List<File> fileList = fStorage.getLoadedFiles();
		for(File file : fileList) {
			
			LOGGER.debug("file expected: " + fileName);
			LOGGER.debug("actual file: " + file.getName());
			if(file.getName().equals(fileName)) {
				return true;  
			} 
		}  
		return false;
	}
	  
	@Test
	public void verifySampleCSVExists() {
		fStorage.getAllFiles();
		Assert.assertTrue(evaluateFileNameFound(Constants.TEST_FILE[0]));
	}
	
	@Test
	public void verifyVehicleDataExists() {
		fStorage.getAllFiles();
		Assert.assertTrue(evaluateFileNameFound(Constants.TEST_EXCEL_FILE[0]));
	}
	
	@Test
	public void verifyFilesWithMimeTypeTotalSize() {
		fStorage.getAllFiles();
		List<File> filesWithMimeType = fStorage.getByMimeType("application/vnd.ms-excel");
		Assert.assertEquals(Constants.TOTAL_NO_EXCEL_FILES, filesWithMimeType.size());
	}
	
	
}
