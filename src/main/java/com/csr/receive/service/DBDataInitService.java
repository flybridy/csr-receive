package com.csr.receive.service;

import com.csr.receive.core.BaseServer;
import com.csr.receive.model.LabDisprobeNumber;
import com.csr.receive.model.LabInputData;
import com.csr.receive.service.task.ParseAndSaveDataTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 16:28
 */
public class DBDataInitService extends BaseServer{
    public static Logger logger = LoggerFactory.getLogger(DBDataInitService.class);

    private static DBDataInitService instance=new DBDataInitService();
    public static DBDataInitService getInstance(){
        return instance;
    }
    private static ConcurrentHashMap<String,LabDisprobeNumber> probeMap=new ConcurrentHashMap<String, LabDisprobeNumber>();

    public LabDisprobeNumber getDisplayTabName(String inputTabName){
        if(probeMap.containsKey(inputTabName)){
            return probeMap.get(inputTabName);
        }else {
            logger.error("there has no probe in database:"+inputTabName);
            return null;
        }
    }

    public void startServer() {

    }

    public void serverHandle() {

    }
    public void insertLabInputData(LabInputData inputData,String tablName){

    }
}
