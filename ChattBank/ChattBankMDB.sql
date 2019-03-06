#
# DUMP FILE
#
# Database is ported from MS Access
#------------------------------------------------------------------
# Created using "MS Access to MySQL" form http://www.bullzip.com
# Program Version 5.4.274
#
# OPTIONS:
#   sourcefilename=C:\Users\nicho_000\Documents\School\Java III\ChattBank\ChattBankMDB.mdb
#   sourceusername=
#   sourcepassword=
#   sourcesystemdatabase=
#   destinationdatabase=movedb
#   storageengine=MyISAM
#   dropdatabase=0
#   createtables=1
#   unicode=1
#   autocommit=1
#   transferdefaultvalues=1
#   transferindexes=1
#   transferautonumbers=1
#   transferrecords=1
#   columnlist=1
#   tableprefix=
#   negativeboolean=0
#   ignorelargeblobs=0
#   memotype=LONGTEXT
#   datetimetype=DATETIME
#

CREATE DATABASE IF NOT EXISTS `movedb`;
USE `movedb`;

#
# Table structure for table 'Accounts'
#

DROP TABLE IF EXISTS `Accounts`;

CREATE TABLE `Accounts` (
  `AcctNo` VARCHAR(255) NOT NULL, 
  `Cid` VARCHAR(255), 
  `Type` VARCHAR(255), 
  `Balance` DECIMAL(19,4), 
  INDEX (`Cid`), 
  PRIMARY KEY (`AcctNo`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Accounts'
#

INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90000', '3003', 'SAV', 8855.9);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90001', '3003', 'CHK', 786.54);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90002', '3001', 'SAV', 9654.13);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90003', '3006', 'SAV', 17619.34);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90004', '3006', 'CHK', 100.29);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90005', '3006', 'MMA', 700356.23);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90006', '3001', 'MMA', 23479.1);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90007', '3004', 'MMA', 18000);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90008', '3005', 'MMA', 25000);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90009', '3006', 'SAV', 9000);
INSERT INTO `Accounts` (`AcctNo`, `Cid`, `Type`, `Balance`) VALUES ('90010', '3003', 'MMA', 10000);
# 11 records

#
# Table structure for table 'Customers'
#

DROP TABLE IF EXISTS `Customers`;

CREATE TABLE `Customers` (
  `CustID` VARCHAR(255) NOT NULL, 
  `CustPassword` VARCHAR(255), 
  `CustFirstName` VARCHAR(255), 
  `CustLastName` VARCHAR(255), 
  `CustAddress` VARCHAR(255), 
  `CustEmail` VARCHAR(255), 
  PRIMARY KEY (`CustID`)
) ENGINE=myisam DEFAULT CHARSET=utf8;

SET autocommit=1;

#
# Dumping data for table 'Customers'
#

INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3001', '1234', 'Billy', 'Carter', 'Georgia', 'bc@yahoo.com');
INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3002', '1111', 'Tony', 'Danza', 'Atlanta', 'ggggg@hotmail.com');
INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3003', '6789', 'Terry', 'March', 'Texas', 'mm@gmail.com');
INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3004', '1111', 'Susan', 'Slater', 'Arizona', 'ss@yahoo.com');
INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3005', '1212', 'Tony', 'Randal', 'California', 'tr1@hotmail.com');
INSERT INTO `Customers` (`CustID`, `CustPassword`, `CustFirstName`, `CustLastName`, `CustAddress`, `CustEmail`) VALUES ('3006', '9999', 'Bill', 'Gates', 'Washington', 'bgates@ms.com');
# 6 records

