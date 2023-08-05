create database QuanLySinhVien;
USE QuanLySinhVien;

CREATE TABLE Class
(
    ClassID   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    ClassName VARCHAR(60) NOT NULL,
    StartDate DATETIME    NOT NULL,
    Status    BIT
);
CREATE TABLE Student
(
    StudentId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    StudentName VARCHAR(30) NOT NULL,
    Address     VARCHAR(50),
    Phone       VARCHAR(20),
    Status      BIT,
    ClassId     INT         NOT NULL,
    FOREIGN KEY (ClassId) REFERENCES Class (ClassID)
);
CREATE TABLE Subject
(
    SubId   INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubName VARCHAR(30) NOT NULL,
    Credit  TINYINT     NOT NULL DEFAULT 1 CHECK ( Credit >= 1 ),
    Status  BIT                  DEFAULT 1
);
CREATE TABLE Mark
(
    MarkId    INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    SubId     INT NOT NULL,
    StudentId INT NOT NULL,
    Mark      FLOAT   DEFAULT 0 CHECK ( Mark BETWEEN 0 AND 100),
    ExamTimes TINYINT DEFAULT 1,
    UNIQUE (SubId, StudentId),
    FOREIGN KEY (SubId) REFERENCES Subject (SubId),
    FOREIGN KEY (StudentId) REFERENCES Student (StudentId)
);

INSERT INTO Class
VALUES (1, 'A1', '2008-12-20', 1),
 (2, 'A2', '2008-12-22', 1),
 (3, 'B3', current_date, 0);
 
 INSERT INTO Student (StudentName, Address, Phone, Status, ClassId)
VALUES ("thanh","tien my","0852146552",1,1),
("thanh","tien my","0852146552",1,2),
("thanh","tien my","0852146552",1,3);
		

INSERT INTO Subject
VALUES (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

INSERT INTO Mark (SubId, StudentId, Mark, ExamTimes)
VALUES (1, 1, 8, 1),
       (1, 2, 10, 2),
       (2, 1, 12, 1);
drop database QuanLySinhVien;
-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
SELECT * FROM student WHERE StudentName LIKE 't%';
-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT * FROM class WHERE month(startDate) = 12;
-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
select * from subject where Credit between 3 and 5;
-- Thay đổi mã lớp(ClassID) của sinh viên có tên ‘Hung’ là 2.
update student
set ClassId=2
where StudentName = 'thanh';
select * from student;


-- Hiển thị các thông tin: StudentName, SubName, Mark. Dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.

select s.StudentName, su.SubName, m.Mark
from mark as m join student as s on m.StudentId=s.StudentId join `subject` as su on su.SubID=m.SubID 
order by  Mark desc,StudentName asc;

update mark
set mark=12
where StudentId=1;
select * from mark;
-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject 
where Credit =(select max(Credit) from subject);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select * from mark 
where mark =(select max(mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select st.StudentID,StudentName,Address,Phone,st.`Status`,st.ClassID,ClassName,StartDate,MarkID,m.SubID,ExamTimes,SubName,Credit,avg(Mark) as dtb
from student st join class c on st.ClassID=c.ClassID join mark m on st.StudentId=m.StudentId join `subject` s on m.SubId=s.SubId
group by StudentId
order by dtb desc; 

