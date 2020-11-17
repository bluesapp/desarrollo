/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.dao.impl;

import co.com.medplus.Medico.dao.LoggDao;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jorgelp
 */
@Repository
public class LoggDaoJdbc implements LoggDao{
    
    
    @Autowired
    @Qualifier(value = "dsCrmMedico")
    private DataSource dataSource;

    @Override
    public void setRequestHistory(int idLoginHistory, String apiUrl, String methodHttp, String apiResource, String apiResourceMethodName, int responseStatus, int processTime, String parameterRequest, String body2Request) throws Exception {
      
           Connection conn = this.dataSource.getConnection();
       		
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spSetRequestHistoryOffice(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
			cstm.setInt(1, idLoginHistory);
			cstm.setString(2, apiUrl);
			cstm.setString(3, methodHttp);
			cstm.setString(4, apiResource);
			cstm.setString(5, apiResourceMethodName);
			cstm.setInt(6, responseStatus);
			cstm.setInt(7, processTime);
			cstm.setString(8, parameterRequest);
			cstm.setInt(9, error);
			cstm.setString(10, messageError);
			cstm.registerOutParameter(9, Types.INTEGER);
			cstm.registerOutParameter(10, Types.VARCHAR);			
			
			cstm.execute();
			
			int _error = cstm.getInt(9);

			if (_error != 0) {

				throw new Exception(cstm.getString(10));

			}			
			

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		} finally {

			try {
				
				if (cstm != null)
					cstm.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    }

    @Override
    public void setExceptionHistory(int idLoginHistory, String apiUrl, String methodHttp, String parameterRequest, String body2Request, String exception, int responseStatus) throws Exception {
      
           Connection conn = this.dataSource.getConnection();
		//Connection conn = null;
		CallableStatement cstm = null;	
		
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spSetExceptionHistoryOffice(?, ?, ?, ?, ?, ?, ?, ?)}");
			cstm.setInt(1, idLoginHistory);
			cstm.setString(2, apiUrl);
			cstm.setString(3, methodHttp);
			cstm.setString(4, parameterRequest);
			cstm.setString(5, exception);
			cstm.setInt(6, responseStatus);
			cstm.setInt(7, error);
			cstm.setString(8, messageError);
			cstm.registerOutParameter(7, Types.INTEGER);
			cstm.registerOutParameter(8, Types.VARCHAR);
			
			cstm.execute();
			
			int _error = cstm.getInt(7);

			if (_error != 0) {

				throw new Exception(cstm.getString(8));

			}			
			

		} catch (Exception e) {

			//e.printStackTrace();
			throw e;

		} finally {

			try {
				
				if (cstm != null)
					cstm.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

    }

    @Override
    	public int setLoginHistory(String user, String ip, int typeAccess) throws Exception {
		
            Connection conn = this.dataSource.getConnection();
		//Connection conn = null;
		CallableStatement cstm = null;		
		int result = 0;
		
		int id = 0;
		int error = 0;
		String messageError = "";

		try {

			//conn = dataSource.getConnection();
			cstm = conn.prepareCall("{call spSetLoginHistoryOffice(?, ?, ?, ?, ?, ?)}");
			cstm.setString(1, user);
			cstm.setString(2, ip);
			cstm.setInt(3, typeAccess);
			cstm.setInt(4, id);
			cstm.setInt(5, error);
			cstm.setString(6, messageError);
			cstm.registerOutParameter(4, Types.INTEGER);
			cstm.registerOutParameter(5, Types.INTEGER);
			cstm.registerOutParameter(6, Types.VARCHAR);

			cstm.execute();

			int _error = cstm.getInt(5);

			if (_error != 0) {

				throw new Exception(cstm.getString(6));

			}				
				
			int _id =  cstm.getInt(4);
				
			if(_id != 0){					
				result = _id;					
			}			

			return result;

		} catch (Exception e) {

			e.printStackTrace();
			throw e;

		} finally {

			try {
				
				if (cstm != null)
					cstm.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

        
    @Override
    public void setMailHistory(int idMailType, int idLoginHistory, String mailTO, String mailCC, String mailContent) throws Exception {
     try{
           Connection con = this.dataSource.getConnection();
           con.close();
       }catch(SQLException e){
           System.out.println(e);
       }
    }

    @Override
    public int getLoginFailedAttempt(String userLogin) throws Exception {
      try{
           Connection con = this.dataSource.getConnection();
           con.close();
           return 0;
       }catch(SQLException e){
           System.out.println(e);
           throw e;
       }
    }
    
    
    
    
}
