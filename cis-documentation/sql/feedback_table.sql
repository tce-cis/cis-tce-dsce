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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
