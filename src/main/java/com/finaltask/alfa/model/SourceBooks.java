package com.finaltask.alfa.model;
import com.finaltask.alfa.model.entity.Book;
import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SourceBooks {

    public static List<Book> generateBooks() {
        List<Book> list = new ArrayList<>();
        list.add(new Book("title1", "Author1", "Publisher1", 1998, 100, 200.00));
        list.add(new Book("title2", "Author2", "Publisher2", 1998, 100, 200.00));
        return list;

       /* return Arrays.asList(
                new Book("title1", "Author1", "Publisher1", 1998, 100, 200.00),
                new Book("title2", "Author2", "Publisher2", 2011, 110, 201.00),
                new Book("title3", "Author3", "Publisher3", 2001, 120, 202.00),
                new Book("title4", "Author4", "Publisher4", 2020, 420, 502.00)
        );*/

    }

    public static List<Book> getBookFromJson() {
        try {
            return Arrays.asList(new Gson().fromJson(String.join("", Files.readAllLines(Paths.get("src/main/resources/soursbook.json"))), Book[].class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e);
        }
    }

    public static void setBookToJson(String name, String author, String publisher, int year, int pages, double cost) {
        Gson obj= new Gson();
        List<Book> jsonBooks = new ArrayList<>(getBookFromJson());
        jsonBooks.add(new Book(name, author, publisher, year, pages, cost));
        String s = obj.toJson(jsonBooks.toArray(), Book[].class);
        try {
            Files.write(Paths.get("src/main/resources/soursbook.json"), s.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JsonWriter writer = null;
//        try {
//            writer = new JsonWriter(new FileWriter("src/main/resources/soursbook.json"));
//            writer.beginArray();
//            writer.beginObject();
//            writer.name("data").value(name);
//            writer.name("author").value(author);
//            writer.name("publisher").value(publisher);
//            writer.name("year").value(year);
//            writer.name("pages").value(pages);
//            writer.name("cost").value(cost);
//            writer.endObject();
//
//            writer.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }


    /*public static void main(String[] args) {
        System.out.println("args = " + getBookFromJson());
    }*/


}
