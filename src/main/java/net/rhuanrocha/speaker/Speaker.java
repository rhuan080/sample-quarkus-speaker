package net.rhuanrocha.speaker;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class Speaker extends PanacheEntity {

    public String name;
    public String minibio;
    public String idEvent;

}
