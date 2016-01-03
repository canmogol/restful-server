package com.fererlab.book.model;

import javax.persistence.*;


@Entity
@Table(name = "TABLE_BOOK")
public class Book {

    private Long id;

    private String title;

    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        System.out.println("Book.getId " + id);
        return id;
    }

    public void setId(Long id) {
        System.out.println("Book.setId this.id: " + this.id + " id: " + id);
        this.id = id;
    }

    @Column(name = "B_TITLE", length = 50)
    public String getTitle() {
        System.out.println("Book.getTitle " + title);
        return title;
    }

    public void setTitle(String title) {
        System.out.println("Book.setTitle this.title: " + this.title + " title: " + title);
        this.title = title;
    }

    @Column(name = "B_DESC", length = 2000)
    public String getDescription() {
        System.out.println("Book.getDescription " + description);
        return description;
    }

    public void setDescription(String description) {
        System.out.println("Book.setDescription this.description: " + this.description + " description: " + description);
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
