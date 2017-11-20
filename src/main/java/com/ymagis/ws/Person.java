package com.ymagis.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 Wrapper Bean il faut des setter et des getter pour les type complex
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD) // pour dire que les attribut et non les getters si je l'enlève il faut le mettre XmlElement sur les getter
public class Person {
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "old")
    private int old;
    @XmlElement(name = "greeting")
    private Greeting greeting;
    
    /**Constructeur par defaut obligatoire pour un type complexe dans un appel webservice**/
    public Person(){}
    public Person(String name, int old, Greeting greeting){
        this.name = name;
        this.old = old;
        this.greeting = greeting;
    }

    public String getName() {
        return name;
    }

    public int getOld() {
        return old;
    }

    public Greeting getGreeting() {
        return greeting;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public void setGreeting(Greeting greeting) {
        this.greeting = greeting;
    }
    
}
