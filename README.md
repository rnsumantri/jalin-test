# Getting Started

### Reference Documentation
Java version: 17 \
Maven version: 3.2 \
Idea : Intellij (optional) \

Database migration \
database: Postgresql \
Migration file path: src/main/resources/migrations/create-table-users.sql \
Migration filename: create-table-users.sql \
Step:\
1. create database name = jalin
2. create schema = public
3. configuration detail referred in 'application.properties'
4. execute sql create-table-users.sql


Answer 1: \
Location file : src/main/java/com/ronisumantri/jalinbisa/task1 \
Run step: 
1. Direct run Class Staircase.java
2. fill parameter in terminal (scanner)

![img.png](img.png)

Answer 2:\
First run:
1. Run 'mvn clean install' from Idea like picture below
![img_1.png](img_1.png)
2. Or run from main class
3. execute cURL 
 example:
 * insert master data role \
   curl --location 'localhost:8080/api/roles/insert' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8' \
   --data '{
   "role_name":"Manager IT",
   "insert":true,
   "read":true,
   "update":true,
   "delete":false,
   "is_active":true
   }'
 * insert master data users \
   curl --location 'localhost:8080/api/users/insert' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8' \
   --data '{
   "username":"ipul",
   "name":"James",
   "phone":"08777777",
   "createdBy":"admin",
   "modifiedBy":"admin",
   "isActive":true,
   "hashPassword":"password",
   "masterRole":{
   "id":1
   }
   }'
 * get all roles \
   curl --location 'localhost:8080/api/roles/list-role' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8'
 * get all users \
   curl --location 'localhost:8080/api/users/list-all' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8'
 * update master role \
   curl --location --request PUT 'localhost:8080/api/roles/update/4' \
   --header 'Content-Type: application/json' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8' \
   --data '{
   "id":4,
   "role_name":"Manager",
   "insert":true,
   "read":true,
   "update":true,
   "delete":false,
   "is_active":false
   }'
 * delete master role \
   curl --location --request DELETE 'localhost:8080/api/roles/delete/1' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8' \
   --data '' \
   

Answer 3: \
Step: 
1. Put 'config.txt' in 'src/config/config.txt'
2. execute cURL \
   curl --location 'localhost:8080/api/report/print' \
   --header 'Authorization: Basic TXVobGlzOnBhc3N3b3Jk' \
   --header 'Cookie: JSESSIONID=8F599F14BE8B5335EEF59AD342F8B4C8'
3. file will generated in 'src/output' with format .html
![img_2.png](img_2.png)
4. Reason file generated to .html for flexible purpose (convert to pdf or insert logo)
