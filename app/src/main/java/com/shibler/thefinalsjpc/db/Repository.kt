package com.shibler.thefinalsjpc.db

import kotlinx.coroutines.flow.Flow

class Repository (private val localSourceDAO: LocalSourceDAO){

    val allSources: Flow<List<BuildEntity>> = localSourceDAO.getAllEntity()

    fun insert(buildEntity: BuildEntity){
        localSourceDAO.insert(buildEntity)
    }

    suspend fun delete(listName: String){
        localSourceDAO.delete(listName)
    }

    suspend fun update(buildEntity: BuildEntity){
        localSourceDAO.update(buildEntity)
    }

    suspend fun deleteAll(){
        localSourceDAO.deleteAll()
    }

    suspend fun getListWithClassNumber(classNumber: Int): List<ItemData> {
        return localSourceDAO.getListWithClassNumber(classNumber)
    }

    suspend fun getAllClassNumber(): List<Int> {
        return localSourceDAO.getAllClassNumber()
    }


}