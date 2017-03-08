package com.offcasoftware.databaseexample.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * @author maciej.pachciarek on 08.03.2017.
 */
@DatabaseTable (tableName = Person.TABLE_NAME)
public class Person {

    static final String TABLE_NAME = "person";

    @DatabaseField(columnName = "id",generatedId = true)
    private int mId;

    @DatabaseField(columnName = "name", canBeNull = false)
    private String mName;

    @DatabaseField (columnName = "country", canBeNull = false)
    private String mCountry;

    @DatabaseField (columnName = "clicked") // TODO: 2017-03-08 sprawdzić, dlaczego nie przyjmuje default 0 (int)
    private int mClicked;

    public Person(){

    }

    public Person(final int id, final String name, final String country, final int clicked) {
        mId = id;
        mName = name;
        mCountry = country;
        mClicked = clicked;
    }

    public int getId() {
        return mId;
    }

    public String getName() {
        return mName;
    }

    public String getCountry() {
        return mCountry;
    }

    public int getClicked() {
        return mClicked;
    }
}
