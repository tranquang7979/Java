USE [ITViet]
GO
/****** Object:  Table [dbo].[City]    Script Date: 11/12/2019 8:55:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[City](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_City] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Company]    Script Date: 11/12/2019 8:55:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Company](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Logo] [varchar](500) NULL,
	[Banner] [varchar](500) NULL,
	[Name] [nvarchar](50) NULL,
	[Address] [nvarchar](200) NULL,
	[CityId] [int] NULL,
	[CompanyType] [nvarchar](50) NULL,
	[CompanySize] [int] NULL,
	[CountryFlag] [varchar](10) NULL,
	[CountryName] [nvarchar](50) NULL,
	[WorkingDay] [nvarchar](50) NULL,
	[OTOption] [nvarchar](50) NULL,
	[Rating] [decimal](4, 2) NULL,
	[Description] [nvarchar](max) NULL,
 CONSTRAINT [PK_Company] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CompanySkill]    Script Date: 11/12/2019 8:55:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CompanySkill](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CompanyId] [int] NOT NULL,
	[SkillId] [int] NOT NULL,
 CONSTRAINT [PK_CompanySkill] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Job]    Script Date: 11/12/2019 8:55:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Job](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CompanyId] [int] NOT NULL,
	[Title] [nvarchar](50) NULL,
	[ShortDescription] [nvarchar](max) NULL,
	[IsHotJob] [bit] NOT NULL,
	[CreateDate] [datetime] NOT NULL,
 CONSTRAINT [PK_RecruitNews] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Skill]    Script Date: 11/12/2019 8:55:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Skill](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
 CONSTRAINT [PK_Technical] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[City] ON 

GO
INSERT [dbo].[City] ([Id], [Name]) VALUES (1, N'Tp.HCM')
GO
INSERT [dbo].[City] ([Id], [Name]) VALUES (2, N'Ha Noi')
GO
INSERT [dbo].[City] ([Id], [Name]) VALUES (3, N'Da Nang')
GO
INSERT [dbo].[City] ([Id], [Name]) VALUES (4, N'Others')
GO
SET IDENTITY_INSERT [dbo].[City] OFF
GO
SET IDENTITY_INSERT [dbo].[Company] ON 

GO
INSERT [dbo].[Company] ([Id], [Logo], [Banner], [Name], [Address], [CityId], [CompanyType], [CompanySize], [CountryFlag], [CountryName], [WorkingDay], [OTOption], [Rating], [Description]) VALUES (1, N'https://cdn.itviec.com/employers/home-credit-vietnam/logo/w170/dFAsZ8oiQpLPyUr8Yi5jUWdj/home-credit-vietnam-ppf-logo.png', N'https://cdn.itviec.com/photos/39536/processed_headline_photo/home-credit-vietnam-headline_photo.jpg', N'Home Credit Vietnam ', N'20 Nguyen Dang Giai
, District 2, 
Ho Chi Minh ', 1, N'Product', 1000, N'cz', N'Czech Republic', N'Monday - Friday ', N'No OT ', CAST(4.00 AS Decimal(4, 2)), N'<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title headline">
Home Credit Vietnam Finance Company Limited 
</h3>
</div>
<div class="panel-body">
<div class="paragraph">
<p></p><p>Welcome to Home Credit IT Department, a dynamic and high performance family. Aside from benefits proposed by the company (competitive salary, various bonuses such as 13th month and KPI and more), IT Family offers you special advantages to engage your career:</p><ul><li>Working with the latest technology in the Finance Industry</li><li>Flexible working environment, with pure Agile-Scrum methodology applied</li><li>Oversea training opportunities</li><li>Training courses and materials (online, offline, onsite) provided: vertical, horizontal, people management, and technology expert.</li><li>A deep understand about the product life cycle that you will develop</li></ul><p>More than one hundred of tech talents have joined Home Credit IT Family to achieve one consistent goal: Being the Leading Technology Driven Finance Company in the World. Join us, for a bright career path is awaiting you here.<br>Discover more at: https://youtu.be/JWij7c-JhSg</p><p>&nbsp;</p><p></p>
</div>
<h3 class="panel-title"></h3>
<ul class="employer-skills">
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/nodejs">NodeJS</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/java">Java</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/agile">Agile</a></li>
</ul>
<div class="paragraph">
<p></p>
</div>
</div>
</div>')
GO
INSERT [dbo].[Company] ([Id], [Logo], [Banner], [Name], [Address], [CityId], [CompanyType], [CompanySize], [CountryFlag], [CountryName], [WorkingDay], [OTOption], [Rating], [Description]) VALUES (2, N'https://cdn.itviec.com/employers/fpt-software/logo/w170/mir3HT3xtedbECJY5jVeRRgV/fpt-software-logo.png', N'https://cdn.itviec.com/photos/42004/processed_headline_photo/fpt-software-headline_photo.png', N'FPT Software ', N'Ho Chi Minh, Ha Noi, Da Nang ', 2, N'Outsourcing', 1000, N'vn', N'Viet Nam', N'Monday - Friday ', N'Extra salary for OT ', CAST(3.30 AS Decimal(4, 2)), N'<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title headline">
The leading provider of software outsourcing services in Vietnam
</h3>
</div>
<div class="panel-body">
<div class="paragraph">
<p></p><p>“ <i>FPT Software is part of FPT Corporation (FPT – HoSE) – the global leading technology, outsourcing and IT services group headquartered in Vietnam with nearly US$2 billion in revenue and more than 13,000 employees. Qualified with CMMI Level 5 &amp; ISO 27001:2013, ASPICE LEVEL 3, FPT Software delivers world-class services in Smart factory, Digital platform, RPA, AI, IoT, Enterprise Mobilization, Cloud, AR/VR, Embedded System, Managed service, Testing, Platform modernization, Business Applications, Application Service, BPO and more services globally from delivery centers across the United States, Japan, Europe, Korea, China, Australia, Vietnam and the Asia Pacific.&nbsp;</i><br><br><i>In 2017, FPT Software has been placed in top 10 of the ranking for three consecutive years. Among top 10, FPT Software is the only IT Company.&nbsp;</i></p><p></p>
</div>
<h3 class="panel-title">Our Key Skills</h3>
<ul class="employer-skills">
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/c++">C++</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/english">English</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/java">Java</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/sql">SQL</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/android">Android</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/.net">.NET</a></li>
</ul>
<div class="paragraph">
<p></p>
</div>
</div>
</div>')
GO
INSERT [dbo].[Company] ([Id], [Logo], [Banner], [Name], [Address], [CityId], [CompanyType], [CompanySize], [CountryFlag], [CountryName], [WorkingDay], [OTOption], [Rating], [Description]) VALUES (3, N'https://cdn.itviec.com/employers/techbase-vietnam/logo/w170/8gNAausgAQwCDP6PStongxob/HINH.png', N'https://cdn.itviec.com/photos/40049/processed_headline_photo/techbase-vietnam-headline_photo.jpg', N'Techbase Vietnam ', N'District 1, Ho Chi Minh ', 3, N'Product', NULL, N'jp', N'Japan', N'Monday - Friday ', N'No OT ', CAST(4.20 AS Decimal(4, 2)), N'<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title headline">
TECHBASE  VIETNAM
</h3>
</div>
<div class="panel-body">
<div class="paragraph">
<p></p><p>TECHBASE VIETNAM, a Japanese company 100% invested by Yahoo! JAPAN CORPORATION – the biggest portal site in Japan, was established in May 2015 and located in&nbsp;Saigon Centre.<br>We have over 140 members now. To expand our business in Vietnam,&nbsp;<strong>we are looking for&nbsp;many developers major in&nbsp;Java, PHP, NodeJS, React, Angular, Android, IOS,…</strong>&nbsp;with skills and experience&nbsp;to develop our&nbsp;E-Commerce and Media Service such as Yahoo! Shopping, Yahoo! Auction, Yahoo! Finance, Yahoo! Weather etc.<br>You will be developing software products, implementing new features or improving existing ones.<br><br>We believe this is a great opportunity for you to improve your skills and know-how, as well as being a part of a growing team to create a unique product that would make a dramatic impact on the company''s growth.</p><p></p>
</div>
<h3 class="panel-title">Our Key Skills</h3>
<ul class="employer-skills">
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/nodejs">NodeJS</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/java">Java</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/php">PHP</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/android">Android</a></li>
<li class="employer-skills__item"><a target="_blank" data-controller="utm-tracking" href="/it-jobs/ios">iOS</a></li>
</ul>
<div class="paragraph">
<p>Readable code, Time management, Japanese</p>
</div>
</div>
</div>')
GO
SET IDENTITY_INSERT [dbo].[Company] OFF
GO
SET IDENTITY_INSERT [dbo].[CompanySkill] ON 

GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (2, 1, 1)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (3, 1, 2)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (4, 1, 3)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (5, 1, 4)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (6, 1, 5)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (7, 1, 6)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (8, 1, 7)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (9, 1, 8)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (10, 1, 9)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (11, 2, 1)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (12, 2, 2)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (13, 2, 3)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (14, 2, 4)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (15, 2, 5)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (16, 2, 6)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (17, 2, 7)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (18, 2, 8)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (19, 2, 9)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (20, 3, 1)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (21, 3, 2)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (22, 3, 3)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (23, 3, 4)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (24, 3, 5)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (25, 3, 6)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (26, 3, 7)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (27, 3, 8)
GO
INSERT [dbo].[CompanySkill] ([Id], [CompanyId], [SkillId]) VALUES (28, 3, 9)
GO
SET IDENTITY_INSERT [dbo].[CompanySkill] OFF
GO
SET IDENTITY_INSERT [dbo].[Job] ON 

GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (1, 1, N'Product Owner - Open API', N'Drive the delivery of business features and technical enablers. Requirements analysis: work with Product Managers and System Architects to define and... ', 1, CAST(N'2019-12-11 20:43:10.700' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (2, 1, N'
Senior Android Developer (Sign-on bonus) ', N'Develop fully responsive, user-friendly, feature-rich and modern mobile applications using Android Integrate mobile applications with third-party... ', 1, CAST(N'2019-12-11 20:43:10.700' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (5, 1, N'
Senior Business Analyst (Sign-on bonus) ', N'Study and have firm knowledge of business processes and information systems in the company, e.g: How loan contract was created and operated until... ', 1, CAST(N'2019-12-11 20:44:09.930' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (8, 2, N'
[HCM] 02 Solution Architects–Up to $2000 ', N'Làm việc với vài trò Solution Architect trong các dự án của FWI.CCG Tham gia các hoạt động presales tại các thị trường nước ngoài Xây dựng, tư vấn giải... ', 1, CAST(N'2019-12-11 20:44:09.930' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (9, 2, N'
Software Engineer (Java, .NET) ', N'Tham gia xây dựng và phát triển dự án với khách hàng ', 1, CAST(N'2019-12-11 20:44:09.930' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (11, 3, N'Frontend ReactJS, VueJS (Sign on Bonus) ', N'Develop systems for biggest services of Yahoo! JAPAN, has millions daily users Communicate directly with Yahoo! JAPAN engineers Participate in hiring... ', 1, CAST(N'2019-12-11 20:44:09.930' AS DateTime))
GO
INSERT [dbo].[Job] ([Id], [CompanyId], [Title], [ShortDescription], [IsHotJob], [CreateDate]) VALUES (12, 3, N'QC Leader (Up to $1400 Gross)', N'Lead team to delivery project on schedule and on quality Research new technology, testing methods to share knowledge with other team members. Coach... ', 1, CAST(N'2019-12-11 20:44:09.930' AS DateTime))
GO
SET IDENTITY_INSERT [dbo].[Job] OFF
GO
SET IDENTITY_INSERT [dbo].[Skill] ON 

GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (1, N'Tester')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (2, N'Java')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (3, N'PHP')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (4, N'Android')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (5, N'.NET')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (6, N'iOS')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (7, N'Business Analyst')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (8, N'QA QC')
GO
INSERT [dbo].[Skill] ([Id], [Name]) VALUES (9, N'All jobs by skill')
GO
SET IDENTITY_INSERT [dbo].[Skill] OFF
GO
