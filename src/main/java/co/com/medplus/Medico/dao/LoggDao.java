/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao;

/**
 *
 * @author jorgelp
 */
public interface LoggDao {
    
        public void setRequestHistory(int idLoginHistory, String apiUrl, String methodHttp, String apiResource, String apiResourceMethodName, int responseStatus,  int processTime, String bodyRequest, String body2Request) throws Exception;
	
	public void setExceptionHistory(int idLoginHistory, String apiUrl, String methodHttp, String bodyRequest, String body2Request, String exception, int responseStatus) throws Exception;
	
        public int setLoginHistory(String user, String ip, int typeAccess) throws Exception;

	public void setMailHistory(int idMailType, int idLoginHistory, String mailTO, String mailCC, String mailContent) throws Exception;
	
	public int getLoginFailedAttempt(String userLogin) throws Exception;
	
}
