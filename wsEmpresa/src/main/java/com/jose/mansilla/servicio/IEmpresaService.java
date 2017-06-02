package com.jose.mansilla.servicio;

import java.util.List;

import com.jose.mansilla.modelo.Empresa;

public interface IEmpresaService {
	public Empresa insertar(Empresa empresa);
	
	public Empresa getEmpresa(String name);
	
	public List<Empresa> getEmpresas();
	
}
