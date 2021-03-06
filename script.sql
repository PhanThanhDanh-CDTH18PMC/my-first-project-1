USE [ CinemaProject]
GO
/****** Object:  Table [dbo].[Chair]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Chair](
	[Id] [nchar](10) NOT NULL,
	[RoomId] [nchar](10) NOT NULL,
	[Number] [int] NULL,
 CONSTRAINT [PK_Chair_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Id] [nchar](10) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Age] [int] NULL,
	[Email] [nvarchar](30) NULL,
	[Password] [nchar](10) NULL,
	[Telephone] [int] NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gerne]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gerne](
	[Id] [nchar](10) NOT NULL,
	[GerneName] [nvarchar](30) NULL,
 CONSTRAINT [PK_Gerne] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[ID] [nchar](10) NOT NULL,
	[MovieName] [nvarchar](50) NULL,
	[Director] [nvarchar](30) NULL,
	[Time] [int] NULL,
	[GerneId] [nchar](10) NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Room]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Room](
	[Id] [nchar](10) NOT NULL,
	[AmountChair] [int] NULL,
	[TheaterId] [nchar](10) NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Room] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Screening]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Screening](
	[Id] [nchar](10) NOT NULL,
	[TimeStart] [time](7) NULL,
	[TimeEnd] [time](7) NULL,
	[MovieId] [nchar](10) NULL,
 CONSTRAINT [PK_Screening] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Showtime]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Showtime](
	[Id] [nchar](10) NOT NULL,
	[ScreeningId] [nchar](10) NOT NULL,
	[RoomId] [nchar](10) NOT NULL,
	[MovieId] [nchar](10) NULL,
	[Status] [int] NULL,
 CONSTRAINT [PK_Showtime_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Theater]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Theater](
	[Id] [nchar](10) NOT NULL,
	[TheaterName] [nvarchar](30) NULL,
	[Address] [nvarchar](50) NULL,
 CONSTRAINT [PK_Theater] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ticket]    Script Date: 11/17/2020 12:02:53 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ticket](
	[Id] [nchar](10) NOT NULL,
	[ShowtimeId] [nchar](10) NOT NULL,
	[CustomerId] [nchar](10) NOT NULL,
 CONSTRAINT [PK_Ticket_1] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Chair]  WITH CHECK ADD  CONSTRAINT [FK_Chair_Room] FOREIGN KEY([RoomId])
REFERENCES [dbo].[Room] ([Id])
GO
ALTER TABLE [dbo].[Chair] CHECK CONSTRAINT [FK_Chair_Room]
GO
ALTER TABLE [dbo].[Movie]  WITH CHECK ADD  CONSTRAINT [FK_Movie_Gerne] FOREIGN KEY([GerneId])
REFERENCES [dbo].[Gerne] ([Id])
GO
ALTER TABLE [dbo].[Movie] CHECK CONSTRAINT [FK_Movie_Gerne]
GO
ALTER TABLE [dbo].[Room]  WITH CHECK ADD  CONSTRAINT [FK_Room_Theater] FOREIGN KEY([TheaterId])
REFERENCES [dbo].[Theater] ([Id])
GO
ALTER TABLE [dbo].[Room] CHECK CONSTRAINT [FK_Room_Theater]
GO
ALTER TABLE [dbo].[Showtime]  WITH CHECK ADD  CONSTRAINT [FK_Showtime_Movie] FOREIGN KEY([MovieId])
REFERENCES [dbo].[Movie] ([ID])
GO
ALTER TABLE [dbo].[Showtime] CHECK CONSTRAINT [FK_Showtime_Movie]
GO
ALTER TABLE [dbo].[Showtime]  WITH CHECK ADD  CONSTRAINT [FK_Showtime_Room] FOREIGN KEY([RoomId])
REFERENCES [dbo].[Room] ([Id])
GO
ALTER TABLE [dbo].[Showtime] CHECK CONSTRAINT [FK_Showtime_Room]
GO
ALTER TABLE [dbo].[Showtime]  WITH CHECK ADD  CONSTRAINT [FK_Showtime_Screening] FOREIGN KEY([ScreeningId])
REFERENCES [dbo].[Screening] ([Id])
GO
ALTER TABLE [dbo].[Showtime] CHECK CONSTRAINT [FK_Showtime_Screening]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_Ticket_Customer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_Ticket_Customer]
GO
ALTER TABLE [dbo].[Ticket]  WITH CHECK ADD  CONSTRAINT [FK_Ticket_Showtime] FOREIGN KEY([ShowtimeId])
REFERENCES [dbo].[Showtime] ([Id])
GO
ALTER TABLE [dbo].[Ticket] CHECK CONSTRAINT [FK_Ticket_Showtime]
GO
