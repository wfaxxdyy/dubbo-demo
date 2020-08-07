package cn.wf.dubboconsumer.controller;


import cn.wf.dubboapi.api.IUserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Service
@RequestMapping("/get")
public class UserController {

    @Reference(timeout = 1000,check = true,generic = false)
    private IUserService userService;


    @RequestMapping("/getName")
    @ResponseBody
    public List<String> getUserName(){
        return userService.selectUsername();
    }

}
