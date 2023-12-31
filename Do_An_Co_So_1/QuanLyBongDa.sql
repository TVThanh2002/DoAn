USE [master]
GO
/****** Object:  Database [QuanLyBongDa]    Script Date: 5/30/2021 9:27:43 AM ******/
CREATE DATABASE [QuanLyBongDa]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLyBongDa', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyBongDa.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLyBongDa_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\QuanLyBongDa_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLyBongDa] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLyBongDa].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLyBongDa] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLyBongDa] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET  DISABLE_BROKER 
GO
ALTER DATABASE [QuanLyBongDa] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLyBongDa] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [QuanLyBongDa] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLyBongDa] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLyBongDa] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLyBongDa] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLyBongDa] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLyBongDa] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLyBongDa] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [QuanLyBongDa] SET QUERY_STORE = OFF
GO
USE [QuanLyBongDa]
GO
/****** Object:  Table [dbo].[Danh sách giải]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Danh sách giải](
	[Mã giải đấu] [varchar](50) NOT NULL,
	[Tên giải đấu] [nvarchar](50) NULL,
	[Ngày bắt đầu] [date] NULL,
	[Ngày kết thúc] [date] NULL,
 CONSTRAINT [PK_Danh sách giải] PRIMARY KEY CLUSTERED 
(
	[Mã giải đấu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_Bảng xếp hạng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_Bảng xếp hạng](
	[Đội bóng] [nvarchar](50) NULL,
	[Số trận] [int] NULL,
	[Thắng] [int] NULL,
	[Hòa] [int] NULL,
	[Thua] [int] NULL,
	[Bàn thắng] [int] NULL,
	[Bàn thua] [int] NULL,
	[Hiệu số] [int] NULL,
	[Điểm] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_Danh sách đội bóng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_Danh sách đội bóng](
	[Mã đội bóng] [nvarchar](50) NOT NULL,
	[Tên đội bóng] [nvarchar](50) NULL,
	[Đội trưởng] [nvarchar](50) NULL,
	[Huấn luyện viên] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã đội bóng] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB001_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB001_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB002_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB002_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB003_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB003_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB004_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB004_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB005_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB005_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB006_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB006_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB007_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB007_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB008_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB008_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB009_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB009_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB010_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB010_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB011_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB011_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB012_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB012_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_DB013_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_DB013_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_Lịch thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_Lịch thi đấu](
	[Mã trận] [nvarchar](50) NOT NULL,
	[Ngày] [nvarchar](50) NULL,
	[Giờ] [nvarchar](50) NULL,
	[Sân] [nvarchar](50) NULL,
	[Đội 1] [nvarchar](50) NULL,
	[Bàn thắng đội 1] [int] NULL,
	[Bàn thắng đội 2] [int] NULL,
	[Đội 2] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã trận] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD001_Sân thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD001_Sân thi đấu](
	[Tên sân] [nvarchar](50) NULL,
	[Địa điểm] [nvarchar](50) NULL,
	[Sức chứa] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_Bảng xếp hạng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_Bảng xếp hạng](
	[Đội bóng] [nvarchar](50) NULL,
	[Số trận] [int] NULL,
	[Thắng] [int] NULL,
	[Hòa] [int] NULL,
	[Thua] [int] NULL,
	[Bàn thắng] [int] NULL,
	[Bàn thua] [int] NULL,
	[Hiệu số] [int] NULL,
	[Điểm] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_Danh sách đội bóng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_Danh sách đội bóng](
	[Mã đội bóng] [nvarchar](50) NOT NULL,
	[Tên đội bóng] [nvarchar](50) NULL,
	[Đội trưởng] [nvarchar](50) NULL,
	[Huấn luyện viên] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã đội bóng] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_DB001_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_DB001_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_DB002_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_DB002_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_Lịch thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_Lịch thi đấu](
	[Mã trận] [nvarchar](50) NOT NULL,
	[Ngày] [nvarchar](50) NULL,
	[Giờ] [nvarchar](50) NULL,
	[Sân] [nvarchar](50) NULL,
	[Đội 1] [nvarchar](50) NULL,
	[Bàn thắng đội 1] [int] NULL,
	[Bàn thắng đội 2] [int] NULL,
	[Đội 2] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã trận] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD002_Sân thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD002_Sân thi đấu](
	[Tên sân] [nvarchar](50) NULL,
	[Địa điểm] [nvarchar](50) NULL,
	[Sức chứa] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD003_Bảng xếp hạng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD003_Bảng xếp hạng](
	[Đội bóng] [nvarchar](50) NULL,
	[Số trận] [int] NULL,
	[Thắng] [int] NULL,
	[Hòa] [int] NULL,
	[Thua] [int] NULL,
	[Bàn thắng] [int] NULL,
	[Bàn thua] [int] NULL,
	[Hiệu số] [int] NULL,
	[Điểm] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD003_Danh sách đội bóng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD003_Danh sách đội bóng](
	[Mã đội bóng] [nvarchar](50) NOT NULL,
	[Tên đội bóng] [nvarchar](50) NULL,
	[Đội trưởng] [nvarchar](50) NULL,
	[Huấn luyện viên] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã đội bóng] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD003_DB001_Danh sách cầu thủ]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD003_DB001_Danh sách cầu thủ](
	[Mã cầu thủ] [nvarchar](50) NOT NULL,
	[Tên cầu thủ] [nvarchar](50) NULL,
	[Ngày sinh] [nvarchar](50) NULL,
	[Số áo] [int] NULL,
	[Vị trí] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã cầu thủ] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD003_Lịch thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD003_Lịch thi đấu](
	[Mã trận] [nvarchar](50) NOT NULL,
	[Ngày] [nvarchar](50) NULL,
	[Giờ] [nvarchar](50) NULL,
	[Sân] [nvarchar](50) NULL,
	[Đội 1] [nvarchar](50) NULL,
	[Bàn thắng đội 1] [int] NULL,
	[Bàn thắng đội 2] [int] NULL,
	[Đội 2] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã trận] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD003_Sân thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD003_Sân thi đấu](
	[Tên sân] [nvarchar](50) NULL,
	[Địa điểm] [nvarchar](50) NULL,
	[Sức chứa] [nvarchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD004_Bảng xếp hạng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD004_Bảng xếp hạng](
	[Đội bóng] [nvarchar](50) NULL,
	[Số trận] [int] NULL,
	[Thắng] [int] NULL,
	[Hòa] [int] NULL,
	[Thua] [int] NULL,
	[Bàn thắng] [int] NULL,
	[Bàn thua] [int] NULL,
	[Hiệu số] [int] NULL,
	[Điểm] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD004_Danh sách đội bóng]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD004_Danh sách đội bóng](
	[Mã đội bóng] [nvarchar](50) NOT NULL,
	[Tên đội bóng] [nvarchar](50) NULL,
	[Đội trưởng] [nvarchar](50) NULL,
	[Huấn luyện viên] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã đội bóng] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD004_Lịch thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD004_Lịch thi đấu](
	[Mã trận] [nvarchar](50) NOT NULL,
	[Ngày] [nvarchar](50) NULL,
	[Giờ] [nvarchar](50) NULL,
	[Sân] [nvarchar](50) NULL,
	[Đội 1] [nvarchar](50) NULL,
	[Bàn thắng đội 1] [int] NULL,
	[Bàn thắng đội 2] [int] NULL,
	[Đội 2] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[Mã trận] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GD004_Sân thi đấu]    Script Date: 5/30/2021 9:27:43 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GD004_Sân thi đấu](
	[Tên sân] [nvarchar](50) NULL,
	[Địa điểm] [nvarchar](50) NULL,
	[Sức chứa] [nvarchar](50) NULL
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [QuanLyBongDa] SET  READ_WRITE 
GO
