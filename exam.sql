CREATE DATABASE exam1;
USE exam1;

create table BenhAn (
maBenhAn varchar(5) primary key not null,
tenBenhAn varchar(50)
);

create table BenhNhan(
maBenhAn varchar(5),
maBenhNhan varchar(5) primary key not null,
tenBenhNhan varchar(50),
ngayNhapVien date,
ngayRaVien date,
lyDo varchar(100),
CONSTRAINT fk_htk_maBenhAn FOREIGN KEY (maBenhAn) REFERENCES BenhAn (maBenhAn)
);
insert into BenhAn(maBenhAn,tenBenhAn)
values("BA001","Ung Thu Gan"),
("BA002","Ung Thu Da Day"),
("BA003","Ung Thu Ruot"),
("BA004","Mau Kho Dong"),
("BA005","So Gan"),
("BA006","Xuong Khop"),
("BA007","Tri");

insert into BenhNhan
values("BA004","BN019","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN018","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN012","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN013","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN014","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN015","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN016","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day"),
("BA007","BN017","Le Xuan Loc","2022-05-12","2022-06-18","Dau da day");
drop database exam

 
 
