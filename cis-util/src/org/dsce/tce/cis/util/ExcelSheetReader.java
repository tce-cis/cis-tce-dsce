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
import org.dsce.tce.cis.bean.Company;
import org.dsce.tce.cis.bean.Faculty;
import org.dsce.tce.cis.bean.Publication;
import org.dsce.tce.cis.bean.Research;
import org.dsce.tce.cis.bean.Student;
import org.dsce.tce.cis.bean.Subject;
import org.dsce.tce.cis.bean.SubjectScore;
import org.dsce.tce.cis.bean.SubjectUnit;

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

		excelFilePath = "data/faculty_details.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readPublicationSheet(workbook.getSheetAt(1));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/subjects.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readSubjectDetails(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/subjects.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));

		workbook = new XSSFWorkbook(inputStream);
		excelReader.readSubjectUnitsSheet(workbook.getSheetAt(1));
		// for (int i = 1; i < workbook.getNumberOfSheets(); i++) { }
		workbook.close();
		inputStream.close();

		excelFilePath = "data/results.xlsx";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readResultsSheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/research.xlsx  ";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readResearchDetailsSheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

		excelFilePath = "data/placements.xlsx  ";
		inputStream = new FileInputStream(new File(excelFilePath));
		workbook = new XSSFWorkbook(inputStream);
		excelReader.readCompanySheet(workbook.getSheetAt(0));
		workbook.close();
		inputStream.close();

	}

	private void readCompanySheet(Sheet placementsSheet) {
		Iterator<Row> iterator = placementsSheet.iterator();
		List<Company> companyList = new ArrayList<>();
		int cellCount;
		Company company = new Company();
		while (iterator.hasNext()) {

			cellCount = 1;

			company = new Company();
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						company.setName(cell.getStringCellValue().trim());
						break;
					case 2:
						company.setNoOffers(Integer.parseInt(cell.getStringCellValue().trim()));
						break;
					case 3:
						company.setCtc(Float.parseFloat(cell.getStringCellValue().trim()));
						break;
					case 4:
						company.setCompanyType(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			companyList.add(company);
		}
		// System.out.println(new Gson().toJson(researchList));
		jdbcUtil.persistCompanyData(companyList);
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
						research.setPiNameDesignation(cell.getStringCellValue().trim());
						break;
					case 4:
						research.setCoPiNameDesignation(cell.getStringCellValue().trim());
						break;
					case 5:
						research.setFundingAgencyAndAmount(cell.getStringCellValue().trim());
						break;
					case 6:
						research.setStartYearEndYear(cell.getStringCellValue().trim());
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
		jdbcUtil.persistFacultyData(facultyList);
	}

	/**
	 * @author Chetan Gorkal
	 * @param publicationsSheet
	 */
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
						publication.setPrimaryAuthor(cell.getStringCellValue().trim());
						break;
					case 2:
						publication.setTitle(cell.getStringCellValue().trim());
						break;
					case 3:
						publication.setJournal(cell.getStringCellValue().trim());
						break;
					case 4:
						publication.setCoAuthors(cell.getStringCellValue().trim());
						break;
					default:
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			publicationList.add(publication);
		}
		jdbcUtil.persistPublicationData(publicationList);
	}

	/**
	 * @author Asha R Adiga
	 * @param subjectSheet
	 */
	private void readSubjectDetails(Sheet subjectSheet) {
		Iterator<Row> iterator = subjectSheet.iterator();
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
		}

		jdbcUtil.persistSubjectList(subjectlist);
	}

	private void readSubjectUnitsSheet(Sheet syllabusSheet) {
		Iterator<Row> iterator = syllabusSheet.iterator();
		List<SubjectUnit> subjectUnitList = new ArrayList<>();
		int cellCount;
		SubjectUnit syllabus = new SubjectUnit();
		while (iterator.hasNext()) {
			cellCount = 1;
			syllabus = new SubjectUnit();
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						syllabus.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 2:
						syllabus.setPart(cell.getStringCellValue().trim());
						break;
					case 3:
						syllabus.setUnit(cell.getStringCellValue().trim());
						break;
					case 4:
						syllabus.setUnitTitle(cell.getStringCellValue().trim());
						break;
					case 5:
						syllabus.setUnitDescription(cell.getStringCellValue().trim());
						break;
					case 6:
						syllabus.setUnitHours(cell.getStringCellValue().trim());
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			subjectUnitList.add(syllabus);
		}
		jdbcUtil.persistSubjectUnitsData(subjectUnitList);
	}

	private void readResultsSheet(Sheet resultsSheet) {
		Iterator<Row> iterator = resultsSheet.iterator();
		List<Student> studentsList = new ArrayList<>();
		int cellCount;
		Student student = new Student();
		SubjectScore subjectScore1 = null;
		SubjectScore subjectScore2 = null;
		SubjectScore subjectScore3 = null;
		SubjectScore subjectScore4 = null;
		SubjectScore subjectScore5 = null;
		SubjectScore subjectScore6 = null;
		SubjectScore subjectScore7 = null;
		SubjectScore subjectScore8 = null;

		while (iterator.hasNext()) {
			cellCount = 1;
			student = new Student();
			student.setMarksCard(new ArrayList<SubjectScore>());
			Row nextRow = iterator.next();
			Iterator<Cell> cellIterator = nextRow.cellIterator();

			subjectScore1 = new SubjectScore();
			subjectScore2 = new SubjectScore();
			subjectScore3 = new SubjectScore();
			subjectScore4 = new SubjectScore();
			subjectScore5 = new SubjectScore();
			subjectScore6 = new SubjectScore();
			subjectScore7 = new SubjectScore();
			subjectScore8 = new SubjectScore();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();
				cell.setCellType(Cell.CELL_TYPE_STRING);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					switch (cellCount) {
					case 1:
						subjectScore1.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore2.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore3.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore4.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore5.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore6.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore7.setSemesterNumber(cell.getStringCellValue().trim());
						subjectScore8.setSemesterNumber(cell.getStringCellValue().trim());
						break;
					case 2:
						student.setUsn(cell.getStringCellValue().trim());
						break;
					case 3:
						subjectScore1.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 4:
						subjectScore1.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 5:
						subjectScore1.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 6:
						subjectScore2.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 7:
						subjectScore2.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 8:
						subjectScore2.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 9:
						subjectScore3.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 10:
						subjectScore3.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 11:
						subjectScore3.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 12:
						subjectScore4.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 13:
						subjectScore4.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 14:
						subjectScore4.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 15:
						subjectScore5.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 16:
						subjectScore5.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 17:
						subjectScore5.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 18:
						subjectScore6.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 19:
						subjectScore6.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 20:
						subjectScore6.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 21:
						subjectScore7.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 22:
						subjectScore7.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 23:
						subjectScore7.setExternalMarks(cell.getStringCellValue().trim());
						break;
					case 24:
						subjectScore8.setSubjectCode(cell.getStringCellValue().trim());
						break;
					case 25:
						subjectScore8.setInternalMarks(cell.getStringCellValue().trim());
						break;
					case 26:
						subjectScore8.setExternalMarks(cell.getStringCellValue().trim());
						break;
					default:
						break;
					}
				default:
					break;
				}
				cellCount++;
			}
			List<SubjectScore> marksCard = student.getMarksCard();
			marksCard.add(subjectScore1);
			marksCard.add(subjectScore2);
			marksCard.add(subjectScore3);
			marksCard.add(subjectScore4);
			marksCard.add(subjectScore5);
			marksCard.add(subjectScore6);
			marksCard.add(subjectScore7);
			marksCard.add(subjectScore8);
			student.setMarksCard(marksCard);
			studentsList.add(student);
		}
		jdbcUtil.persistStudentMarks(studentsList);
	}
}
