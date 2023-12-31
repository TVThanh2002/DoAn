USE [master]
GO
/****** Object:  Database [DoAn2]    Script Date: 12/3/2021 10:04:06 PM ******/
CREATE DATABASE [DoAn2]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'DoAn2', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.TVTHANH\MSSQL\DATA\DoAn2.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'DoAn2_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.TVTHANH\MSSQL\DATA\DoAn2_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [DoAn2] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [DoAn2].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [DoAn2] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [DoAn2] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [DoAn2] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [DoAn2] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [DoAn2] SET ARITHABORT OFF 
GO
ALTER DATABASE [DoAn2] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [DoAn2] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [DoAn2] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [DoAn2] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [DoAn2] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [DoAn2] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [DoAn2] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [DoAn2] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [DoAn2] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [DoAn2] SET  DISABLE_BROKER 
GO
ALTER DATABASE [DoAn2] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [DoAn2] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [DoAn2] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [DoAn2] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [DoAn2] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [DoAn2] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [DoAn2] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [DoAn2] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [DoAn2] SET  MULTI_USER 
GO
ALTER DATABASE [DoAn2] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [DoAn2] SET DB_CHAINING OFF 
GO
ALTER DATABASE [DoAn2] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [DoAn2] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [DoAn2] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [DoAn2] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [DoAn2] SET QUERY_STORE = OFF
GO
USE [DoAn2]
GO
/****** Object:  Table [dbo].[BangDau]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BangDau](
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[GiaiDau] [varchar](50) NULL,
 CONSTRAINT [PK_BangDau] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CauThu]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CauThu](
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[ngaySinh] [date] NULL,
	[soAo] [int] NULL,
	[viTri] [nvarchar](50) NULL,
	[DoiBong] [varchar](50) NULL,
 CONSTRAINT [PK_CauThu] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DoiBong]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DoiBong](
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[HLV] [nvarchar](50) NULL,
	[DoiTruong] [nvarchar](50) NULL,
	[GiaiDau] [varchar](50) NULL,
 CONSTRAINT [PK_DoiBong_1] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GiaiDau]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GiaiDau](
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
 CONSTRAINT [PK_GiaiDau] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[San]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[San](
	[ten] [nvarchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NULL,
	[SucChua] [int] NULL,
	[GiaiDau] [varchar](50) NULL,
 CONSTRAINT [PK_San] PRIMARY KEY CLUSTERED 
(
	[ten] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TranDau]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TranDau](
	[ID] [varchar](50) NOT NULL,
	[doi1] [varchar](50) NULL,
	[banthang1] [int] NULL,
	[doi2] [varchar](50) NULL,
	[banthang2] [int] NULL,
	[tinhtrang] [nvarchar](10) NULL,
	[thoigian] [datetime] NULL,
	[san] [nvarchar](50) NOT NULL,
	[BangDau] [nvarchar](50) NULL,
	[GiaiDau] [varchar](50) NULL,
 CONSTRAINT [PK_TranDau] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TrongTai]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TrongTai](
	[tran] [varchar](50) NOT NULL,
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[diaChi] [nvarchar](50) NULL,
 CONSTRAINT [PK_TrongTai] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XepHang]    Script Date: 12/3/2021 10:04:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XepHang](
	[ID] [varchar](50) NOT NULL,
	[ten] [nvarchar](50) NULL,
	[soTran] [int] NULL,
	[thang] [int] NULL,
	[thua] [int] NULL,
	[hoa] [int] NULL,
	[soBanThang] [int] NULL,
	[soBanThua] [int] NULL,
	[hieuSo] [int] NULL,
	[diem] [int] NULL,
	[bangDau] [varchar](50) NULL,
 CONSTRAINT [PK_xepHang] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[BangDau] ([ID], [ten], [GiaiDau]) VALUES (N'VKU_01', N'Bang A', N'VKU01')
INSERT [dbo].[BangDau] ([ID], [ten], [GiaiDau]) VALUES (N'VKU_02', N'Bang B', N'VKU01')
GO
INSERT [dbo].[CauThu] ([ID], [ten], [ngaySinh], [soAo], [viTri], [DoiBong]) VALUES (N'20CE01', N'Thanh', CAST(N'2002-11-15' AS Date), 11, N'Tiền vệ', N'VKU_D1')
INSERT [dbo].[CauThu] ([ID], [ten], [ngaySinh], [soAo], [viTri], [DoiBong]) VALUES (N'20CE02', N'Trần Văn Vũ', CAST(N'2002-01-01' AS Date), 10, N'Tiền đạo', N'VKU_D1')
GO
INSERT [dbo].[DoiBong] ([ID], [ten], [HLV], [DoiTruong], [GiaiDau]) VALUES (N'VKU_D1', N'20CE', N'Thanh', N'Thanh', N'VKU01')
INSERT [dbo].[DoiBong] ([ID], [ten], [HLV], [DoiTruong], [GiaiDau]) VALUES (N'VKU_D2', N'21CE', N'Vũ', N'Vũ', N'VKU01')
INSERT [dbo].[DoiBong] ([ID], [ten], [HLV], [DoiTruong], [GiaiDau]) VALUES (N'VKU_D3', N'19CE', N'Thanh', N'Thanh', N'VKU01')
GO
INSERT [dbo].[GiaiDau] ([ID], [ten], [ngayBatDau], [ngayKetThuc]) VALUES (N'VKU01', N'Giải bóng đá nam VKU', CAST(N'2021-11-11' AS Date), CAST(N'2022-01-03' AS Date))
GO
INSERT [dbo].[San] ([ten], [diaChi], [SucChua], [GiaiDau]) VALUES (N'Sân 2', N'Khu K', 1500, N'VKU01')
INSERT [dbo].[San] ([ten], [diaChi], [SucChua], [GiaiDau]) VALUES (N'Sân Chính', N'Khu K', 2000, N'VKU01')
GO
INSERT [dbo].[TranDau] ([ID], [doi1], [banthang1], [doi2], [banthang2], [tinhtrang], [thoigian], [san], [BangDau], [GiaiDau]) VALUES (N'VKU_01', N'VKU_D1', 2, N'VKU_D2', 3, N'Đã thi đấu', CAST(N'2021-11-11T18:00:00.000' AS DateTime), N'Sân Chính', N'Bang A', N'VKU01')
INSERT [dbo].[TranDau] ([ID], [doi1], [banthang1], [doi2], [banthang2], [tinhtrang], [thoigian], [san], [BangDau], [GiaiDau]) VALUES (N'VKU_02', N'VKU_D1', NULL, N'VKU_D2', NULL, N'', CAST(N'2021-01-01T18:00:00.000' AS DateTime), N'Sân Chính', N'Bang A', N'VKU01')
INSERT [dbo].[TranDau] ([ID], [doi1], [banthang1], [doi2], [banthang2], [tinhtrang], [thoigian], [san], [BangDau], [GiaiDau]) VALUES (N'VKU_03', N'VKU_D1', NULL, N'VKU_D3', NULL, N'', CAST(N'2021-01-01T19:00:00.000' AS DateTime), N'Sân Chính', N'Bang A', N'VKU01')
GO
INSERT [dbo].[TrongTai] ([tran], [ID], [ten], [diaChi]) VALUES (N'VKU_01', N'TT01', N'Trần Văn A', N'Đà Nẵng')
INSERT [dbo].[TrongTai] ([tran], [ID], [ten], [diaChi]) VALUES (N'VKU_01', N'TT02', N'Trần Văn B', N'Đà Nẵng')
INSERT [dbo].[TrongTai] ([tran], [ID], [ten], [diaChi]) VALUES (N'VKU_02', N'TT03', N'Nguyễn Văn A', N'Đà Nẵng')
GO
INSERT [dbo].[XepHang] ([ID], [ten], [soTran], [thang], [thua], [hoa], [soBanThang], [soBanThua], [hieuSo], [diem], [bangDau]) VALUES (N'VKU_D1', N'20CE', 1, 0, 1, 0, 2, 3, -1, 0, N'VKU_01')
INSERT [dbo].[XepHang] ([ID], [ten], [soTran], [thang], [thua], [hoa], [soBanThang], [soBanThua], [hieuSo], [diem], [bangDau]) VALUES (N'VKU_D2', N'21CE', 1, 1, 0, 0, 3, 2, 1, 3, N'VKU_01')
INSERT [dbo].[XepHang] ([ID], [ten], [soTran], [thang], [thua], [hoa], [soBanThang], [soBanThua], [hieuSo], [diem], [bangDau]) VALUES (N'VKU_D3', N'19CE', 0, 0, 0, 0, 0, 0, 0, 0, N'VKU_01')
GO
ALTER TABLE [dbo].[BangDau]  WITH CHECK ADD  CONSTRAINT [FK_BangDau_GiaiDau] FOREIGN KEY([GiaiDau])
REFERENCES [dbo].[GiaiDau] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[BangDau] CHECK CONSTRAINT [FK_BangDau_GiaiDau]
GO
ALTER TABLE [dbo].[CauThu]  WITH CHECK ADD  CONSTRAINT [FK_CauThu_DoiBong1] FOREIGN KEY([DoiBong])
REFERENCES [dbo].[DoiBong] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CauThu] CHECK CONSTRAINT [FK_CauThu_DoiBong1]
GO
ALTER TABLE [dbo].[DoiBong]  WITH CHECK ADD  CONSTRAINT [FK_DoiBong_GiaiDau] FOREIGN KEY([GiaiDau])
REFERENCES [dbo].[GiaiDau] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[DoiBong] CHECK CONSTRAINT [FK_DoiBong_GiaiDau]
GO
ALTER TABLE [dbo].[San]  WITH CHECK ADD  CONSTRAINT [FK_San_GiaiDau] FOREIGN KEY([GiaiDau])
REFERENCES [dbo].[GiaiDau] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[San] CHECK CONSTRAINT [FK_San_GiaiDau]
GO
ALTER TABLE [dbo].[TranDau]  WITH CHECK ADD  CONSTRAINT [FK_TranDau_GiaiDau] FOREIGN KEY([GiaiDau])
REFERENCES [dbo].[GiaiDau] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TranDau] CHECK CONSTRAINT [FK_TranDau_GiaiDau]
GO
ALTER TABLE [dbo].[TranDau]  WITH CHECK ADD  CONSTRAINT [FK_TranDau_San] FOREIGN KEY([san])
REFERENCES [dbo].[San] ([ten])
GO
ALTER TABLE [dbo].[TranDau] CHECK CONSTRAINT [FK_TranDau_San]
GO
ALTER TABLE [dbo].[TrongTai]  WITH CHECK ADD  CONSTRAINT [FK_TrongTai_TranDau] FOREIGN KEY([tran])
REFERENCES [dbo].[TranDau] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[TrongTai] CHECK CONSTRAINT [FK_TrongTai_TranDau]
GO
ALTER TABLE [dbo].[XepHang]  WITH CHECK ADD  CONSTRAINT [FK_xepHang_BangDau] FOREIGN KEY([bangDau])
REFERENCES [dbo].[BangDau] ([ID])
GO
ALTER TABLE [dbo].[XepHang] CHECK CONSTRAINT [FK_xepHang_BangDau]
GO
ALTER TABLE [dbo].[XepHang]  WITH CHECK ADD  CONSTRAINT [FK_xepHang_DoiBong1] FOREIGN KEY([ID])
REFERENCES [dbo].[DoiBong] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[XepHang] CHECK CONSTRAINT [FK_xepHang_DoiBong1]
GO
USE [master]
GO
ALTER DATABASE [DoAn2] SET  READ_WRITE 
GO
