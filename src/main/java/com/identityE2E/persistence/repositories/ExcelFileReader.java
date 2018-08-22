package com.identityE2E.persistence.repositories;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.identityE2E.persistence.domain.Vehicle;


public class ExcelFileReader {
	
	final static Logger LOGGER = Logger.getLogger(ExcelFileReader.class);

	private Object getCellValue(Cell cell) {
	    switch (cell.getCellType()) {
	    case Cell.CELL_TYPE_STRING:
	        return cell.getStringCellValue();
	 
	    case Cell.CELL_TYPE_BOOLEAN:
	        return cell.getBooleanCellValue();
	 
	    case Cell.CELL_TYPE_NUMERIC:
	        return cell.getNumericCellValue();
	    }
	 
	    return null;
	}
	
	
	public List<Vehicle> readVehiclesFromExcelFile(String excelFilePath) throws IOException {
		LOGGER.debug("retrieving vehicles from :" + excelFilePath);
	    List<Vehicle> vehiclesList = new ArrayList<>();
	    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
	 
	    Workbook workBook = new XSSFWorkbook(inputStream);
	    Sheet firstSheet = workBook.getSheetAt(0);
	    Iterator<Row> iterator = firstSheet.iterator();
	 
	    while (iterator.hasNext()) {
	        Row nextRow = iterator.next();
	        Iterator<Cell> cellIterator = nextRow.cellIterator();
	        Vehicle vehicle = new Vehicle();
	 
	        while (cellIterator.hasNext()) {
	            Cell nextCell = cellIterator.next();
	            int columnIndex = nextCell.getColumnIndex();
	 
	            switch (columnIndex) {
	            case 0:
	            	vehicle.setRegNo((String) getCellValue(nextCell));
	                break;
	            case 3:
	            	vehicle.setColour((String) getCellValue(nextCell));
	                break;
	            case 6:
	            	vehicle.setMake((String) getCellValue(nextCell));
	                break;
	            }
	        }
	        vehiclesList.add(vehicle);
	     }
	 
	    workBook.close();
	    inputStream.close();
	 
	    return vehiclesList;
	}
}
