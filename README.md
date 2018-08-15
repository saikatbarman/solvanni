# solvanni
Solvanni Test Example


Step 1: Download/ fork project

Step 2: There are two packages
a. solvanni > Spring Boot Application
b. solvanni-web > Spring Web Application

Step 3: import the projects in eclipse as maven projects

Step 4: 
a. Go to package com.microservice.customer.crud.solvanni
b. open SpringApplication.java
c. right click > run as Spring boot/ java Application

Step 5:
a. Go to solvanni-web
b. right click > run as > run on server

Step 6:
a. Select Tomcat Server 9 > NEXT > FINISH

Step 7:
It will open the index page for Customer CRUD operations

Step 8: Alternately, use any browser and hit the below URL
http://localhost:8080/solvanni-web/


Create a database for the application as below (MySQL)
SQL for Database:

CREATE DATABASE `solvanni` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

CREATE TABLE `customer` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'Unique ID for Customer Table\nPrimary Key\nInput Type: Auto Generated with an increment value of 1',
  `customer_name` varchar(200) NOT NULL COMMENT 'Customer Name\nInput Type: Varchar, User Defined',
  `customer_address` varchar(500) NOT NULL COMMENT 'Customer Address\nInput type: Varchar, User Defined',
  `customer_internal_name` varchar(500) DEFAULT NULL COMMENT 'Customer Internal Name\nInput type: Varchar, User Defined',
  `customer_status` varchar(45) DEFAULT NULL COMMENT 'Customer Current Status\nInput type: Varchar, User Defined\nInput Values: ACTIVE or INACTIVE',
  `create_date` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'Data Creation\nInput Type: Auto Generated, DateTime Stamp for tracking data entry',
  `update_date` timestamp(6) NULL DEFAULT CURRENT_TIMESTAMP(6) COMMENT 'Data Modification\nInput Type: Auto Generated, DateTime Stamp for tracking data entry',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


