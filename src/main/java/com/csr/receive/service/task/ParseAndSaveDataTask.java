package com.csr.receive.service.task;

import com.csr.receive.model.LabDisprobeNumber;
import com.csr.receive.model.LabInputData;
import com.csr.receive.service.DBDataInitService;
import com.csr.receive.util.RegexUtil;
import com.csr.receive.util.SCMUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:45
 */
public class ParseAndSaveDataTask implements Runnable {
    public static Logger logger = LoggerFactory.getLogger(ParseAndSaveDataTask.class);
    private String messageInfo;

    public ParseAndSaveDataTask(String messageInfo) {
        this.messageInfo = messageInfo;
    }

    public void run() {
        String[] paramterStr = SCMUtil.getArrayFromSCM(RegexUtil.getParams(this.messageInfo));
        logger.info("parse data:  " + paramterStr[0] + " " + paramterStr[1]);
        String inputProbNum = "";
        String createdOn = "";

        double tempCheck = -25.0D;
        double humCheck = -20.0D;

        String inputTabName = "";
        for (int i = 0; i < paramterStr.length; i++) {
            String[] paramters = SCMUtil.getParamterFromArray(paramterStr[i]);
            inputProbNum = paramters[0];
            createdOn = SCMUtil.getSimpledDateTime();
            Double temperature = Double.valueOf(paramters[1]);
            Double humidity = Double.valueOf(paramters[2]);

            logger.info("insert into inputProbNum:->" + inputProbNum);
            LabDisprobeNumber labDisprobeNumber = DBDataInitService.getInstance().getDisplayTabName(inputProbNum);
            if (labDisprobeNumber != null) {
                inputTabName = labDisprobeNumber.getTabDisplayName();
                LabInputData labInputData;
                if ((temperature > tempCheck) && (humidity > humCheck)) {
                    labInputData = new LabInputData(inputProbNum, createdOn, temperature, humidity,
                            labDisprobeNumber.getDisplayProbeNumber());
                } else {
                    labInputData = new LabInputData(inputProbNum, createdOn, tempCheck, humidity,
                            labDisprobeNumber.getDisplayProbeNumber());
                }
                // DBDataService.getInstance().insertLabInputData(labInputData, inputTabName);
            }
        }


    }
}
