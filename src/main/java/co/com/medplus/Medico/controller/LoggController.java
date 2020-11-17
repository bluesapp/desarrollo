/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.controller;

import co.com.medplus.Medico.dao.LoggDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jorgelp
 */
@Controller
public class LoggController {
    
	private LoggDao dao;

	@Autowired
	public void setDao(LoggDao dao) {
		this.dao = dao;
	}
	
	public void setRequestHistory(int idLoginHistory, String apiUrl, String methodHttp, String apiResource, String apiResourceMethodName, int responseStatus,  int processTime, String bodyRequest, String body2Request){
		
		try {
			dao.setRequestHistory(idLoginHistory, apiUrl, methodHttp, apiResource, apiResourceMethodName, responseStatus, processTime, bodyRequest, body2Request);
		} catch (Exception e) {
	                   System.out.println(e);
		}
	}
	
	public void setExceptionHistory(int idLoginHistory, String apiUrl, String methodHttp, String bodyRequest, String body2Request, String exception, int responseStatus){
		
		try {
			dao.setExceptionHistory(idLoginHistory, apiUrl, methodHttp, bodyRequest, body2Request, exception, responseStatus);
		} catch (Exception e) {			
			System.out.println(e);
		}
		
	}
        
        public int setLoginHistory(String user, String ip, int typeAccess){
               
		try {
			return dao.setLoginHistory(user, ip, typeAccess);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;			
		}
		
	}
	
	public void setMailHistory(int idMailType, int idLoginHistory, String mailTO, String mailCC, String mailContent){
		
		try {
			dao.setMailHistory(idMailType, idLoginHistory, mailTO, mailCC, mailContent);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public int getLoginFailedAttempt(String userLogin){
		
		try {
			return dao.getLoginFailedAttempt(userLogin);
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
		
	}
	
	
}


