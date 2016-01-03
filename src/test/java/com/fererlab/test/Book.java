package com.fererlab.test;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
// Access type for the entity class can be set as explicitly with @Access annotation, either FIELD or PROPERTY can be selected.
// The AccessType.FIELD means that the values will be written and read by direct field access,
// The AccessType.PROPERTY means that the values will be written and read by the setter and getter methods
//@Access(AccessType.FIELD)
//@Access(AccessType.PROPERTY)
public class Book {

    @Id
    // if the @Access annotation is not in place
    // and the @Id annotation is placed at field, Access type is FIELD,
    // if the @Id annotation is placed at the property which means it is placed at the getId method,
    // then the value value of Long id is accessed through setter and getter methods,
    // it means the Access type is set tot PROPERTY.
    private Long id;
    private String name;

    public Book(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // if the @Access annotation is not in place
    // and the @Id annotation is here, the default access type for the entity is PROPERTY,
    // meaning the read and write operations will be carried out by the methods not direct field access
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
