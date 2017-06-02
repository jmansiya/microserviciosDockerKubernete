package com.jose.mansilla.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jose.mansilla.modelo.Empresa;
import com.jose.mansilla.modelo.QEmpresa;
import com.jose.mansilla.repository.IEmpresaRepository;
import com.jose.mansilla.servicio.IEmpresaService;
import com.querydsl.core.types.Predicate;

@Service
public class EmpresaService implements IEmpresaService {

	@Autowired
	private IEmpresaRepository repositorio;
	
	@Override
	public Empresa getEmpresa(String name) {
		// TODO Auto-generated method stub
		QEmpresa qEmpresa = QEmpresa.empresa;
		System.out.println("NAME : " + name);
		Predicate predicado = qEmpresa.name.equalsIgnoreCase(name);
		
		return repositorio.findOne(predicado);
	}

	@Override
	public List<Empresa> getEmpresas() {
		// TODO Auto-generated method stub
		return repositorio.findAll();
	}

	@Override
	public Empresa insertar(Empresa empresa) {
		// TODO Auto-generated method stub
		return repositorio.insert(empresa);
	}

}


