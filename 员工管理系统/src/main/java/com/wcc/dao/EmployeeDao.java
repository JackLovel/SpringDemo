package com.wcc.dao;

import com.wcc.model.Department;
import com.wcc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工dao
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    // 员工有所属的部门
    static {
        employees = new HashMap<>(); // 创建一个部门表
        employees.put(1001, new Employee(1001, "AA", "A2192132@qq.com", 0, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "BB", "B2192132@qq.com", 1, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "CC", "C2192132@qq.com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "DD", "D2192132@qq.com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "EE", "E2192132@qq.com", 0, new Department(105, "后勤部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 获得所有部门信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过 id 查询员工
    public Employee getDepartmentById(Integer id) {
        return employees.get(id);
    }

    // 删除员工
    public void delete(Integer id) {
        employees.remove(id);
    }
}
