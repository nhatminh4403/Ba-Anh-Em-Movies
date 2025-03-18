-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Mar 15, 2025 at 02:20 AM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baanhemwebsitedacn`
--

-- --------------------------------------------------------

--
-- Table structure for table `blog`
--

CREATE TABLE `blog` (
  `blog_id` bigint NOT NULL,
  `blog_content` longtext NOT NULL,
  `blog_daycreate` datetime(6) NOT NULL,
  `combo_poster` varchar(255) DEFAULT NULL,
  `blog_title` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `blog`
--

INSERT INTO `blog` (`blog_id`, `blog_content`, `blog_daycreate`, `combo_poster`, `blog_title`) VALUES
(1, 'Xe máy trên 5 năm sẽ phải kiểm định khí thải\r\nChủ sở hữu xe mô tô, xe gắn máy sản xuất từ 5 năm trở lên bắt buộc phải mang xe đi kiểm định khí thải tại các trung tâm đăng kiểm.\r\n\r\nTheo Thông tư 47/2024 của Bộ Giao thông Vận tải, xe mô tô, xe gắn máy có tuổi đời dưới 5 năm được miễn kiểm định khí thải. Xe từ 5 đến 12 năm tuổi phải kiểm định hai năm một lần, còn xe trên 12 năm tuổi phải kiểm định hàng năm.\r\n\r\n', '2024-12-16 07:45:16.893226', '/assets/img/adminblog/f7055f36-0f70-42c3-ac22-b7b6d4a40319.jpg', 'Xe máy trên 5 năm sẽ phải kiểm định khí thải'),
(2, 'Nhận quà từ bạn nước ngoài làm quen qua mạng\r\n\r\nCác đối tượng tự giới thiệu là người nước ngoài, kết bạn, liên lạc để tạo mối quan hệ với nạn nhân thông qua mạng xã hội. Sau khi tạo được lòng tin ở đối phương sẽ thông báo muốn gửi tiền, quà từ nước ngoài về Việt Nam rồi yêu cầu người bị hại nộp tiền để nhận quà với các lý do khác nhau như cước vận chuyển, thuế, phí… vào các tài khoản ngân hàng do các đối tượng cung cấp rồi chiếm đoạt.\r\n\r\nTự xưng cơ quan chức năng gọi điện thông báo điều tra\r\n\r\nĐối tượng giả danh cán bộ Công an, Viện kiểm sát, Tòa án hoặc giả mạo Cổng thông tin điện tử của Công an để thông báo chủ thuê bao có liên quan đến các vụ án đang bị điều tra. Sau đó, khai thác thông tin cá nhân, tài khoản ngân hàng và yêu cầu chuyển toàn bộ tiền trong tài khoản của bị hại vào tài khoản ngân hàng do đối tượng cung cấp với lý do để phục vụ công tác điều tra rồi chiếm đoạt.\r\n\r\nHack Facebook, zalo… nhắn tin mượn tiền\r\n\r\nĐây là chiêu lừa đảo đã quá quen thuộc. Chúng thường lập hoặc chiếm đoạt quyền quản trị tài khoản của người nào đó rồi nhắn tin lừa người thân, bạn bè của chủ tài khoản chuyển tiền để chiếm đoạt.\r\n\r\nThông báo trúng thưởng tiền, tài sản có giá trị\r\n\r\nKẻ lừa đảo sẽ gửi tin nhắn thông báo trúng thưởng xe máy, điện thoại, đồng hồ hoặc tiền mặt… có giá trị lớn. Sau đó, yêu cầu người bị hại nạp tiền qua thẻ điện thoại hoặc chuyển tiền qua tài khoản ngân hàng để làm thủ tục nhận thưởng rồi chiếm đoạt.\r\n\r\nGửi link giả để đánh cắp thông tin ngân hàng\r\n\r\nThủ đoạn thường thấy là gửi tin nhắn SMS giả mạo của ngân hàng để lừa khách hàng truy cập vào đường link giả, sau đó yêu cầu cung cấp thông tin bảo mật như tên, mật khẩu đăng nhập, mã OTP, thông tin thẻ... khi có được thông tin sẽ rút tiền trong tài khoản của nạn nhân và chiếm đoạt.\r\n\r\nChuyển nhầm tiền vào tài khoản ngân hàng\r\n\r\nCác đối tượng cố ý “chuyển nhầm” một khoản tiền đến tài khoản ngân hàng, tiếp đó yêu cầu người dùng trả lại số tiền kia như một khoản vay cùng với khoản lãi cắt cổ, nếu không trả các đối tượng khủng bố trên điện thoại, đe doạ tố cáo, gây rối quấy nhiễu… để buộc trả tiền gốc, lãi cao cho chúng.\r\nKêu gọi đầu tư tài chính, tiền ảo\r\n\r\nĐối tượng lập website đầu tư tài chính, ứng dụng có giao diện tương tự đầu tư tài chính quốc tế, rồi sử dụng nhiều thủ đoạn khác nhau để thu hút, lôi kéo nhiều người tham gia. Các sàn tiền ảo, đầu tư tài chính này cam kết người chơi sẽ được hưởng mức lãi suất cao nhưng lại an toàn, có thể rút vốn bất kỳ lúc nào, không cần đầu tư trí tuệ, thời gian. Ban đầu các đối tượng chuyển trả tiền lãi rất đầy đủ, rõ ràng (nhưng cũng chỉ là tiền ảo), đến khi người tham gia đầu tư nhiều thì các đối tượng ngưng giao dịch, bằng các phương thức như: Thông báo dừng hoạt động để bảo trì lỗi; chặn liên lạc và chặn đăng nhập làm khách hàng không vào tài khoản của mình được, rồi các đối tượng chiếm đoạt tiền mà khách hàng đã gửi hay đầu tư vào trang website do chúng lập ra.\r\n\r\nHỗ trợ lấy lại tiền đã bị lừa\r\n\r\nĐối tượng lập tài khoản ảo, không có thông tin rõ ràng về công ty, địa chỉ hoặc các thông tin liên hệ. Đối tượng lừa đảo chạy quảng cáo các bài đăng với nội dung \"hỗ trợ lấy lại tiền\", \"cam kết lấy lại được tiền bị lừa\", bên dưới là những bình luận cảm ơn đã lấy lại tiền bằng những tài khoản ảo khác. Sau khi được người dùng liên hệ, chúng sẽ nhiệt tình tư vấn, đồng thời liên tục hứa hẹn, cam kết lấy lại 100% số tiền đã mất. Tiếp đó, yêu cầu nạn nhân cung cấp thông tin cá nhân, tài khoản ngân hàng, số tiền đã bị lừa đảo và chuyển khoản thành công \"tiền phí dịch vụ\". Tuy nhiên, ngay lập tức nhân viên thông báo tài khoản ngân hàng bị lỗi và không cho rút tiền về. Khi nạn nhân thắc mắc thì đối tượng sẽ chặn toàn bộ liên lạc.\r\n\r\nBán thuốc đặc trị trên mạng xã hội\r\n\r\nCác đối tượng sẽ hoạt động theo hội nhóm, đồng thời tạo lập các tài khoản mạng xã hội ảo, đăng bài quảng cáo về các loại thuốc \"thần dược\" với giá cao với công dụng như phòng chống ung thư, giảm tác dụng hóa trị, xạ trị ung thư, thuốc cho người mắc bệnh ung thư giai đoạn cuối nhưng thực chất là các loại thuốc giá rẻ với thành phần không rõ nguồn gốc. Tinh vi hơn, các nhóm đối tượng này còn thực hiện chiêu trò \"giảm giá\" cho người già, người nghèo, người bệnh nặng, nhằm đánh vào tâm lý thích khuyến mãi.\r\n\r\nXuất khẩu lao động, du lịch miễn thị thực\r\n\r\nĐối tượng lập tài khoản mạng xã hội giả mạo, tham gia các hội nhóm để tìm người có nhu cầu mua vé máy bay và làm visa, chào mời và hứa hẹn cấp visa trong thời gian rất ngắn, tỷ lệ thành công cao mà không cần kiểm tra hồ sơ cẩn thận. Lợi dụng sự thiếu hiểu biết một bộ phận người dân, chúng yêu cầu cung cấp những thông tin không cần thiết, hay yêu cầu chuyển khoản trước những khoản phí không rõ ràng. Sau khi nạn nhân chuyển tiền, đối tượng sẽ không liên hệ với cơ quan, tổ chức hay cá nhân nào làm thủ tục mà thực hiện hành vi chiếm đoạt.\r\n\r\nTrước thực trạng trên, bên cạnh việc chủ động triển khai nhiều kế hoạch, biện pháp đấu tranh, cơ quan chức năng cũng khuyến cáo người dân cần thường xuyên, liên tục nâng cao cảnh giác và tuyên truyền với người thân, gia đình, bạn bè, đồng nghiệp về các phương thức, thủ đoạn hoạt động của đối tượng lừa đảo.\r\n\r\nCụ thể, không cung cấp thông tin cá nhân, số điện thoại, hình ảnh căn cước công dân, địa chỉ nhà ở, tài khoản ngân hàng, mã OTP trên điện thoại cá nhân... cho bất kỳ ai không quen biết hoặc chưa biết rõ nhân thân, lai lịch.\r\n\r\nTrường hợp có nghi ngờ về hoạt động lừa đảo cần kịp thời thông báo cho Cơ quan Công an nơi gần nhất, hoặc tra cứu địa chỉ tố giác tội phạm trên Chuyên mục “Hướng dẫn tố giác tội phạm” của Cổng Thông tin điện tử Bộ Công an (địa chỉ http://bocongan.gov.vn hoặc http://mps.gov.vn) để được tiếp nhận và hướng dẫn giải quyết.', '2024-12-18 22:23:23.569175', '/assets/img/adminblog/3b1eb397-a7a2-4656-97cd-f5395611d68f.jpg', 'Các hình thức lừa đảo phổ biến trên mạng'),
(3, 'The Game Awards 2024, giải thưởng được ví như Oscar dành cho ngành công nghiệp game hiện nay, đã chính thức diễn ra với danh sách những giải thưởng và các đề cử là những tựa game nổi bật nhất trong năm nay. Hãy cùng GEARVN điểm danh qua những đề cử trong The Game Awards 2024 ngay tại bài viết sau đây nhé !\r\n\r\nDanh sách đề cử Game Of The Year 2024 \r\nASTRO BOT - Team Asobi/SIE\r\n\r\nBalatro - LocalThunk/Playstack\r\n\r\nBlack Myth: Wukong - Game Science\r\n\r\nElden Ring Shadow of the Erdtree - FromSoftware/Bandai Namco\r\n\r\nFinal Fantasy VII Rebirth - Square Enix\r\n\r\nMetaphor: ReFantazio - Studio Zero/Atlus/Sega', '2024-12-18 22:27:37.268506', '/assets/img/adminblog/705a15a9-8975-430e-a103-ae762836f3fe.jpg', 'Tổng hợp đề cử và giải thưởng của The Game Awards 2024');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` bigint NOT NULL,
  `cinema_address` varchar(255) DEFAULT NULL,
  `cinema_name` varchar(255) DEFAULT NULL,
  `creat_at` datetime(6) DEFAULT NULL,
  `film_name` varchar(255) DEFAULT NULL,
  `payment` varchar(255) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `price` bigint DEFAULT NULL,
  `room_name` varchar(255) DEFAULT NULL,
  `seat_name` varchar(255) DEFAULT NULL,
  `lich_chieu` datetime(6) DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `combo_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `cinema_address`, `cinema_name`, `creat_at`, `film_name`, `payment`, `poster`, `price`, `room_name`, `seat_name`, `lich_chieu`, `status`, `combo_id`, `user_id`, `order_id`) VALUES
(22, 'Làng Đại học Thủ Đức', 'CineStar Làng Đại học', '2024-12-26 14:44:28.755000', 'Black Adam', 'Cash', 'https://media.themoviedb.org/t/p/w220_and_h330_face/7FH36YrotoVFCTx8VwPLELHGo7C.jpg', 68000, 'Phòng 02-CineStar', 'A8', '2024-07-02 21:10:00.000000', b'0', NULL, 8, NULL),
(23, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2024-12-26 14:44:49.289000', 'Black Adam', 'Cash', 'https://media.themoviedb.org/t/p/w220_and_h330_face/7FH36YrotoVFCTx8VwPLELHGo7C.jpg', 100000, 'Phòng 01-CGV Thủ Đức', 'E5', '2024-07-10 19:40:00.000000', b'0', NULL, 8, NULL),
(24, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2024-12-26 23:04:28.964000', 'Black Adam', 'paypal', 'https://media.themoviedb.org/t/p/w220_and_h330_face/7FH36YrotoVFCTx8VwPLELHGo7C.jpg', 100000, 'Phòng 01-CGV Thủ Đức', 'H9', '2024-07-11 16:50:00.000000', b'1', NULL, 8, NULL),
(25, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:33:49.454000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(26, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:07.624000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(27, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:07.981000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(28, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:17.835000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(29, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:06.961000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(30, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:07.427000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(31, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-01-22 21:34:07.794000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 300000, 'Phòng 01-CGV Thủ Đức', 'E5,E6,E7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL),
(32, '12, Võ Văn Ngân', 'CGV Thủ Đức', '2025-03-15 08:39:47.198000', 'The Marvels', 'Cash', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 80000, 'Phòng 01-CGV Thủ Đức', 'C7', '2024-07-03 22:50:00.000000', b'0', NULL, 8, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `booking_detail`
--

CREATE TABLE `booking_detail` (
  `booking_detail_id` bigint NOT NULL,
  `price` bigint DEFAULT NULL,
  `booking_id` bigint DEFAULT NULL,
  `schedule_id` bigint DEFAULT NULL,
  `seat_id` bigint DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `booking_detail`
--

INSERT INTO `booking_detail` (`booking_detail_id`, `price`, `booking_id`, `schedule_id`, `seat_id`, `status`) VALUES
(151, 80000, 22, 32, 112, NULL),
(152, 100000, 23, 29, 29, NULL),
(153, 100000, 24, 30, 101, NULL),
(154, 100000, 25, 35, 29, NULL),
(155, 100000, 25, 35, 30, NULL),
(156, 100000, 25, 35, 31, NULL),
(157, 100000, 26, 35, 29, NULL),
(158, 100000, 26, 35, 30, NULL),
(159, 100000, 26, 35, 31, NULL),
(160, 100000, 27, 35, 29, NULL),
(161, 100000, 27, 35, 30, NULL),
(162, 100000, 27, 35, 31, NULL),
(163, 100000, 28, 35, 29, NULL),
(164, 100000, 28, 35, 30, NULL),
(165, 100000, 28, 35, 31, NULL),
(166, 100000, 29, 35, 29, NULL),
(167, 100000, 29, 35, 30, NULL),
(168, 100000, 29, 35, 31, NULL),
(169, 100000, 30, 35, 29, NULL),
(170, 100000, 30, 35, 30, NULL),
(171, 100000, 30, 35, 31, NULL),
(172, 100000, 31, 35, 29, NULL),
(173, 100000, 31, 35, 30, NULL),
(174, 100000, 31, 35, 31, NULL),
(175, 80000, 32, 35, 63, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `category_id` bigint NOT NULL,
  `category_name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
