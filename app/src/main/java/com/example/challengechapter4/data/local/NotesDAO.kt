package com.example.challengechapter4.data.local

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDAO {
    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun readAllNotes(): LiveData<List<NotesEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addNotes(notes: NotesEntity)

    @Update
    fun updateNotes(notes: NotesEntity)

    @Delete
    fun deleteNotes(notes: NotesEntity)
}