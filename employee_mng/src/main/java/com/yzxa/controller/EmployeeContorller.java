package com.yzxa.controller;

import com.yzxa.domain.Employee;
import com.yzxa.service.EmployeeService;
import com.yzxa.util.MapUtil;
import com.yzxa.util.PageModel;
import jdk.internal.instrumentation.TypeMapping;
import jxl.read.biff.BiffException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

@Controller
@RequestMapping("employee")
public class EmployeeContorller {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("finByParas")
    public String finByParas(Model model, HttpServletRequest request){
        Map<String,String> map = MapUtil.transToMAP(request.getParameterMap());
        List<Employee> employees = employeeService.finByParas(map);
        model.addAttribute("employees",employees);
        model.addAttribute("map",map);
        return "list";
    }

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Employee> employees = employeeService.findAll();
        model.addAttribute("employees",employees);
        return "list";
    }

    @RequestMapping("deleteById/{id}")
    public String deleteById(@PathVariable( "id")String id,Model model){
        employeeService.deleteById(id);
        Map<String,String> map = new TreeMap();
        map.put("curNum","1");
        PageModel pageModel = employeeService.findAndpaging(map);
        model.addAttribute("pm",pageModel);
        return "list";
    }
    @RequestMapping("addEmployee")
    public String addEmployee(Employee employee,Model model){
        try {
            employeeService.addEmployee(employee);
            Map<String,String> map = new TreeMap();
            map.put("curNum","1");
            PageModel pageModel = employeeService.findAndpaging(map);
            model.addAttribute("pm",pageModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "add";
        }
        return "list";
    }

    @RequestMapping("updateEmployee")
    public String updateEmployee(Employee employee,Model model){
        try {
            employeeService.updateEmployee(employee);
            Map<String,String> map = new TreeMap();
            map.put("curNum","1");
            PageModel pageModel = employeeService.findAndpaging(map);
            model.addAttribute("pm",pageModel);
        } catch (Exception e) {
            e.printStackTrace();
            return "update";
        }
        return "list";
    }
    @RequestMapping("forwordUpdateJSP/{id}")
    public ModelAndView forwordUpdateJSP(@PathVariable( "id")String id,Model model){
        ModelAndView mv=new ModelAndView();
        Employee employee = employeeService.findById(id);
        mv.addObject("employee",employee);
        mv.setViewName("update");
        return mv;
    }
    @ResponseBody
    @RequestMapping("BatchDeleteByIds")
    public  String BatchDeleteByIds(@RequestParam(value = "ids[]")String[] ids){
        for (String id:ids){
            employeeService.deleteById(id);
        }
        return "success";
    }
    @RequestMapping("findAndpaging")
   public String findAndpaging( Model model, HttpServletRequest request){
            Map<String,String> map = MapUtil.transToMAP(request.getParameterMap());
            String cur =map.get("curNum")==null?"1":map.get("curNum").toString();
            map.put("curNum",cur);
            PageModel pageModel = employeeService.findAndpaging(map);
            model.addAttribute("pm",pageModel);
            model.addAttribute("map",map);
            return "list";

   }
    @RequestMapping("excelImport")
    public String excelImport(HttpServletRequest request ,Model model, MultipartFile upload){

        try {
            String path = request.getSession().getServletContext().getRealPath("/uploads");
            File file=new File(path);
            if (!file.exists()){
                file.mkdirs();
            }
            String filename = upload.getOriginalFilename();
            String uuid = UUID.randomUUID().toString().replace("-", "");
            filename=uuid+"-"+filename;
            File file1 = new File(path, filename);
            upload.transferTo(file1);
            employeeService.excelImport(path,filename);

            Map<String,String> map = new TreeMap();
            map.put("curNum","1");
            PageModel pageModel = employeeService.findAndpaging(map);
            model.addAttribute("pm",pageModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "list";

    }

}