(1, 'Phiêu lưu'),
(2, 'Hành động'),
(3, 'Khoa học viễn tưởng'),
(4, 'Kinh dị'),
(5, 'Hài kịch'),
(6, 'Gia đình'),
(7, 'Bom tấn'),
(8, 'Chính kịch'),
(9, 'Hoạt hình'),
(10, 'Thần thoại');

-- --------------------------------------------------------

--
-- Table structure for table `cinema`
--

CREATE TABLE `cinema` (
  `cinema_id` bigint NOT NULL,
  `address` varchar(255) NOT NULL,
  `map` varchar(255) DEFAULT NULL,
  `cinema_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `cinema`
--

INSERT INTO `cinema` (`cinema_id`, `address`, `map`, `cinema_name`) VALUES
(1, '12, Võ Văn Ngân', 'https://maps.app.goo.gl/vmkbizWBfHeT2Pjz7', 'CGV Thủ Đức'),
(3, 'Làng Đại học Thủ Đức', 'https://maps.app.goo.gl/nJwk84AYh6SrsUUL7', 'CineStar Làng Đại học'),
(5, '190, Lê Văn Việt', 'https://maps.app.goo.gl/Lxi6G9u3mv2tCHfG7', 'BHD Lê Văn Việt'),
(8, 'QL1A, Linh Trung, Thủ Đức', 'https://maps.app.goo.gl/QENAZ3bcrNWQa8cF8', 'Galaxy Linh Trung');

-- --------------------------------------------------------

--
-- Table structure for table `combo_food`
--

CREATE TABLE `combo_food` (
  `combo_id` bigint NOT NULL,
  `combo_name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `combo_poster` varchar(255) DEFAULT NULL,
  `combo_price` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `combo_food`
--

INSERT INTO `combo_food` (`combo_id`, `combo_name`, `description`, `combo_poster`, `combo_price`) VALUES
(1, 'Combo Chill chill', '1x Bắp 1x Nước', '/assets/img/comboFood/c1055923-9e05-46ff-ad05-4eab88f3bf41.jpg', 60000),
(2, 'Combo Cày phim', '1x Bắp 1x Nước 1x Burger 1x Khoai tây chiên', '/assets/img/comboFood/870112e8-7a53-4472-b6be-4f83fe329be5.jpg', 150000),
(4, 'Combo Thả ga', '2x Bắp 2x Nước M&M Gói kẹo dẻo ngẫu nhiên', '/assets/img/comboFood/f51c031c-2ea5-4a54-881c-aeea03d704d6.jpg', 180000);

-- --------------------------------------------------------

--
-- Table structure for table `comment`
--

CREATE TABLE `comment` (
  `comment_id` bigint NOT NULL,
  `comment_content` varchar(255) DEFAULT NULL,
  `comment_daycreat` datetime(6) DEFAULT NULL,
  `blog_id` bigint DEFAULT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `comment`
--

INSERT INTO `comment` (`comment_id`, `comment_content`, `comment_daycreat`, `blog_id`, `user_id`) VALUES
(1, 'Bổ ích', '2024-12-18 23:44:05.434657', 1, 8);

-- --------------------------------------------------------

--
-- Table structure for table `country`
--

CREATE TABLE `country` (
  `country_id` bigint NOT NULL,
  `country_name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `country`
--

INSERT INTO `country` (`country_id`, `country_name`) VALUES
(1, 'Âu Mỹ'),
(2, 'Nhật Bản'),
(4, 'Việt Nam'),
(5, 'Trung Quốc'),
(7, 'Mỹ'),
(9, 'Haiti'),
(10, 'Thái Lan');

-- --------------------------------------------------------

--
-- Table structure for table `feed_back`
--

CREATE TABLE `feed_back` (
  `feedback_id` bigint NOT NULL,
  `feedback_email` varchar(255) NOT NULL,
  `feedback_message` varchar(255) NOT NULL,
  `feedback_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `film_id` bigint NOT NULL,
  `actor` varchar(255) DEFAULT NULL,
  `description` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `director` varchar(255) DEFAULT NULL,
  `duration` int NOT NULL,
  `limit_age` varchar(255) DEFAULT NULL,
  `film_name` varchar(255) NOT NULL,
  `opening_day` datetime(6) DEFAULT NULL,
  `poster` varchar(255) DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `subtitle` varchar(255) DEFAULT NULL,
  `trailer` varchar(255) DEFAULT NULL,
  `country_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`film_id`, `actor`, `description`, `director`, `duration`, `limit_age`, `film_name`, `opening_day`, `poster`, `quality`, `subtitle`, `trailer`, `country_id`) VALUES
(1, 'Ben Schwartz, Colleen O\'Shaughnessey, Idris Elba.', 'Sonic, Knuckles và Tails phải đối mặt với một kẻ thù mới cực kỳ mạnh mẽ là Shadow - một nhân vật phản diện bí ẩn với sức mạnh không giống bất kỳ đối thủ nào họ từng đối mặt trước đây. Bị áp đảo về năng lực, Sonic phải lên đường thành lập một liên minh to lớn hơn.', 'Jeff Fowler', 110, 'K - Phim được phổ biến đến người xem dưới 13 tuổi và có người bảo hộ đi kèm', 'SONIC 3', '2024-12-27 00:01:01.000000', 'https://m.media-amazon.com/images/M/MV5BMjZjNjE5NDEtOWJjYS00Mjk2LWI1ZDYtOWI1ZWI3MzRjM2UzXkEyXkFqcGc@._V1_FMjpg_UX1000_.jpg', '4D', 'Tiếng Anh - Phụ đề Tiếng Việt; Lồng tiếng Việt', '4ICmq6J7txI', 1),
(28, 'Dwayne Johnson, Aldis Hodge, Noah Centineo, Sarah Shahi', 'Black Adam là bộ phim siêu anh hùng xoay quanh nhân vật cùng tên thuộc vũ trụ DC, với sức mạnh không tưởng và hành trình tìm kiếm công lý của mình.', 'Jaume Collet-Serra', 124, '13', 'Black Adam', '2022-10-21 00:00:00.000000', 'https://media.themoviedb.org/t/p/w220_and_h330_face/7FH36YrotoVFCTx8VwPLELHGo7C.jpg', 'HD', 'Tiếng Việt, Tiếng Anh', 'mkomfZHG5q4', 1),
(29, 'Brie Larson, Teyonah Parris, Iman Vellani', 'Captain Marvel 2: The Marvels là phần tiếp theo của bộ phim siêu anh hùng, tập trung vào cuộc phiêu lưu mới của Carol Danvers và đồng đội.', 'Nia DaCosta', 130, '13', 'The Marvels', '2023-11-10 00:00:00.000000', 'https://cdn-images.vtv.vn/562122370168008704/2023/10/3/photo-1-16963023274971868122186.jpeg', 'HD', 'Tiếng Việt, Tiếng Anh', 'wS_qbDztgVY', 1),
(32, 'Subaru Kimura, Megumi Oohara, Megumi Oohara, Kakazu Yumi, Seki Tomokazu', 'Doraemon: Nobita\'s Little Star Wars kể về hành trình của nhóm bạn Doraemon tham gia cuộc chiến bảo vệ thiên hà cùng những người bạn ngoài hành tinh.', 'Yamaguchi Susumu', 108, 'P', 'DORAEMON: NOBITA VÀ CUỘC CHIẾN VŨ TRỤ TÍ HON', '2022-03-04 00:00:00.000000', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTSGVPaQy8uLeZOEGydmFly54AeK5Z3EpSqwQ&s', 'HD', 'Tiếng Việt, Tiếng Anh', 'Yug8gbDd5EQ', 2),
(34, 'Letitia Wright, Lupita Nyong\'o, Danai Gurira, Winston Duke', 'Black Panther: Wakanda Forever là phần tiếp theo của bộ phim về quốc gia Wakanda, nơi họ phải bảo vệ quê hương sau cái chết của vua T\'Challa.', 'Ryan Coogler', 161, '13', 'Black Panther: Wakanda Forever', '2022-11-11 00:00:00.000000', 'https://upload.wikimedia.org/wikipedia/vi/3/3b/Black_Panther_Wakanda_Forever_poster.jpg', 'HD', 'Tiếng Việt, Tiếng Anh', 'RlOB3UALvrQ', 7),
(35, 'Sam Worthington, Zoe Saldaña, Sigourney Weaver, Kate Winslet', 'Avatar: The Way of Water là phần tiếp theo của bộ phim Avatar (2009), khám phá thế giới Pandora với những cuộc phiêu lưu dưới nước của gia đình Sully.', 'James Cameron', 192, '13', 'Avatar: The Way of Water', '2022-12-16 00:00:00.000000', 'https://m.media-amazon.com/images/I/71s3cEqEZTL._AC_UF894,1000_QL80_.jpg', '4K', 'Tiếng Việt, Tiếng Anh', 'd9MyW72ELq0', 5),
(36, 'Tom Holland, Zendaya, Benedict Cumberbatch, Willem Dafoe', 'Spider-Man: No Way Home tiếp tục hành trình của Peter Parker khi anh đối mặt với đa vũ trụ và những kẻ thù từ các dòng thời gian khác.', 'Jon Watts', 148, '13', 'Spider-Man: No Way Home', '2021-12-31 00:00:00.000000', 'https://upload.wikimedia.org/wikipedia/en/0/00/Spider-Man_No_Way_Home_poster.jpg', 'HD', 'Tiếng Việt, Tiếng Anh', 'JfVOs4VSpmA', 1),
(37, 'Vin Diesel, Jason Momoa, Michelle Rodriguez, Tyrese Gibson', 'Fast X là phần tiếp theo của loạt phim Fast & Furious, xoay quanh các cuộc đua xe gay cấn và nhiệm vụ nguy hiểm của Dominic Toretto và đồng đội.', 'Louis Leterrier', 142, '13', 'Fast X', '2023-05-19 00:00:00.000000', 'https://images.squarespace-cdn.com/content/v1/63bb3e8a824d7e2f7eedf0d3/366770a7-63b9-4519-a277-2427a06decf9/Fast+X+3.jpeg?format=300w', 'HD', 'Tiếng Việt, Tiếng Anh', '32RAq6JzY-w', 7),
(42, 'Benedict Cumberbatch, Elizabeth Olsen, Chiwetel Ejiofor, Benedict Wong', 'Doctor Strange in the Multiverse of Madness đưa người xem vào hành trình xuyên qua đa vũ trụ với những nguy hiểm và bất ngờ đang chờ đợi.', 'Sam Raimi', 126, '13', 'Doctor Strange in the Multiverse of Madness', '2022-05-06 00:00:00.000000', 'https://upload.wikimedia.org/wikipedia/en/1/17/Doctor_Strange_in_the_Multiverse_of_Madness_poster.jpg', '4K', 'Tiếng Việt, Tiếng Anh', 'aWzlQ2N6qqg', 4),
(43, 'Anthony Mackie, Tim Blake Nelson, Harrison Ford', 'Hay ', 'Julius Onah', 123, '16', 'Captain America: Brave New World (2025)', '2025-02-14 20:53:00.000000', '/assets/img/movie/da2613d5-4ea2-4a0a-8581-3bd29d5cf0e8.jpg', 'Hay', 'Tiếng Việt, Tiếng Anh', '1pHDWnXmK7Y', 1);

-- --------------------------------------------------------

--
-- Table structure for table `film_category`
--

CREATE TABLE `film_category` (
  `film_id` bigint NOT NULL,
  `category_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `film_category`
--

INSERT INTO `film_category` (`film_id`, `category_id`) VALUES
(29, 2),
(29, 3),
(29, 5),
(37, 2),
(37, 3),
(28, 2),
(28, 3),
(29, 2),
(29, 3),
(29, 5),
(37, 2),
(37, 3),
(28, 2),
(28, 3),
(34, 2),
(34, 7),
(35, 3),
(35, 7),
(36, 3),
(42, 8),
(42, 9),
(32, 3),
(32, 9),
(43, 2),
(43, 4),
(1, 1),
(1, 6);

-- --------------------------------------------------------

--
-- Table structure for table `mo_mo_payment_save`
--

CREATE TABLE `mo_mo_payment_save` (
  `id` bigint NOT NULL,
  `amount` bigint DEFAULT NULL,
  `created_at` datetime(6) DEFAULT NULL,
  `failure_message` varchar(255) DEFAULT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_method` varchar(255) DEFAULT NULL,
  `payment_status` varchar(255) DEFAULT NULL,
  `payment_time` datetime(6) DEFAULT NULL,
  `request_id` varchar(255) DEFAULT NULL,
  `transaction_id` varchar(255) DEFAULT NULL,
  `booking_booking_id` bigint DEFAULT NULL,
  `response_time` datetime(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `mo_mo_payment_save`
--

INSERT INTO `mo_mo_payment_save` (`id`, `amount`, `created_at`, `failure_message`, `order_id`, `payment_method`, `payment_status`, `payment_time`, `request_id`, `transaction_id`, `booking_booking_id`, `response_time`) VALUES
(13, 80000, '2024-12-26 14:37:40.600000', NULL, '1735198660575', NULL, NULL, NULL, '1735198660575', NULL, NULL, NULL),
(14, 64000, '2024-12-26 14:37:45.701000', NULL, '1735198665701', NULL, NULL, NULL, '1735198665701', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `promotion_id` bigint NOT NULL,
  `promotion_description` varchar(350) NOT NULL,
  `promotion_discount_rate` double DEFAULT NULL,
  `promotion_end_date` datetime(6) NOT NULL,
  `promotion_start_date` datetime(6) NOT NULL,
  `promotion_code` varchar(255) NOT NULL,
  `point_to_redeem` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`promotion_id`, `promotion_description`, `promotion_discount_rate`, `promotion_end_date`, `promotion_start_date`, `promotion_code`, `point_to_redeem`) VALUES
(1, 'Giảm giá 20% cho sinh viên', 0.2, '2026-12-31 23:59:00.000000', '2024-12-04 21:05:00.000000', 'SVD20', NULL),
(2, '30 Tết - Giảm 15% trên tổng giá vé', 0.15, '2025-12-28 23:59:59.999999', '2024-12-10 00:00:00.000000', 'TETM30', 30),
(3, 'Học sinh giảm 10% trên tổng giá vé', 0.1, '2035-12-31 23:59:59.999999', '2024-12-01 09:59:12.000000', 'HSD10', NULL),
(4, 'Kính lão đắc thọ - Giảm 18% cho thành viên trên 50 tuổi', 0.18, '2034-12-31 23:59:59.999999', '2024-12-01 00:01:00.000000', 'NGD18', NULL),
(5, 'Giảm 5% nếu bạn là người tham gia cuộc thi Đấu trường Chân lý', 0.05, '2025-01-05 16:57:00.000000', '2024-12-25 16:57:00.000000', 'GG5GG', 10);

-- --------------------------------------------------------

--
-- Table structure for table `rating`
--

CREATE TABLE `rating` (
  `rating_id` bigint NOT NULL,
  `rating_content` varchar(255) DEFAULT NULL,
  `rating_daycreate` datetime(6) DEFAULT NULL,
  `rating_star` int DEFAULT NULL,
  `film_id` bigint DEFAULT NULL,
  `user_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `rating`
--

INSERT INTO `rating` (`rating_id`, `rating_content`, `rating_daycreate`, `rating_star`, `film_id`, `user_id`) VALUES
(1, 'Phim hay', '2024-12-25 15:57:20.360365', 4, 29, 13),
(2, 'Hay', '2024-12-26 22:51:18.195940', 5, 28, 1),
(3, 'Phim hay nhưng hơi buồn ngủ\r\n', '2024-12-26 22:52:08.205550', 4, 28, 8);

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` bigint NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, NULL, 'ADMIN'),
(2, NULL, 'USER');

-- --------------------------------------------------------

--
-- Table structure for table `room`
--

CREATE TABLE `room` (
  `room_id` bigint NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `room_name` varchar(255) NOT NULL,
  `cinema_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `room`
--

INSERT INTO `room` (`room_id`, `description`, `room_name`, `cinema_id`) VALUES
(1, 'Góc bên phải rạp', 'Phòng 01-CGV Thủ Đức', 1),
(2, '', 'Phòng 02-CineStar', 3),
(8, 'abc', 'Phòng chiếu 03-Linh Trung', 8),
(10, '123', 'Phòng số 5-BHD', 5),
(11, '', 'Phòng số 10 BHD', 5),
(12, 'Góc phải cuối hành lang bên trái', 'Phòng 3', 1),
(13, 'Góc phải cuối hành lang bên trái', 'Phòng 4', 1);

-- --------------------------------------------------------

--
-- Table structure for table `schedule`
--

CREATE TABLE `schedule` (
  `schedule_id` bigint NOT NULL,
  `START_TIME` datetime DEFAULT NULL,
  `film_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `schedule`
--

INSERT INTO `schedule` (`schedule_id`, `START_TIME`, `film_id`, `room_id`) VALUES
(29, '2024-07-10 19:40:00', 28, 1),
(30, '2024-07-11 16:50:00', 28, 1),
(31, '2024-07-09 18:50:00', 28, 2),
(32, '2024-07-02 21:10:00', 28, 2),
(33, '2024-07-11 00:17:00', 29, 2),
(35, '2024-07-03 22:50:00', 29, 1),
(36, '2024-07-10 10:10:00', 37, 8),
(37, '2024-07-10 13:20:00', 37, 8),
(38, '2024-07-10 19:00:00', 37, 8),
(39, '2024-07-10 12:12:00', 32, 2),
(40, '2024-07-11 02:20:00', 32, 2),
(41, '2024-07-11 10:20:00', 35, 1),
(42, '2024-07-10 13:20:00', 35, 2),
(43, '2024-07-10 11:30:00', 35, 1),
(44, '2024-07-10 15:10:00', 36, 8),
(45, '2024-07-10 16:20:00', 36, 1),
(46, '2024-07-11 17:35:00', 37, 2),
(47, '2024-12-06 21:06:00', 32, 12),
(48, '2024-12-24 21:51:00', 42, 12),
(49, '2024-12-26 16:56:00', 34, 13),
(50, '2024-12-25 17:17:00', 34, 13);

-- --------------------------------------------------------

--
-- Table structure for table `seat`
--

CREATE TABLE `seat` (
  `seat_id` bigint NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `seat_number` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `seat_type_id` bigint DEFAULT NULL,
  `schedule_id` bigint DEFAULT NULL,
  `room_id` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seat`
--

INSERT INTO `seat` (`seat_id`, `image`, `seat_number`, `status`, `seat_type_id`, `schedule_id`, `room_id`) VALUES
(1, '/assets/img/seat/regular.png', 'A1', 0, 1, NULL, 1),
(2, '/assets/img/seat/regular.png', 'A2', 0, 1, NULL, 1),
(3, '/assets/img/seat/regular.png', 'A3', 0, 1, NULL, 1),
(4, '/assets/img/seat/regular.png', 'A4', 0, 1, NULL, 1),
(5, '/assets/img/seat/regular.png', 'A5', 0, 1, NULL, 1),
(6, '/assets/img/seat/regular.png', 'A6', 0, 1, NULL, 1),
(7, '/assets/img/seat/regular.png', 'A7', 0, 1, NULL, 1),
(8, '/assets/img/seat/regular.png', 'A8', 0, 1, NULL, 1),
(9, '/assets/img/seat/regular.png', 'A9', 0, 1, NULL, 1),
(10, '/assets/img/seat/regular.png', 'A10', 0, 1, NULL, 1),
(11, '/assets/img/seat/regular.png', 'A11', 0, 1, NULL, 1),
(12, '/assets/img/seat/regular.png', 'A12', 0, 1, NULL, 1),
(13, '/assets/img/seat/regular.png', 'B1', 0, 1, NULL, 1),
(14, '/assets/img/seat/regular.png', 'B2', 0, 1, NULL, 1),
(15, '/assets/img/seat/regular.png', 'B3', 0, 1, NULL, 1),
(16, '/assets/img/seat/regular.png', 'B4', 0, 1, NULL, 1),
(17, '/assets/img/seat/regular.png', 'B5', 0, 1, NULL, 1),
(18, '/assets/img/seat/regular.png', 'B6', 0, 1, NULL, 1),
(19, '/assets/img/seat/regular.png', 'B7', 0, 1, NULL, 1),
(20, '/assets/img/seat/regular.png', 'B8', 0, 1, NULL, 1),
(21, '/assets/img/seat/regular.png', 'B9', 0, 1, NULL, 1),
(22, '/assets/img/seat/regular.png', 'B10', 0, 1, NULL, 1),
(23, '/assets/img/seat/regular.png', 'B11', 0, 1, NULL, 1),
(24, '/assets/img/seat/regular.png', 'B12', 0, 1, NULL, 1),
(25, '/assets/img/seat/VIP.png', 'E1', 0, 2, NULL, 1),
(26, '/assets/img/seat/VIP.png', 'E2', 0, 2, NULL, 1),
(27, '/assets/img/seat/VIP.png', 'E3', 0, 2, NULL, 1),
(28, '/assets/img/seat/VIP.png', 'E4', 0, 2, NULL, 1),
(29, '/assets/img/seat/VIP.png', 'E5', 1, 2, NULL, 1),
(30, '/assets/img/seat/VIP.png', 'E6', 1, 2, NULL, 1),
(31, '/assets/img/seat/VIP.png', 'E7', 1, 2, NULL, 1),
(32, '/assets/img/seat/VIP.png', 'E8', 0, 2, NULL, 1),
(33, '/assets/img/seat/VIP.png', 'E9', 0, 2, NULL, 1),
(34, '/assets/img/seat/VIP.png', 'E10', 0, 2, NULL, 1),
(35, '/assets/img/seat/VIP.png', 'E11', 0, 2, NULL, 1),
(36, '/assets/img/seat/VIP.png', 'E12', 0, 2, NULL, 1),
(37, '/assets/img/seat/VIP.png', 'F1', 0, 2, NULL, 1),
(38, '/assets/img/seat/VIP.png', 'F2', 0, 2, NULL, 1),
(39, '/assets/img/seat/VIP.png', 'F3', 0, 2, NULL, 1),
(40, '/assets/img/seat/VIP.png', 'F4', 0, 2, NULL, 1),
(41, '/assets/img/seat/VIP.png', 'F5', 0, 2, NULL, 1),
(42, '/assets/img/seat/VIP.png', 'F6', 0, 2, NULL, 1),
(43, '/assets/img/seat/VIP.png', 'F7', 0, 2, NULL, 1),
(44, '/assets/img/seat/VIP.png', 'F8', 0, 2, NULL, 1),
(45, '/assets/img/seat/VIP.png', 'F9', 0, 2, NULL, 1),
(46, '/assets/img/seat/VIP.png', 'F10', 0, 2, NULL, 1),
(47, '/assets/img/seat/VIP.png', 'F11', 0, 2, NULL, 1),
(48, '/assets/img/seat/VIP.png', 'F12', 0, 2, NULL, 1),
(49, '/assets/img/seat/couple.png', 'J1J2', 0, 4, NULL, 1),
(50, '/assets/img/seat/couple.png', 'J3J4', 0, 4, NULL, 1),
(51, '/assets/img/seat/couple.png', 'J4J5', 0, 4, NULL, 1),
(52, '/assets/img/seat/couple.png', 'J6J7', 0, 4, NULL, 1),
(53, '/assets/img/seat/couple.png', 'J8J9', 0, 4, NULL, 1),
(54, '/assets/img/seat/couple.png', 'J10J11', 0, 4, NULL, 1),
(55, '/assets/img/seat/couple.png', 'J12J13', 0, 4, NULL, 1),
(56, '/assets/img/seat/couple.png', 'J14J15', 0, 4, NULL, 1),
(57, '/assets/img/seat/regular.png', 'C1', 0, 1, NULL, 1),
(58, '/assets/img/seat/regular.png', 'C2', 0, 1, NULL, 1),
(59, '/assets/img/seat/regular.png', 'C3', 0, 1, NULL, 1),
(60, '/assets/img/seat/regular.png', 'C4', 0, 1, NULL, 1),
(61, '/assets/img/seat/regular.png', 'C5', 0, 1, NULL, 1),
(62, '/assets/img/seat/regular.png', 'C6', 0, 1, NULL, 1),
(63, '/assets/img/seat/regular.png', 'C7', 1, 1, NULL, 1),
(64, '/assets/img/seat/regular.png', 'C8', 0, 1, NULL, 1),
(65, '/assets/img/seat/regular.png', 'C9', 0, 1, NULL, 1),
(66, '/assets/img/seat/regular.png', 'C10', 0, 1, NULL, 1),
(67, '/assets/img/seat/regular.png', 'C11', 0, 1, NULL, 1),
(68, '/assets/img/seat/regular.png', 'C12', 0, 1, NULL, 1),
(69, '/assets/img/seat/regular.png', 'D1', 0, 1, NULL, 1),
(70, '/assets/img/seat/regular.png', 'D2', 0, 1, NULL, 1),
(71, '/assets/img/seat/regular.png', 'D3', 0, 1, NULL, 1),
(72, '/assets/img/seat/regular.png', 'D4', 0, 1, NULL, 1),
(73, '/assets/img/seat/regular.png', 'D5', 0, 1, NULL, 1),
(74, '/assets/img/seat/regular.png', 'D6', 0, 1, NULL, 1),
(75, '/assets/img/seat/regular.png', 'D7', 0, 1, NULL, 1),
(76, '/assets/img/seat/regular.png', 'D8', 0, 1, NULL, 1),
(77, '/assets/img/seat/regular.png', 'D9', 0, 1, NULL, 1),
(78, '/assets/img/seat/regular.png', 'D10', 0, 1, NULL, 1),
(79, '/assets/img/seat/regular.png', 'D11', 0, 1, NULL, 1),
(80, '/assets/img/seat/regular.png', 'D12', 0, 1, NULL, 1),
(81, '/assets/img/seat/VIP.png', 'G1', 0, 2, NULL, 1),
(82, '/assets/img/seat/VIP.png', 'G2', 0, 2, NULL, 1),
(83, '/assets/img/seat/VIP.png', 'G3', 0, 2, NULL, 1),
(84, '/assets/img/seat/VIP.png', 'G4', 0, 2, NULL, 1),
(85, '/assets/img/seat/VIP.png', 'G5', 0, 2, NULL, 1),
(86, '/assets/img/seat/VIP.png', 'G6', 0, 2, NULL, 1),
(87, '/assets/img/seat/VIP.png', 'G7', 0, 2, NULL, 1),
(88, '/assets/img/seat/VIP.png', 'G8', 0, 2, NULL, 1),
(89, '/assets/img/seat/VIP.png', 'G9', 0, 2, NULL, 1),
(90, '/assets/img/seat/VIP.png', 'G10', 0, 2, NULL, 1),
(91, '/assets/img/seat/VIP.png', 'G11', 0, 2, NULL, 1),
(92, '/assets/img/seat/VIP.png', 'G12', 0, 2, NULL, 1),
(93, '/assets/img/seat/VIP.png', 'H1', 0, 2, NULL, 1),
(94, '/assets/img/seat/VIP.png', 'H2', 0, 2, NULL, 1),
(95, '/assets/img/seat/VIP.png', 'H3', 0, 2, NULL, 1),
(96, '/assets/img/seat/VIP.png', 'H4', 0, 2, NULL, 1),
(97, '/assets/img/seat/VIP.png', 'H5', 0, 2, NULL, 1),
(98, '/assets/img/seat/VIP.png', 'H6', 0, 2, NULL, 1),
(99, '/assets/img/seat/VIP.png', 'H7', 0, 2, NULL, 1),
(100, '/assets/img/seat/VIP.png', 'H8', 0, 2, NULL, 1),
(101, '/assets/img/seat/VIP.png', 'H9', 0, 2, NULL, 1),
(102, '/assets/img/seat/VIP.png', 'H10', 0, 2, NULL, 1),
(103, '/assets/img/seat/VIP.png', 'H11', 0, 2, NULL, 1),
(105, '/assets/img/seat/regular.png', 'A1', 0, 1, NULL, 2),
(106, '/assets/img/seat/regular.png', 'A2', 0, 1, NULL, 2),
(107, '/assets/img/seat/regular.png', 'A3', 0, 1, NULL, 2),
(108, '/assets/img/seat/regular.png', 'A4', 0, 1, NULL, 2),
(109, '/assets/img/seat/regular.png', 'A5', 0, 1, NULL, 2),
(110, '/assets/img/seat/regular.png', 'A6', 0, 1, NULL, 2),
(111, '/assets/img/seat/regular.png', 'A7', 0, 1, NULL, 2),
(112, '/assets/img/seat/regular.png', 'A8', 0, 1, NULL, 2),
(113, '/assets/img/seat/regular.png', 'A9', 0, 1, NULL, 2),
(114, '/assets/img/seat/regular.png', 'A10', 0, 1, NULL, 2),
(115, '/assets/img/seat/regular.png', 'A11', 0, 1, NULL, 2),
(116, '/assets/img/seat/regular.png', 'A12', 0, 1, NULL, 2),
(117, '/assets/img/seat/regular.png', 'B1', 0, 1, NULL, 2),
(118, '/assets/img/seat/regular.png', 'B2', 0, 1, NULL, 2),
(119, '/assets/img/seat/regular.png', 'B3', 0, 1, NULL, 2),
(120, '/assets/img/seat/regular.png', 'B4', 0, 1, NULL, 2),
(121, '/assets/img/seat/regular.png', 'B5', 0, 1, NULL, 2),
(122, '/assets/img/seat/regular.png', 'B6', 0, 1, NULL, 2),
(123, '/assets/img/seat/regular.png', 'B7', 0, 1, NULL, 2),
(124, '/assets/img/seat/regular.png', 'B8', 0, 1, NULL, 2),
(125, '/assets/img/seat/regular.png', 'B9', 0, 1, NULL, 2),
(126, '/assets/img/seat/regular.png', 'B10', 0, 1, NULL, 2),
(127, '/assets/img/seat/regular.png', 'B11', 0, 1, NULL, 2),
(128, '/assets/img/seat/regular.png', 'B12', 0, 1, NULL, 2),
(129, '/assets/img/seat/regular.png', 'C1', 0, 1, NULL, 2),
(130, '/assets/img/seat/regular.png', 'C2', 0, 1, NULL, 2),
(131, '/assets/img/seat/regular.png', 'C3', 0, 1, NULL, 2),
(132, '/assets/img/seat/regular.png', 'C4', 0, 1, NULL, 2),
(133, '/assets/img/seat/regular.png', 'C5', 0, 1, NULL, 2),
(134, '/assets/img/seat/regular.png', 'C6', 0, 1, NULL, 2),
(135, '/assets/img/seat/regular.png', 'C7', 0, 1, NULL, 2),
(136, '/assets/img/seat/regular.png', 'C8', 0, 1, NULL, 2),
(137, '/assets/img/seat/regular.png', 'C9', 0, 1, NULL, 2),
(138, '/assets/img/seat/regular.png', 'C10', 0, 1, NULL, 2),
(139, '/assets/img/seat/regular.png', 'C11', 0, 1, NULL, 2),
(140, '/assets/img/seat/regular.png', 'C12', 0, 1, NULL, 2),
(141, '/assets/img/seat/VIP.png', 'D1', 0, 2, NULL, 2),
(142, '/assets/img/seat/VIP.png', 'D2', 0, 2, NULL, 2),
(143, '/assets/img/seat/VIP.png', 'D3', 0, 2, NULL, 2),
(144, '/assets/img/seat/VIP.png', 'D4', 0, 2, NULL, 2),
(145, '/assets/img/seat/VIP.png', 'D5', 0, 2, NULL, 2),
(146, '/assets/img/seat/VIP.png', 'D6', 0, 2, NULL, 2),
(147, '/assets/img/seat/VIP.png', 'D7', 0, 2, NULL, 2),
(148, '/assets/img/seat/VIP.png', 'D8', 0, 2, NULL, 2),
(149, '/assets/img/seat/VIP.png', 'D9', 0, 2, NULL, 2),
(150, '/assets/img/seat/VIP.png', 'D10', 0, 2, NULL, 2),
(151, '/assets/img/seat/VIP.png', 'D11', 0, 2, NULL, 2),
(152, '/assets/img/seat/VIP.png', 'D12', 0, 2, NULL, 2),
(153, '/assets/img/seat/VIP.png', 'E1', 0, 2, NULL, 2),
(154, '/assets/img/seat/VIP.png', 'E2', 0, 2, NULL, 2),
(155, '/assets/img/seat/VIP.png', 'E3', 0, 2, NULL, 2),
(156, '/assets/img/seat/VIP.png', 'E4', 0, 2, NULL, 2),
(157, '/assets/img/seat/VIP.png', 'E5', 0, 2, NULL, 2),
(158, '/assets/img/seat/VIP.png', 'E6', 0, 2, NULL, 2),
(159, '/assets/img/seat/VIP.png', 'E7', 0, 2, NULL, 2),
(160, '/assets/img/seat/VIP.png', 'E8', 0, 2, NULL, 2),
(161, '/assets/img/seat/VIP.png', 'E9', 0, 2, NULL, 2),
(162, '/assets/img/seat/VIP.png', 'E10', 0, 2, NULL, 2),
(163, '/assets/img/seat/VIP.png', 'E11', 0, 2, NULL, 2),
(164, '/assets/img/seat/VIP.png', 'E12', 0, 2, NULL, 2),
(165, '/assets/img/seat/VIP.png', 'F1', 0, 2, NULL, 2),
(166, '/assets/img/seat/VIP.png', 'F2', 0, 2, NULL, 2),
(167, '/assets/img/seat/VIP.png', 'F3', 0, 2, NULL, 2),
(168, '/assets/img/seat/VIP.png', 'F4', 0, 2, NULL, 2),
(169, '/assets/img/seat/VIP.png', 'F5', 0, 2, NULL, 2),
(170, '/assets/img/seat/VIP.png', 'F6', 0, 2, NULL, 2),
(171, '/assets/img/seat/VIP.png', 'F7', 0, 2, NULL, 2),
(172, '/assets/img/seat/VIP.png', 'F8', 0, 2, NULL, 2),
(173, '/assets/img/seat/VIP.png', 'F9', 0, 2, NULL, 2),
(174, '/assets/img/seat/VIP.png', 'F10', 0, 2, NULL, 2),
(175, '/assets/img/seat/VIP.png', 'F11', 0, 2, NULL, 2),
(176, '/assets/img/seat/VIP.png', 'F12', 0, 2, NULL, 2),
(177, '/assets/img/seat/couple.png', 'G1G2', 0, 4, NULL, 2),
(178, '/assets/img/seat/couple.png', 'G3G4', 0, 4, NULL, 2),
(179, '/assets/img/seat/couple.png', 'G5G6', 0, 4, NULL, 2),
(180, '/assets/img/seat/couple.png', 'G7G8', 0, 4, NULL, 2),
(181, '/assets/img/seat/couple.png', 'G9G10', 0, 4, NULL, 2),
(182, '/assets/img/seat/couple.png', 'G11G12', 0, 4, NULL, 2),
(183, '/assets/img/seat/couple.png', 'G13G14', 0, 4, NULL, 2),
(185, '/assets/img/seat/regular.png', 'A1', 0, 1, NULL, 8),
(186, '/assets/img/seat/regular.png', 'A2', 0, 1, NULL, 8),
(187, '/assets/img/seat/regular.png', 'A3', 0, 1, NULL, 8),
(188, '/assets/img/seat/regular.png', 'A4', 0, 1, NULL, 8),
(189, '/assets/img/seat/regular.png', 'A5', 0, 1, NULL, 8),
(190, '/assets/img/seat/regular.png', 'A6', 0, 1, NULL, 8),
(191, '/assets/img/seat/regular.png', 'A7', 0, 1, NULL, 8),
(192, '/assets/img/seat/regular.png', 'A8', 0, 1, NULL, 8),
(193, '/assets/img/seat/regular.png', 'A9', 0, 1, NULL, 8),
(194, '/assets/img/seat/regular.png', 'A10', 0, 1, NULL, 8),
(195, '/assets/img/seat/regular.png', 'A11', 0, 1, NULL, 8),
(196, '/assets/img/seat/regular.png', 'A12', 0, 1, NULL, 8),
(197, '/assets/img/seat/regular.png', 'B1', 0, 1, NULL, 8),
(198, '/assets/img/seat/regular.png', 'B2', 0, 1, NULL, 8),
(199, '/assets/img/seat/regular.png', 'B3', 0, 1, NULL, 8),
(200, '/assets/img/seat/regular.png', 'B4', 0, 1, NULL, 8),
(201, '/assets/img/seat/regular.png', 'B5', 0, 1, NULL, 8),
(202, '/assets/img/seat/regular.png', 'B6', 0, 1, NULL, 8),
(203, '/assets/img/seat/regular.png', 'B7', 0, 1, NULL, 8),
(204, '/assets/img/seat/regular.png', 'B8', 0, 1, NULL, 8),
(205, '/assets/img/seat/regular.png', 'B9', 0, 1, NULL, 8),
(206, '/assets/img/seat/regular.png', 'B10', 0, 1, NULL, 8),
(207, '/assets/img/seat/regular.png', 'B11', 0, 1, NULL, 8),
(208, '/assets/img/seat/regular.png', 'B12', 0, 1, NULL, 8),
(209, '/assets/img/seat/VIP.png', 'C1', 0, 2, NULL, 8),
(210, '/assets/img/seat/VIP.png', 'C2', 0, 2, NULL, 8),
(211, '/assets/img/seat/VIP.png', 'C3', 0, 2, NULL, 8),
(212, '/assets/img/seat/VIP.png', 'C4', 0, 2, NULL, 8),
(213, '/assets/img/seat/VIP.png', 'C5', 0, 2, NULL, 8),
(214, '/assets/img/seat/VIP.png', 'C6', 0, 2, NULL, 8),
(215, '/assets/img/seat/VIP.png', 'C7', 0, 2, NULL, 8),
(216, '/assets/img/seat/VIP.png', 'C8', 0, 2, NULL, 8),
(217, '/assets/img/seat/VIP.png', 'C9', 0, 2, NULL, 8),
(218, '/assets/img/seat/VIP.png', 'C10', 0, 2, NULL, 8),
(219, '/assets/img/seat/VIP.png', 'C11', 0, 2, NULL, 8),
(220, '/assets/img/seat/VIP.png', 'C12', 0, 2, NULL, 8),
(221, '/assets/img/seat/VIP.png', 'D1', 0, 2, NULL, 8),
(222, '/assets/img/seat/VIP.png', 'D2', 0, 2, NULL, 8),
(223, '/assets/img/seat/VIP.png', 'D3', 0, 2, NULL, 8),
(224, '/assets/img/seat/VIP.png', 'D4', 0, 2, NULL, 8),
(225, '/assets/img/seat/VIP.png', 'D5', 0, 2, NULL, 8),
(226, '/assets/img/seat/VIP.png', 'D6', 0, 2, NULL, 8),
(227, '/assets/img/seat/VIP.png', 'D7', 0, 2, NULL, 8),
(228, '/assets/img/seat/VIP.png', 'D8', 0, 2, NULL, 8),
(229, '/assets/img/seat/VIP.png', 'D9', 0, 2, NULL, 8),
(230, '/assets/img/seat/VIP.png', 'D10', 0, 2, NULL, 8),
(231, '/assets/img/seat/VIP.png', 'D11', 0, 2, NULL, 8),
(232, '/assets/img/seat/VIP.png', 'D12', 0, 2, NULL, 8),
(233, '/assets/img/seat/VIP.png', 'E1', 0, 2, NULL, 8),
(234, '/assets/img/seat/VIP.png', 'E2', 0, 2, NULL, 8),
(235, '/assets/img/seat/VIP.png', 'E3', 0, 2, NULL, 8),
(236, '/assets/img/seat/VIP.png', 'E4', 0, 2, NULL, 8),
(237, '/assets/img/seat/VIP.png', 'E5', 0, 2, NULL, 8),
(238, '/assets/img/seat/VIP.png', 'E6', 0, 2, NULL, 8),
(239, '/assets/img/seat/VIP.png', 'E7', 0, 2, NULL, 8),
(240, '/assets/img/seat/VIP.png', 'E8', 0, 2, NULL, 8),
(241, '/assets/img/seat/VIP.png', 'E9', 0, 2, NULL, 8),
(242, '/assets/img/seat/VIP.png', 'E10', 0, 2, NULL, 8),
(243, '/assets/img/seat/VIP.png', 'E11', 0, 2, NULL, 8),
(244, '/assets/img/seat/VIP.png', 'E12', 0, 2, NULL, 8),
(245, '/assets/img/seat/VIP.png', 'F1', 0, 2, NULL, 8),
(246, '/assets/img/seat/VIP.png', 'F2', 0, 2, NULL, 8),
(247, '/assets/img/seat/VIP.png', 'F3', 0, 2, NULL, 8),
(248, '/assets/img/seat/VIP.png', 'F4', 0, 2, NULL, 8),
(249, '/assets/img/seat/VIP.png', 'F5', 0, 2, NULL, 8),
(250, '/assets/img/seat/VIP.png', 'F6', 0, 2, NULL, 8),
(251, '/assets/img/seat/VIP.png', 'F7', 0, 2, NULL, 8),
(252, '/assets/img/seat/VIP.png', 'F8', 0, 2, NULL, 8),
(253, '/assets/img/seat/VIP.png', 'F9', 0, 2, NULL, 8),
(254, '/assets/img/seat/VIP.png', 'F10', 0, 2, NULL, 8),
(255, '/assets/img/seat/VIP.png', 'F11', 0, 2, NULL, 8),
(256, '/assets/img/seat/VIP.png', 'F12', 0, 2, NULL, 8),
(257, '/assets/img/seat/couple.png', 'G1G2', 0, 4, NULL, 8),
(258, '/assets/img/seat/couple.png', 'G3G4', 0, 4, NULL, 8),
(259, '/assets/img/seat/couple.png', 'G5G6', 0, 4, NULL, 8),
(260, '/assets/img/seat/couple.png', 'G7G8', 0, 4, NULL, 8),
(261, '/assets/img/seat/couple.png', 'G9G10', 0, 4, NULL, 8),
(262, '/assets/img/seat/couple.png', 'G11G12', 0, 4, NULL, 8),
(263, '/assets/img/seat/couple.png', 'G13G14', 0, 4, NULL, 8),
(264, '/assets/img/seat/couple.png', 'G15G16', 0, 4, NULL, 8),
(265, '/assets/img/seat/regular.png', 'A1', 1, 1, NULL, 12),
(266, '/assets/img/seat/regular.png', 'A2', 1, 1, NULL, 12),
(267, '/assets/img/seat/regular.png', 'A3', 1, 1, NULL, 12),
(268, '/assets/img/seat/regular.png', 'A4', 1, 1, NULL, 12),
(269, '/assets/img/seat/regular.png', 'A5', 1, 1, NULL, 12),
(270, '/assets/img/seat/regular.png', 'A6', 1, 1, NULL, 12),
(271, '/assets/img/seat/regular.png', 'A7', 1, 1, NULL, 12),
(272, '/assets/img/seat/regular.png', 'A8', 1, 1, NULL, 12),
(273, '/assets/img/seat/regular.png', 'A9', 1, 1, NULL, 12),
(274, '/assets/img/seat/regular.png', 'A10', 1, 1, NULL, 12),
(275, '/assets/img/seat/regular.png', 'A11', 1, 1, NULL, 12),
(276, '/assets/img/seat/regular.png', 'A12', 1, 1, NULL, 12),
(277, '/assets/img/seat/regular.png', 'B1', 1, 1, NULL, 12),
(278, '/assets/img/seat/regular.png', 'B2', 1, 1, NULL, 12),
(279, '/assets/img/seat/regular.png', 'B3', 1, 1, NULL, 12),
(280, '/assets/img/seat/regular.png', 'B4', 1, 1, NULL, 12),
(281, '/assets/img/seat/regular.png', 'B5', 1, 1, NULL, 12),
(282, '/assets/img/seat/regular.png', 'B6', 1, 1, NULL, 12),
(283, '/assets/img/seat/regular.png', 'B7', 1, 1, NULL, 12),
(284, '/assets/img/seat/regular.png', 'B8', 1, 1, NULL, 12),
(285, '/assets/img/seat/regular.png', 'B9', 1, 1, NULL, 12),
(286, '/assets/img/seat/regular.png', 'B10', 1, 1, NULL, 12),
(287, '/assets/img/seat/regular.png', 'B11', 1, 1, NULL, 12),
(288, '/assets/img/seat/regular.png', 'B12', 1, 1, NULL, 12),
(289, '/assets/img/seat/regular.png', 'C1', 1, 1, NULL, 12),
(290, '/assets/img/seat/regular.png', 'C2', 1, 1, NULL, 12),
(291, '/assets/img/seat/regular.png', 'C3', 1, 1, NULL, 12),
(292, '/assets/img/seat/regular.png', 'C4', 1, 1, NULL, 12),
(293, '/assets/img/seat/regular.png', 'C5', 1, 1, NULL, 12),
(294, '/assets/img/seat/regular.png', 'C6', 1, 1, NULL, 12),
(295, '/assets/img/seat/regular.png', 'C7', 1, 1, NULL, 12),
(296, '/assets/img/seat/regular.png', 'C8', 1, 1, NULL, 12),
(297, '/assets/img/seat/regular.png', 'C9', 1, 1, NULL, 12),
(298, '/assets/img/seat/regular.png', 'C10', 1, 1, NULL, 12),
(299, '/assets/img/seat/regular.png', 'C11', 1, 1, NULL, 12),
(300, '/assets/img/seat/regular.png', 'C12', 1, 1, NULL, 12),
(301, '/assets/img/seat/regular.png', 'D1', 1, 1, NULL, 12),
(302, '/assets/img/seat/regular.png', 'D2', 1, 1, NULL, 12),
(303, '/assets/img/seat/regular.png', 'D3', 1, 1, NULL, 12),
(304, '/assets/img/seat/regular.png', 'D4', 1, 1, NULL, 12),
(305, '/assets/img/seat/regular.png', 'D5', 1, 1, NULL, 12),
(306, '/assets/img/seat/regular.png', 'D6', 1, 1, NULL, 12),
(307, '/assets/img/seat/regular.png', 'D7', 1, 1, NULL, 12),
(308, '/assets/img/seat/regular.png', 'D8', 1, 1, NULL, 12),
(309, '/assets/img/seat/regular.png', 'D9', 1, 1, NULL, 12),
(310, '/assets/img/seat/regular.png', 'D10', 1, 1, NULL, 12),
(311, '/assets/img/seat/regular.png', 'D11', 1, 1, NULL, 12),
(312, '/assets/img/seat/regular.png', 'D12', 1, 1, NULL, 12),
(313, '/assets/img/seat/VIP.png', 'E1', 1, 2, NULL, 12),
(314, '/assets/img/seat/VIP.png', 'E2', 1, 2, NULL, 12),
(315, '/assets/img/seat/VIP.png', 'E3', 1, 2, NULL, 12),
(316, '/assets/img/seat/VIP.png', 'E4', 1, 2, NULL, 12),
(317, '/assets/img/seat/VIP.png', 'E5', 1, 2, NULL, 12),
(318, '/assets/img/seat/VIP.png', 'E6', 1, 2, NULL, 12),
(319, '/assets/img/seat/VIP.png', 'E7', 1, 2, NULL, 12),
(320, '/assets/img/seat/VIP.png', 'E8', 1, 2, NULL, 12),
(321, '/assets/img/seat/VIP.png', 'E9', 1, 2, NULL, 12),
(322, '/assets/img/seat/VIP.png', 'E10', 1, 2, NULL, 12),
(323, '/assets/img/seat/VIP.png', 'E11', 1, 2, NULL, 12),
(324, '/assets/img/seat/VIP.png', 'E12', 1, 2, NULL, 12),
(325, '/assets/img/seat/VIP.png', 'F1', 1, 2, NULL, 12),
(326, '/assets/img/seat/VIP.png', 'F2', 1, 2, NULL, 12),
(327, '/assets/img/seat/VIP.png', 'F3', 1, 2, NULL, 12),
(328, '/assets/img/seat/VIP.png', 'F4', 1, 2, NULL, 12),
(329, '/assets/img/seat/VIP.png', 'F5', 1, 2, NULL, 12),
(330, '/assets/img/seat/VIP.png', 'F6', 1, 2, NULL, 12),
(331, '/assets/img/seat/VIP.png', 'F7', 1, 2, NULL, 12),
(332, '/assets/img/seat/VIP.png', 'F8', 1, 2, NULL, 12),
(333, '/assets/img/seat/VIP.png', 'F9', 1, 2, NULL, 12),
(334, '/assets/img/seat/VIP.png', 'F10', 1, 2, NULL, 12),
(335, '/assets/img/seat/VIP.png', 'F11', 1, 2, NULL, 12),
(336, '/assets/img/seat/VIP.png', 'F12', 1, 2, NULL, 12),
(337, '/assets/img/seat/VIP.png', 'G1', 1, 2, NULL, 12),
(338, '/assets/img/seat/VIP.png', 'G2', 1, 2, NULL, 12),
(339, '/assets/img/seat/VIP.png', 'G3', 1, 2, NULL, 12),
(340, '/assets/img/seat/VIP.png', 'G4', 1, 2, NULL, 12),
(341, '/assets/img/seat/VIP.png', 'G5', 1, 2, NULL, 12),
(342, '/assets/img/seat/VIP.png', 'G6', 1, 2, NULL, 12),
(343, '/assets/img/seat/VIP.png', 'G7', 1, 2, NULL, 12),
(344, '/assets/img/seat/VIP.png', 'G8', 1, 2, NULL, 12),
(345, '/assets/img/seat/VIP.png', 'G9', 1, 2, NULL, 12),
(346, '/assets/img/seat/VIP.png', 'G10', 1, 2, NULL, 12),
(347, '/assets/img/seat/VIP.png', 'G11', 1, 2, NULL, 12),
(348, '/assets/img/seat/VIP.png', 'G12', 1, 2, NULL, 12),
(349, '/assets/img/seat/VIP.png', 'H1', 1, 2, NULL, 12),
(350, '/assets/img/seat/VIP.png', 'H2', 1, 2, NULL, 12),
(351, '/assets/img/seat/VIP.png', 'H3', 1, 2, NULL, 12),
(352, '/assets/img/seat/VIP.png', 'H4', 1, 2, NULL, 12),
(353, '/assets/img/seat/VIP.png', 'H5', 1, 2, NULL, 12),
(354, '/assets/img/seat/VIP.png', 'H6', 1, 2, NULL, 12),
(355, '/assets/img/seat/VIP.png', 'H7', 1, 2, NULL, 12),
(356, '/assets/img/seat/VIP.png', 'H8', 1, 2, NULL, 12),
(357, '/assets/img/seat/VIP.png', 'H9', 1, 2, NULL, 12),
(358, '/assets/img/seat/VIP.png', 'H10', 1, 2, NULL, 12),
(359, '/assets/img/seat/VIP.png', 'H11', 1, 2, NULL, 12),
(360, '/assets/img/seat/VIP.png', 'H12', 1, 2, NULL, 12),
(361, '/assets/img/seat/couple.png', 'J1J2', 1, 4, NULL, 12),
(362, '/assets/img/seat/couple.png', 'J3J4', 1, 4, NULL, 12),
(363, '/assets/img/seat/couple.png', 'J5J6', 1, 4, NULL, 12),
(364, '/assets/img/seat/couple.png', 'J7J8', 1, 4, NULL, 12),
(365, '/assets/img/seat/couple.png', 'J9J10', 1, 4, NULL, 12),
(366, '/assets/img/seat/couple.png', 'J11J12', 1, 4, NULL, 12),
(367, '/assets/img/seat/regular.png', 'A1', 1, 1, NULL, 13),
(368, '/assets/img/seat/regular.png', 'A2', 1, 1, NULL, 13),
(369, '/assets/img/seat/regular.png', 'A3', 1, 1, NULL, 13),
(370, '/assets/img/seat/regular.png', 'A4', 1, 1, NULL, 13),
(371, '/assets/img/seat/regular.png', 'A5', 1, 1, NULL, 13),
(372, '/assets/img/seat/regular.png', 'A6', 1, 1, NULL, 13),
(373, '/assets/img/seat/regular.png', 'A7', 1, 1, NULL, 13),
(374, '/assets/img/seat/regular.png', 'A8', 1, 1, NULL, 13),
(375, '/assets/img/seat/regular.png', 'A9', 1, 1, NULL, 13),
(376, '/assets/img/seat/regular.png', 'A10', 1, 1, NULL, 13),
(377, '/assets/img/seat/regular.png', 'A11', 1, 1, NULL, 13),
(378, '/assets/img/seat/regular.png', 'A12', 1, 1, NULL, 13),
(379, '/assets/img/seat/regular.png', 'B1', 1, 1, NULL, 13),
(380, '/assets/img/seat/regular.png', 'B2', 1, 1, NULL, 13),
(381, '/assets/img/seat/regular.png', 'B3', 1, 1, NULL, 13),
(382, '/assets/img/seat/regular.png', 'B4', 1, 1, NULL, 13),
(383, '/assets/img/seat/regular.png', 'B5', 1, 1, NULL, 13),
(384, '/assets/img/seat/regular.png', 'B6', 1, 1, NULL, 13),
(385, '/assets/img/seat/regular.png', 'B7', 1, 1, NULL, 13),
(386, '/assets/img/seat/regular.png', 'B8', 1, 1, NULL, 13),
(387, '/assets/img/seat/regular.png', 'B9', 1, 1, NULL, 13),
(388, '/assets/img/seat/regular.png', 'B10', 1, 1, NULL, 13),
(389, '/assets/img/seat/regular.png', 'B11', 1, 1, NULL, 13),
(390, '/assets/img/seat/regular.png', 'B12', 1, 1, NULL, 13),
(391, '/assets/img/seat/regular.png', 'C1', 1, 1, NULL, 13),
(392, '/assets/img/seat/regular.png', 'C2', 1, 1, NULL, 13),
(393, '/assets/img/seat/regular.png', 'C3', 1, 1, NULL, 13),
(394, '/assets/img/seat/regular.png', 'C4', 1, 1, NULL, 13),
(395, '/assets/img/seat/regular.png', 'C5', 1, 1, NULL, 13),
(396, '/assets/img/seat/regular.png', 'C6', 1, 1, NULL, 13),
(397, '/assets/img/seat/regular.png', 'C7', 1, 1, NULL, 13),
(398, '/assets/img/seat/regular.png', 'C8', 1, 1, NULL, 13),
(399, '/assets/img/seat/regular.png', 'C9', 1, 1, NULL, 13),
(400, '/assets/img/seat/regular.png', 'C10', 1, 1, NULL, 13),
(401, '/assets/img/seat/regular.png', 'C11', 1, 1, NULL, 13),
(402, '/assets/img/seat/regular.png', 'C12', 1, 1, NULL, 13),
(403, '/assets/img/seat/regular.png', 'D1', 1, 1, NULL, 13),
(404, '/assets/img/seat/regular.png', 'D2', 1, 1, NULL, 13),
(405, '/assets/img/seat/regular.png', 'D3', 1, 1, NULL, 13),
(406, '/assets/img/seat/regular.png', 'D4', 1, 1, NULL, 13),
(407, '/assets/img/seat/regular.png', 'D5', 1, 1, NULL, 13),
(408, '/assets/img/seat/regular.png', 'D6', 1, 1, NULL, 13),
(409, '/assets/img/seat/regular.png', 'D7', 1, 1, NULL, 13),
(410, '/assets/img/seat/regular.png', 'D8', 1, 1, NULL, 13),
(411, '/assets/img/seat/regular.png', 'D9', 1, 1, NULL, 13),
(412, '/assets/img/seat/regular.png', 'D10', 1, 1, NULL, 13),
(413, '/assets/img/seat/regular.png', 'D11', 1, 1, NULL, 13),
(414, '/assets/img/seat/regular.png', 'D12', 1, 1, NULL, 13),
(415, '/assets/img/seat/VIP.png', 'E1', 1, 2, NULL, 13),
(416, '/assets/img/seat/VIP.png', 'E2', 1, 2, NULL, 13),
(417, '/assets/img/seat/VIP.png', 'E3', 1, 2, NULL, 13),
(418, '/assets/img/seat/VIP.png', 'E4', 1, 2, NULL, 13),
(419, '/assets/img/seat/VIP.png', 'E5', 1, 2, NULL, 13),
(420, '/assets/img/seat/VIP.png', 'E6', 1, 2, NULL, 13),
(421, '/assets/img/seat/VIP.png', 'E7', 1, 2, NULL, 13),
(422, '/assets/img/seat/VIP.png', 'E8', 1, 2, NULL, 13),
(423, '/assets/img/seat/VIP.png', 'E9', 1, 2, NULL, 13),
(424, '/assets/img/seat/VIP.png', 'E10', 1, 2, NULL, 13),
(425, '/assets/img/seat/VIP.png', 'E11', 1, 2, NULL, 13),
(426, '/assets/img/seat/VIP.png', 'E12', 1, 2, NULL, 13),
(427, '/assets/img/seat/VIP.png', 'F1', 1, 2, NULL, 13),
(428, '/assets/img/seat/VIP.png', 'F2', 1, 2, NULL, 13),
(429, '/assets/img/seat/VIP.png', 'F3', 1, 2, NULL, 13),
(430, '/assets/img/seat/VIP.png', 'F4', 1, 2, NULL, 13),
(431, '/assets/img/seat/VIP.png', 'F5', 1, 2, NULL, 13),
(432, '/assets/img/seat/VIP.png', 'F6', 1, 2, NULL, 13),
(433, '/assets/img/seat/VIP.png', 'F7', 1, 2, NULL, 13),
(434, '/assets/img/seat/VIP.png', 'F8', 1, 2, NULL, 13),
(435, '/assets/img/seat/VIP.png', 'F9', 1, 2, NULL, 13),
(436, '/assets/img/seat/VIP.png', 'F10', 1, 2, NULL, 13),
(437, '/assets/img/seat/VIP.png', 'F11', 1, 2, NULL, 13),
(438, '/assets/img/seat/VIP.png', 'F12', 1, 2, NULL, 13),
(439, '/assets/img/seat/VIP.png', 'G1', 1, 2, NULL, 13),
(440, '/assets/img/seat/VIP.png', 'G2', 1, 2, NULL, 13),
(441, '/assets/img/seat/VIP.png', 'G3', 1, 2, NULL, 13),
(442, '/assets/img/seat/VIP.png', 'G4', 1, 2, NULL, 13),
(443, '/assets/img/seat/VIP.png', 'G5', 1, 2, NULL, 13),
(444, '/assets/img/seat/VIP.png', 'G6', 1, 2, NULL, 13),
(445, '/assets/img/seat/VIP.png', 'G7', 1, 2, NULL, 13),
(446, '/assets/img/seat/VIP.png', 'G8', 1, 2, NULL, 13),
(447, '/assets/img/seat/VIP.png', 'G9', 1, 2, NULL, 13),
(448, '/assets/img/seat/VIP.png', 'G10', 1, 2, NULL, 13),
(449, '/assets/img/seat/VIP.png', 'G11', 1, 2, NULL, 13),
(450, '/assets/img/seat/VIP.png', 'G12', 1, 2, NULL, 13),
(451, '/assets/img/seat/VIP.png', 'H1', 1, 2, NULL, 13),
(452, '/assets/img/seat/VIP.png', 'H2', 1, 2, NULL, 13),
(453, '/assets/img/seat/VIP.png', 'H3', 1, 2, NULL, 13),
(454, '/assets/img/seat/VIP.png', 'H4', 1, 2, NULL, 13),
(455, '/assets/img/seat/VIP.png', 'H5', 1, 2, NULL, 13),
(456, '/assets/img/seat/VIP.png', 'H6', 1, 2, NULL, 13),
(457, '/assets/img/seat/VIP.png', 'H7', 1, 2, NULL, 13),
(458, '/assets/img/seat/VIP.png', 'H8', 1, 2, NULL, 13),
(459, '/assets/img/seat/VIP.png', 'H9', 1, 2, NULL, 13),
(460, '/assets/img/seat/VIP.png', 'H10', 1, 2, NULL, 13),
(461, '/assets/img/seat/VIP.png', 'H11', 1, 2, NULL, 13),
(462, '/assets/img/seat/VIP.png', 'H12', 1, 2, NULL, 13),
(463, '/assets/img/seat/couple.png', 'J1J2', 1, 4, NULL, 13),
(464, '/assets/img/seat/couple.png', 'J3J4', 1, 4, NULL, 13),
(465, '/assets/img/seat/couple.png', 'J5J6', 1, 4, NULL, 13),
(466, '/assets/img/seat/couple.png', 'J7J8', 1, 4, NULL, 13),
(467, '/assets/img/seat/couple.png', 'J9J10', 1, 4, NULL, 13),
(468, '/assets/img/seat/couple.png', 'J11J12', 1, 4, NULL, 13);

-- --------------------------------------------------------

--
-- Table structure for table `seat_type`
--

CREATE TABLE `seat_type` (
  `seat_type_id` bigint NOT NULL,
  `price` bigint DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `point_giving` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `seat_type`
--

INSERT INTO `seat_type` (`seat_type_id`, `price`, `type`, `point_giving`) VALUES
(1, 80000, 'regular', 1),
(2, 100000, 'VIP', 2),
(4, 120000, 'couple', 4);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` bigint NOT NULL,
  `email` varchar(50) NOT NULL,
  `fullname` varchar(100) DEFAULT NULL,
  `password` varchar(250) NOT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `provider` varchar(50) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `age` int DEFAULT NULL,
  `birthday` varchar(255) DEFAULT NULL,
  `point` bigint DEFAULT NULL,
  `is_student` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `email`, `fullname`, `password`, `phone_number`, `provider`, `username`, `age`, `birthday`, `point`, `is_student`) VALUES
(1, 'admin@admin.com', 'admin', '$2a$10$0FuPoHGpWoubJP82db/79u1D5Zgdh0G8FVTqzvCj5aWARtoQb6P6q', '0987654321', 'LOCAL', 'admin', NULL, NULL, NULL, NULL),
(2, 'user1@user1.com', 'user', '$2a$10$RK/Ax4n1wZXA3Sw5TbxOyO/U1dOd9mqBvLGOVfVIWa52A46iRscvO', '0987656781', 'LOCAL', 'user123', NULL, NULL, NULL, NULL),
(3, 'user2@user2.com', 'user', '$2a$10$lKXEZtjT8FAjwREAWrGrpOEyJAg8OdfMct8B3n.qgKXK1kIJ3Ulwm', '0987654327', 'LOCAL', 'user1', NULL, NULL, NULL, NULL),
(5, 'user5@user.com', 'PHẠM TRẦN NHẬT MINH', '$2a$10$lyBkhdgVhNWur0Wb/7bBc.str9ILayNdb9u95QztgPe/zHIFXq4DG', '0987654908', 'LOCAL', 'minh', 21, '04/04/2003', 90, NULL),
(6, 'nhatminh4403@gmail.com', NULL, '$2a$10$T0JomzZWbF6rrUz6v8Atie2kYqtv6SvPOz48j4cJpZUdbrLaXdzMC', '0567890123', 'LOCAL', 'asdasdas', NULL, NULL, NULL, NULL),
(8, 'user1234@user.com', 'PHAM TRAN NHAT MINH', '$2a$10$rwEOQhktfXAs0E1l6XY.9OwQ.B.zU2.nape.QJAtOiG9dDefG2rb2', '0123456432', 'LOCAL', 'user1234', 21, '04/04/2003', 1, b'1'),
(9, 'user123456@user123456.com', NULL, '$2a$10$9zPLOT7ZLW1BlieOj2Tx5e2/fDAC91HrPnKjnrbMcqSkf0yZaVqgS', '0678954213', 'LOCAL', 'user123456', NULL, NULL, 1, b'0'),
(10, 'user123456@user.com', 'User1735108240135', '$2a$10$JqPvmY.SO6gbJVdVlClp6eYbRlnvW6k6f2RwrqNtoDu6kxcRm.fyS', '0945678321', 'LOCAL', 'user1234567', NULL, NULL, 0, b'0'),
(11, 'user2@gmail.com', 'User1735116846278', '$2a$10$yH3SaV3Wa1uXWaVhrHF07OypsyZdhP3ojBog4PAlgGmN2ApSyTmnu', '0789654321', 'LOCAL', 'user2', NULL, NULL, 0, b'0'),
(12, 'user3@user34.com', 'User1735116919534', '$2a$10$k4XCAkbDHcNfCFd.uLlxr.L/qYXhk2W6oYbxtsQyqJSJzx5bkpNiO', '0987658767', 'LOCAL', 'user34', NULL, NULL, 0, b'0'),
(13, 'user3@user3.com', 'PHAM TRAN NHAT MINH', '$2a$10$c4NsoOBS6pYaGQ7.JjVXreMkSr/NA2yvmakIUULu.eRMq5zoS0cPG', '0126837654', 'LOCAL', 'user3', 21, '04/04/2003', 0, b'1'),
(14, 'user4@user4.com', 'PHAM TRAN NHAT MINH', '$2a$10$HGN6VkDRNQtbsqTsEh8dBegLHpRMwn4r3ydSpchfpU.JzZbRkgDsy', '0953475687', 'LOCAL', 'user4', 21, '04/04/2003', 0, b'1'),
(15, 'user5@user6.com', 'User1735120104738', '$2a$10$.7CgHNt4XSfnShd5kFiwRO.X.lScyImICAoLSR.8/h2APb8lFpQf2', '0234157896', 'LOCAL', 'user6', NULL, NULL, 0, b'0'),
(16, 'user321@user321.com', 'PHAN LE HAI DANG', '$2a$10$ztM3uYAasPKIero6mI.4u.o8uDz8kSCp6Ww4ilojMcR9GZs5Nk91K', '0987123456', 'LOCAL', 'user321', 21, '12/11/2003', 0, b'1');

-- --------------------------------------------------------

--
-- Table structure for table `user_promotion`
--

CREATE TABLE `user_promotion` (
  `user_id` bigint NOT NULL,
  `promotion_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_promotion`
--

INSERT INTO `user_promotion` (`user_id`, `promotion_id`) VALUES
(13, 1),
(14, 1),
(16, 1),
(8, 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(5, 2),
(6, 2),
(8, 2),
(9, 2),
(10, 2),
(11, 2),
(12, 2),
(13, 2),
(14, 2),
(15, 2),
(16, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blog`
--
ALTER TABLE `blog`
  ADD PRIMARY KEY (`blog_id`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `FKeoasrfgo5quyoufjklwet5uos` (`combo_id`),
  ADD KEY `FKkgseyy7t56x7lkjgu3wah5s3t` (`user_id`);

--
-- Indexes for table `booking_detail`
--
ALTER TABLE `booking_detail`
  ADD PRIMARY KEY (`booking_detail_id`),
  ADD KEY `FK59941ondg9nwaifm2umnrduev` (`booking_id`),
  ADD KEY `FKfp15ke8gq2n7pksqye2w9qd1h` (`schedule_id`),
  ADD KEY `FKmex8swj2vph4x0gtjjy57cp68` (`seat_id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `cinema`
--
ALTER TABLE `cinema`
  ADD PRIMARY KEY (`cinema_id`);

--
-- Indexes for table `combo_food`
--
ALTER TABLE `combo_food`
  ADD PRIMARY KEY (`combo_id`);

--
-- Indexes for table `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `FKkap39f76wn135k7ru564fbjb7` (`blog_id`),
  ADD KEY `FK8kcum44fvpupyw6f5baccx25c` (`user_id`);

--
-- Indexes for table `country`
--
ALTER TABLE `country`
  ADD PRIMARY KEY (`country_id`);

--
-- Indexes for table `feed_back`
--
ALTER TABLE `feed_back`
  ADD PRIMARY KEY (`feedback_id`);

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`film_id`),
  ADD KEY `FKkn6k7l7y3jg7bdu1bv0oskgd5` (`country_id`);

--
-- Indexes for table `film_category`
--
ALTER TABLE `film_category`
  ADD KEY `FKo1ve8mjm8cxf87g7r55w53rcj` (`category_id`),
  ADD KEY `FKr4u0m4y199rhohqiy9gd46l7u` (`film_id`);

--
-- Indexes for table `mo_mo_payment_save`
--
ALTER TABLE `mo_mo_payment_save`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK418yq5lte3yph4sv9iusjajfh` (`booking_booking_id`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`promotion_id`);

--
-- Indexes for table `rating`
--
ALTER TABLE `rating`
  ADD PRIMARY KEY (`rating_id`),
  ADD KEY `FKkytag56hfux9ln7t4lahh85w3` (`film_id`),
  ADD KEY `FKpn05vbx6usw0c65tcyuce4dw5` (`user_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `room`
--
ALTER TABLE `room`
  ADD PRIMARY KEY (`room_id`),
  ADD UNIQUE KEY `UK2tklvare2e5touoeqsdgdsdgm` (`room_name`),
  ADD KEY `FK838jvntrkjvmbpm310wsdad1r` (`cinema_id`);

--
-- Indexes for table `schedule`
--
ALTER TABLE `schedule`
  ADD PRIMARY KEY (`schedule_id`),
  ADD KEY `FKd16eytqjh540g98s2mmh9ffs0` (`film_id`),
  ADD KEY `FKh2hdhbss2x31ns719hka6enma` (`room_id`);

--
-- Indexes for table `seat`
--
ALTER TABLE `seat`
  ADD PRIMARY KEY (`seat_id`),
  ADD KEY `FKd7f42843rt05tt66t6vcb7s9u` (`room_id`),
  ADD KEY `FKd4mx49q62bd2apkk2rfkl8l9w` (`seat_type_id`),
  ADD KEY `FKppyv67e00qxortqrtlmr7gfdo` (`schedule_id`);

--
-- Indexes for table `seat_type`
--
ALTER TABLE `seat_type`
  ADD PRIMARY KEY (`seat_type_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `UKob8kqyqqgmefl0aco34akdtpe` (`email`),
  ADD UNIQUE KEY `UKsb8bbouer5wak8vyiiy4pf2bx` (`username`),
  ADD UNIQUE KEY `UK4bgmpi98dylab6qdvf9xyaxu4` (`phone_number`);

--
-- Indexes for table `user_promotion`
--
ALTER TABLE `user_promotion`
  ADD KEY `FKc4uk0tmorfjmwpdf9y4m88l7d` (`promotion_id`),
  ADD KEY `FKg9d3ca8jtsx3bw6p1lohmt4ll` (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blog`
--
ALTER TABLE `blog`
  MODIFY `blog_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `booking_detail`
--
ALTER TABLE `booking_detail`
  MODIFY `booking_detail_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=176;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `category_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT for table `cinema`
--
ALTER TABLE `cinema`
  MODIFY `cinema_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `combo_food`
--
ALTER TABLE `combo_food`
  MODIFY `combo_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `comment`
--
ALTER TABLE `comment`
  MODIFY `comment_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `country`
--
ALTER TABLE `country`
  MODIFY `country_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `feed_back`
--
ALTER TABLE `feed_back`
  MODIFY `feedback_id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `film_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;

--
-- AUTO_INCREMENT for table `mo_mo_payment_save`
--
ALTER TABLE `mo_mo_payment_save`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `promotion_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `rating`
--
ALTER TABLE `rating`
  MODIFY `rating_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `room`
--
ALTER TABLE `room`
  MODIFY `room_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `schedule`
--
ALTER TABLE `schedule`
  MODIFY `schedule_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=51;

--
-- AUTO_INCREMENT for table `seat`
--
ALTER TABLE `seat`
  MODIFY `seat_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=469;

--
-- AUTO_INCREMENT for table `seat_type`
--
ALTER TABLE `seat_type`
  MODIFY `seat_type_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `FKeoasrfgo5quyoufjklwet5uos` FOREIGN KEY (`combo_id`) REFERENCES `combo_food` (`combo_id`),
  ADD CONSTRAINT `FKkgseyy7t56x7lkjgu3wah5s3t` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `booking_detail`
--
ALTER TABLE `booking_detail`
  ADD CONSTRAINT `FK59941ondg9nwaifm2umnrduev` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`),
  ADD CONSTRAINT `FKfp15ke8gq2n7pksqye2w9qd1h` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`),
  ADD CONSTRAINT `FKmex8swj2vph4x0gtjjy57cp68` FOREIGN KEY (`seat_id`) REFERENCES `seat` (`seat_id`);

--
-- Constraints for table `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `FK8kcum44fvpupyw6f5baccx25c` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKkap39f76wn135k7ru564fbjb7` FOREIGN KEY (`blog_id`) REFERENCES `blog` (`blog_id`);

--
-- Constraints for table `film`
--
ALTER TABLE `film`
  ADD CONSTRAINT `FKkn6k7l7y3jg7bdu1bv0oskgd5` FOREIGN KEY (`country_id`) REFERENCES `country` (`country_id`);

--
-- Constraints for table `film_category`
--
ALTER TABLE `film_category`
  ADD CONSTRAINT `FKo1ve8mjm8cxf87g7r55w53rcj` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`),
  ADD CONSTRAINT `FKr4u0m4y199rhohqiy9gd46l7u` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`);

--
-- Constraints for table `mo_mo_payment_save`
--
ALTER TABLE `mo_mo_payment_save`
  ADD CONSTRAINT `FKnkdkpj44sxolups0m3m1a25r6` FOREIGN KEY (`booking_booking_id`) REFERENCES `booking` (`booking_id`);

--
-- Constraints for table `rating`
--
ALTER TABLE `rating`
  ADD CONSTRAINT `FKkytag56hfux9ln7t4lahh85w3` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`),
  ADD CONSTRAINT `FKpn05vbx6usw0c65tcyuce4dw5` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `room`
--
ALTER TABLE `room`
  ADD CONSTRAINT `FK838jvntrkjvmbpm310wsdad1r` FOREIGN KEY (`cinema_id`) REFERENCES `cinema` (`cinema_id`);

--
-- Constraints for table `schedule`
--
ALTER TABLE `schedule`
  ADD CONSTRAINT `FKd16eytqjh540g98s2mmh9ffs0` FOREIGN KEY (`film_id`) REFERENCES `film` (`film_id`),
  ADD CONSTRAINT `FKh2hdhbss2x31ns719hka6enma` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`);

--
-- Constraints for table `seat`
--
ALTER TABLE `seat`
  ADD CONSTRAINT `FKd4mx49q62bd2apkk2rfkl8l9w` FOREIGN KEY (`seat_type_id`) REFERENCES `seat_type` (`seat_type_id`),
  ADD CONSTRAINT `FKd7f42843rt05tt66t6vcb7s9u` FOREIGN KEY (`room_id`) REFERENCES `room` (`room_id`),
  ADD CONSTRAINT `FKppyv67e00qxortqrtlmr7gfdo` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`schedule_id`);

--
-- Constraints for table `user_promotion`
--
ALTER TABLE `user_promotion`
  ADD CONSTRAINT `FKc4uk0tmorfjmwpdf9y4m88l7d` FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`promotion_id`),
  ADD CONSTRAINT `FKg9d3ca8jtsx3bw6p1lohmt4ll` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
