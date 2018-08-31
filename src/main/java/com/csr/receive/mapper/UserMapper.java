package com.csr.receive.mapper;

import com.csr.receive.model.UserBean;

import java.util.HashMap;
import java.util.List;

/**
 * User: cdp
 * Date: 2018/7/2
 * Time: 17:53
 */
public interface UserMapper {
    public int insertUser(UserBean user) throws Exception;

    public List<UserBean> selectAllUser() throws Exception;
    public List<UserBean> selectUser(HashMap<String,Object> parm) throws Exception;
    public List<UserBean> selectTimeUser() throws Exception;

    public UserBean selectUserById(int id) throws Exception;

    public int updateUser (UserBean user,int id) throws Exception;

    public int deleteUser(int id) throws Exception;

}
