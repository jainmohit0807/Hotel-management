/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.0.67-community-nt : Database - hotel
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`hotel` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `hotel`;

/*Table structure for table `booking` */

DROP TABLE IF EXISTS `booking`;

CREATE TABLE `booking` (
  `CustomerId` varchar(20) default NULL,
  `Date-in` varchar(40) default NULL,
  `Date-out` varchar(40) default NULL,
  `Name` varchar(30) default NULL,
  `Address` varchar(200) default NULL,
  `Phone-no.` varchar(14) default NULL,
  `City` varchar(20) default NULL,
  `State` varchar(20) default NULL,
  `Id-type` varchar(15) default NULL,
  `Id-number` varchar(20) default NULL,
  `Room-type` varchar(10) default NULL,
  `Days` varchar(15) default NULL,
  `Bed-type` varchar(10) default NULL,
  `Roomno` varchar(15) default NULL,
  `Adults` varchar(15) default NULL,
  `Minors` varchar(15) default NULL,
  `PayBy` varchar(20) default NULL,
  `Total` varchar(15) default NULL,
  `Paid` varchar(15) default NULL,
  `Due` varchar(15) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `booking` */

insert  into `booking`(`CustomerId`,`Date-in`,`Date-out`,`Name`,`Address`,`Phone-no.`,`City`,`State`,`Id-type`,`Id-number`,`Room-type`,`Days`,`Bed-type`,`Roomno`,`Adults`,`Minors`,`PayBy`,`Total`,`Paid`,`Due`) values ('686345','12.09.2016','13.9.2016','Mohit jain','Chipptola, Agra','7073590355','Agra','UP','Voter-id','1203a4','Ac','2','Single','1','1','0','Cash','1700','1500','200'),('899691','12.09.2016','14.9.2016','Shivam','PratapNagar,Jaipur','8956200314','jaipur','Rajasthan','DL','120as','Ac','3','Double','27','3','1','Paytm','3000','2500','500'),('127421','14.9.2016','16.9.2016','Gaurav','Gandhinagar,Jaipur','9562301447','Jaipur','Rajasthan','Other','ajshjsa','Ac','3','Double','4','3','0','CreditCard','3000','3000','0'),('371188','12.09.2016','15.9.2016','Mayank','Raja ki mandi,Agra','7455521036','Agra','UP','DL','adsjhj','Ac','4','Triple','20','4','3','DebitCard','4600','4000','600'),('676656','13.9.2016','14.9.2016','Gopal','ChandiChowk,New Delhi','8451203697','DELHI','DELHI','DL','askdj','Non Ac','2','Single','8','2','0','CreditCard','1000','1000','0'),('815653','20.9.2016','21.9.2016','Rajesh','AjmeriGate,Jaipur','7845120369','Jaipur','Rajasthan','Other','asdk','Ac','2','Double','21','3','2','OnlineTransfer','2000','2000','0'),('467783','18.9.2016','19.9.2016','Harish','NaikiMandi,Agra','7410258963','Agra','UP','Voter-id','askksa','Ac','2','Single','7','2','0','Cash','1700','1500','200'),('999843','12.09.2016','15.9.2016','kishore sharma','Gopalpura,Jaipur','7412056938','jaipur','raj.','Pancard','84512','Ac','4','Double','4','4','1','DebitCard','4000','2500','1500'),('571728','12.09.2016','13.9.2016','karan','Kandari,Agra','8521306497','Agra','UP','Pancard','asdasdj','Ac','2','Triple','1','5','2','Cash','2300','2300','0'),('684823','12.09.2016','13.9.2016','Shubham','Gandhinagar,Jaipur','8520136479','jaipur','Raj','Voter-id','5263','Ac','2','Double','6','4','0','DebitCard','2000','1500','500'),('214915','14.09.2016','16.9.2016','Adarsh ','Kamla nagar,Agra','8520003695','Agra','UP','Voter-id','6532','Ac','3','Double','29','2','3','Paytm','3000','2600','400'),('516384','30.9.2016','1.10.2016','Raman','Kumbha Marg,Jaipur','7410023568','Jaipur','Rajasthan','DL','sauhjk','Ac','2','Double','5','4','2','DebitCard','2000','1800','0'),('791828','14.09.2016','17.9.2016','Nick','jcamp\n	','1234567899','jp','raj','Passport','sdnfkjsdfjsdfsd','Ac','3','Double','12','2','0','Cash','3000','4000','-2000');

/*Table structure for table `login` */

DROP TABLE IF EXISTS `login`;

CREATE TABLE `login` (
  `Username` varchar(25) default NULL,
  `Password` varchar(25) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `login` */

insert  into `login`(`Username`,`Password`) values ('Admin','mohit');

/*Table structure for table `status_advance` */

DROP TABLE IF EXISTS `status_advance`;

CREATE TABLE `status_advance` (
  `CustomerId` varchar(50) default NULL,
  `Name` varchar(50) default NULL,
  `Roomno` varchar(50) default NULL,
  `CheckIn` varchar(50) default NULL,
  `Checkout` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `status_advance` */

insert  into `status_advance`(`CustomerId`,`Name`,`Roomno`,`CheckIn`,`Checkout`) values ('815653','Rajesh','21','20.9.2016','21.9.2016'),('516384','Raman','5','30.9.2016','1.10.2016');

/*Table structure for table `status_current` */

DROP TABLE IF EXISTS `status_current`;

CREATE TABLE `status_current` (
  `CustomerId` varchar(50) default NULL,
  `Name` varchar(50) default NULL,
  `Roomno` varchar(10) default NULL,
  `CheckIn` varchar(50) default NULL,
  `CheckOut` varchar(50) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `status_current` */

insert  into `status_current`(`CustomerId`,`Name`,`Roomno`,`CheckIn`,`CheckOut`) values ('371188','Mayank','20','12.09.2016','15.9.2016'),('999843','kishore sharma','4','12.09.2016','15.9.2016'),('571728','karan','1','12.09.2016','13.9.2016'),('684823','Shubham','6','12.09.2016','13.9.2016'),('214915','Adarsh ','29','14.09.2016','16.9.2016');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
