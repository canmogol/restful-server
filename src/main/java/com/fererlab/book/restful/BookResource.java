package com.fererlab.book.restful;

import com.fererlab.book.model.Book;
import com.fererlab.book.serviceengine.BookService;

import javax.ejb.*;
import javax.ws.rs.*;

@Path("/book")
@Produces({"application/json"})
@Consumes({"application/json"})
//@Stateless
//@LocalBean
public class BookResource {

//    @Inject
//    @BookServiceQualifier
    @EJB(name = "BookServiceImpl")
    BookService bookService;

    @GET
    @Path("/findById/{id}")
    public Book findById(@PathParam("id") Long id) {
        Book book = bookService.findById(id);
        System.out.println("findById book to json: " + book);
        return book;
    }

    @GET
    @Path("/updateTitle/{id}/{title}")
    public Book updateTitle(@PathParam("id") Long id, @PathParam("title") String title) {
        Book book = bookService.updateTitle(id, title);
        System.out.println("updateTitle book to json: " + book);
        return book;
    }

    @GET
    @Path("/createBook/{title}/{description}")
    public Book createBook(@PathParam("title") String title,
                           @PathParam("description") String description
                           ) {
        Book book = bookService.createBook(title, description);
        System.out.println("createBook book to json: " + book);
        return book;
    }

}