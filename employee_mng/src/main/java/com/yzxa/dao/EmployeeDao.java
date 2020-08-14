package com.yzxa.dao;

import com.yzxa.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Repository
public interface EmployeeDao {

    List<Employee> findAll();

     void  deleteById (String id);

    void addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    Employee findById(String id);

    List<Employee> finByParas(Map map);

    void BatchDeleteByIds(String[] ids);

    int findCount(Map map);

    List<Employee> findByStartAndEnd(Map map);
}
