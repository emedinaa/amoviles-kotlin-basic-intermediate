package com.kotlin.samples.kotlinapp.model.storage.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.kotlin.samples.kotlinapp.model.entity.Warike;

import java.util.List;

/**
 * @author : Eduardo Medina
 * @see : https://developer.android.com/index.html
 * @since : 6/8/18
 */

@Dao
public interface WarikeDao {

    @Insert
    void insert(Warike place);

    @Insert
    void insertAll(Warike... places);

    @Update
    void update(Warike place);

    @Update
    public void updateNotes(Warike... places);

    @Delete
    void delete(Warike place);

    @Delete
    public void deleteNotes(Warike... places);

    @Query("DELETE FROM tb_place")
    void deleteAll();

    @Query("SELECT * FROM tb_place")
    List<Warike> getAll();

    @Query("select count(*) from tb_place")
    long notesCounter();

    /*
    @Query("SELECT * FROM user WHERE age > :minAge")

    @Query("SELECT * FROM user WHERE age BETWEEN :minAge AND :maxAge")
    public User[] loadAllUsersBetweenAges(int minAge, int maxAge);

    @Query("SELECT * FROM user WHERE first_name LIKE :search "
           + "OR last_name LIKE :search")
    public List<User> findUserWithName(String search)
     */
}
