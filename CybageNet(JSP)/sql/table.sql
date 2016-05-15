create database book;

use book;

CREATE TABLE `books` (
  `book_ID` int(11) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) DEFAULT NULL,
  `book_author` varchar(50) DEFAULT NULL,
  `book_publisher` varchar(50) DEFAULT NULL,
  `book_review` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`book_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `userlog` (
  `userlog_ID` int(11) NOT NULL AUTO_INCREMENT,
  `userlog_loginname` varchar(50) DEFAULT NULL,
  `userlog_ipaddress` varchar(15) DEFAULT NULL,
  `userlog_timestamp` timestamp,
  PRIMARY KEY (`userlog_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `user_ID` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
