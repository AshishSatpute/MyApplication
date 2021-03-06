package com.melayer.roomsqlite;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.Entity;

@Database(entities = UserModel.class,version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context){
        if (INSTANCE== null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class,"user_db").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public abstract UserModelDao userDao();
}
