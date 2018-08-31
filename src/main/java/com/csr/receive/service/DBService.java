package com.csr.receive.service;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.csr.receive.comm.GlobalParam;
import com.csr.receive.core.BaseServer;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 13:20
 */
public class DBService extends BaseServer {
    private static DBService instance = new DBService();
    private static ComboPooledDataSource dataSource;

    public static DBService getInstance() {
        return instance;
    }

    public void startServer() {
        dataSource = new ComboPooledDataSource();
       // dataSource.setUser("root");     //用户名
        dataSource.setUser(GlobalParam.DB_USER);     //用户名
        dataSource.setPassword(GlobalParam.DB_PWD); //密码
        //dataSource.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/lab");//数据库地址
        dataSource.setJdbcUrl(GlobalParam.DB_ADDRESS);//数据库地址
        try {
            dataSource.setDriverClass(GlobalParam.DB_DRIVER);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        dataSource.setInitialPoolSize(3); // 初始化时获取连接数，取值应在minPoolSize与maxPoolSize之间。Default: 3
        dataSource.setMinPoolSize(1);  //  连接池中保留的最小连接数
        dataSource.setMaxPoolSize(10); // 连接池中保留的最大连接数。Default: 15
        dataSource.setMaxStatements(5);//最长等待时间
        dataSource.setMaxIdleTime(60);//最大空闲时间,60秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0
        dataSource.setAcquireIncrement(3);// 当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3
        dataSource.setAcquireRetryAttempts(30);// 定义在从数据库获取新连接失败后重复尝试的次数。Default: 30
    }


    public synchronized Connection getConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public synchronized void ReleaseConn(Connection conn) {
        try {
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void serverHandle() {
    }
}
