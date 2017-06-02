package com.jmansilla.servicio.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jmansilla.modelo.Employee;
import com.jmansilla.servicio.IEmployeeService;

/**
 * Clase en la que tendremos los test unitarios de la capa de servicios para el microservicio de Employee.
 * @author josemansilla
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {
	
	@Autowired
	private IEmployeeService employeeService;
	
    @Before
    public void setUp() throws Exception {
        Employee empl1= new Employee("Alice", 23);
        Employee empl2= new Employee("Bob", 38);
        
        assertNull(empl1.getId());
        assertNull(empl2.getId());//null before save
        
        empl1 = this.employeeService.insertarEmpleado(empl1);
        empl2 = this.employeeService.insertarEmpleado(empl2);
        
        assertNotNull(empl1.getId());
        assertNotNull(empl2.getId());
    }

    @Test
    public void testGetTotalDatos(){
        /*Test get total datos en la collección */
    	long total = this.employeeService.getTotalEmpleados();
    	
    	//Insertamos un nuevo empleado.
    	Employee empl = new Employee("Jose", 35);
    	this.employeeService.insertarEmpleado(empl);
    	
        assertNotEquals(total, this.employeeService.getTotalEmpleados());
        assertEquals(total + 1, this.employeeService.getTotalEmpleados());
    }
    
    @Test
    public void testEliminarEmpleado(){
    	//Eliminamos el empleado dado. para ello primero lo tendremos que obtener.
    	Employee empl = this.employeeService.getEmpleado("Alice", 23);
    	
    	assertNotNull(empl);
    	
    	this.employeeService.eliminarEmpleado(empl);
    	
    	empl = this.employeeService.getEmpleado("Alice", 23);
    	
    	assertNull(empl);
    }
    
    @Test
    public void testEliminarTodosEmpleado(){
    	//Eliminamos el empleado dado. para ello primero lo tendremos que obtener.
    	long totalEmpleados = this.employeeService.getTotalEmpleados();
    	
    	assertNotEquals(0, totalEmpleados);
    	
    	this.employeeService.eliminarTodosEmpleados();
    	
    	totalEmpleados = this.employeeService.getTotalEmpleados();
    	
    	assertEquals(0, totalEmpleados);
    }
    
    @After
    public void eliminarDatosPruebas(){
    	this.employeeService.eliminarTodosEmpleados();
    }
 
}

