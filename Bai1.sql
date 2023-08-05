create database Furama;

use Furama;

create table vi_tri(
ma_vi_tri int not null primary key auto_increment,
ten_vi_tri varchar(45)
);
create table trinh_do(
ma_trinh_do int not null primary key auto_increment,
ten_trinh_do varchar(45)
);

create table bo_phan(
ma_bo_phan int not null primary key auto_increment,
ten_bo_phan varchar(45)
);
create table dich_vu_di_kem(
ma_dich_vu_di_kem int not null primary key auto_increment,
ten_dich_vu_di_kem varchar(45),
gia double,
don_vi varchar(10),
trang_thai varchar(45)
);

create table loai_khach(
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(45)
);

create table loai_dich_vu(
ma_loai_dich_vu int not null primary key auto_increment,
ten_loai_dich_vu varchar(45)
);
create table kieu_thue(
ma_kieu_thue int primary key auto_increment,
ten_kieu_thue varchar(45)
);

create table dich_vu(
ma_dich_vu int not null primary key auto_increment,
ten_dich_vu varchar(45),
dien_tich int,
chi_phi_thue double,
so_nguoi_toi_da int,
tieu_chuan_phong varchar(45),
mo_ta_tien_nghi_khac varchar(45),
dien_tich_ho_boi double,
so_tang int,
ma_kieu_thue int not null,
ma_loai_dich_vu int not null,
 FOREIGN KEY (ma_kieu_thue) REFERENCES kieu_thue (ma_kieu_thue),
 FOREIGN KEY (ma_loai_dich_vu) REFERENCES loai_dich_vu (ma_loai_dich_vu)
);

create table khach_hang(
ma_khach_hang int not null primary key auto_increment,
ma_loai_khach int not null,
ho_ten varchar(45),
ngay_sinh date,
gioi_tinh bit(1),
so_cmnd varchar(45),
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
 FOREIGN KEY (ma_loai_khach) REFERENCES loai_khach (ma_loai_khach)
);

create table nhan_vien(
ma_nhan_vien int not null auto_increment primary key,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
luong double,
so_dien_thoai varchar(45),
email varchar(45),
dia_chi varchar(45),
ma_vi_tri int not null,
ma_trinh_do int not null,
ma_bo_phan int not null,
 FOREIGN KEY (ma_vi_tri) REFERENCES vi_tri (ma_vi_tri),
 FOREIGN KEY (ma_trinh_do) REFERENCES trinh_do (ma_trinh_do),
 FOREIGN KEY (ma_bo_phan) REFERENCES bo_phan (ma_bo_phan)
);

create table hop_dong(
ma_hop_dong int not null primary key auto_increment,
ngay_lam_hop_dong datetime,
ngay_ket_thuc datetime,
tien_dat_coc double,
ma_nhan_vien int not null,
ma_khach_hang int not null,
ma_dich_vu int not null,
FOREIGN KEY (ma_nhan_vien) REFERENCES nhan_vien (ma_nhan_vien),
FOREIGN KEY (ma_khach_hang) REFERENCES khach_hang (ma_khach_hang),
FOREIGN KEY (ma_dich_vu) REFERENCES dich_vu (ma_dich_vu)
);

create table hop_dong_chi_tiet(
ma_hop_dong_chi_tiet int not null primary key auto_increment,
ma_hop_dong int not null,
ma_dich_vu_di_kem int not null,
so_luong int,
FOREIGN KEY (ma_hop_dong) REFERENCES hop_dong (ma_hop_dong),
FOREIGN KEY (ma_dich_vu_di_kem) REFERENCES dich_vu_di_kem (ma_dich_vu_di_kem)
);
-- 1. Thêm mới thông tin cho tất cả các bảng có trong CSDL để có thể thoả mãn các yêu cầu bên dưới.

-- Vị Trí --
INSERT INTO vi_tri(ma_vi_tri, ten_vi_tri)
VALUES 	(1, 'Giám đốc'), 
		(2, 'Quản Lý'),
		(3, 'Giám Sát'),
		(4, 'Chuyên Viên'),
		(5, 'Phục Vụ'),
		(6, 'Lễ Tân');
        
-- Trình Độ --
INSERT INTO trinh_do(ma_trinh_do, ten_trinh_do)
VALUES 	(1,'Trung Cấp'),
		(2,'Cao Đẳng'),
        (3,'Đại Học'),
        (4,'Sau Đại Học');
        
-- Bộ Phận --        
INSERT INTO bo_phan(ma_bo_phan, ten_bo_phan)
VALUES 	(1,'Sale-Marketing'),
		(2,'Hành Chính'),
		(3,'Phục Vụ'),
		(4,'Quản Lý');
        
