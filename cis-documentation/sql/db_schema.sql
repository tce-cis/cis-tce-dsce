DROP DATABASE IF EXISTS `cis_tce_dsce`;

CREATE DATABASE `cis_tce_dsce` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE cis_tce_dsce;

CREATE TABLE `company` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `no_offers` varchar(3) NOT NULL,
  `ctc` varchar(4) NOT NULL,
  `type` varchar(3) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

CREATE TABLE `department` (
  `department_id` int(11) NOT NULL,
  `department_name` varchar(45) NOT NULL,
  `department_code` varchar(10) NOT NULL,
  `department_head` varchar(45) NOT NULL,
  PRIMARY KEY (`department_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `faculty` (
  `faculty_id` int(11) NOT NULL AUTO_INCREMENT,
  `full_name` varchar(45) NOT NULL,
  `designation` varchar(45) NOT NULL,
  `education_qualification` varchar(20) NOT NULL,
  `experience` int(2) NOT NULL,
  `specialization` varchar(100) NOT NULL,
  `email` varchar(45) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `salutation` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;

CREATE TABLE `feedback` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `teaching` varchar(20) NOT NULL,
  `time_utilization` varchar(20) NOT NULL,
  `content_delivery` varchar(20) NOT NULL,
  `regularity` varchar(20) NOT NULL,
  `practical_aspect` varchar(20) NOT NULL,
  `doubts_clarification` varchar(20) NOT NULL,
  `evaluation` varchar(20) NOT NULL,
  `availability` varchar(20) NOT NULL,
  `syllabus_coverage` varchar(20) NOT NULL,
  `dress_code` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `program_outcomes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `po_description` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `publication` (
  `publication_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(400) NOT NULL,
  `journal` varchar(600) NOT NULL,
  `primary_author` varchar(45) NOT NULL,
  `co_authors` varchar(400) DEFAULT NULL,
  `faculty_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`publication_id`),
  KEY `faculty_Publication_FK_idx` (`faculty_id`)
) ENGINE=InnoDB AUTO_INCREMENT=336 DEFAULT CHARSET=latin1;

CREATE TABLE `research` (
  `id` int(3) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL,
  `description` varchar(4000) NOT NULL,
  `pi_name_designation` varchar(400) NOT NULL,
  `co_pi_name_designation` varchar(500) NOT NULL,
  `funding_agency_amount` varchar(500) NOT NULL,
  `start_year_end_year` varchar(100) NOT NULL,
  PRIMARY KEY (`id`,`title`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `results` (
  `subject_code` varchar(20) NOT NULL,
  `semester_number` varchar(1) NOT NULL,
  `usn` varchar(15) NOT NULL,
  `internal_marks` int(2) NOT NULL,
  `external_marks` int(3) NOT NULL,
  PRIMARY KEY (`subject_code`,`usn`,`semester_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `semester` (
  `semester_number` int(1) NOT NULL,
  PRIMARY KEY (`semester_number`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `student` (
  `usn` varchar(11) NOT NULL,
  `full_name` varchar(45) NOT NULL,
  `email` varchar(255) NOT NULL,
  `percent_10th` decimal(4,0) NOT NULL,
  `percent_12th` decimal(4,0) NOT NULL,
  `studentcol` varchar(45) DEFAULT NULL,
  `yoj` int(4) DEFAULT NULL,
  PRIMARY KEY (`usn`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `subject` (
  `subjectName` varchar(45) NOT NULL,
  `code` varchar(45) NOT NULL,
  `iaMarks` int(11) NOT NULL,
  `examHours` int(11) NOT NULL,
  `hrsPerWeek` int(11) NOT NULL,
  `totalHrs` int(11) NOT NULL,
  `examMarks` int(11) NOT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `subject_unit` (
  `subject_code` varchar(45) NOT NULL,
  `part` varchar(3) NOT NULL,
  `unit` int(1) NOT NULL,
  `unit_title` varchar(200) NOT NULL,
  `unit_description` varchar(1000) NOT NULL,
  `unit_hours` varchar(3) NOT NULL,
  PRIMARY KEY (`part`,`unit`,`subject_code`),
  KEY `subjectcode_FK_idx` (`subject_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `user` (
  `username` varchar(16) NOT NULL,
  `password` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
