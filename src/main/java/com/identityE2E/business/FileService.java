package com.identityE2E.business;

import java.util.List;

import com.identityE2E.persistence.domain.File;

public interface FileService {
	List<File> getAllFiles();
}
