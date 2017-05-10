package org.dsce.tce.cis.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.dsce.tce.cis.bean.Faculty;

import com.google.gson.Gson;

public class ExcelToJsonConvetor {

	public static void main(String[] args) throws IOException {
		ExcelToJsonConvetor excelReader = new ExcelToJsonConvetor();
		String excelFilePath = "data/faculty_details.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

		Workbook workbook = new XSSFWorkbook(inputStream);
		excelReader.readFacultyDetailsSheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

	}

	private void readFacultyDetailsSheet(Sheet facultySheet) {
		Iterator<Row> iterator = facultySheet.iterator();
		List<Faculty> facultyList = new ArrayList<>();
		int cellCount;
		Faculty faculty = new Faculty();
		while (iterator.hasNext()) {

			cellCount = 1;

			faculty = new Faculty();
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						faculty.setName(cell.getStringCellValue().trim());
						break;
					case 2:
						faculty.setDesignation(cell.getStringCellValue().trim());
						break;
					case 3:
						faculty.setEducationalQualification(cell.getStringCellValue().trim());
						break;
					case 4:
						faculty.setExperienceYears(cell.getStringCellValue().trim());
						break;
					case 5:
						faculty.setSpecialization(cell.getStringCellValue().trim());
						break;
					case 6:
						faculty.setEmailId(cell.getStringCellValue().trim());
						break;
					case 7:
						faculty.setPhoneNumber(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			facultyList.add(faculty);
			for (Faculty member : facultyList) {
				System.out.println(member.getEmailId());
			}
			System.out.println();
		}
		System.out.println(new Gson().toJson(facultyList));

		// Caution(Chetan): Never run below method again
		// JDBCUtil.persistFacultyData(facultyList);
	}
}
