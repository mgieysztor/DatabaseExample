package com.offcasoftware.databaseexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.offcasoftware.databaseexample.model.Person;

import java.sql.SQLException;

/**
 * Created by RENT on 2017-03-08.
 */

public class DatabaseImpl extends OrmLiteSqliteOpenHelper implements Database {

    private static final String DATABASE_NAME = "people_database";
    private static final int DATABASE_VERSION = 1;

    private RuntimeExceptionDao<Person, Integer> mPersonDAO;

    public DatabaseImpl(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

        mPersonDAO = getRuntimeExceptionDao(Person.class);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, Person.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }
}
