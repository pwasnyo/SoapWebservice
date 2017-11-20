
package com.ymagis.ws;

import javax.jws.WebService;

@WebService(endpointInterface = "com.ymagis.ws.HelloWorld")
//Impl de HelloWorldImpl n'est pas obligatoire puisque l'annotation au dessus se charge de faire le lien.
public class HelloWorldImpl implements HelloWorld {

    
    @Override
    public String getHelloWorldAsString() {
        return "Hello World JAX-WS";
    }
    
    @Override
    public String greeting(Person pers) {
        return pers.getGreeting()+" i'am "+pers.getName()+" from "+pers.getGreeting().name()+" i have "+pers.getOld()+" years old.";
    }
}
/* Il faut absolument la dépendance pour quer le webservice fonctionne

        <dependency>
            <groupId>com.sun.xml.ws</groupId>
            <artifactId>jaxws-rt</artifactId>
            <version>2.2.5</version>
        </dependency>
*/