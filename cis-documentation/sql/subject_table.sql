CREATE TABLE `subject` (
  `name` varchar(150) NOT NULL,
  `code` varchar(12) NOT NULL,
  `IA_marks` int(2) DEFAULT NULL,
  `hours_per_week` int(2) DEFAULT NULL,
  `total_hours` int(2) DEFAULT NULL,
  `exam_marks` int(3) DEFAULT NULL,
  `exam_hours` int(2) DEFAULT NULL,
  PRIMARY KEY (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
