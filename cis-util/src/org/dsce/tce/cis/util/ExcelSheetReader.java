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
import org.dsce.tce.cis.bean.Publication;

import com.google.gson.Gson;

public class ExcelSheetReader {

	public static void main(String[] args) throws IOException {
		ExcelSheetReader excelReader = new ExcelSheetReader();
		String excelFilePath = "data/faculty_details.xlsx";
		FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
		Workbook workbook = new XSSFWorkbook(inputStream);
		excelReader.readFacultyDetailsSheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/publication.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readPublicationSheet(workbook.getSheetAt(0));
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
		}
		System.out.println(new Gson().toJson(facultyList));
		JDBCUtil.persistFacultyData(facultyList);
	}

	private void readPublicationSheet(Sheet publicationsSheet) {
		Iterator<Row> iterator = publicationsSheet.iterator();
		List<Publication> publicationList = new ArrayList<>();
		int cellCount;
		Publication publication = new Publication();
		while (iterator.hasNext()) {

			cellCount = 1;

			publication = new Publication();
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						// publication.setTitle(cell.getStringCellValue().trim());
						break;
					case 2:
						publication.setTitle(cell.getStringCellValue().trim());
						break;
					case 3:
						publication.setJournal(cell.getStringCellValue().trim());
						break;
					case 4:
						publication.setPrimaryAuthor(cell.getStringCellValue().trim());
						break;
					case 5:
						publication.setCoAuthors(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			publicationList.add(publication);
			System.out.println();
		}
		System.out.println(new Gson().toJson(publicationList));
		JDBCUtil.persistPublicationData(publicationList);
	}
}
