package com.identityE2E.business;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.identityE2E.persistence.domain.File;

public class FileServiceImpl implements FileService {
	
	Logger LOGGER =  Logger.getLogger(FileService.class);

	@Override
	public List<File> getAllFiles() {
		List<File> fileList = new ArrayList<>();
		return fileList;
	}

	
	
}
