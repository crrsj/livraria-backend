package com.Livrariabackend.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.Livrariabackend.Service.DbService;

import jakarta.annotation.PostConstruct;

@Configuration
@Profile("test")
public class TesteConfig {

	@Autowired
	private DbService db;
	
	@PostConstruct
	public void instanciaBaseDeDados() {
		this.db.instanciaBaseDeDados();
	}
}
