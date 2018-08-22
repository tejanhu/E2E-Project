package com.identityE2E.persistence.repositories;

import java.io.File;
import java.util.List;

public interface FileStorage {
	List<File> getAllFiles();

	List<File> getByMimeType(String mimeType);

	List<File> getExcelFiles();

	List<File> getByFileExtension(String fileExtension);
}
