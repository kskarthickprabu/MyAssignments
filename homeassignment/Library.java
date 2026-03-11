package org.testleaf.week2.homeassignment;

public class Library {

    public String addBook(String bookTitle){
        System.out.println("Book added successfully");
        return bookTitle;
    }

    public void issueBook(){
        System.out.println("Book issued successfully");
    }

    public static void main(String[] args) {

    Library book= new Library();
    book.addBook("Book added successfully");
    book.issueBook();
    
      
        }
    }

