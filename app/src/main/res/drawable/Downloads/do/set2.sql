---Create the EMP Table with all necessary constraints such as
---In EMP TABLE: Employee id should be primary key, Department no should be
--Foreign key, employee age (birth_date) should be greater than 18 years, salary should
--be greater than zero, email should have (@ and dot) sign in address, designation of 
--employee can be “manager”, “clerk”, “leader”, “analyst”, “designer”, “coder”,
--“tester”

---EMPLOYEE (emp_id, emp_name, birth_date, gender, dept_no, address, designation, salary,
---experience, email)
---DEPARTMENT (dept_no, dept_name, location)

create table EMPLOYEE( 
emp_id int PRIMARY KEY, 
emp_name varchar2(10),
birthdate date,
gender varchar2(10),
dept_no int references DEPARTMENT(dept_no),
address varchar2(10),
designation varchar2(10),
salary int,
experience varchar2(10),
email varchar2(20)
);

 create table DEPARTMENT(
 dept_no int PRIMARY KEY,
 dept_name varchar2(10),
 location varchar2(10));
 
 insert into EMPLOYEE values(1,'mansi','8-jun-2001','female',1,'jamnagar','clerk',11000,'good','mansi@gmail.com');

---8. List all records of each table in ascending order. 
 select *from EMPLOYEE orderby emp_id;