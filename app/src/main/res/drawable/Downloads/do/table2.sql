--1. Create the EMP Table with all necessary constraints such as
--In EMP TABLE: Employee id should be primary key, 
--Department no should be
--Foreign key, 
--employee age (birth_date) should be greater than 18 years, 
--salary should
--be greater than zero, 
--email should have (@ and dot) sign in address, 
--designation of employee can be “-”, “clerk”, “leader”, “analyst”, “designer”, “coder”, “tester”.

create table Department2(
dept_no number(10)primary key,
dept_name varchar(10),
location varchar(10)
);

insert into Department2 values(6,'bsc','ahmdabad');
insert into Department2 values(8,'clerk','jm');



create table Employee(
emp_id number(10)primary key,
emp_name varchar(10),
birth_date date,
gender varchar(10),
dept_no number(10) references department2(dept_no),
address varchar(50),
designation varchar(20),
salary number(10)check(salary>0),
experience varchar(10),
email varchar(20)check(email like '%@%.%___')
);

alter table Employee modify email varchar(20)check(email like '%@%.%___');

alter table Employee modify salary number(10)check(salary>0);

alter table Employee modify experience 

insert into Employee values(2,'abc','21-mar-2001','female',2,'jm','clerk',2000,'2 year','abc@gmail.com');
insert into Employee values(3,'parth','06-jUN-2004','male',3,'rj','clerk',2000,'3 year','xyz@gmail.com');
insert into Employee values(2,'abc','21-mar-2001','female',2,'jm','it',2000,'2 year','abc@gmail.com');
insert into Employee values(2,'abc','21-mar-2001','female',2,'jm','clerk',2000,'2 year','abc@gmail.com');
insert into Employee values(2,'abc','21-mar-2001','female',2,'jm','clerk',2000,'2 year','abc@gmail.com');
insert into Employee values(2,'abc','21-mar-2001','female',2,'jm','clerk',2000,'2 year','abc@gmail.com');



---5. ‘Male’ or ‘Female’ in gender field and display the structure
select *from Employee where gender='female';

--8. List all records of each table in ascending order

select *from Employee order by emp_name;

--9. Delete the department whose loction in Ahmedabad.

delete from department2 where 

---12. Find the names of the employee who has salary less than 5000 and greater than 2000.


select emp_name,salary from Employee  where salary between 2000 and 5000;

---13. Display the names and the designation of all female employee in descending order.

select emp_name,designation,gender 
from Employee 
where gender='female' 
order by emp_name; 

--14. Display the names of all the employees who names starts with ‘A’ ends with ‘A’.

select emp_name 
from Employee
where emp_name like 'A%A';

--15. Find the name of employee and salary for those who had obtain minimum salary.

select emp_name,salary
from Employee
where salary=(
select min(salary) from Employee);

---16. Add 10% raise in salary of all employees whose department is ‘IT’.

update Employee set salary=salary+(salary*0.10)
where dept_no=(select dept_no 
from Department2 
where dept_name='clerk');


select salary,salary*0.10
(salary+(salary*0.10)) new_salary,dept_no
 from Employee
 where dept_no=(
select dept_no from Department2 
where dept_name='clerk');

--17. Count total number of employees of ‘IT’ department.

select count(*)from Employee
where dept_no=(
select dept_no from Department2
where dept_name='clerk');

--18. List all employees who born in the current month.

select emp_name,to_char(birth_date,'MON')
from Employee
where to_char(birth_date,'MON')=(
select to_char(sysdate,'MON') from dual);

---19. Print the record of employee and dept table as “Employee works in department 
--‘MBA’

select e.emp_name || ' works in ' ||d.dept_name ||' department2'
 from Employee e,Department2 d
where e.dept_no = d.dept_no;

--20. List names of employees who are fresher’s (less than 1 year of experience).

select experience,emp_name
from Employee
where experience<=2;

---21. List department wise names of employees who has more than 5 years of experience.

select e.experience,e.emp_name,d.dept_no 
from Employee e,department2 d
where e.experience>=2
and e.dept_no=d.dept_no
order by d.dept_no;

--22. Crete Sequence to generate department ID

create sequence sq;
select sq.nextval from dual;
select sq.currval from dual;

--23. List department having no employees

select dept_name from department2
where dept_name not in (select dept_name from Employee);
