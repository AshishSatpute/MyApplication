package com.melayer.roomsqlite;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by ashish on 13/2/18.
 */

@Dao
public interface UserModelDao {

    @Query("SELECT * FROM UserModel")
    List<UserModel> getAll();

    @Insert
   void addUser(UserModel userModel);

    @Delete
    void  deleteUser(UserModel userModel);
}
