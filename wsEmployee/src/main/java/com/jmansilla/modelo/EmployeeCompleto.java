package com.jmansilla.modelo;

/**
 * 
 * @author josemansilla
 *
 * Clase que encapsula la información de un empleado.
 */

public class EmployeeCompleto{
	private String fullName;
	private Empresa empresa;
	
	public EmployeeCompleto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
		
}

