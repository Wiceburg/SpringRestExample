# SpringRestExample
    
    This is a sample project of Spring4 RESTful web service with Hibernate4.
    
###Software Requirement

    1. Java 1.8
    2. Spring 4.2.5.RELEASE
    3. Hibernate 4.3.11.FINAL
    4. Jackson 2.5.3
    5. Tomcat 8
    6. MySQL 5.7.9
    7. Eclipse Mars.2

###Database Setup

    MySQL script to create a simple database and table structure to be used in this application:
    
    1. Dumping database structure for test
        
        CREATE DATABASE test;
        USE test;
        
    2. Dumping structure for table address
    
        CREATE TABLE IF NOT EXISTS address(
            id bigint(20) NOT NULL AUTO_INCREMENT,
            FIRSTNAME varchar(45) DEFAULT NULL,
            LASTNAME varchar(45) DEFAULT NULL,
            PHONE varchar(45) DEFAULT NULL,
            STREET varchar(45) DEFAULT NULL,
            ZIP int(20) DEFAULT NULL,
            PRIMARY KEY (id)
            ) ;

    3. Dumping structure for table address
    
        INSERT INTO address(id, FIRSTNAME, LASTNAME, PHONE, STREET, ZIP) VALUES(1, 'Olaf', 'Schneider', '017699999999', 'Schaenzlerstr.1', 79104);
        
###REST Endpoints

| REST Endpoint | HTTP Method | Description |
|---------------|-------------|-------------|
| /address | GET | Return partial info of all addresses |
| /address/{id} | GET | Return all info of an address |
| /address/ | POST | Create/Update an address |
| /address/{id} | PUT | Update an address |
| /address/{id} | DELETE | Delete an address |
