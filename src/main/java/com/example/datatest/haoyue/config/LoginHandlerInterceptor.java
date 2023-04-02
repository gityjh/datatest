package com.example.datatest.haoyue.config;

import com.alibaba.druid.support.json.JSONUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("UTF-8");
        //这里是前端Vue放在请求头中的字段名   Authorization：token字符串
        String token = request.getHeader("Authorization");

        if (token != null){
            String sessionToken = request.getSession().getAttribute("token")+"";
            if(token.equals(sessionToken)){
                System.out.println("验证成功:"+ token);
                return true;
            }
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        try{

            Map<String,String> json = new HashMap<>(5);
            json.put("msg","token失效请重新登陆");
            json.put("code","-1");
            response.getWriter().append(JSONUtils.toJSONString(json));
            System.out.println("认证失败，未通过拦截器");

        }catch (Exception e){
            e.printStackTrace();
            response.sendError(500);
            return false;
        }
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
