package com.ahead.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Yang
 * @version 1.0
 * @time 2019/2/12
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    /**
     * 在Handler请求方法之前执行
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object user = request.getSession().getAttribute("user");
        if (!StringUtils.isEmpty(user)) {
            //不为空说明已登陆，放行
            return true;
        } else {
            //为空说明未登陆，不放行，并转发到登陆页面
            request.setAttribute("msg", "权限不够请先登陆");
            request.getRequestDispatcher("/login").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
