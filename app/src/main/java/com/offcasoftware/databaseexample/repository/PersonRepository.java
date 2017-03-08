package com.offcasoftware.databaseexample.repository;

import com.offcasoftware.databaseexample.model.Person;

import java.util.List;

/**
 * @author maciej.pachciarek on 08.03.2017.
 */

public interface PersonRepository {

    List<Person> getPersons();

}
