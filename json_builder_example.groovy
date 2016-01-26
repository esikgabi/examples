package com.example.groovy

import groovy.json.JsonBuilder  
import groovy.json.JsonSlurper  
import groovy.transform.ToString

/**
 * Created by rhasija on 1/15/16.
 * Modified by esikgabi on 1/26/16.
**/

    // Person object
    def person = new Person(firstName: "John", lastName: "Doe", emails: ["john.doe@gmail.com", "johndoe@gmail.com"])
    // Json String
    def personJSON = new JsonBuilder(person).toPrettyString()
    // Json String to Map
    def personMap = new JsonSlurper().parseText(personJSON)
    // using Map to convert to Person object type
    def newPerson = new Person(personMap)
    
    assert newPerson.firstName.equals(person.firstName)
    assert newPerson.lastName.equals(person.lastName)
    assert newPerson.emails.equals(person.emails)
    
    println("original object: $person")
    println("\nobject in json:\n$personJSON\n")
    println("object from json: $newPerson")

@ToString
class Person {  
    String firstName
    String lastName
    List emails
}
