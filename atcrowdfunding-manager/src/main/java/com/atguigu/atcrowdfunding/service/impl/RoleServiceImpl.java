package com.atguigu.atcrowdfunding.service.impl;

import com.atguigu.atcrowdfunding.bean.TRole;
import com.atguigu.atcrowdfunding.bean.TRoleExample;
import com.atguigu.atcrowdfunding.dao.TRoleMapper;
import com.atguigu.atcrowdfunding.service.RoleService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    TRoleMapper roleMapper;

    @ResponseBody
    @RequestMapping("/role/doUpdate")
    public String doUpdate(TRole role){
        roleMapper.updateRole(role);
        return "ok";
    }

    @Override
    public PageInfo<TRole> listPage(Map<String, Object> paramMap) {

        TRoleExample example = new TRoleExample();
        String condition = (String) paramMap.get("condition");
        if (!StringUtils.isEmpty(condition)){
            example.createCriteria().andNameLike("%"+condition+"%");
        }

        List<TRole> list = roleMapper.selectByExample(example);

        PageInfo<TRole> pageInfo = new PageInfo<TRole>(list,5);
        return pageInfo;
    }

    @Override
    public void saveRole(TRole role) {
        roleMapper.insertSelective(role);
    }

    @Override
    public TRole getRoleById(Integer id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateRole(TRole role) {
        roleMapper.updateByPrimaryKeySelective(role);

    }

    @Override
    public void deleteRoleById(Integer id) {
        roleMapper.deleteByPrimaryKey(id);
    }
}