-- Nhân Viên --        
INSERT INTO nhan_vien(ma_nhan_vien,ho_ten,ngay_sinh,so_cmnd,luong,so_dien_thoai,email,dia_chi,ma_vi_tri,ma_trinh_do,ma_bo_phan)
VALUES  (1, 'Nguyễn Ngọc Trung Bảo', '2003-6-25', '206493602', 1000, '0389056171', 'baokx2k3@gmail.com', 'Thăng Bình', 1, 4, 4 ),
		(2, 'Nguyễn Ngọc Huy Bảo', '2003-6-25', '206493603', 800, '0329002453', 'hbkx22kx3@gmail.com', 'Thăng Bình', 3, 2, 1 ),
        (3, 'Huỳnh Văn Nam', '2003-3-10', '206493154', 1000, '0321724124', 'namhuynh@gmail.com', 'Thăng Bình', 2, 1, 4 ),
        (4, 'Phạm Nguyễn Trường Tín', '2003-5-12', '206412171', 900, '0312388242', 'tinpham@gmail.com', 'Núi Thành', 4, 1, 2 ),
		(5, 'Võ Nguyễn Phát', '2003-6-19', '206492131', 1100, '0312324912', 'phatvo@gmail.com', 'Nông Sơn', 1, 3, 4 ),
		(6, 'Dương Tấn Tài', '2003-2-12', '206437123', 500, '0342417234', 'taiduong@gmail.com', 'Duy Xuyên', 6, 1, 1 ),
		(7, 'Trần Công Nhật', '2003-11-8', '206812337', 650, '0981234412', 'nhattran@gmail.com', 'Phú Ninh', 5, 2, 3 ),
		(8, 'Nguyễn Đức Việt', '2003-4-12', '206781231', 480, '0931231284', 'vietnguyen@gmail.com', 'Thăng Bình', 6, 1, 4 ),
		(9, 'Ngô Ngọc Huy', '2003-9-11', '206152351', 700, '09137127312', 'huyngo@gmail.com', 'Núi Thành', 3, 1, 4 ),
		(10, 'Kiều Nhật Tân', '2003-10-12', '206812312', 800, '0313192412', 'tankieu@gmail.com', 'Thăng Bình', 4, 2, 4 ),
		(11, 'Phạm Thị Thuý Hằng', '2003-5-24', '206123144', 800, '0283183211', 'hangpham@gmail.com', 'Thăng Bình', 5, 2, 3);
        
