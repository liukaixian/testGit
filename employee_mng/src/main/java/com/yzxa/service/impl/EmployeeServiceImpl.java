package com.yzxa.service.impl;

import com.yzxa.dao.EmployeeDao;
import com.yzxa.domain.Employee;
import com.yzxa.service.EmployeeService;
import com.yzxa.util.PageModel;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public void deleteById(String id) {
        employeeDao.deleteById(id);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    public Employee findById(String id) {
        return employeeDao.findById(id);
    }

    @Override
    public List<Employee> finByParas(Map map) {
        return employeeDao.finByParas(map);
    }

    @Override
    public void BatchDeleteByIds(String[] ids) {
        employeeDao.BatchDeleteByIds(ids);
    }

    public PageModel findAndpaging(Map map){

        int totalRecords=employeeDao.findCount(map);
        int curNum=Integer.parseInt(map.get("curNum").toString());
        PageModel pm=new PageModel(curNum,totalRecords,5);
        map.put("start",pm.getStartIndex());
        map.put("end",pm.getPageSize());
        List list=employeeDao.findByStartAndEnd(map);
        pm.setRecords(list);
        //3_关联url
      //  pm.setUrl("ProductServlet");

        return pm;
    }

    @Override
    public void excelImport(String path, String filename) throws IOException, BiffException {
        List<Employee> list=new ArrayList<>();
        Workbook rwb = Workbook.getWorkbook(new File(path,filename));
        Sheet rs = rwb.getSheet(0);//rwb.getSheet("用户信息");// 或者rwb.getSheet(0)
        int clos = rs.getColumns();// 得到所有的列
        int rows = rs.getRows();// 得到所有的行

        for (int i = 1; i < rows; i++) {
            Employee employee = new Employee();
            Cell cell1 = rs.getCell(0, i);
            Cell cell2 = rs.getCell(1, i);
            Cell cell3 = rs.getCell(2, i);
            Cell cell4 = rs.getCell(3, i);
            Cell cell5 = rs.getCell(4, i);
            Cell cell6 = rs.getCell(5, i);
            employee.setName(cell1.getContents());
            employee.setAge(Integer.parseInt(cell2.getContents()));
            employee.setGender(cell3.getContents());
            employee.setDepartment(cell4.getContents());
            employee.setSalary(Double.parseDouble(cell5.getContents()));
            employee.setGrade(Double.parseDouble(cell6.getContents()));
            employeeDao.addEmployee(employee);
        }

    }
}
