package com.ymagis.ws;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

//Service Endpoint Interface
@WebService
@SOAPBinding(style = Style.RPC)
public interface HelloWorld {

    @WebMethod
    String getHelloWorldAsString();

    @WebMethod
     /* targetNamespace par Defaut c'est le package name(il peut être inversé comme dans ce cas) dans lequel se trouve 
        les foncions du webservice ou regarder dans le wsdl ce qu'il y'a dans la propriété targetNamespace)
        className = "com.ymagis.ws.Person" le lieu de mon type complexe qui me sert de paramètre 
    */
    @RequestWrapper(targetNamespace = "http://ws.ymagis.com/", className = "com.ymagis.ws.Person")
    @ResponseWrapper(targetNamespace = "http://ws.ymagis.com/",className = "java.lang.String")
    String greeting(Person pers);
}
