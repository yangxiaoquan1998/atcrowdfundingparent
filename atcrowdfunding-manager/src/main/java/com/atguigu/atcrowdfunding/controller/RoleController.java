package com.atguigu.atcrowdfunding.controller;

import com.atguigu.atcrowdfunding.bean.TRole;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class RoleController {

    @Autowired
    RoleService roleService;

    @ResponseBody
    @RequestMapping("/role/doDelete")
    public String delete(Integer id){
        roleService.deleteRoleById(id);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/role/doUpdate")
    public String doUpdate(TRole role){
        roleService.updateRole(role);
        return "ok";
    }

    @ResponseBody
    @RequestMapping("/role/getRoleById")
    public TRole get(Integer id){
        return roleService.getRoleById(id);
    }

    @ResponseBody
    @RequestMapping("/role/doAdd")
    public String doAdd(TRole role){
        roleService.saveRole(role);
        return "ok";
    }

    @ResponseBody//告诉框架采用HttpMessageConverter组件,将Bean对象转换为json格式数据(jackson)
    @RequestMapping("/role/loadData")
    public PageInfo<TRole> loadData(
            @RequestParam(value = "pageNum",required = false,defaultValue = "") Integer pageNum,
            @RequestParam(value = "pageSize",required = false,defaultValue = "") Integer pageSize,
            @RequestParam(value = "condition",required = false,defaultValue = "") String condition){

        PageHelper.startPage(pageNum,pageSize);

        Map<String,Object> paramMap = new HashMap<String, Object>();
        paramMap.put("condition",condition);

        PageInfo<TRole> pageInfo = roleService.listPage(paramMap);

        return pageInfo;
    }

    @RequestMapping("/role/index")
    public String index(){
        return "role/index";
    }
}
