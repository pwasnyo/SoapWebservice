package com.ymagis.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;

/**
 *
 * @author pwasnyo
 */
@XmlEnum(String.class)
public enum Greeting {
    @XmlEnumValue("french")
    French("Bonjour"),
    @XmlEnumValue("british")
    British("Hello"),
    @XmlEnumValue("spanish")
    Spanish("Buenos Dias");

    private String greeting;

    Greeting(String greeting) {
        this.greeting = greeting;
    }
    
    public String toString(){
        return this.greeting;
    }
}
