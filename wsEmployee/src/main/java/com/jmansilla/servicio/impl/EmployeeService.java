package com.jmansilla.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jmansilla.modelo.Employee;
import com.jmansilla.modelo.EmployeeCompleto;
import com.jmansilla.modelo.Empresa;
import com.jmansilla.modelo.QEmployee;
import com.jmansilla.repositorio.EmployeeRepository;
import com.jmansilla.servicio.IEmployeeService;
import com.querydsl.core.types.Predicate;


@Service
public class EmployeeService implements IEmployeeService{

	@Autowired
	public EmployeeRepository repositorioEmployee;
	
	@Autowired
	@LoadBalanced
	private RestTemplate restTemplate;
	
	public String serviceUrl = "http://EMPRESA";
	
	public Employee insertarEmpleado(Employee newEmployee){
		newEmployee = repositorioEmployee.insert(newEmployee);
		
		return newEmployee;
	}
	
	public long getTotalEmpleados(){
		long total = repositorioEmployee.count();
		
		return total;
	}
	
	public void eliminarEmpleado(Employee empleado){
		repositorioEmployee.delete(empleado);
	}
	
	public void eliminarTodosEmpleados(){
		repositorioEmployee.deleteAll();
	}
	
	public Employee getEmpleado(String name, int edad){
		QEmployee empleado = QEmployee.employee;
		
		Predicate predicado = empleado.name.eq(name)
				.and(empleado.edad.eq(edad));
		
		return repositorioEmployee.findOne(predicado);
	}

	@Override
	public Employee getEmpleadoById(String id) {
		// TODO Auto-generated method stub
		return repositorioEmployee.findOne(id);
	}

	@Override
	public List<Employee> getEmpleados() {
		// TODO Auto-generated method stub
		return repositorioEmployee.findAll();
	}

	@Override
	public EmployeeCompleto getEmpleadoCompletoById(String id) {
		// TODO Auto-generated method stub
		Employee employee = repositorioEmployee.findOne(id);
		Empresa empresa =  restTemplate.getForObject(serviceUrl + "/empresa/{name}", Empresa.class, employee.getEmpresa());
		EmployeeCompleto employCompleto = new EmployeeCompleto();
		employCompleto.setEmpresa(empresa);
		employCompleto.setFullName(employee.getFullName());
		
		return employCompleto;
	}
	
}

