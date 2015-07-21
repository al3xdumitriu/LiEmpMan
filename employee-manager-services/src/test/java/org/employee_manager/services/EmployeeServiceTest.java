package org.employee_manager.services;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.employee_manager.model.Employee;
import org.junit.Before;
import org.junit.Test;

public class EmployeeServiceTest extends BaseServicesTest {

    private Employee employee, employeeSecond;

    @Before
    public void init() {

        // employee object
        employee = new Employee();
        employee.setName("name");
        employee.setCnp(1234567890);
        employee.setPhone("0731767676");
        employee.setEmail("test@email.com");
        employee.setExperienceLevel("junior");
        employee.setAvailableHours(40);
        employee.setJobTitle("javaDeveloper");
        employee.setAccount(null);
        employee.setAddressId(null);
        employee.setAchievements(null);
        employee.setEmployeeProjects(null);
        employee.setEvaluations(null);
        employee.setSkills(null);

        // employee second object
        employeeSecond = new Employee();
        employeeSecond.setName("secondName");
        employeeSecond.setCnp(1234567890);
        employeeSecond.setPhone("0731767676");
        employeeSecond.setEmail("test@email.com");
        employeeSecond.setExperienceLevel("junior");
        employeeSecond.setAvailableHours(40);
        employeeSecond.setJobTitle("javaDeveloper");
        employeeSecond.setAccount(null);
        employeeSecond.setAddressId(null);
        employeeSecond.setAchievements(null);
        employeeSecond.setEmployeeProjects(null);
        employeeSecond.setEvaluations(null);
        employeeSecond.setSkills(null);
    }

    @Test
    public void testSave() {

        Employee employeeResult = employeeService.save(employee);

        assertEquals("name", employeeResult.getName());
        assertEquals(1234567890, employeeResult.getCnp());
        assertEquals("0731767676", employeeResult.getPhone());
        assertEquals("test@email.com", employeeResult.getEmail());
        assertEquals("junior", employeeResult.getExperienceLevel());
        assertEquals(40, employeeResult.getAvailableHours());
        assertEquals("javaDeveloper", employeeResult.getJobTitle());
    }

    @Test
    public void testSaveAll() {

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employeeSecond);

        List<Employee> employeeListResult = employeeService.saveAll(employeeList);
        assertEquals(2, employeeListResult.size());
        assertEquals("name", employeeListResult.get(0).getName());
        assertEquals("secondName", employeeListResult.get(1).getName());
    }

    @Test
    public void testFindById() {

        Employee employeeResult = employeeService.save(employee);
        Employee employeeResultTwo = employeeService.findById(employeeResult.getId());
        
        assertEquals(employeeResultTwo.getId(), employeeResult.getId());
        assertEquals("name", employeeResult.getName());
        assertEquals(1234567890, employeeResult.getCnp());
        assertEquals("0731767676", employeeResult.getPhone());
        assertEquals("test@email.com", employeeResult.getEmail());
        assertEquals("junior", employeeResult.getExperienceLevel());
        assertEquals(40, employeeResult.getAvailableHours());
        assertEquals("javaDeveloper", employeeResult.getJobTitle());
    }

    @Test
    public void testFindAll() {
        
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        employeeList.add(employeeSecond);

        List<Employee> employeeListSave = employeeService.saveAll(employeeList);
        List<Employee> employeeListResultFind = employeeService.findAll();
        
        assertEquals(true, employeeListResultFind.containsAll(employeeListSave));
    }
}
