USE [Activity20]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 16/09/2019 9:03:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[categoryId] [int] IDENTITY(1,1) NOT NULL,
	[categoryName] [varchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[categoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Song]    Script Date: 16/09/2019 9:03:46 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Song](
	[songid] [int] IDENTITY(1,1) NOT NULL,
	[songName] [varchar](50) NULL,
	[urlLink] [varchar](50) NULL,
 CONSTRAINT [PK_Song] PRIMARY KEY CLUSTERED 
(
	[songid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

GO
INSERT [dbo].[Category] ([categoryId], [categoryName]) VALUES (1, N'Books')
GO
INSERT [dbo].[Category] ([categoryId], [categoryName]) VALUES (2, N'Cloths')
GO
INSERT [dbo].[Category] ([categoryId], [categoryName]) VALUES (3, N'Fashion')
GO
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
