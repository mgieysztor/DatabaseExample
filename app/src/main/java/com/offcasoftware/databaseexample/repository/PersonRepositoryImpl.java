package com.offcasoftware.databaseexample.repository;

import android.provider.ContactsContract;

import com.offcasoftware.databaseexample.AndroidApplication;
import com.offcasoftware.databaseexample.database.Database;
import com.offcasoftware.databaseexample.model.Person;
import com.offcasoftware.databaseexample.net.PersonService;
import com.offcasoftware.databaseexample.net.PersonServiceImpl;

import java.util.List;

/**
 * @author maciej.pachciarek on 08.03.2017.
 */

public class PersonRepositoryImpl implements PersonRepository {

    private static final PersonRepositoryImpl ourInstance = new PersonRepositoryImpl();

    public static PersonRepositoryImpl getInstance() {
        return ourInstance;
    }

    private PersonService mPersonService;
    Database mDatabase;


    private PersonRepositoryImpl() {
        mPersonService = new PersonServiceImpl();
        mDatabase = AndroidApplication.getDatabase();
    }

    @Override
    public List<Person> getPersons() {
        return mPersonService.downloadPersons();
    }
}
