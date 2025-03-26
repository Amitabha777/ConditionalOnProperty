package com.project.codesnippet.Interceptors;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoggingInterceptor implements HandlerInterceptor{


    /* 
    ! To Generate Methods to override, 
    !               right click on the HandlerInterface, go to Source Action -> Generate Override Methods 
    */

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        
                System.out.println("After Completion: Request URI is: "+request.getRequestURI());
            }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
       
                System.out.println("PostHandle: Request URI is: "+request.getRequestURI());
            }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        
                System.out.println("PreHandle: Request URI is: "+request.getRequestURI());
        
                return true;
    }
    
}
