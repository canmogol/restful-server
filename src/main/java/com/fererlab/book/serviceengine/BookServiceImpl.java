package com.fererlab.book.serviceengine;

import com.fererlab.book.model.Book;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@BookServiceQualifier
@Stateless(name = "BookServiceImpl", mappedName = "BookServiceImpl")
public class BookServiceImpl implements BookService {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public Book findById(Long id) {
        Book book = entityManager.find(Book.class, id);
        System.out.println("service findById book: " + book);
        return book;
    }

    @Override
    public Book updateTitle(Long id, String title) {
        Book book = findById(id);
        book.setTitle(title);
        System.out.println("service updateTitle book: " + book);
        return book;
    }

    @Override
    public Book createBook(String title, String description) {
        Book book = new Book();
        book.setTitle(title);
        book.setDescription(description);
        System.out.println("service book before: " + book);
        entityManager.persist(book);
        System.out.println("service book after: " + book);
        return book;
    }

}
