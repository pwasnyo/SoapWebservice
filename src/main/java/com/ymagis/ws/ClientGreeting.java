package com.ymagis.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author pwasnyo
 */
public class ClientGreeting {

    public static void main(String[] args) {
        final String SERVICE_ADDRESS = "http://localhost:8080/HelloWord/hello?wsdl";
        /* par Defaut c'est le package name(il peut être inversé comme dans ce cas) dans lequel se trouve 
        les foncions du webservice ou regarder dans le wsdl ce qu'il y'a dans la propriété targetNamespace */
        final String NAMESPACE = "http://ws.ymagis.com/";
        final String SERVICE_NAME = "HelloWorldImplService"; // voir la balise name dans le wsdl ou correspond au nom du fichier généré dans le dossier Web Services du projet

        List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Jean", 20, Greeting.French));
        persons.add(new Person("Peter", 30, Greeting.British));
        persons.add(new Person("Alves", 20, Greeting.Spanish));

        try {
            URL url = new URL(SERVICE_ADDRESS);
            QName qName = new QName(NAMESPACE, SERVICE_NAME);
            Service service = Service.create(url, qName);
            HelloWorld hello = service.getPort(HelloWorld.class);
            System.out.println(hello.getHelloWorldAsString());

            for (Person person : persons) {
                String greetingMessage = hello.greeting(person);
                System.out.println(greetingMessage);
            }

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
