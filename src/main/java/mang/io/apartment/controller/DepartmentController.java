package mang.io.apartment.controller;

import mang.io.apartment.entity.Department;
import mang.io.apartment.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/departments")
    public Department saveDepartment(@RequestBody Department department){
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        return departmentService.fetchDepartment();
    }

    @GetMapping("department/{id}")
    public Department fetchDepartmentById(@PathVariable Long id){
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
