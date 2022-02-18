# management-student
Backend Spring boot quản lý sinh viên

1. Mô tả ER(entity relationship) 

![image](https://user-images.githubusercontent.com/85503042/154639912-18842b3e-beca-469f-962b-ad17a7807246.png)

- có 3 đối tượng chính; sinh viên, khóa học, lớp học
- mối quan hệ giữa các đối tượng: 
    + sinh viên - lớp học: many to many
    + sinh viên - khóa học: many to many
    + khóa học - lớp học: many to one

2. Features

- CRUD sinh viên
- CRUD môn học
- CRUD lớp học
- sinh viên đăng ký môn học có 2 trường hợp
    + được xếp vào lớp đang diễn ra môn học đó và dưới 30 sinh viên (nếu có)
    + được xếp vào lớp mới chưa có môn học và chưa có sinh viên
 - sinh viên hủy đăng ký môn sẽ được hủy xếp lớp, và xếp môn
 - danh sách sinh viên theo lớp
 - sanh sách môn học theo sinh viên

