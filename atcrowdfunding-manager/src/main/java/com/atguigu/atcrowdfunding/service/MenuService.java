package com.atguigu.atcrowdfunding.service;

import com.atguigu.atcrowdfunding.bean.TMenu;

import java.util.List;

public interface MenuService {
    //查詢所有父,父含有children屬性
    //侧边栏,组装好父子关系后返回所有的fu.
    List<TMenu> listAllMenus();

    List<TMenu> listAllMenusTree();
}
