package com.csr.receive.mapper;

import com.csr.receive.model.LabDataBean;

import java.util.List;

/**
 * User: cdp
 * Date: 2018/8/27
 * Time: 13:40
 */
public interface  LabDataMapper {
    public int insertLabData0701(LabDataBean labDataBean) throws Exception;
   // public int updateLabData0701(LabDataBean labDataBean) throws Exception;
    public List<LabDataBean> selectAllLabData0701() throws Exception;
}
