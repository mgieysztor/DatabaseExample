package com.offcasoftware.databaseexample;

import android.app.Application;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.offcasoftware.databaseexample.database.Database;
import com.offcasoftware.databaseexample.database.DatabaseImpl;

import java.sql.SQLException;

/**
 * Created by RENT on 2017-03-08.
 */

public class AndroidApplication extends Application {

    private static Database mDatabase;


    @Override
    public void onCreate() {
        super.onCreate();
        mDatabase = OpenHelperManager.getHelper(this, DatabaseImpl.class);

        try {
            ((DatabaseImpl) mDatabase)
                    .getConnectionSource()
                    .getReadWriteConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Database getDatabase() {
        return mDatabase;
    }
}
