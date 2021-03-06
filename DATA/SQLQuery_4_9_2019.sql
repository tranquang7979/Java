create database [Activity17DB]
go

USE [Activity17DB]

GO
/****** Object:  Table [dbo].[Category]    Script Date: 9/4/2019 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [varchar](50) NULL,
	[description] [varchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Item]    Script Date: 9/4/2019 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Item](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[itemName] [nvarchar](50) NULL,
	[price] [nvarchar](150) NULL,
	[discount] [int] NULL,
	[author] [nvarchar](150) NULL,
	[image] [varchar](50) NULL,
	[categoryId] [int] NULL,
 CONSTRAINT [PK_Item] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[UserAccounts]    Script Date: 9/4/2019 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[UserAccounts](
	[userName] [varchar](50) NOT NULL,
	[password] [varchar](50) NULL,
	[roles] [varchar](50) NULL,
 CONSTRAINT [PK_UserAccounts] PRIMARY KEY CLUSTERED 
(
	[userName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[vw_items]    Script Date: 9/4/2019 9:03:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create view [dbo].[vw_items]
as

select it.[id],[itemName],[author],[price],[discount],[image],[categoryName]
from [dbo].[Item] it ,[dbo].[Category] ca
where it.categoryId = ca.id
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

GO
INSERT [dbo].[Category] ([id], [categoryName], [description]) VALUES (1, N'Sách tiếng anh', NULL)
GO
INSERT [dbo].[Category] ([id], [categoryName], [description]) VALUES (2, N'Sách tiếng việt', NULL)
GO
INSERT [dbo].[Category] ([id], [categoryName], [description]) VALUES (3, N'Sách tham  khảo', NULL)
GO
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Item] ON 

GO
INSERT [dbo].[Item] ([id], [itemName], [price], [discount], [author], [image], [categoryId]) VALUES (1, N'Sách Family and Friends 1', N'128000', 10, N'KK', N'1.jpg', 1)
GO
INSERT [dbo].[Item] ([id], [itemName], [price], [discount], [author], [image], [categoryId]) VALUES (3, N'Sách Family and Friends 2', N'128000', 10, N'KK', N'2.jpg', 1)
GO
INSERT [dbo].[Item] ([id], [itemName], [price], [discount], [author], [image], [categoryId]) VALUES (4, N'Sách toán 1', N'16000', 10, N'kk', N'3.jpg', 2)
GO
INSERT [dbo].[Item] ([id], [itemName], [price], [discount], [author], [image], [categoryId]) VALUES (5, N'Sách bài tập toán 1', N'8000', 10, N'kk', N'4.jpg', 3)
GO
SET IDENTITY_INSERT [dbo].[Item] OFF
GO
INSERT [dbo].[UserAccounts] ([userName], [password], [roles]) VALUES (N'admin', N'123456', N'admin')
GO
ALTER TABLE [dbo].[Item]  WITH CHECK ADD  CONSTRAINT [FK_Item_Category] FOREIGN KEY([categoryId])
REFERENCES [dbo].[Category] ([id])
GO
ALTER TABLE [dbo].[Item] CHECK CONSTRAINT [FK_Item_Category]
GO
