package com.example.challengechapter4.repository

import androidx.lifecycle.LiveData
import com.example.challengechapter4.data.local.NotesDAO
import com.example.challengechapter4.data.local.NotesEntity

class NotesRepository(private val notesDAO: NotesDAO) {
    val readAllNotes: LiveData<List<NotesEntity>> = notesDAO.readAllNotes()

    suspend fun addNotes(notes: NotesEntity){
        notesDAO.addNotes(notes)
    }

    suspend fun updateNotes(notes: NotesEntity){
        notesDAO.updateNotes(notes)
    }

    suspend fun deleteNotes(notes: NotesEntity){
        notesDAO.deleteNotes(notes)
    }

}