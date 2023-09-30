# IDCardSystem
--> DEVEPLOPMENT COMPLETED
To changes the major part like
1. jsp/servlet ---> Spring Boot microservices
2. mysql db ---> yugabyte db for store the large file data  store easily
3. code optimization



for check
#swagger UI - http://localhost:9080/idcard/rest/swagger-ui/index.html


CQL KeySpace - idcardsystem

CQL Schema --

CREATE TABLE idcardsystem.idcard (
    serialno text,
    session text,
    university text,
    degree text,
    college text,
    name text,
    fathername text,
    gender text,
    dob text,
    mobile text,
    email text,
    address text,
    photo blob,
    image blob,
    PRIMARY KEY ((serialno,university), session, degree, college, name)
) WITH CLUSTERING ORDER BY (session ASC, degree ASC, college ASC, name ASC)
    AND default_time_to_live = 0
    AND transactions = {'enabled': 'true'};