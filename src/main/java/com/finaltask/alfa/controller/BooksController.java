package com.finaltask.alfa.controller;


import com.finaltask.alfa.model.ServiceBooks;
import com.finaltask.alfa.view.BooksView;
import com.finaltask.alfa.view.InputDataView;
import org.apache.log4j.Logger;

public class BooksController {

    private BooksView printBooks;
    private ServiceBooks serviceBooks;
    private InputDataView dataView;
    private CheckIncomingParameters checkIncomingParameters;
    private Logger log = Logger.getLogger(this.getClass());


    public BooksController() {

        printBooks = new BooksView();
        serviceBooks = new ServiceBooks();
        dataView = new InputDataView(printBooks);
    }

    public void execute() {
        while (true) {
            System.out.println();
            int menuItem = dataView.inputMenuItem();
            switch (menuItem) {
                case 0: System.exit(0);
                case 1: printBooks.printListBooks(serviceBooks.getBookList()); break;
                case 2: inputAddBook(); break;
                case 3: inputNewPrise(); break;
                case 4: handleFilterMenu(); break;
                default: printBooks.printMessage(BooksView.ERROR_ENTER);

            }
        }
    }

    private void inputAddBook() {
        String name = dataView.inputString(BooksView.ENTER_TITLE);
        String author = dataView.inputString(BooksView.ENTER_AUTHOR);
        String publisher = dataView.inputString(BooksView.ENTER_PUBLISHER);
        String year = dataView.inputString(BooksView.ENTER_YEAR);
        String pages = dataView.inputString(BooksView.ENTER_PAGES);
        String cost = dataView.inputString(BooksView.ENTER_COST);
        serviceBooks.addBook(name, author, publisher, Integer.parseInt(year), Integer.parseInt(pages),
                Double.parseDouble(cost));
    }

    private void inputNewPrise() {
        String cost = dataView.inputString(BooksView.ENTER_COST);
        CheckIncomingParameters.checkPrise(Double.parseDouble(cost));
        serviceBooks.increasePrise(Double.parseDouble(cost));
    }

    public void handleFilterMenu() {
        while (true) {
            System.out.println();
            int menuItem = dataView.inputFilterMenu();
            switch (menuItem) {
                case 1: filterByAuthor(); break;
                case 2: filterByYear(); break;
                case 3: filterByPublisher(); break;
                default: printBooks.printMessage(BooksView.ERROR_ENTER);

            }
        }
    }

    private void filterByAuthor() {
        String author = dataView.inputString(BooksView.ENTER_AUTHOR);
        log.info("filterByAuthor -> " + author);
        printBooks.printListBooks(serviceBooks.filterBy(book -> book.getAuthor().equals(author)));
    }

    private void filterByPublisher() {
        String publisher = dataView.inputString(BooksView.ENTER_PUBLISHER);
        log.info("filterByPublisher -> " + publisher);
        printBooks.printListBooks(serviceBooks.filterBy(book -> book.getPublisher().equals(publisher)));
    }


    private void filterByYear() {
        String year = dataView.inputString(BooksView.ENTER_YEAR);
        log.info("filterByYear -> " + year);
        printBooks.printListBooks(serviceBooks.filterBy(book -> ((book.getYear()) > Integer.parseInt(year))));
    }

}
