package mang.io.apartment.controller;

import mang.io.apartment.entity.Department;
import mang.io.apartment.error.DepartmentNotFoundException;
import mang.io.apartment.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);


    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment of DepartmentController");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        LOGGER.info("Inside fetchDepartmentList of DepartmentController");
        return departmentService.fetchDepartment();
    }

    @GetMapping("department/{id}")
    public Department fetchDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
        return departmentService.fetchDepartmentById(id);
    }

    @DeleteMapping("department/{id}")
    public String deleteDepartmentById(@PathVariable Long id){
        departmentService.deleteDepartmentById(id);
        return "Item deleted successfully";
    }

    @PutMapping("department/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("department/name/{departmentName}")
    public Department fetchDepartmentByName(@PathVariable String departmentName){
        return departmentService.fetchDepartmentByName(departmentName);
    }

}
