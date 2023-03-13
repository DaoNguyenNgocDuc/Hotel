package com.java.hotelmanagement.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.hotelmanagement.config.JwtService;
import com.java.hotelmanagement.model.NhanVien;
import com.java.hotelmanagement.repo.NhanVienRepo;
import com.java.hotelmanagement.service.NhanVienService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
	
	private final NhanVienService nhanVienService;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;
	
	public AuthenticationResponse register(RegisterRequest request) {
		var user = NhanVien.builder()
				.ten_nv(request.getTen_nv())
				.email(request.getEmail())
				.mat_khau(passwordEncoder.encode(request.getMat_khau()))
				.ngay_sinh(request.getNgay_sinh())
				.gioi_tinh(request.getGioi_tinh())
				.id_cv(request.getId_cv())
				.build();
		nhanVienService.addNhanVien(user);
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) {
		authenticationManager.authenticate(
		new UsernamePasswordAuthenticationToken(
				request.getEmail(), 
				request.getMat_khau())
		);
		var user = nhanVienService.findNhanVienByEmail(request.getEmail());
		var jwtToken = jwtService.generateToken(user);
		return AuthenticationResponse.builder()
				.token(jwtToken)
				.build();
	}
}
