package mang.io.apartment.service;

import mang.io.apartment.entity.Department;

import java.util.List;

public interface DepartmentService  {
    public Department saveDepartment(Department department);

    public List<Department> fetchDepartment();

    public Department fetchDepartmentById(Long id);

    public void deleteDepartmentById(Long id);

    public Department updateDepartment(Long id, Department department);

    public Department fetchDepartmentByName(String departmentName);
}
