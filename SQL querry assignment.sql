use organization;
#1. Display all employee names in ascending order
select empname from emp order by empname Asc ;

#2.Display all employee names, salary, commision of employees in dept 10
select empname,sal,com from emp where deptno=10;

#3. Display all employees(all columns) in department 20 and 30
select * from emp where deptno=20 or deptno=30;

#4. Display all the employees who are managers
select * from emp where job="manager";

#5. Display all the employees whose salary is between 2000 and 5000
select  * from emp where sal Between 2000 and 5000 ;

#6. Display all the employees whose commission is null
select * from emp where com is null;

#7.Display employee name, salary, commission in descending order based on salary
select empname,sal,com  from emp order by sal desc;

#8.Display average, max, min and sum of salaries of employees
Select min(sal) as minimumsalary,max(sal) as maximumsalary,avg(sal) as averagesalary ,sum(sal) as totalsalary  FROM emp;

#9. Display hire_date, current_date, tenure(calculated col) of the empl
select hiredate,current_date(),concat(timestampdiff(year,hiredate,current_date()),' years ',(timestampdiff(month,hiredate,current_date()))%12,' months') as tenure from emp;
#9.1. Display hire_date, current_date, tenure(calculated col) of the employee in months
select hiredate,current_date(),concat((timestampdiff(month,hiredate,current_date())),' months') as tenure from emp;

#10. Display all the employees whose name starts with s
select * from emp where empname like "s%";

#11. Display unique department numbers from the employee table
select DISTINCT deptno from emp;

#12. Display emp_name and job in lower case
select lower(empname),lower(job) from emp;

#13. Select top 3 salary earning employee
select sal from emp  order by sal desc limit 3;

# 14.Select clerks and Managers in department 10
 select empname,job,deptno from emp where deptno=10 and (job="CLERK" or  JOB='MANAGER');

#15. Display all clerks in ascending order of deptno
select * from emp where job='clerk' order by deptno;

#16.Display all employees department wise
select e.empname,d.deptname from emp e join department d on e.deptno=d.deptno order by d.deptname;

#17. Display how many employees are there for each job
select job,count(job) from emp group by job;

#18.Display what jobs are there for each department and number of employees for each job
select deptno,job,count(*) as noofemployees from emp group by job,deptno;

#19.Display how many employees are there for each department
select deptno,count(deptno) from emp group by deptno;

#20.Display the rank of each employee with respect to their salary (highest salary will be rank 1)
select empname,sal, rank() over (order by sal desc) as rankings from emp;



