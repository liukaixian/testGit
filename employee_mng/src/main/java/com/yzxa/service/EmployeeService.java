package com.yzxa.service;

import com.yzxa.domain.Employee;
import com.yzxa.util.PageModel;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

     List<Employee> findAll();

     void deleteById(String id);

     void addEmployee(Employee employee);

     void  updateEmployee (Employee employee);

     Employee findById(String id);

     List<Employee> finByParas(Map map);

     void BatchDeleteByIds(String [] ids);
     /*分页查找*/
     PageModel findAndpaging(Map map);


    void excelImport(String path, String filename) throws IOException, BiffException;
}
