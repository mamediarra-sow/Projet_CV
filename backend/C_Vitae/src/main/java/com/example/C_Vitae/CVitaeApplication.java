package com.example.C_Vitae;
import java.awt.Desktop;
import java.net.URI;

import com.example.C_Vitae.Model.Certification;
import com.example.C_Vitae.Model.Formation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@SpringBootApplication
@RestController
public class CVitaeApplication {

	public static void main(String[] args) { SpringApplication.run(CVitaeApplication.class, args); }
	Certification cert = new Certification(1,"2019-2020","www.yotube.com");
	@GetMapping
	public String Cert(){
		return cert.toString();

	}



}