-- Loại Khách --
INSERT INTO loai_khach(ma_loai_khach,ten_loai_khach)
VALUES  (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
        
-- Khách Hàng --        
INSERT INTO khach_hang(ma_khach_hang,ho_ten,ngay_sinh,gioi_tinh,so_cmnd,so_dien_thoai,email,dia_chi,ma_loai_khach)
VALUES 	 (1,'Nguyễn Thị Hào','1970-11-07',0,'643431213','0945423362','thihao07@gmail.com','23 Nguyễn Hoàng, Đà Nẵng',5),
         (2,'Trần Cao Vân','1990-4-12',1,'488641231','031238123','vancao2702@gmail.com','K67/47 Hà Huy Tập, Đà Nẵng',2),
         (3,'Trương Đình Nghệ','1990-02-27',1,'488645199','0373213122','nghenhan2702@gmail.com','K323/12 Ông Ích Khiêm, Vinh',1),
		 (4,'Nguyễn Văn Chí','1990-5-11',1,'4886712393','09123712321','chinguyen123@gmail.com','Nguyễn Văn Cừ, Hà Nội',1),
         (5,'Hoàng Trần Nhi Nhi','1995-12-09',0,'795453345','0312345678','nhinhi123@gmail.com','224 Lý Thái Tổ, Gia Lai',4),
         (6,'Tôn Nữ Mộc Châu','2005-12-06',0,'732434215','0988888844','tonnuchau@gmail.com','37 Yên Thế, Đà Nẵng',4),
         (7,'Nguyễn Mỹ Kim','1984-04-08',0,'856453123','0912345698','kimcuong84@gmail.com','K123/45 Lê Lợi, Hồ Chí Minh',1),
         (8,'Nguyễn Thị Hào','1999-04-08',0,'965656433','0763212345','haohao99@gmail.com','55 Nguyễn Văn Linh, Kon Tum',3),
         (9,'Trần Đại Danh','1994-07-01',1,'432341235','0643343433','danhhai99@gmail.com','24 Lý Thường Kiệt, Quảng Ngãi',1);
-- Hợp Đồng --          
INSERT INTO hop_dong(ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,ma_nhan_vien,ma_khach_hang,ma_dich_vu)
VALUES  (1,'2020-12-08','2020-12-08',0,3,1,3),
		(2,'2020-07-14','2020-07-21',200000,7,3,1),
		(3,'2021-03-15','2021-03-17',50000,3,4,2),
		(4,'2021-01-14','2021-01-18',100000,7,5,5),
		(5,'2021-07-14','2021-07-15',0,7,2,6),
		(6,'2021-06-01','2021-06-03',0,7,7,6),
		(7,'2021-09-02','2021-09-05',100000,7,4,4),
		(8,'2021-06-17','2021-06-18',150000,3,4,1),
		(9,'2020-11-19','2020-11-19',0,3,4,3),
		(10,'2021-04-12','2021-04-14',0,10,3,5),
		(11,'2021-04-25','2021-04-25',0,2,2,1),
		(12,'2021-05-25','2021-05-27',0,7,8,1);

-- Hợp Đồng Chi Tiết --        
INSERT INTO hop_dong_chi_tiet(ma_hop_dong_chi_tiet,so_luong,ma_hop_dong,ma_dich_vu_di_kem)
VALUES  (1,5,2,4),
		(2,8,2,5),
		(3,15,2,6),
		(4,1,3,1),
		(5,11,3,2),
		(6,1,1,3),
		(7,2,1,2),
		(8,2,12,2);

-- Dịch Vụ Đi Kèm --        
INSERT INTO dich_vu_di_kem(ma_dich_vu_di_kem,ten_dich_vu_di_kem,gia,don_vi,trang_thai)
VALUES  (1,'Karaoke',10000,'giờ','tiện nghi, hiện tại'),
		(2,'Thuê xe máy',10000,'chiếc','hỏng 1 xe'),
		(3,'Thuê xe đạp',20000,'chiếc','tốt'),
		(4,'Buffet buổi sáng',15000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(5,'Buffet buổi trưa',90000,'suất','đầy đủ đồ ăn, tráng miệng'),
		(6,'Buffet buổi tối',16000,'suất','đầy đủ đồ ăn, tráng miệng');


-- Loại Dịch Vụ --        
INSERT INTO loai_dich_vu(ma_loai_dich_vu, ten_loai_dich_vu)
VALUES  (1,'Villa'),
		(2,'House'),
		(3,'Room');

-- Kiểu Thuê --        
INSERT INTO kieu_thue(ma_kieu_thue,ten_kieu_thue)
VALUES (1,'year'),
	   (2,'month'),
	   (3,'day'),
	   (4,'hour');

-- Dịch Vụ --       
INSERT INTO dich_vu(ma_dich_vu,ten_dich_vu,dien_tich,chi_phi_thue,so_nguoi_toi_da,tieu_chuan_phong,mo_ta_tien_nghi_khac,dien_tich_ho_boi,so_tang,ma_kieu_thue,ma_loai_dich_vu)
VALUES  (1,'Villa Beach Front',25000,10000000,10,'vip','Có hồ bơi',500,4,3,1),
		(2,'House Princess 01',14000,5000000,7,'vip','Có thêm bếp nướng',NULL,3,2,2),
		(3,'Room Twin 01',5000,1000000,2,'normal','Có tivi',NULL,NULL,4,3),
		(4,'Villa No Beach Front',22000,9000000,8,'normal','Có hồ bơi',300,3,3,1),
		(5,'House Princess 02',10000,4000000,5,'normal','Có thêm bếp nướng',NULL,2,3,2),
		(6,'Room Twin 02',3000,900000,2,'normal','Có tivi',NULL,NULL,4,3);
-- Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where  ho_ten LIKE 'H%' OR ho_ten LIKE 'T%' OR ho_ten LIKE 'K%'
limit 15;
-- Hien thi thong tin cua khach hang co do tuoi tu 18 - 50 va co dia chi o da nang hoac quang ngai
select * from khach_hang
where(timestampdiff(year,ngay_sinh,curdate()) between 18 and 50) and (dia_chi LIKE '% Đà Nẵng' OR dia_chi LIKE '% Quảng Ngãi');
-- 4. Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.(dùng bảng khách hàng , hợp đồng)
select kh.ma_khach_hang,ho_ten,count(hd.ma_hop_dong) as solandatphong
from khach_hang as kh inner join hop_dong as hd
on kh.ma_khach_hang = hd.ma_khach_hang
where ma_loai_khach= 1
group by ma_khach_hang
order by solandatphong  asc;
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, 
-- ngay_lam_hop_dong, ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau: 
-- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet) 
-- cho tất cả các khách hàng đã từng đặt phòng. 
-- (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, kh.ho_ten, lk.ten_loai_khach, hd.ma_hop_dong, dv.ten_dich_vu, hd.ngay_lam_hop_dong, hd.ngay_ket_thuc,(dv.chi_phi_thue+dvdk.gia*hdct.so_luong) as 'tong_tien'
from khach_hang kh left join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
				   left join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
                   left join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
                   left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
                   left join dich_vu_di_kem dvdk on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
                   group by ma_hop_dong;
                   
-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
SELECT dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu 
FROM dich_vu dv JOIN loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
				JOIN hop_dong hd on hd.ma_dich_vu = dv.ma_dich_vu
WHERE MONTH(hd.ngay_lam_hop_dong) BETWEEN 4 AND 12
GROUP BY dv.ma_dich_vu;
-- 			
	

