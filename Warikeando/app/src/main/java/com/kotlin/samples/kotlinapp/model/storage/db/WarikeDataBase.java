package com.kotlin.samples.kotlinapp.model.storage.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import com.kotlin.samples.kotlinapp.model.entity.Warike;


/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 6/8/18
 */
@Database(entities = {Warike.class}, version = 1)
public abstract class WarikeDataBase extends RoomDatabase{

    public abstract WarikeDao warikeDao();

    private static WarikeDataBase INSTANCE;

    public static WarikeDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WarikeDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WarikeDataBase.class, "BDWarike")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    /**
     * Override the onOpen method to populate the database.
     * For this sample, we clear the database every time it is created or opened.
     */
    private static Callback sRoomDatabaseCallback = new Callback(){

        @Override
        public void onOpen (@NonNull SupportSQLiteDatabase db){
            super.onOpen(db);
            // If you want to keep the data through app restarts,
            // comment out the following line.
            //clearNotes(INSTANCE);
        }

    };

    private static void clearPlaces(@NonNull WarikeDataBase db) {
        WarikeDao warikeDao= db.warikeDao();
        warikeDao.deleteAll();
    }
}
