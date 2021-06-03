package com.finaltask.alfa.controller;

import com.finaltask.alfa.controller.exception.NotValidVariableException;
import org.apache.log4j.Logger;


public class CheckIncomingParameters {
   // private BooksController booksController;
    private Logger log = Logger.getLogger(this.getClass());

 public void checkPrise(double prise) throws Exception {
        if (prise == 0.0){
          log.error("The parameters must not be 0.0");
          throw new NotValidVariableException("The prise must not be 0.0");
        }
    }



    public void checkPages(int pages) throws Exception {
        if (pages <= 0){
            log.error("The parameters must not be 0.0 or not be negative");
            throw new NotValidVariableException("The cost pages not be 0.0 or not be negative");
        }
    }

}
