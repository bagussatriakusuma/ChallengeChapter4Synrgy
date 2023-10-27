package com.example.challengechapter4.presentation.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.challenge4.database.NotesDatabase
import com.example.challengechapter4.data.local.NotesEntity
import com.example.challengechapter4.repository.NotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application): AndroidViewModel(application) {
    val readAllNotes: LiveData<List<NotesEntity>>
    private val repository: NotesRepository

    init {
        val notesDAO = NotesDatabase.getDatabase(application).notesDAO()
        repository = NotesRepository(notesDAO)
        readAllNotes = repository.readAllNotes
    }

    fun insertNotes(notes: NotesEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.addNotes(notes)
        }
    }

    fun updateNotes(notes: NotesEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateNotes(notes)
        }
    }

    fun deleteNotes(notes: NotesEntity){
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteNotes(notes)
        }
    }
}