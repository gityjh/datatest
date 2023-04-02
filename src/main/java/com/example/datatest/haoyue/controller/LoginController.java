package com.example.datatest.haoyue.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("login")
public class LoginController {
    @PostMapping("userLogin")
    public Map<String,String> login(@RequestBody Map<String, String> map, HttpServletRequest request){
        Map<String,String> responseMap = new HashMap<>(5);
        //System.out.println("test:"+test);
        String username = map.get("username");
        String password = map.get("password");
        if(!"admin".equals(username)||!"123456".equals(password)){
            responseMap.put("code","-1");
            responseMap.put("message","用户不存在");
            return responseMap;
        }
        String token = username+System.currentTimeMillis()+password;
        request.getSession().setAttribute("token",token);
        responseMap.put("code","0");
        responseMap.put("message","登录成功");
        responseMap.put("token",token);
        return responseMap;
    }
}
