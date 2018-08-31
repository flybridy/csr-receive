package com.csr.receive.main;

import com.csr.receive.core.ServerContainer;
import com.csr.receive.mapper.LabDataMapper;
import com.csr.receive.model.LabDataBean;
import com.csr.receive.model.UserBean;
import com.csr.receive.mapper.UserMapper;
import com.csr.receive.service.*;
import org.apache.ibatis.session.SqlSession;
import com.csr.receive.util.DBTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 13:18
 */
public class StartUp {
    public static void main(String[] args) throws SQLException {

        Logger LOG= LoggerFactory.getLogger(StartUp.class);
        ServerContainer serverContainer = new ServerContainer();
        serverContainer.start();
        serverContainer.addService(DBService.class);
        serverContainer.addService(DBDataInitService.class);
        serverContainer.addService(DataFormatService.class);
        serverContainer.addService(DataReceiveService.class);

        LOG.info("fffffff");
        SqlSession session = DBTools.getSession();
       // LabDataMapper mapper = session.getMapper(LabDataMapper.class);
       // LabDataBean dataBean = new LabDataBean("8ad007","测试",new Date(),26,59,new Date());
        UserMapper mapper = session.getMapper(UserMapper.class);

        UserBean userBean=new UserBean("我dfa长度","123dfa",522,new Timestamp(new Date().getTime()));
        try {
         // mapper.insertLabData0701(dataBean);
           // List<LabDataBean> beans=mapper.selectAllLabData0701();
            mapper.insertUser(userBean);
            HashMap<String,Object> parm=new HashMap<String,Object>();
            parm.put("username","test");
            parm.put("startTime","2018-08-01 00:00:00");
            parm.put("endTime","2018-08-29 23:00:00");
            List<UserBean> beans=mapper.selectUser(parm);
            LOG.info("getresult-->>"+beans.toString());
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
        /*try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Connection conn=DBService.getInstance().getConnection();
        String sql="insert into t_user(username,password,account)values(?,?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);
        try {
            stmt.setString(1,"我门额");
            stmt.setString(2,"sdfsfa");
            stmt.setDouble(3,542.24);
            stmt.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        DBService.getInstance().ReleaseConn(conn);*/
        /*Connection connection=null;
        try {
             connection=JDBCService.getDBConnet();
            String sql="select * from user";
            PreparedStatement stmt= null;
            try {
                stmt = connection.prepareCall(sql);
                ResultSet res=stmt.executeQuery();
                while (res.next()){
                    LOG.info("query res:->>"+res.getString("name"));
                }
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }*/
    }


}
