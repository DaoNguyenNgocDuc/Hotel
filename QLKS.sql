CREATE Database hotel;
use hotel;
Create table loai_phong
(
	id Integer  NOT NULL AUTO_INCREMENT,
	ten_lp varchar(50) NULL,
	mo_ta varchar(255) NULL,
Primary Key (id)
);


Create table phong
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_lp Integer NOT NULL,
	so_nguoi Integer NULL,
	don_gia Integer NULL,
	tinh_trang Bit NULL,
Primary Key (id)
);
Alter table phong add  foreign key(id_lp) references loai_phong (id)  on update no action on delete no action ;
 
Create table khach_hang
(
	id Integer NOT NULL AUTO_INCREMENT,
	ho_ten Nvarchar(50) NULL,
	cccd Char(12) NULL,
	quoc_tich Nvarchar(50) NULL,
	sdt Char(10) NULL,
	gioi_tinh Bit NULL,
	ngay_sinh Datetime NULL,
	email Nvarchar(50) NULL,
Primary Key (id)
) ;

Create table chuc_vu
(
	id Integer NOT NULL AUTO_INCREMENT,
	ten_cv Nvarchar(80) NULL,
Primary Key (id)
) ;

Create table nhan_vien
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_cv Integer NOT NULL,
	ten_nv Nvarchar(50) NULL,
	ngay_sinh Datetime NULL,
	gioi_tinh Bit NULL,
	tai_khoan Nvarchar(30) NULL,
	mat_khau Nvarchar(20) NULL,
	email Nvarchar(50) NULL,
Primary Key (id)
);
Alter table nhan_vien add  foreign key(id_cv) references chuc_vu (id)  on update no action on delete no action;

Create table phieu_dat_phong
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_kh Integer NOT NULL,
	id_nv Integer NOT NULL,
	ngay_dat Datetime NULL,
	ngay_tra_dk Datetime NULL,
	tien_coc Integer NULL,
Primary Key (id)
);

Alter table phieu_dat_phong add  foreign key(id_nv) references nhan_vien (id)  on update no action on delete no action ;
Alter table phieu_dat_phong add  foreign key(id_kh) references khach_hang (id)  on update no action on delete no action ;

Create table ct_pdp
(
	id_pdp Integer NOT NULL,
	id_p Integer NOT NULL,
Primary Key (id_pdp,id_p)
);
Alter table ct_pdp add  foreign key(id_p) references phong (id)  on update no action on delete no action;
Alter table ct_pdp add  foreign key(id_pdp) references phieu_dat_phong (id)  on update no action on delete no action ;

Create table loai_thanh_toan
(
	id Integer NOT NULL AUTO_INCREMENT,
	ten_ltt Nvarchar(50) NULL,
Primary Key (id)
) ;

Create table hoa_don
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_nv Integer NOT NULL,
	id_ltt Integer NOT NULL,
	ngay_lap Datetime NULL,
	tong_tien Integer NULL,
Primary Key (id)
) ;
Alter table hoa_don add  foreign key(id_ltt) references loai_thanh_toan (id)  on update no action on delete no action ;
Alter table hoa_don add  foreign key(id_nv) references nhan_vien (id)  on update no action on delete no action ;

Create table ct_hd
(
	id_hd Integer NOT NULL,
	id_pdp Integer NOT NULL,
	id_p Integer NOT NULL,
	tien_thue Integer NULL,
	tien_dv Integer NULL,
Primary Key (id_hd,id_pdp,id_p)
) ;
Alter table ct_hd add  foreign key(id_pdp,id_p) references ct_pdp (id_pdp,id_p)  on update no action on delete no action ;
Alter table ct_hd add  foreign key(id_hd) references hoa_don (id)  on update no action on delete no action ;


Create table dich_vu
(
	id Integer NOT NULL AUTO_INCREMENT,
	ten_dv Nvarchar(50) NULL,
	don_vi Nvarchar(50) NULL,
	don_gia Integer NULL,
Primary Key (id)
) ;

Create table phieu_su_dung
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_dv Integer NOT NULL,
	id_p Integer NOT NULL,
	id_pdp Integer NOT NULL,
	id_nv Integer NULL,
	ngay_sd Datetime NULL,
	sl Integer NULL,
Primary Key (id)
) ;

Alter table phieu_su_dung add  foreign key(id_dv) references dich_vu (id)  on update no action on delete no action ;
Alter table phieu_su_dung add  foreign key(id_pdp,id_p) references ct_pdp (id_pdp,id_p)  on update no action on delete no action;
Alter table phieu_su_dung add  foreign key(id_nv) references nhan_vien (id)  on update no action on delete no action ;

Create table phieu_kt
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_pdp Integer NOT NULL,
	id_nv Integer NULL,
	ngay_lap Datetime NULL,
	tinh_trang Nvarchar(50) NULL,
Primary Key (id,id_pdp)
) ;

Alter table phieu_kt add  foreign key(id_pdp) references phieu_dat_phong (id)  on update no action on delete no action ;
Alter table phieu_kt add  foreign key(id_nv) references nhan_vien (id)  on update no action on delete no action;

Create table phieu_den_bu
(
	id Integer NOT NULL AUTO_INCREMENT,
	id_pkt Integer NULL,
	id_nv Integer NULL,
	id_pdp Integer NULL,
	ngay_lap Datetime NULL,
	tien_phat Integer NULL,
Primary Key (id)
) ;

Alter table phieu_den_bu add  foreign key(id_pkt,id_pdp) references phieu_kt (id,id_pdp)  on update no action on delete no action ;
Alter table phieu_den_bu add  foreign key(id_nv) references nhan_vien (id)  on update no action on delete no action ;