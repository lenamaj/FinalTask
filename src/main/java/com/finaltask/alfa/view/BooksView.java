package com.finaltask.alfa.view;



import com.finaltask.alfa.model.entity.Book;

import java.util.List;

public class BooksView {

    public static final String ENTER_COMMAND = "Make you choice: ";
    public static final String ERROR_ENTER = "Error. Repeat! ";
    public static final String ENTER_TITLE = "Enter title:";
    public static final String ENTER_AUTHOR = "Enter author:";
    public static final String ENTER_PUBLISHER = "Enter publisher:";
    public static final String ENTER_YEAR= "Enter year:";
    public static final String ENTER_PAGES = "Enter pages:";
    public static final String ENTER_COST = "Enter cost:";

    public void printMessage (String message){
        System.out.println(message);
    }

    public void printListBooks(List<Book> books){

        for (Book elem: books) {
            System.out.println(convertBookToString(elem));
        }
    }

    private String convertBookToString(Book book){
        return String.format("%-20s| %-30s| %-20s| %-5d| %-5d| %8.2f", book.getAuthor(), book.getName(),
                book.getPublisher(), book.getYear(), book.getPages(), book.getCost());
    }

    public void printMenu(){
        System.out.println(

                        "1. View all books\n" +
                        "2.Add a new book\n" +
                        "3.Change price of the book\n" +
                        "4.Search the book (by author,year or publisher)\n" +
                        "0. Close the app "
        );
    }

    public void printFilterMenu () {
        System.out.println(

                        "1.Filter by author\n" +
                        "2.Filter by year\n" +
                        "3.Filter by publisher"
        );

    }
}



//[
//        {
//        "data": "Title5",
//        "author": "Author5",
//        "publisher": "Publisher5",
//        "year": 6,
//        "pages": 7,
//        "cost": 7.0
//        },
//
//        {
//        "data": "Title1",
//        "author": "Author1",
//        "publisher": "Publisher1",
//        "year": 6,
//        "pages": 7,
//        "cost": 7.0
//        }
//        ]