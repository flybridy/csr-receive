package com.csr.receive.service;

import com.csr.receive.comm.GlobalParam;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * User: cdp
 * Date: 2018/7/11
 * Time: 10:30
 */
public class JDBCService {

    public   static Connection getDBConnet() throws Exception{
        Connection con=null;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(GlobalParam.DB_ADDRESS,GlobalParam.DB_USER,GlobalParam.DB_PWD);
        return con;
    }
}
