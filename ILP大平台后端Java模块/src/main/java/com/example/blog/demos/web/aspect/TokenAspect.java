package com.example.blog.demos.web.aspect;

import com.example.blog.demos.web.untils.TokenUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Aspect
@Component
public class TokenAspect {
    @Pointcut("@annotation(com.example.blog.demos.web.aspect.PointCut.TokenRequired)")
    public void tokenRequired(){}

    @Around("tokenRequired()")
    public Object tokenRequired(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
          String token= request.getHeader("Authorization");
    //    String token=authorization.substring(7);
          Map<String,Object> map=new HashMap<>();
          if(TokenUtils.verifyToken(token)) {
              return joinPoint.proceed();
          }else if (!TokenUtils.verifyToken(token)) {
              System.out.println(token);
              map.put("code",1);
              return ResponseEntity.ok().body(map);
          }else {
              map.put("code",2);
              return ResponseEntity.ok().body(map);
          }
      }

}
