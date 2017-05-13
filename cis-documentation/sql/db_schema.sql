CREATE SCHEMA `cis_tce_dsce` ;

CREATE TABLE `cis_tce_dsce`.`staff` (
  `staff_id` INT NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(45) NOT NULL,
  `designation` VARCHAR(45) NOT NULL,
  `interest` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone` INT(10) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE INDEX `student_id_UNIQUE` (`staff_id` ASC));
  
CREATE TABLE `cis_tce_dsce`.`student` (
  `student_id` INT NOT NULL,
  `full_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `usn` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`student_id`));
  
ALTER TABLE `cis_tce_dsce`.`student` 
DROP COLUMN `student_id`,
CHANGE COLUMN `usn` `usn` VARCHAR(11) NOT NULL FIRST,
ADD COLUMN `percent_10th` DECIMAL(4) NOT NULL AFTER `email`,
ADD COLUMN `percent_12th` DECIMAL(4) NOT NULL AFTER `percent_10th`,
ADD COLUMN `studentcol` VARCHAR(45) NULL AFTER `percent_12th`,
ADD COLUMN `yoj` INT(4) NULL AFTER `studentcol`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`usn`);

CREATE TABLE `cis_tce_dsce`.`subject` (
  `subject_id` INT NOT NULL,
  `subject_name` VARCHAR(45) NOT NULL,
  `teaching_hours` INT(2) NULL,
  `subject_code` VARCHAR(5) NOT NULL,
  PRIMARY KEY (`subject_id`));
  
CREATE TABLE `cis_tce_dsce`.`semester` (
  `semester_id` INT(1) NOT NULL,
  `semester_number` INT(1) NOT NULL,
  PRIMARY KEY (`semester_id`));
  
ALTER TABLE `cis_tce_dsce`.`semester` 
DROP COLUMN `semester_id`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`semester_number`);

