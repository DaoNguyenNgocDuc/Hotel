package com.java.hotelmanagement.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
	private Long id_cv;
	private String ngay_sinh;
	private String gioi_tinh;
	private String ten_nv;
	private String mat_khau;
	private String email;
}
