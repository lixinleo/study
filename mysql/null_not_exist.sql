(select null as SecondHighestSalary
where not exists (

    select Salary as SecondHighestSalary
from Employee
where Salary not in (select max(Salary) from Employee)
order by Salary Desc limit 1

))

union

(select Salary as SecondHighestSalary
from Employee
where Salary not in (select max(Salary) from Employee)
order by Salary Desc limit 1)
