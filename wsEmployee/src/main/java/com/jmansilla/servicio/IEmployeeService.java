package com.jmansilla.servicio;

import java.util.List;

import com.jmansilla.modelo.Employee;
import com.jmansilla.modelo.EmployeeCompleto;

public interface IEmployeeService {
	public Employee insertarEmpleado(Employee newEmployee);
	
	public long getTotalEmpleados();
	
	public void eliminarEmpleado(Employee empleado);
	
	public void eliminarTodosEmpleados();
	
	public Employee getEmpleado(String name, int edad);
	
	public Employee getEmpleadoById(String id);

	public List<Employee> getEmpleados();
	
	public EmployeeCompleto getEmpleadoCompletoById(String id);

}

