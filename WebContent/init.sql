USE [Weixin]
GO
/****** Object:  Table [dbo].[T_DATA_12366_HOT]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_12366_HOT](
	[id] [numeric](18, 0) IDENTITY(1,1) NOT NULL,
	[Q] [varchar](200) NULL,
	[A] [varchar](8000) NULL,
	[DT] [datetime] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_DATA_Article]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_Article](
	[ID] [varchar](50) NOT NULL,
	[ID_PARENT] [varchar](50) NOT NULL,
	[Title] [varchar](100) NULL,
	[Description] [varchar](100) NULL,
	[Url] [varchar](1000) NULL,
	[PicUrl] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_DATA_LOCATION]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_LOCATION](
	[FromUser] [varchar](200) NULL,
	[ToUser] [varchar](200) NULL,
	[Latitude] [numeric](18, 10) NULL,
	[Longitude] [numeric](18, 10) NULL,
	[Precision] [numeric](18, 10) NULL,
	[Status] [int] NULL,
	[Dt] [datetime] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_DATA_MENU]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_MENU](
	[ID] [varchar](50) NOT NULL,
	[ID_PARENT] [varchar](50) NULL,
	[Caption] [varchar](100) NULL,
	[Key] [varchar](10) NULL,
	[URL] [varchar](1000) NULL,
	[Level] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_DATA_QUESTION]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_QUESTION](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[DT] [datetime] NOT NULL,
	[Open_ID] [varchar](1000) NOT NULL,
	[QUESTION] [varchar](1000) NOT NULL,
	[ANSWER] [varchar](1000) NULL,
	[TIME_ANSWER] [datetime] NULL,
	[USER_ANSWER] [varchar](1000) NULL,
	[IS_COMMON] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_DATA_suggestion]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_DATA_suggestion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[DT] [datetime] NOT NULL,
	[Open_ID] [varchar](1000) NOT NULL,
	[suggestion] [varchar](1000) NOT NULL,
	[STATUS] [varchar](10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[T_SYS_LocalTax_Address]    Script Date: 2014/8/27 8:34:21 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[T_SYS_LocalTax_Address](
	[id] [int] NULL,
	[Area] [varchar](50) NULL,
	[Depart] [varchar](50) NULL,
	[Address] [varchar](50) NULL,
	[Tel_Consult] [varchar](50) NULL,
	[Tel_Support] [varchar](50) NULL,
	[Lng] [numeric](18, 10) NULL,
	[Lat] [numeric](18, 10) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[T_DATA_LOCATION] ADD  CONSTRAINT [DF_T_DATA_LOCATION_Status]  DEFAULT ((0)) FOR [Status]
GO
ALTER TABLE [dbo].[T_DATA_LOCATION] ADD  CONSTRAINT [DF_T_DATA_LOCATION_Dt]  DEFAULT (getdate()) FOR [Dt]
GO
ALTER TABLE [dbo].[T_DATA_QUESTION] ADD  DEFAULT (getdate()) FOR [DT]
GO
ALTER TABLE [dbo].[T_DATA_QUESTION] ADD  DEFAULT ('') FOR [ANSWER]
GO
ALTER TABLE [dbo].[T_DATA_QUESTION] ADD  DEFAULT ('') FOR [USER_ANSWER]
GO
ALTER TABLE [dbo].[T_DATA_QUESTION] ADD  DEFAULT ('') FOR [IS_COMMON]
GO
ALTER TABLE [dbo].[T_DATA_suggestion] ADD  DEFAULT (getdate()) FOR [DT]
GO
ALTER TABLE [dbo].[T_DATA_suggestion] ADD  DEFAULT ('审核中') FOR [STATUS]
GO
