package com.finaltask.alfa.controller;

import com.finaltask.alfa.controller.exception.NotValidVariableException;
import org.apache.log4j.Logger;


public class CheckIncomingParameters {
   // private BooksController booksController;
    private Logger log = Logger.getLogger(this.getClass());

 public void checkPrise(double prise) throws Exception {
        if (prise == 0.0){
          log.error("The parameters must not to be 0.0 or not be empty");
          throw new NotValidVariableException("The prise must not to be 0.0");
        }
    }
}
