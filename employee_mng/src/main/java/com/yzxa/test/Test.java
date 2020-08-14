package com.yzxa.test;

import com.yzxa.domain.Employee;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test{

    public static void main(String[] args) throws IOException, BiffException {
        String path="D:\\UserData\\Book1.xls";
        List<Employee> list=new ArrayList<>();
        Workbook rwb = Workbook.getWorkbook(new File(path));
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
            list.add(employee);
        }
        System.out.println(list);
    }

}


