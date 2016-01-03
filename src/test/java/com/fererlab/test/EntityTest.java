package com.fererlab.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityTest {

    public static void main(String[] args) {
        EntityTest entityTest = new EntityTest();
        entityTest.emTest();
    }

    private void emTest() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPU");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(new Book(1L, "first book"));
        Book book = entityManager.find(Book.class, 1L);
        System.out.println(book);
    }

}
