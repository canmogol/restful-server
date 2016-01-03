package com.fererlab.book.serviceengine;

import com.fererlab.book.model.Book;

import javax.ejb.Local;

@Local
public interface BookService {

    Book findById(Long id);

    Book updateTitle(Long id, String title);

    Book createBook(String title, String description);

}
