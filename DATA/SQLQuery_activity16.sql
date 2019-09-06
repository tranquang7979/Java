
insert [dbo].[Category] ([Name],[description]) 
values (N'Sách tiếng việt',N'Sách tiếng việt')

select * from Category


update Category
set categoryName='English', [description] = 'no desc'
where id = 1


delete Category
where id=1