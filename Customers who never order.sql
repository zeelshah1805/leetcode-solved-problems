
select name as "Customers"
from Customers
where id not in (Select customerId from Orders);
