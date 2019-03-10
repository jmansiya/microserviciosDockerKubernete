package com.jose.mansilla.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jose.mansilla.modelo.Empresa;
import com.jose.mansilla.servicio.IEmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	
	@Autowired
	private IEmpresaService empresaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Empresa insertarEmpresa(@RequestBody Empresa empresa){
		for (int i = 0; i < 100; i++) {
			
		}
		return empresaService.insertar(empresa);		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Empresa> getEmpresas(){
		for (int i = 0; i < 50; i++) {
			
		}
		return empresaService.getEmpresas();
	}
	
	@RequestMapping(value = "/{nameEmpresa}", method = RequestMethod.GET)
	public Empresa getEmpresa(@PathVariable String nameEmpresa){
		return empresaService.getEmpresa(nameEmpresa);
	}
	
}
