/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.exception;

import org.springframework.stereotype.Component;

/**
 *
 * @author senanayake
 */
@Component
public class CustomGenericException extends RuntimeException{

    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @param errCode the errCode to set
     */
    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    /**
     * @return the errMsg
     */
    public String getErrMsg() {
        return errMsg;
    }

    /**
     * @param errMsg the errMsg to set
     */
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    /**
     * @return the backPath
     */
    public String getBackPath() {
        return backPath;
    }

    /**
     * @param backPath the backPath to set
     */
    public void setBackPath(String backPath) {
        this.backPath = backPath;
    }
    private static final long serialVersionUID = 1L ;

    public CustomGenericException() {
    }

    
    
    public CustomGenericException(String errCode, String errMsg, String backPath) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.backPath = backPath;
    }

    
    
    
    
    private String errCode;
    private String errMsg ;
    private String backPath ;
}
