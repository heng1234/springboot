package com.hlvy.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.hlvy.springboot.model.User;
import com.hlvy.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * UserController
 *
 * @author heng
 * @version 1.0.0
 **/
@Controller
public class UserController {

    @Reference
    private UserService userService;

    /**
     * 分页
     * @param curPage 当前页码
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(@RequestParam(value = "curPage",required = false) Integer curPage, Model model){
        int pageSize = 6;//煤业显示数量
        if(curPage == null){
            curPage = 1;
        }
        //总数
        int totle =  userService.getUserTotle();
        //计算分页
         int totlePage = totle / pageSize;
         //有可能有余数
        int left = totle % pageSize;
        if(left > 0) {
            totlePage +=1;
        }
        if(curPage < 1){
            curPage = 1;
        }
        if(curPage > totlePage){
            curPage = totlePage;
        }

        Map<String,Object> map = new HashMap<String,Object>();
        //计算查询的开始行
        int page = (curPage - 1) * pageSize;
        map.put("page",page);
        map.put("pageSize",pageSize);
        List<User> userList = userService.getUserByPage(map);
        model.addAttribute("userList",userList);
        model.addAttribute("curPage",curPage);
        model.addAttribute("totlePage",totlePage);
        model.addAttribute("pageSize",pageSize);
        model.addAttribute("totle",totle);
        System.out.println(userList);
        //跳转到模板页面
        return "index";
    }

    /**
     * 跳转到添加或修改用户页面
     * @return
     */
    @RequestMapping("user/toSaveUser")
    public String toSaveUser(){
        return  "saveUser";
    }

    /**
     * 添加用户 或者 修改用户
     * @param user
     * @return
     */
    @RequestMapping("user/saveOrUpdateUser")
    public String saveUser(User user){
        if(user.getId() != null){
            userService.updateUser(user);//修改方法
        }else {
            userService.saveUser(user);//添加方法
        }
        return  "redirect:/index";
    }


    /**
     * 跳转到修改用户页面
     * @return
     */
    @RequestMapping("user/toUpdateUser")
    public String toUpdateUser(@RequestParam("id") Integer id,Model model){
        User user =  userService.findUser(id);
        model.addAttribute("user",user);
        return  "saveUser";
    }


    /**
     * 删除用户
     * @param user
     * @return
     */
    @RequestMapping("user/deleteUser")
    public String deleteUser(User user){
        userService.deleteUser(user);//删除方法
        return  "redirect:/index";
    }
}
