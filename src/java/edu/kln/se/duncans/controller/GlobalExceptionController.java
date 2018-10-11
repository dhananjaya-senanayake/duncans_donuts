/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.kln.se.duncans.controller;

import edu.kln.se.duncans.exception.CustomGenericException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 *
 * @author senanayake
 */


@ControllerAdvice
public class GlobalExceptionController {
    
    @ExceptionHandler(CustomGenericException.class)
    public ModelAndView handleCustomException(CustomGenericException ex){
        ModelAndView mav = new ModelAndView ("error/generic_error");
        mav.addObject("errCode",ex.getErrCode());
        mav.addObject("errMsg", ex.getErrMsg());
        mav.addObject("backPath",ex.getBackPath());
        return mav;
    }
    
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNoHandlerFoundException(NoHandlerFoundException ex){
        return "error/resource_not_found";
    }
    
    
    
}
