package com.jmansilla.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * @author josemansilla
 *
 * Clase que encapsula la información de un empleado.
 */

@Document(collection = "employee")
public class Employee{
	@Id
	private String id;
	private String name;
	private int edad;
	private String email;
	private String fullName;
	private String managerEmail;
	private String empresa;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, int edad){
		this.name = name;
		this.edad = edad;
	}
	
	public Employee(String name, int edad, String email, String fullName, String managerEmail) {
		super();
		this.name = name;
		this.edad = edad;
		this.email = email;
		this.fullName = fullName;
		this.managerEmail = managerEmail;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	@Override
	public String toString(){
		String mensaje = "";
		mensaje = "ID: " + getId() + "\n" + 
				"Nombre: " + getName() + "n" + 
				"Edad: " + getEdad();
		
		return mensaje;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getManagerEmail() {
		return managerEmail;
	}

	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	
}

