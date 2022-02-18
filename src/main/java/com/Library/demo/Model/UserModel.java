package com.Library.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "bookIssue1")
    private String bookIssue1 = "";
    @Column(name = "bookIssueDate1")
    private String bookIssueDate1 = "";
    @Column(name = "bookIssue2")
    private String bookIssue2 = "";
    @Column(name = "bookIssueDate2")
    private String bookIssueDate2 = "";

    public UserModel() {
    }

    public UserModel(String userName, String bookIssue1, String bookIssueDate1, String bookIssue2, String bookIssueDate2) {
        this.userName = userName;
        this.bookIssue1 = bookIssue1;
        this.bookIssueDate1 = bookIssueDate1;
        this.bookIssue2 = bookIssue2;
        this.bookIssueDate2 = bookIssueDate2;
    }

    public UserModel(String userName, String bookIssue1, String bookIssue2) {
        this.userName = userName;
        this.bookIssue1 = bookIssue1;
        this.bookIssue2 = bookIssue2;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookIssue1() {
        return bookIssue1;
    }

    public void setBookIssue1(String bookIssue1) {
        this.bookIssue1 = bookIssue1;
    }

    public String getBookIssueDate1() {
        return bookIssueDate1;
    }

    public void setBookIssueDate1(String bookIssueDate1) {
        this.bookIssueDate1 = bookIssueDate1;
    }

    public String getBookIssue2() {
        return bookIssue2;
    }

    public void setBookIssue2(String bookIssue2) {
        this.bookIssue2 = bookIssue2;
    }

    public String getBookIssueDate2() {
        return bookIssueDate2;
    }

    public void setBookIssueDate2(String bookIssueDate2) {
        this.bookIssueDate2 = bookIssueDate2;
    }

    @Override
    public String toString() {
        return "User [id=" + id + " username= " + userName + "]";
    }
}