CREATE TABLE `cis_tce_dsce`.`user` (
  `username` VARCHAR(16) NOT NULL,
  `email` VARCHAR(255) NULL,
  `password` VARCHAR(32) NOT NULL);
  
  CREATE TABLE `cis_tce_dsce`.`department` (
  `department_id` INT NOT NULL,
  `department_name` VARCHAR(45) NOT NULL,
  `department_code` VARCHAR(10) NOT NULL,
  `department_head` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`department_id`));
  
  
  CREATE TABLE `cis_tce_dsce`.`student_semester` (
  `idstudent_semester_id` INT NOT NULL,
  `student_usn` VARCHAR(11) NOT NULL,
  `semester_number` INT(1) NOT NULL,
  PRIMARY KEY (`idstudent_semester_id`),
  INDEX `_idx` (`semester_number` ASC),
  INDEX `student_FK_idx` (`student_usn` ASC),
  CONSTRAINT `semester_FK`
    FOREIGN KEY (`semester_number`)
    REFERENCES `cis_tce_dsce`.`semester` (`semester_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_FK`
    FOREIGN KEY (`student_usn`)
    REFERENCES `cis_tce_dsce`.`student` (`usn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
CREATE TABLE `cis_tce_dsce`.`publication` (
  `publication_id` INT NOT NULL,
  `publication_title` VARCHAR(45) NOT NULL,
  `publication_journal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`publication_id`));

ALTER TABLE `cis_tce_dsce`.`staff` 
CHANGE COLUMN `staff_id` `faculty_id` INT(11) NOT NULL AUTO_INCREMENT , RENAME TO  `cis_tce_dsce`.`faculty` ;


CREATE TABLE `cis_tce_dsce`.`faculty_publication` (
  `faculty_publication_id` INT NOT NULL,
  `faculty_id` INT NOT NULL,
  `publication_id` INT NOT NULL,
  PRIMARY KEY (`faculty_publication_id`));

ALTER TABLE `cis_tce_dsce`.`faculty_publication` 
ADD INDEX `faculty_fk_idx` (`faculty_id` ASC),
ADD INDEX `publication_fk_idx` (`publication_id` ASC);
ALTER TABLE `cis_tce_dsce`.`faculty_publication` 
ADD CONSTRAINT `faculty_fk`
  FOREIGN KEY (`faculty_id`)
  REFERENCES `cis_tce_dsce`.`faculty` (`faculty_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION,
ADD CONSTRAINT `publication_fk`
  FOREIGN KEY (`publication_id`)
  REFERENCES `cis_tce_dsce`.`publication` (`publication_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `cis_tce_dsce`.`publication` 
ADD COLUMN `publication_summary` VARCHAR(4000) NULL AFTER `publication_journal`;

CREATE TABLE `cis_tce_dsce`.`marks` (
  `marks_id` INT NOT NULL,
  `marks_obtained` INT(3) NOT NULL,
  `marks_max` INT(3) NOT NULL,
  `student_usn` VARCHAR(11) NOT NULL,
  `subject_id` INT(11) NOT NULL,
  `semester_number` INT(1) NOT NULL,
  PRIMARY KEY (`marks_id`),
  INDEX `student_fk_idx` (`student_usn` ASC),
  INDEX `semester_fk_idx` (`semester_number` ASC),
  INDEX `subject_fk_idx` (`subject_id` ASC),
  CONSTRAINT `marks_student_fk`
    FOREIGN KEY (`student_usn`)
    REFERENCES `cis_tce_dsce`.`student` (`usn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `marks_semester_fk`
    FOREIGN KEY (`semester_number`)
    REFERENCES `cis_tce_dsce`.`semester` (`semester_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `marks_subject_fk`
    FOREIGN KEY (`subject_id`)
    REFERENCES `cis_tce_dsce`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
    
ALTER TABLE `cis_tce_dsce`.`faculty` 
DROP COLUMN `interest`,
ADD COLUMN `education_qualification` VARCHAR(20) NOT NULL AFTER `designation`,
ADD COLUMN `experience` INT(2) NOT NULL AFTER `education_qualification`,
ADD COLUMN `specialization` VARCHAR(100) NOT NULL AFTER `experience`,
DROP INDEX `student_id_UNIQUE` ;

ALTER TABLE `cis_tce_dsce`.`faculty` 
CHANGE COLUMN `phone` `phone` INT(12) NOT NULL ;

ALTER TABLE `cis_tce_dsce`.`faculty` 
CHANGE COLUMN `phone` `phone` VARCHAR(10) NOT NULL ;

ALTER TABLE `cis_tce_dsce`.`publication` 
CHANGE COLUMN `publication_title` `title` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `publication_journal` `journal` VARCHAR(45) NOT NULL ,
CHANGE COLUMN `publication_summary` `primary_author` VARCHAR(45) NOT NULL ,
ADD COLUMN `co_authors` VARCHAR(45) NULL AFTER `primary_author`;

DROP TABLE `cis_tce_dsce`.`faculty_publication`;

ALTER TABLE `cis_tce_dsce`.`publication` 
CHANGE COLUMN `publication_id` `publication_id` INT(11) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `cis_tce_dsce`.`publication` 
CHANGE COLUMN `title` `title` VARCHAR(400) NOT NULL ,
CHANGE COLUMN `journal` `journal` VARCHAR(600) NOT NULL ,
CHANGE COLUMN `co_authors` `co_authors` VARCHAR(400) NULL DEFAULT NULL ;

CREATE TABLE `cis_tce_dsce`.`program_outcomes` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `po_description` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `cis_tce_dsce`.`subject_new` (
  `suject_code` VARCHAR(12) NOT NULL,
  `IA_marks` INT(2) NOT NULL,
  `hours_per_week` INT(2) NOT NULL,
  `total_hours` INT(2) NOT NULL,
  `exam_marks` INT(3) NOT NULL,
  PRIMARY KEY (`suject_code`));

  DROP TABLE `cis_tce_dsce`.`student_semester`;
  DROP TABLE `cis_tce_dsce`.`marks`;
  DROP TABLE `cis_tce_dsce`.`subject`;

  CREATE TABLE `cis_tce_dsce`.`student_semester` (
  `idstudent_semester_id` INT NOT NULL,
  `student_usn` VARCHAR(11) NOT NULL,
  `semester_number` INT(1) NOT NULL,
  PRIMARY KEY (`idstudent_semester_id`),
  INDEX `_idx` (`semester_number` ASC),
  INDEX `student_FK_idx` (`student_usn` ASC),
  CONSTRAINT `semester_FK`
    FOREIGN KEY (`semester_number`)
    REFERENCES `cis_tce_dsce`.`semester` (`semester_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `student_FK`
    FOREIGN KEY (`student_usn`)
    REFERENCES `cis_tce_dsce`.`student` (`usn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
   insert into  user values('anusha', 'anu@1','123a'); //dummy data
   insert into  user values('asha', 'ashu@1','125a');  //dummy data  
    
   CREATE TABLE `cis_tce_dsce`.`syllabus` (
  `subjectCode` VARCHAR(40) NOT NULL,
  `part` VARCHAR(10) NOT NULL,
  `unit` INT UNSIGNED NOT NULL,
  `unitTitle` VARCHAR(40) NOT NULL,
  `UnitDescription` VARCHAR(400) NOT NULL,
  `unitHours` INT UNSIGNED NOT NULL,
  UNIQUE INDEX `subjectCode_UNIQUE` (`subjectCode` ASC));

   
    ALTER TABLE `cis_tce_dsce`.`subject_new` 
RENAME TO  `cis_tce_dsce`.`subject` ;