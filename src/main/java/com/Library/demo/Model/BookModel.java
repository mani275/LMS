package com.Library.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Table
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bookID;
    @Column(name = "bookTitle")
    private String bookTitle;
    @Column(name = "publisher")
    private String publisher;
    @Column(name = "status")
    private boolean status;
    @Column(name = "borrower")
    private String borrower;
    @Column(name = "borrowDate")
    private Date borrowDate;

    public BookModel() {
    }

    public BookModel(String bookTitle, String publisher, boolean status, String borrower, Date borrowDate) {
        this.bookTitle = bookTitle;
        this.publisher = publisher;
        this.status = status;
        this.borrower = borrower;
        this.borrowDate = borrowDate;
    }

    public long getBookID() {
        return bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStatus() {
        return status;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }
}
