package com.jose.mansilla.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import com.jose.mansilla.modelo.Empresa;

public interface IEmpresaRepository extends MongoRepository<Empresa, String>, QueryDslPredicateExecutor<Empresa>{
	public Empresa findByName(String name);
}
