package com.utkarsh.scientific.sarathi.selfHelpBooksPack;

public class BookModel {
    private String bookName, bookUrl;

    public BookModel() {
    }

    public BookModel(String bookName, String bookUrl) {
        this.bookName = bookName;
        this.bookUrl = bookUrl;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }
}
