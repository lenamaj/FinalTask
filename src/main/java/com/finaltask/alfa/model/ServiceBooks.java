package com.finaltask.alfa.model;


import com.finaltask.alfa.model.entity.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ServiceBooks {

    private List<Book> bookList;

    public ServiceBooks(){
        bookList = SourceBooks.getBookFromJson();
    }

    public List<Book> getBookList() {
        return (List<Book>) (new ArrayList<Book>(bookList)).clone();
    }

    public void addBook(String name, String author, String publisher, int year, int pages, double cost){
       // bookList.add(new Book(name, author, publisher, year, pages, cost));
        SourceBooks.setBookToJson(name, author, publisher, year, pages, cost);
    }

   public void increasePrise(double percent) {
        for (int i = 0; i < bookList.size(); i++) {
          Book book = bookList.get(i);
          book.setCost(book.getCost()+((book.getCost() * percent) / 100));
        }
    }

    public List<Book> filterBy(Predicate<Book> predicate){
      return bookList.stream().filter(predicate).collect(Collectors.toList());
    }
}
