
-- create view
create view vw_items
as
select it.Id, it.Name, it.Author, it.Price, it.Discount, it.Image, cat.Name as CatName
from Item it, Category cat
where it.CatId = cat.Id

-- test view
select * from vw_items
where id=1

select * from vw_items
where Name like '%Sách%'

select * from vw_items
where Price < 18000