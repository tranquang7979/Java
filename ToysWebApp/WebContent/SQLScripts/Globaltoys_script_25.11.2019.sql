USE [master]
GO
/****** Object:  Database [GlobalToyz]    Script Date: 25/11/2019 8:42:33 PM ******/
CREATE DATABASE [GlobalToyz]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'GlobalToyz', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\GlobalToyz.mdf' , SIZE = 3136KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'GlobalToyz_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\GlobalToyz_log.ldf' , SIZE = 784KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [GlobalToyz] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [GlobalToyz].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [GlobalToyz] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [GlobalToyz] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [GlobalToyz] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [GlobalToyz] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [GlobalToyz] SET ARITHABORT OFF 
GO
ALTER DATABASE [GlobalToyz] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [GlobalToyz] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [GlobalToyz] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [GlobalToyz] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [GlobalToyz] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [GlobalToyz] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [GlobalToyz] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [GlobalToyz] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [GlobalToyz] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [GlobalToyz] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [GlobalToyz] SET  ENABLE_BROKER 
GO
ALTER DATABASE [GlobalToyz] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [GlobalToyz] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [GlobalToyz] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [GlobalToyz] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [GlobalToyz] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [GlobalToyz] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [GlobalToyz] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [GlobalToyz] SET RECOVERY FULL 
GO
ALTER DATABASE [GlobalToyz] SET  MULTI_USER 
GO
ALTER DATABASE [GlobalToyz] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [GlobalToyz] SET DB_CHAINING OFF 
GO
ALTER DATABASE [GlobalToyz] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [GlobalToyz] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
EXEC sys.sp_db_vardecimal_storage_format N'GlobalToyz', N'ON'
GO
USE [GlobalToyz]
GO
/****** Object:  UserDefinedDataType [dbo].[id]    Script Date: 25/11/2019 8:42:33 PM ******/
CREATE TYPE [dbo].[id] FROM [char](6) NOT NULL
GO
/****** Object:  StoredProcedure [dbo].[prcGenOrder]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[prcGenOrder]
@OrderNo char(6)OUTPUT
as
SELECT @OrderNo=Max(cOrderNo) FROM Orders
SELECT @OrderNo= 
CASE 
	WHEN @OrderNo >=0 and @OrderNo<9 Then '00000'+Convert(char,@OrderNo+1)
	WHEN @OrderNo>=9 and @OrderNo<99 Then '0000'+Convert(char,@OrderNo+1)
	WHEN @OrderNo>=99 and @OrderNo<999 Then '000'+Convert(char,@OrderNo+1)
	WHEN @OrderNo>=999 and @OrderNo<9999 Then '00'+Convert(char,@OrderNo+1)
	WHEN @OrderNo>=9999 and @OrderNo<99999 Then '0'+Convert(char,@OrderNo+1)
	WHEN @OrderNo>=99999 Then Convert(char,@OrderNo+1)
END
RETURN  


GO
/****** Object:  Table [dbo].[Category]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Category](
	[cCategoryId] [char](3) NOT NULL,
	[cCategory] [char](20) NOT NULL,
	[vDescription] [varchar](100) NULL,
 CONSTRAINT [ct_pk] PRIMARY KEY CLUSTERED 
(
	[cCategoryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ContactUs]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ContactUs](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](100) NULL,
	[Email] [varchar](50) NULL,
	[Phone] [varchar](15) NULL,
	[Contents] [nvarchar](250) NULL,
 CONSTRAINT [PK_ContactUs] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Country]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Country](
	[cCountryId] [char](3) NOT NULL,
	[cCountry] [char](25) NOT NULL,
 CONSTRAINT [c_pk] PRIMARY KEY CLUSTERED 
(
	[cCountryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[cOrderNo] [char](6) NOT NULL,
	[cToyId] [char](6) NOT NULL,
	[siQty] [smallint] NOT NULL,
	[cGiftWrap] [char](1) NULL,
	[cWrapperId] [char](3) NULL,
	[vMessage] [varchar](256) NULL,
	[mToyCost] [money] NULL,
 CONSTRAINT [z_key] PRIMARY KEY CLUSTERED 
(
	[cOrderNo] ASC,
	[cToyId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Orders](
	[cOrderNo] [char](6) NOT NULL,
	[dOrderDate] [datetime] NOT NULL,
	[cCartId] [char](6) NOT NULL,
	[cShopperId] [char](6) NOT NULL,
	[cShippingModeId] [char](2) NULL,
	[mShippingCharges] [money] NULL,
	[mGiftWrapCharges] [money] NULL,
	[cOrderProcessed] [char](1) NULL,
	[mTotalCost] [money] NULL,
	[dExpDelDate] [datetime] NULL,
 CONSTRAINT [CO_PK] PRIMARY KEY CLUSTERED 
(
	[cOrderNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PickOfMonth]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[PickOfMonth](
	[cToyId] [char](6) NOT NULL,
	[siMonth] [smallint] NOT NULL,
	[iYear] [int] NOT NULL,
	[iTotalSold] [int] NULL,
 CONSTRAINT [POM_PK] PRIMARY KEY CLUSTERED 
(
	[cToyId] ASC,
	[siMonth] ASC,
	[iYear] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Recipient]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Recipient](
	[cOrderNo] [char](6) NOT NULL,
	[vFirstName] [varchar](20) NOT NULL,
	[vLastName] [varchar](20) NOT NULL,
	[vAddress] [varchar](20) NOT NULL,
	[cCity] [char](15) NOT NULL,
	[cState] [char](15) NOT NULL,
	[cCountryId] [char](3) NULL,
	[cZipCode] [char](10) NULL,
	[cPhone] [char](15) NULL,
 CONSTRAINT [RCP_PK] PRIMARY KEY CLUSTERED 
(
	[cOrderNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shipment]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shipment](
	[cOrderNo] [char](6) NOT NULL,
	[dShipmentDate] [datetime] NULL,
	[cDeliveryStatus] [char](1) NULL,
	[dActualDeliveryDate] [datetime] NULL,
 CONSTRAINT [SHP_PK] PRIMARY KEY CLUSTERED 
(
	[cOrderNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ShippingMode]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShippingMode](
	[cModeId] [char](2) NOT NULL,
	[cMode] [char](25) NOT NULL,
	[iMaxDelDays] [int] NULL,
 CONSTRAINT [spm_pk] PRIMARY KEY CLUSTERED 
(
	[cModeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ShippingRate]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShippingRate](
	[cCountryID] [char](3) NOT NULL,
	[cModeId] [char](2) NOT NULL,
	[mRatePerPound] [money] NOT NULL,
 CONSTRAINT [SR_PRK] PRIMARY KEY CLUSTERED 
(
	[cCountryID] ASC,
	[cModeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Shopper]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Shopper](
	[cShopperId] [char](6) NOT NULL,
	[cPassword] [char](10) NOT NULL,
	[vFirstName] [varchar](20) NOT NULL,
	[vLastName] [varchar](20) NOT NULL,
	[vEmailId] [varchar](40) NOT NULL,
	[vAddress] [varchar](40) NOT NULL,
	[cCity] [char](15) NOT NULL,
	[cState] [char](15) NOT NULL,
	[cCountryId] [char](3) NULL,
	[cZipCode] [char](10) NULL,
	[cPhone] [char](15) NOT NULL,
	[cCreditCardNo] [char](16) NOT NULL,
	[vCreditCardType] [varchar](15) NOT NULL,
	[dExpiryDate] [datetime] NULL,
 CONSTRAINT [s_id] PRIMARY KEY CLUSTERED 
(
	[cShopperId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ShoppingCart]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ShoppingCart](
	[cCartId] [char](6) NOT NULL,
	[cToyId] [char](6) NOT NULL,
	[siQty] [smallint] NOT NULL,
 CONSTRAINT [SCHP_PK] PRIMARY KEY CLUSTERED 
(
	[cCartId] ASC,
	[cToyId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ToyBrand]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ToyBrand](
	[cBrandId] [char](3) NOT NULL,
	[cBrandName] [char](20) NOT NULL,
 CONSTRAINT [TB_pk] PRIMARY KEY CLUSTERED 
(
	[cBrandId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Toys]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Toys](
	[cToyId] [char](6) NOT NULL,
	[vToyName] [varchar](20) NOT NULL,
	[vToyDescription] [varchar](250) NULL,
	[cCategoryId] [char](3) NULL,
	[mToyRate] [money] NOT NULL,
	[cBrandId] [char](3) NULL,
	[imPhoto] [image] NULL,
	[siToyQoh] [smallint] NOT NULL,
	[siLowerAge] [smallint] NOT NULL,
	[siUpperAge] [smallint] NOT NULL,
	[siToyWeight] [smallint] NULL,
	[vToyImgPath] [varchar](50) NULL,
 CONSTRAINT [t_id] PRIMARY KEY CLUSTERED 
(
	[cToyId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Wrapper]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Wrapper](
	[cWrapperId] [char](3) NOT NULL,
	[vDescription] [varchar](20) NULL,
	[mWrapperRate] [money] NOT NULL,
	[imPhoto] [image] NULL,
	[vWrapperImgPath] [varchar](50) NULL,
 CONSTRAINT [w_id] PRIMARY KEY CLUSTERED 
(
	[cWrapperId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  View [dbo].[View_2]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_2]
AS
SELECT     dbo.Toys.cToyId, dbo.Toys.vToyName, dbo.Category.cCategory
FROM         dbo.Category INNER JOIN
                      dbo.Toys ON dbo.Category.cCategoryId = dbo.Toys.cCategoryId


GO
/****** Object:  View [dbo].[VW_3]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

 CREATE VIEW [dbo].[VW_3]
 AS
 SELECT * FROM VIEW_2 WHERE cCategory='Activity'

GO
/****** Object:  View [dbo].[View_1]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[View_1]
AS
SELECT     cCategoryId, cCategory
FROM         dbo.Category


GO
/****** Object:  View [dbo].[VW_1]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
 CREATE VIEW [dbo].[VW_1]
 AS

 SELECT * FROM [Category] WHERE CCATEGORYID IN('001','003')

GO
/****** Object:  View [dbo].[vw_hoadon]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create view [dbo].[vw_hoadon]
as
select [cOrderNo],[dOrderDate],[mTotalCost],s.[cShopperId],c.[cCartId],[vFirstName],[vLastName],c.[cToyId],[siQty],[vToyName],[mToyRate], 'line total' =[siQty]*[mToyRate]
from

[dbo].[Orders] o  join [dbo].[Shopper] s
on o.cShopperId = s.cShopperId 

join  [dbo].[ShoppingCart] c on c.cCartId = o.cCartId

join [dbo].[Toys] t on t.cToyId = c.cToyId

-- 

GO
/****** Object:  View [dbo].[vwOrderWrapper]    Script Date: 25/11/2019 8:42:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

Create view [dbo].[vwOrderWrapper]
as
SELECT cOrderNo,cToyId,siQty,vDescription,mWrapperRate
FROM OrderDetail JOIN Wrapper
ON OrderDetail.cWrapperId=Wrapper.cWrapperId


GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'001', N'Activity            ', N'Activity toys encourage the childs social skills and interest in the world around them.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'002', N'Dolls               ', N'A wide range of dolls from all the leading brands.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'003', N'Arts And Crafts     ', N'Encourage children to create masterpieces with these incredible craft kits.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'004', N'Games               ', N'A complete range of new and classic games.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'005', N'Cars N Racing       ', N'Models of all current and vintage cars.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'006', N'Pretend Play        ', N'These games can play an important part in the childs development.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'007', N'Model Kits          ', N'Models to build planes, cars, ships and much more.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'008', N'Infant              ', N'Colorful, interactive toys for babies.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'009', N'Stuffed Toys        ', N'Teddy bears, monkeys and many more soft toys.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'010', N'Learning            ', N'Designed to make learning so much fun that children will forget they are learning at the same time')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'011', N'Science and Nature  ', N'Toys which encourage children to explore the world around them.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'012', N'Musical toys        ', N'These toys generate music, sound and songs too.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'013', N'Electronic          ', N'These are electronic toys, which run using batteries.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'014', N'Puppets             ', N'These are puppet toys.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'015', N'Trains              ', N'These trains will be the pride of any railway system.')
GO
INSERT [dbo].[Category] ([cCategoryId], [cCategory], [vDescription]) VALUES (N'016', N'Construction Toys   ', N'Bricks, building and other toys the will encourage children to build model houses and buildings.')
GO
SET IDENTITY_INSERT [dbo].[ContactUs] ON 

GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (1, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (2, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (3, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (4, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (5, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (6, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (7, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (8, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (9, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (10, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
INSERT [dbo].[ContactUs] ([Id], [Title], [Email], [Phone], [Contents]) VALUES (11, N'User01', N'user01@gmail.com', N'0365478969', N'Vui long lien he truoc khi giao hang')
GO
SET IDENTITY_INSERT [dbo].[ContactUs] OFF
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'001', N'United states of America ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'002', N'Albania                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'003', N'Andorra                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'004', N'Argentina                ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'005', N'Austria                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'006', N'Bangladesh               ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'007', N'Belgium                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'008', N'Bosnia & Herzegovina     ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'009', N'Bulgaria                 ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'010', N'Czech Republic           ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'011', N'Denmark                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'012', N'Yugoslavia               ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'013', N'France                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'014', N'Gibraltar                ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'015', N'Greece                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'016', N'Georgia                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'017', N'Croatia                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'018', N'Estonia                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'019', N'Iceland                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'020', N'Italy                    ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'021', N'Israel                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'022', N'India                    ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'023', N'Cyprus                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'024', N'Russia                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'025', N'Liechtenstein            ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'027', N'Lithuania                ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'028', N'Luxembourg               ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'030', N'Malta                    ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'031', N'Moldova                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'032', N'Monaco                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'033', N'Netherlands              ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'034', N'Norway                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'035', N'Poland                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'036', N'Portugal                 ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'037', N'Romania                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'038', N'San Marino               ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'039', N'Slovak Republic          ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'040', N'Slovenia                 ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'041', N'Finland                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'042', N'Spain                    ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'043', N'Switzerland              ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'044', N'Turkey                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'045', N'Ukraine                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'046', N'Hungary                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'047', N'Germany                  ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'048', N'Sweden                   ')
GO
INSERT [dbo].[Country] ([cCountryId], [cCountry]) VALUES (N'049', N'Latvia                   ')
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000001', N'000007', 2, N'N', NULL, NULL, 39.9800)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000001', N'000008', 1, N'Y', N'002', N'Surprise', 14.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000002', N'000016', 2, N'Y', N'001', N'I Love you', 86.5000)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000003', N'000017', 3, N'N', NULL, NULL, 71.9700)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000004', N'000030', 1, N'Y', N'001', N'I Love You', 35.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000005', N'000001', 4, N'Y', N'001', N'Happy Birthday', 35.9600)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000005', N'000024', 1, N'Y', N'002', N'Best Wishes', 25.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000005', N'000030', 2, N'Y', N'002', N'Surprise', 71.9800)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000006', N'000013', 2, N'Y', N'003', N'Happy Birth day', 23.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000006', N'000017', 1, N'Y', N'001', N'With love', 29.9800)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000007', N'000006', 1, N'N', NULL, NULL, 12.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000008', N'000023', 2, N'Y', N'001', N'For you with love', 31.9800)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000009', N'000018', 1, N'Y', N'004', N'Congratulations', 16.9900)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000010', N'000020', 2, N'Y', N'005', N'You are the best', 17.9800)
GO
INSERT [dbo].[OrderDetail] ([cOrderNo], [cToyId], [siQty], [cGiftWrap], [cWrapperId], [vMessage], [mToyCost]) VALUES (N'000010', N'000021', 1, N'Y', N'001', N'Happy Birth day', 25.9900)
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000001', CAST(N'2001-05-20 00:00:00.000' AS DateTime), N'000002', N'000002', N'01', 6.0000, 1.2500, N'Y', 62.2200, CAST(N'2001-05-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000002', CAST(N'2001-05-20 00:00:00.000' AS DateTime), N'000001', N'000005', N'02', 8.0000, 2.0000, N'Y', 96.5000, CAST(N'2001-05-23 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000003', CAST(N'2001-05-20 00:00:00.000' AS DateTime), N'000003', N'000007', N'01', 12.0000, 0.0000, N'Y', 83.9700, CAST(N'2001-05-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000004', CAST(N'2001-05-20 00:00:00.000' AS DateTime), N'000004', N'000006', N'01', 4.0000, 1.0000, N'Y', 40.9900, CAST(N'2001-05-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000005', CAST(N'2001-05-21 00:00:00.000' AS DateTime), N'000005', N'000002', N'03', 90.0000, 7.7500, N'Y', 231.6800, CAST(N'2001-05-25 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000006', CAST(N'2001-05-21 00:00:00.000' AS DateTime), N'000003', N'000012', N'03', 40.0000, 4.0000, N'Y', 97.9700, CAST(N'2001-05-22 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000007', CAST(N'2001-05-22 00:00:00.000' AS DateTime), N'000002', N'000008', N'01', 4.0000, 0.0000, N'Y', 16.9900, CAST(N'2001-05-26 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000008', CAST(N'2001-05-22 00:00:00.000' AS DateTime), N'000002', N'000009', N'03', 20.0000, 2.0000, N'Y', 53.9800, CAST(N'2001-05-26 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000009', CAST(N'2001-05-22 00:00:00.000' AS DateTime), N'000004', N'000010', N'02', 8.0000, 2.0000, N'Y', 26.9900, CAST(N'2001-05-25 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Orders] ([cOrderNo], [dOrderDate], [cCartId], [cShopperId], [cShippingModeId], [mShippingCharges], [mGiftWrapCharges], [cOrderProcessed], [mTotalCost], [dExpDelDate]) VALUES (N'000010', CAST(N'2001-05-22 00:00:00.000' AS DateTime), N'000005', N'000003', N'02', 20.0000, 4.0000, N'Y', 67.9700, CAST(N'2001-05-26 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000001', 1, 2000, 1000)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000001', 2, 2000, 1230)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000002', 6, 2000, 3000)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000003', 5, 2000, 2000)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000003', 7, 2000, 5670)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000005', 3, 2000, 4000)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000007', 4, 2000, 5000)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000007', 8, 2000, 2340)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000011', 9, 2000, 5600)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000012', 3, 2001, 2500)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000015', 2, 2001, 3100)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000020', 10, 2000, 2300)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000021', 11, 2000, 4500)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000024', 1, 2001, 3200)
GO
INSERT [dbo].[PickOfMonth] ([cToyId], [siMonth], [iYear], [iTotalSold]) VALUES (N'000026', 12, 2000, 6500)
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000001', N'Barbara', N'Johnson', N'227 Beach Ave.', N'Sunnyvale      ', N'California     ', N'001', N'94087-1147', N'123-5673       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000002', N'Catherine', N'Roberts', N'5508 Aquiline Court', N'San Jose       ', N'California     ', N'001', N'95233-4123', N'445-2256       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000003', N'Christopher', N'Davis', N'4896 11th ST', N'Hill Avenue    ', N'Utah           ', N'001', N'84056-5410', N'556-9087       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000004', N'Jennifer', N'Martin', N'9812  76th Street', N'Brooklyn       ', N'Maryland       ', N'001', N'21254-0025', N'569-7789       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000005', N'Barbara', N'Johnson', N'227 Beach Ave.', N'Sunnyvale      ', N'California     ', N'001', N'94087-1147', N'123-5673       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000006', N'Donna', N'Anderson', N'7930 Orange St.', N'Las Vegas      ', N'Nevada         ', N'001', N'89328-2517', N'845-2323       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000007', N'Laura', N'Rodriguez', N'3242 Limestone  ', N'WayMarietta    ', N'Georgia        ', N'001', N'30062-5423', N'567-3345       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000008', N'Michelle', N'Hernandez', N'1353 Realm Lakes', N'Naperville     ', N'Illinois       ', N'001', N'60563-1256', N'294-5385       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000009', N'David', N'Moore', N'8808 Joviality Drive', N'San Ramon      ', N'California     ', N'001', N'94453-5849', N'982-5577       ')
GO
INSERT [dbo].[Recipient] ([cOrderNo], [vFirstName], [vLastName], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone]) VALUES (N'000010', N'Betty', N'Williams', N'1 Tread Road', N'Virginia Beach ', N'Virginia       ', N'001', N'23455-2456', N'458-3299       ')
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000001', CAST(N'2001-05-23 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000002', CAST(N'2001-05-23 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-23 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000003', CAST(N'2001-05-23 00:00:00.000' AS DateTime), N's', NULL)
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000004', CAST(N'2001-05-24 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-26 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000005', CAST(N'2001-05-24 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-25 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000006', CAST(N'2001-05-22 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-23 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000007', CAST(N'2001-05-25 00:00:00.000' AS DateTime), N's', NULL)
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000008', CAST(N'2001-05-24 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000009', CAST(N'2001-05-24 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-25 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shipment] ([cOrderNo], [dShipmentDate], [cDeliveryStatus], [dActualDeliveryDate]) VALUES (N'000010', CAST(N'2001-05-26 00:00:00.000' AS DateTime), N'd', CAST(N'2001-05-28 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ShippingMode] ([cModeId], [cMode], [iMaxDelDays]) VALUES (N'01', N'Standard Shipping        ', 4)
GO
INSERT [dbo].[ShippingMode] ([cModeId], [cMode], [iMaxDelDays]) VALUES (N'02', N'World Mail               ', 3)
GO
INSERT [dbo].[ShippingMode] ([cModeId], [cMode], [iMaxDelDays]) VALUES (N'03', N'International Priority   ', 1)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'001', N'01', 2.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'001', N'02', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'001', N'03', 10.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'002', N'01', 3.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'002', N'02', 6.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'002', N'03', 10.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'003', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'003', N'02', 6.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'003', N'03', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'004', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'004', N'02', 8.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'004', N'03', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'005', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'005', N'02', 8.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'005', N'03', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'006', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'006', N'02', 8.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'006', N'03', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'007', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'007', N'02', 6.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'007', N'03', 10.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'008', N'01', 4.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'008', N'02', 5.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'008', N'03', 8.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'009', N'01', 10.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'009', N'02', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'009', N'03', 15.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'010', N'01', 10.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'010', N'02', 12.0000)
GO
INSERT [dbo].[ShippingRate] ([cCountryID], [cModeId], [mRatePerPound]) VALUES (N'010', N'03', 15.0000)
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000001', N'angels    ', N'Angela', N'Smith', N'angelas@qmail.com', N'16223 Radiance Court', N'Woodbridge     ', N'Virginia       ', N'001', N'22191     ', N'227-2344       ', N'6947343412896785', N'Master Card', CAST(N'2001-08-09 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000002', N'guide     ', N'Barbara', N'Johnson', N'barbaraj@speedmail.com', N'227 Beach Ave.', N'Sunnyvale      ', N'California     ', N'001', N'94087-1147', N'123-5673       ', N'5345146765854356', N'Master Card', CAST(N'2001-04-10 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000003', N'youbet    ', N'Betty', N'Williams', N'bettyw@dpeedmil.cm', N'1 Tread Road', N'Virginia Beach ', N'Varginia       ', N'001', N'23455     ', N'458-3299       ', N'4747343412896785', N'Visa Card', CAST(N'2001-12-12 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000004', N'credit    ', N'Carol', N'Jones', N'carolj@qmail.com', N'765 - Furling Road Apt 112  ', N'Boone          ', N'North Carolina ', N'001', N'28607     ', N'678-4544       ', N'6344676854335436', N'Visa Card', CAST(N'2001-10-12 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000005', N'prepare   ', N'Catherine', N'Roberts', N'catheriner@qmail.com', N'5508 Aquiline Court', N'San Jose       ', N'California     ', N'001', N'95123     ', N'445-2256       ', N'3756784562869963', N'Master Card', CAST(N'2001-09-10 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000006', N'Char      ', N'Charles', N'Brown', N'charlesb@speedmail.com', N'7822 S. Glitzy Avenue ', N'Maitland       ', N'Florida        ', N'001', N'32751     ', N'225-6678       ', N'3454678545443344', N'Visa Card', CAST(N'2001-10-09 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000007', N'chris     ', N'Christopher', N'Davis', N'Christopherd@qmail.com', N'4896 11th ST  ', N'Hill Avenue    ', N'Utah           ', N'001', N'84056-5410', N'556-9087       ', N'7899887675443322', N'Visa Card', CAST(N'2001-10-02 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000008', N'mills     ', N'Cynthia', N'Miller', N'cynthiam@qmailcom', N'98066 Weary Storm Street', N'Moon Park      ', N'California     ', N'001', N'93021-2930', N'422-5688       ', N'2345566576879900', N'Master Card', CAST(N'2001-08-09 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000009', N'gotcha    ', N'Daniel', N'Wilson', N'danielw@speedmail.com', N'4642 Peripheral Drive  ', N'Brecksville    ', N'Ohio           ', N'001', N'44141     ', N'454-2246       ', N'2345467890986745', N'Visa Card', CAST(N'2001-11-02 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000010', N'bingo     ', N'David', N'Moore', N'davidm@qmail.com', N'8808 Joviality Drive   ', N'San Ramon      ', N'California     ', N'001', N'94583     ', N'982-5577       ', N'2343556678799674', N'Visa Card', CAST(N'2001-11-12 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000011', N'chubby    ', N'Deborah', N'Taylor', N'deboraht@qmail.com', N'2199- Fairfax Drive ', N'Libertyville   ', N'Illinois       ', N'001', N'60048     ', N'889-2235       ', N'2345468798078563', N'Master Card', CAST(N'2001-11-23 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000012', N'smile     ', N'Donna', N'Anderson', N'Donnaa@speedmail.com ', N'7930 Orange St. ', N'Las Vegas      ', N'Nevada         ', N'001', N'89117     ', N'845-2323       ', N'2314345676568766', N'Visa Card', CAST(N'2001-11-24 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000013', N'benhur    ', N'Dorothy', N'Thomas', N'dorthyt@speedmail.com', N'678 East 56th Street- #12', N'New York       ', N'New York       ', N'001', N'10009     ', N'696-2278       ', N'8765435456678754', N'Visa Card', CAST(N'2001-12-03 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000014', N'benjy     ', N'Elizabeth', N'Jackson', N'elizabethj@qmail.com', N'598 Apex Avenue #2', N'Saint Paul     ', N'Minnesota      ', N'001', N'55102     ', N'545-9078       ', N'4576544354567542', N'Visa Card', CAST(N'2001-10-06 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000015', N'sundance  ', N'Frances', N'Turner         ', N'francest@speedmail.com', N'2562 Eastwood  ', N'Denton         ', N'Texas          ', N'001', N'76205-5922', N'878-6670       ', N'5676879007565452', N'Master Card', CAST(N'2001-08-30 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000016', N'bopeep    ', N'Helen', N'White', N'helenw@spedmail.com', N'Fleet Street', N'Point Pleasant ', N'Pennsylvania   ', N'001', N'18950     ', N'585-7796       ', N'4564564564564565', N'Visa Card', CAST(N'2001-10-10 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000017', N'momma     ', N'James', N'Harris', N' helenw@spedmail.com', N'3456 Mt. Regale Drive  ', N'1509 Alexandria', N'Virginia       ', N'001', N'22303-2541', N'335-6678       ', N'4657567545344544', N'Master Card', CAST(N'2001-10-31 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000018', N'grumpy    ', N'Jennifer', N'Martin', N'jenniferm@qmail.com', N'9812  76th Street  ', N'Brooklyn       ', N'Maryland       ', N'001', N'21225     ', N'569-7789       ', N'9775445343233443', N'Visa Card', CAST(N'2001-09-01 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000019', N'patch     ', N'Jessica', N'Thompson', N'jessicat@speedmail.com', N'565 Pebble St. ', N'Arlington      ', N'Texas          ', N'001', N'76014     ', N'445-6797       ', N'9766545343233455', N'Master Card', CAST(N'2001-09-19 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000020', N'sunshine  ', N'John', N'Garcia', N'johng@qmail.com', N'2234 B King Henry Drive ', N'Harrisburg     ', N'Pennsylvania   ', N'001', N'17109     ', N'521-9095       ', N'8764554334534567', N'Master Card', CAST(N'2001-09-13 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000021', N'good      ', N'Joseph', N'Martinez', N'josephm@qmail.com', N'995 Rind Street ', N'Loma Linda     ', N'California     ', N'001', N'92354     ', N'456-9032       ', N'5687567567435344', N'Visa Card', CAST(N'2001-05-31 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000022', N'nestle    ', N'Joyce', N'Phillips', N'joycep@speedmail.com', N'535 Darwin Avenue ', N'Bridgeville    ', N'Pennsylvania   ', N'001', N'15017     ', N'789-6905       ', N'2345345345645656', N'Master Card', CAST(N'2001-09-15 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000023', N'hangon    ', N'Karen', N'Robinson', N'karenr@qmail.com', N'2343-A Flowers Ferry Road    ', N'Marietta       ', N'Georgia        ', N'001', N'30067     ', N'334-5568       ', N'4546575675687689', N'Visa Card', CAST(N'2000-02-26 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000024', N'rumble    ', N'Kimberly', N'Clark', N'kimberlyc@speedmail.com', N'79 Holler Valley Road ', N'Little Rock    ', N'Arkansas       ', N'001', N'72204     ', N'645-9023       ', N'2345653757898999', N'Master Card', CAST(N'2000-05-31 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000025', N'noddy     ', N'Laura', N'Rodriguez', N'laurar@speedmail.com', N'3242 Limestone', N'WayMarietta    ', N'Georgia        ', N'001', N'30062     ', N'567-3345       ', N'2345345676786543', N'Visa Card', CAST(N'2000-03-03 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000026', N'falcon    ', N'Linda', N'Lewis', N'lindal@qmail.com', N'1524 Patagonia Lane ', N'Plano          ', N'Texas          ', N'001', N'75075     ', N'459-4563       ', N'8765434523543366', N'Visa Card', CAST(N'2000-03-14 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000027', N'lazer     ', N'Lisa', N'Lee', N'lisal@speedmail.com', N'18927 Sandstone Ave N ', N'Seattle        ', N'Washington     ', N'001', N'98133     ', N'897-3345       ', N'7653534745756567', N'Master Card', CAST(N'2001-08-30 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000028', N'spartan   ', N'Margaret', N'Walker', N'margaretw@speedmail.com', N'405 SE Aden #101 ', N'Pullman        ', N'Washington     ', N'001', N'99163     ', N'567-9083       ', N'9867865434534467', N'Master Card', CAST(N'2001-07-09 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000029', N'zedi      ', N'Maria', N'Hall', N'Mariah@speedmail.com', N'936 Midland Drive · ', N'Rochester      ', N'New York       ', N'001', N'14609     ', N'345-8764       ', N'9786434564564567', N'Visa Card', CAST(N'2000-04-06 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000030', N'norman    ', N'Mary', N'Allen', N'marya@qmail.com', N'1202 Heathcliff Drive ', N'Urbana         ', N'Illinois       ', N'001', N'61801-5304', N'749-3096       ', N'8674564574574356', N'Master Card', CAST(N'2000-04-23 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000031', N'denice    ', N'Michael', N'Young', N'michaely@speedmail.com', N'440 Allens Trail', N'Montgomery     ', N'Alabama        ', N'001', N'36117     ', N'560-9004       ', N'3478786786785677', N'Master Card', CAST(N'2000-02-21 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000032', N'kate      ', N'Michelle', N'Hernandez', N'michelleh@speedmail.com', N'1353 Realm Lakes ', N'Naperville     ', N'Illinois       ', N'001', N'60563     ', N'294-5385       ', N'6965753564534554', N'Visa Card', CAST(N'2000-01-02 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000033', N'pirate    ', N'Nancy', N'King', N'nancyk@qmail.com', N'429 Ash Birch Lane  ', N'North Andover  ', N'Massachusetts  ', N'001', N'01845     ', N'563-2298       ', N'3464276587468846', N'Master Card', CAST(N'2000-01-01 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000034', N'titanic   ', N'Patricia', N'Wright', N'patreciaw@speedmail.com', N'5689 Marshland Road ', N'Clayton        ', N'California     ', N'001', N'94517-1440', N'345-8765       ', N'3743567985785344', N'Master Card', CAST(N'2000-02-21 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000035', N'fire      ', N'Paul', N'Lopez', N'paull@qmail.com', N'13459 Campton Street ', N'Sherman Oaks   ', N'California     ', N'001', N'91401     ', N'912-7905       ', N'4436465768677778', N'Master Card', CAST(N'2000-03-03 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000036', N'pizza     ', N'Richard', N'Hill', N'richardh@speedmail.com', N'1125 Feeder Road ', N'Glencoe        ', N'Illinois       ', N'001', N'60022     ', N'459-8749       ', N'9568765745645666', N'Visa Card', CAST(N'2001-10-06 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000037', N'heman     ', N'Robert', N'Scott', N'Roberts@speedmail.com', N'5296 Hardboard Dr ', N'Oakland        ', N'California     ', N'001', N'94618     ', N'709-5565       ', N'8678457546556555', N'Master Card', CAST(N'2001-10-02 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000038', N'herby     ', N'Ruth', N'Green', N'ruthg@speedmail.com', N'459 Ridge Road ', N'Mendham        ', N'New Jersey     ', N'001', N'07945     ', N'347-9082       ', N'9887654445423443', N'Visa Card', CAST(N'2001-12-02 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000039', N'superman  ', N'Sandra', N'Adams', N'Sandra@qmail.com', N'12454 Boggy Blvd. ', N'Orlando        ', N'Florida        ', N'001', N'32824     ', N'982-9503       ', N'7455463534636555', N'Master Card', CAST(N'2000-04-18 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000040', N'emerand   ', N'Sarah', N'Baker', N'sarahb@qmail.com', N'2394 Emerald Street ', N'Tarzana        ', N'California     ', N'001', N'91356     ', N'439-2309       ', N'8745654544323343', N'Visa Card', CAST(N'2000-07-30 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000041', N'hills     ', N'Sharon', N'Gonzalez', N'sharong@speedmail.com', N'1289 Belvedere Street  ', N'Hillsdale      ', N'New Jersey     ', N'001', N'07642-0006', N'230-8040       ', N'8765563434543554', N'Master Card', CAST(N'2000-11-27 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000042', N'apartment ', N'Shirley', N'Nelson', N'shirlyn@speedmail.com', N'56700 Chain Boulevard Apartment # 899 ', N'Austin         ', N'Texas          ', N'001', N'78728     ', N'409-2387       ', N'8656554233242334', N'Master Card', CAST(N'2000-01-27 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000043', N'loft      ', N'Susan', N'Carter', N'susanc@speedmail.com', N'3478 Central St.  Loft 201  ', N'Dallas         ', N'Texas          ', N'001', N'75226     ', N'309-8056       ', N'9654323233457864', N'Visa Card', CAST(N'2001-12-29 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000044', N'sugar     ', N'Thomas', N'Mitchell', N'thomasm@qmail.com', N'2103 Ancient Fable Drive', N'Sugar Land     ', N'Texas          ', N'001', N'77478     ', N'408-3389       ', N'8545432346765545', N'Visa Card', CAST(N'2001-12-30 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000045', N'lakes     ', N'William', N'Perez', N'williamp@qmail.com', N'987 Tetragon Avenue ', N'Chickasha      ', N'Oklahoma       ', N'001', N'73018     ', N'234-8764       ', N'8553435667455454', N'Visa Card', CAST(N'2001-12-31 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000046', N'trail     ', N'David', N'Cooper', N'davidc@speedmail.com', N'5614 Raffle Court  ', N'Concord        ', N'California     ', N'001', N'94521     ', N'678-3458       ', N'7877654435543424', N'Master Card', CAST(N'2000-03-14 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000047', N'drive     ', N'Peter', N'Prescott', N'peterp@qmail.com', N'340 Miasma Drive', N'Edinboro       ', N'Pennsylvania   ', N'001', N'16412     ', N'890-4084       ', N'8965453446556577', N'Visa Card', CAST(N'2000-03-13 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000048', N'california', N'John', N'Doran', N'johnd@qmail.com', N'678 Warren Drive - Suite 2B ', N'Sunnyvale      ', N'California     ', N'001', N' 94086    ', N'349-9152       ', N'8565456533457545', N'Master Card', CAST(N'2000-03-14 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000049', N'clay      ', N'Jane', N'Schaffer', N'janes@qmail.com', N'521½ State Street', N'Annapolis      ', N'Maryland       ', N'001', N'21403     ', N'280-9999       ', N'8556543443545444', N'Visa Card', CAST(N'2001-10-08 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[Shopper] ([cShopperId], [cPassword], [vFirstName], [vLastName], [vEmailId], [vAddress], [cCity], [cState], [cCountryId], [cZipCode], [cPhone], [cCreditCardNo], [vCreditCardType], [dExpiryDate]) VALUES (N'000050', N'master    ', N'Heather', N'Landis', N'heatherl@speedmail.com', N'1204 West Draper', N'Chicago        ', N'Illinois       ', N'001', N'60614     ', N'765-2322       ', N'7545475565655433', N'Master Card', CAST(N'2001-10-15 00:00:00.000' AS DateTime))
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000001', N'000001', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000001', N'000007', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000001', N'000008', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000002', N'000009', 5)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000002', N'000016', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000003', N'000017', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000004', N'000004', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000004', N'000030', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000005', N'000001', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000005', N'000018', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000005', N'000024', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000005', N'000030', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000006', N'000013', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000006', N'000017', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000007', N'000006', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000008', N'000023', 1)
GO
INSERT [dbo].[ShoppingCart] ([cCartId], [cToyId], [siQty]) VALUES (N'000009', N'000018', 1)
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'001', N'Bobby               ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'002', N'Frances-Price       ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'003', N'The Bernie Kids     ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'004', N'Largo               ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'005', N'LAMOBIL             ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'006', N'Crazy World         ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'007', N'Brevet              ')
GO
INSERT [dbo].[ToyBrand] ([cBrandId], [cBrandName]) VALUES (N'008', N'Darden              ')
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000001', N'new', N'A giant Blue Whale with two heavy-duty handles that allow a child to ride on its back. ', N'001', 8.9900, N'001', 0x312E6A7067, 50, 3, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000002', N'new', N'Children enjoy playing with water.  The Water Channel System consists of 22 interchangeable pieces including a dock with moveable crane and a water wheel, which creates a current in the water and four boats', N'001', 33.9900, N'001', NULL, 60, 5, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000003', N'new', N'Step on the launch pad and the rocket is launched which sends a parachute slowly down to earth. ', N'001', 6.9900, N'003', NULL, 90, 7, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000004', N'new', N'Create artificial rainfall in your garden with this super deluge.', N'001', 35.9900, N'005', NULL, 74, 8, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000005', N'Light Show Lamp', N'Build a revolving, glowing mood lamp with a set of colorful scenes. ', N'002', 15.9900, N'001', NULL, 58, 7, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000006', N'Glass Decoration', N'Make your own beautiful, art work. Set includes eight paints, one paintbrush, patterns and complete instructions.', N'002', 12.9900, N'004', NULL, 99, 8, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000007', N'Tie Dye Kit', N'CHECK THE ORIGINAL TOY LIST', N'002', 19.9900, N'002', NULL, 76, 7, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000008', N'Alice in Wonderland', N'A huge coloring book.  ', N'002', 14.9900, N'001', NULL, 82, 4, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000009', N'Glamorous Doll', N'She is ready for her acting audition in this blue denim dress and jacket. To carry her film gear, she has a video camera and red tote bag. ', N'002', 18.9900, N'001', NULL, 39, 6, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000011', N'Sleeping Beauty Doll', N'Let your child enact this magical fairy tale with the Sleeping Beauty Doll. ', N'002', 18.9900, N'005', NULL, 65, 4, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000012', N'Pet Loving Doll', N'A beautiful doll with a small pet puppy.', N'002', 10.9900, N'001', NULL, 82, 4, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000013', N'Beautifull Hair Doll', N'Girls can change the hair style and color of this Doll .', N'002', 14.9900, N'003', NULL, 55, 4, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000015', N'Flower Loving Doll', N'A doll with a bouquet of flowers in her hand.', N'002', 49.9900, N'004', NULL, 43, 8, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000016', N'Victorian Dollhouse', N'A beautiful dollhouse that every girl will love.', N'002', 43.2500, N'003', NULL, 36, 5, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000017', N'Kitchen Set', N'A complete kitchen set with utensils, stove and all other kitchen gadgets.', N'006', 23.9900, N'002', NULL, 76, 5, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000018', N'Childrens Bedroom', N'A childrens bedroom set with bunk beds with a ladder and a closet. ', N'006', 16.9900, N'005', NULL, 15, 5, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000019', N'Nursery', N'A nursery with a crib and a baby.', N'006', 8.9900, N'001', NULL, 35, 4, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000020', N'Victorian Family ', N'Let your child travel back in time and out for a stroll with this Victorian family. ', N'006', 8.9900, N'001', NULL, 45, 4, 9, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000021', N'Birthday Party', N'A children’s party with a magician and his tricks, a big game wheel, trees, balloons of all shapes and sizes, presents, and games. ', N'006', 25.9900, N'004', NULL, 56, 4, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000023', N'Tin Drum', N'A tin drum, which is perfect for neighborhood parades. Includes carrying strap and drumsticks.', N'012', 15.9900, N'001', NULL, 88, 3, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000024', N'Key Boom Guitar', N'A guitar with dual volume control and amplifying circuit and includes a shoulder strap and batteries.', N'012', 25.9900, N'001', NULL, 75, 5, 8, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000025', N'My First Flashlight', N'Makes flashlight play fun and easy. This durable flashlight has a big button for easy activation. Requires one AA battery (not included).', N'013', 7.9900, N'003', NULL, 65, 3, 5, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000026', N'Electronic Safe', N'A large size safe. Just press a button to open the safe and hear an alarm. Insert money through a secret slot in the back and use an electronic combination lock. ', N'013', 22.9900, N'005', NULL, 66, 5, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000027', N'X-90 Racers Set', N'The fast-paced action racing track is the ultimate challenge for X-90 Racers. Contains cars with motors inside for incredibly fast and furious racing action. ', N'005', 19.9900, N'001', NULL, 77, 5, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000028', N'Dune Racer', N'A set of dune buggies with a racing track.', N'005', 9.9900, N'004', NULL, 78, 4, 9, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000029', N'Spiral Zoom  Way', N'Give children a chance to enjoy racing excitement with this easy-to-assemble track', N'005', 14.9900, N'002', NULL, 88, 2, 7, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000030', N'Racing Truck', N'Zoom past the competition with this durable plastic truck featuring oversized tires.', N'005', 35.9900, N'005', NULL, 78, 3, 7, 2, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000031', N'Large Duck', N'Big, bright and soft to the touch, this Large Duck. It is made of durable cotton and is filled with flameproof machine-washable material.', N'009', 17.9900, N'001', NULL, 88, 1, 2, 1, NULL)
GO
INSERT [dbo].[Toys] ([cToyId], [vToyName], [vToyDescription], [cCategoryId], [mToyRate], [cBrandId], [imPhoto], [siToyQoh], [siLowerAge], [siUpperAge], [siToyWeight], [vToyImgPath]) VALUES (N'000032', N'Baby Minnie', N'Your infant needs to merely touch Baby Minnie, and she will shake her little rattle, just like a real Baby would. ', N'009', 14.9900, N'002', NULL, 66, 1, 3, 1, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'001', N'Geckos', 1.0000, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'002', N'Baby blocks', 1.2500, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'003', N'Stars', 1.5000, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'004', N'Bubbles', 2.0000, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'005', N'Sesame street', 1.5000, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'006', N'Moon', 2.2500, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'007', N'Sea', 1.0000, NULL, NULL)
GO
INSERT [dbo].[Wrapper] ([cWrapperId], [vDescription], [mWrapperRate], [imPhoto], [vWrapperImgPath]) VALUES (N'008', N'Sky', 1.0000, NULL, NULL)
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([cOrderNo])
REFERENCES [dbo].[Orders] ([cOrderNo])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([cToyId])
REFERENCES [dbo].[Toys] ([cToyId])
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD FOREIGN KEY([cWrapperId])
REFERENCES [dbo].[Wrapper] ([cWrapperId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([cShippingModeId])
REFERENCES [dbo].[ShippingMode] ([cModeId])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([cShopperId])
REFERENCES [dbo].[Shopper] ([cShopperId])
GO
ALTER TABLE [dbo].[PickOfMonth]  WITH CHECK ADD FOREIGN KEY([cToyId])
REFERENCES [dbo].[Toys] ([cToyId])
GO
ALTER TABLE [dbo].[Recipient]  WITH CHECK ADD FOREIGN KEY([cCountryId])
REFERENCES [dbo].[Country] ([cCountryId])
GO
ALTER TABLE [dbo].[Recipient]  WITH CHECK ADD FOREIGN KEY([cOrderNo])
REFERENCES [dbo].[Orders] ([cOrderNo])
GO
ALTER TABLE [dbo].[Shipment]  WITH CHECK ADD FOREIGN KEY([cOrderNo])
REFERENCES [dbo].[Orders] ([cOrderNo])
GO
ALTER TABLE [dbo].[ShippingRate]  WITH CHECK ADD FOREIGN KEY([cCountryID])
REFERENCES [dbo].[Country] ([cCountryId])
GO
ALTER TABLE [dbo].[ShippingRate]  WITH CHECK ADD FOREIGN KEY([cModeId])
REFERENCES [dbo].[ShippingMode] ([cModeId])
GO
ALTER TABLE [dbo].[Shopper]  WITH CHECK ADD FOREIGN KEY([cCountryId])
REFERENCES [dbo].[Country] ([cCountryId])
GO
ALTER TABLE [dbo].[ShoppingCart]  WITH CHECK ADD FOREIGN KEY([cToyId])
REFERENCES [dbo].[Toys] ([cToyId])
GO
ALTER TABLE [dbo].[Toys]  WITH CHECK ADD FOREIGN KEY([cBrandId])
REFERENCES [dbo].[ToyBrand] ([cBrandId])
GO
ALTER TABLE [dbo].[Toys]  WITH CHECK ADD FOREIGN KEY([cCategoryId])
REFERENCES [dbo].[Category] ([cCategoryId])
GO
ALTER TABLE [dbo].[Recipient]  WITH CHECK ADD CHECK  (([cZipCode] like '[0-9][0-9][0-9][0-9][0-9]-[0-9][0-9][0-9][0-9]'))
GO
ALTER TABLE [dbo].[Toys]  WITH CHECK ADD CHECK  (([cToyId] like '[0-9][0-9][0-9][0-9][0-9][0-9]'))
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 235
               Right = 189
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_1'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[14] 4[40] 2[4] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "Category"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 99
               Right = 189
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "Toys"
            Begin Extent = 
               Top = 6
               Left = 227
               Bottom = 114
               Right = 384
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
      Begin ColumnWidths = 9
         Width = 284
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
         Width = 1500
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_2'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'View_2'
GO
USE [master]
GO
ALTER DATABASE [GlobalToyz] SET  READ_WRITE 
GO
