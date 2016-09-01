package io.pivotal.microservices.domain;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class History {

    @Id
    Long id;
    String expression;
    String result;

}
