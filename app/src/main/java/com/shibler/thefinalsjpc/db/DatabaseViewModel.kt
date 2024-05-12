package com.shibler.thefinalsjpc.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DatabaseViewModel(private val repository : Repository) : ViewModel() {

    val allItems: LiveData<List<BuildEntity>> = repository.allSources.asLiveData()

    fun insert(buildEntity: BuildEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.insert(buildEntity)
        }
    }

    suspend fun delete(id: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.delete(id)
        }
    }

    suspend fun update(buildEntity: BuildEntity) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.update(buildEntity)
        }
    }

    suspend fun deleteAll() = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            repository.deleteAll()
        }
    }

    suspend fun getListWithClassNumber(classNumber: Int): List<ItemData> = withContext(Dispatchers.IO) {
            repository.getListWithClassNumber(classNumber)
        }


    suspend fun getAllClassNumber(): List<Int> = withContext(Dispatchers.IO) {
        repository.getAllClassNumber()
    }

}