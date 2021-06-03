package com.finaltask.alfa.controller;

public class CheckIncomingParameters {
    private BooksController booksController;


  static void checkPrise(double prise){
        if (prise == 0.0){
            System.out.println("You entered wrong number");
        }
    }
}
