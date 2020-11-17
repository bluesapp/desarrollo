/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.aspect;

import co.com.medplus.Medico.controller.LoggController;
import co.com.medplus.Medico.service.TokenService;
import co.com.medplus.Medico.service.KeyGeneratorService;
import co.com.medplus.Medico.service.TokenManagementService;
import co.com.medplus.Medico.wrapper.WResponseWrapper;
import java.security.Key;
import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 *
 * @author jorgelp
 */
@Component
@Aspect
public class ApiLogs {

    @Autowired
    private KeyGeneratorService keyService;

    @Autowired
    private TokenService tokenService;

    private LoggController loggController;

    @Autowired
    public void setLoggController(LoggController loggController) {
        this.loggController = loggController;
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void allResources() {
    }

    @Around("allResources()")
    public Object processTime(ProceedingJoinPoint pjp) throws Throwable {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        String token = getToken(request);

        int idLoginHistory = 0;

        if (token != null) {

            Key _key = keyService.generateKey();
            idLoginHistory = tokenService.getIdLogin(token, _key);

        }

        try {

            Calendar before = Calendar.getInstance();
            Object obj = pjp.proceed();
            Calendar now = Calendar.getInstance();

            HttpServletResponse _response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

            String _requestBody = null;
            String _requestBody2 = null;

            if (request.getAttribute("requestBody") != null) {
                _requestBody = (String) request.getAttribute("requestBody");
            }

            if (request.getAttribute("requestBody2") != null) {
                _requestBody2 = (String) request.getAttribute("requestBody2");
            }

            //setea historico request
            loggController.setRequestHistory(idLoginHistory, request.getRequestURL().toString(), request.getMethod(),
                    pjp.getSignature().getDeclaringTypeName(), pjp.getSignature().getName(), _response.getStatus(),
                    (int) (now.getTimeInMillis() - before.getTimeInMillis()), _requestBody, _requestBody2);

            return obj;

        } catch (Exception e) {

            WResponseWrapper response = new WResponseWrapper();
            response.setType("4");
            response.setMensaje(e.getMessage());

            loggController.setExceptionHistory(idLoginHistory, request.getRequestURL().toString(), request.getMethod(),
                    (String) request.getAttribute("requestBody"), "", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    private String getToken(HttpServletRequest request) {

        String auth = request.getHeader("Authorization");
        if (auth != null) {
            String token = auth.substring("Bearer".length()).trim();
            return token;
        }
        return auth;

    }

}
