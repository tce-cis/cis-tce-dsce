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
import org.dsce.tce.cis.bean.Research;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.Syllabus;

public class ExcelSheetReader {

	JDBCUtil jdbcUtil;

	public ExcelSheetReader() {
		jdbcUtil = new JDBCUtil();
	}

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
		// excelReader.readPublicationSheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/subjects.xlsx  ";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		//excelReader.readSubjectDetails(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();
		
		excelFilePath = "data/research.xlsx  ";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readResearchDetailsSheet(workbook.getSheetAt(0));
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
					case 8:
						faculty.setSalutation(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			facultyList.add(faculty);
		}
		// System.out.println(new Gson().toJson(facultyList));
		//jdbcUtil.persistFacultyData(facultyList);
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
		// System.out.println(new Gson().toJson(publicationList));
		//jdbcUtil.persistPublicationData(publicationList);
	}

	private void readSubjectDetails(Sheet subjectDetail) {
		Iterator<Row> iterator = subjectDetail.iterator();
		List<Subject> subjectlist = new ArrayList<>();
		int cellCount;
		Subject subject = new Subject();
		while (iterator.hasNext()) {

			cellCount = 1;

			subject = new Subject();
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						subject.setName(cell.getStringCellValue().trim());
						break;
					case 2:
						subject.setCode(cell.getStringCellValue().trim());
						break;
					case 3:
						subject.setIaMarks(cell.getStringCellValue().trim());
						break;
					case 4:
						subject.setExamHours(cell.getStringCellValue().trim());
						break;
					case 5:
						subject.setHoursPerWeek(cell.getStringCellValue().trim());
						break;
					case 6:
						subject.setTotalHours(cell.getStringCellValue().trim());
						break;
					case 7:
						subject.setExamMarks(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			subjectlist.add(subject);
			System.out.println();
		}
		// System.out.println(new Gson().toJson(subjectlist));

		//jdbcUtil.persistSubjectList(subjectlist);
	}
		private void readResearchDetailsSheet(Sheet researchSheet) {
			Iterator<Row> iterator = researchSheet.iterator();
			List<Research> researchList = new ArrayList<>();
			int cellCount;
			Research research = new Research();
			while (iterator.hasNext()) {

				cellCount = 1;

				research = new Research();
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						switch (cellCount) {
						case 1:
							research.setTitle(cell.getStringCellValue().trim());
							break;
						case 2:
							research.setDescription(cell.getStringCellValue().trim());
							break;
						case 3:
							research.setName1(cell.getStringCellValue().trim());
							break;
						case 4:
							research.setName2(cell.getStringCellValue().trim());
							break;
						case 5:
							research.setFunding(cell.getStringCellValue().trim());
							break;
						case 6:
							research.setYear(cell.getStringCellValue().trim());
							break;
						
						}
					default:
						break;
					}
					cellCount++;
				}
				researchList.add(research);
			}
			// System.out.println(new Gson().toJson(researchList));
			jdbcUtil.persistResearchData(researchList);
		}



	

		private void readSyllabusDetailsSheet(Sheet syllabusSheet) {
			Iterator<Row> iterator = syllabusSheet.iterator();
			List<Syllabus> syllabusList = new ArrayList<>();
			int cellCount;
			Syllabus syllabus = new Syllabus();
			while (iterator.hasNext()) {

				cellCount = 1;

				syllabus = new Syllabus();
				Row nextRow = iterator.next();
				Iterator<Cell> cellIterator = nextRow.cellIterator();

				while (cellIterator.hasNext()) {

					Cell cell = cellIterator.next();
					cell.setCellType(Cell.CELL_TYPE_STRING);
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						switch (cellCount) {
						case 1:
							syllabus.setName(cell.getStringCellValue().trim());
							break;
						case 2:
							syllabus.setpart(cell.getStringCellValue().trim());
							break;
						case 3:
							syllabus.setunit(cell.getStringCellValue().trim());
							break;
						case 4:
							syllabus.setunitTitle(cell.getStringCellValue().trim());
							break;
						case 5:
							syllabus.setUnitDescription(cell.getStringCellValue().trim());
							break;
						case 6:
							syllabus.setunitHours(cell.getStringCellValue().trim());
							break;
						}
					default:
						break;
					}
					cellCount++;
				}
				syllabusList.add(syllabus);
				for (Syllabus member : syllabusList) {
					System.out.println(member.getName());
				}
				System.out.println();
			}
			// System.out.println(new Gson().toJson(syllabusList));

			// Caution(Chetan): Never run below method again
			// JDBCUtil.persistFacultyData(facultyList);
		}
		
	}

