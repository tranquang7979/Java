
------ create new procedure
-- create proc prc_countItems
------ update a procedure
alter proc prc_countItems
AS
BEGIN
	-- declare variable
	declare @count int = 0

	print 'nItems'
	select @count = count(*) from Item

	select @count

	print @count
END

-- run a procedure
exec prc_countItems

-----------------------------------------------

alter proc prc_insertCategory(@CatName varchar(50), @Description varchar(50), @newId int output)
AS
BEGIN
	insert into Category
	values(@CatName, @Description)
	set @newId = @@IDENTITY
END

declare @newId int
exec prc_insertCategory 'Cat 1', 'This is Cat 1', @newId out
print @newId

select * from Category