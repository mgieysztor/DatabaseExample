package com.offcasoftware.databaseexample.net;

import com.offcasoftware.databaseexample.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author maciej.pachciarek on 08.03.2017.
 */

public class PersonServiceImpl implements PersonService {

    private static final int PERSON_COUNT = 100;

    private final List<Person> mPersons;

    private final String[] mNames = {"Antoni", "Jakub", "Szymon", "Jan", "Filip",
            "Franciszek", "Mikolaj", "Aleksander", "Kacper", "Wojciech",
            "Adam", "Michal", "Marcel", "Wiktor", "Stanislaw",
            "Bartosz", "Mateusz", "Igor", "Nikodem", "Alan"};
    private final String[] mCountry = {"Polska", "Niemcy", "Czechy", "Francja", "Szwecja",
            "Dania", "Finlandia", "Grecja", "Hiszpania", "Wlochy"};

    private Random mRandom;

    public PersonServiceImpl() {
        mPersons = new ArrayList<>();
        mRandom = new Random();

        for (int i = 0; i < PERSON_COUNT; i++) {
            int index = mRandom.nextInt(mNames.length);
            int index2 = mRandom.nextInt(mCountry.length);
            mPersons.add(createPerson(i, mNames[index], mCountry[index2]));
        }
    }

    @Override
    public List<Person> downloadPersons() {
        return mPersons;
    }

    private Person createPerson(int id, String name, String country) {
        return new Person(id, name, country, 0);
    }
}
