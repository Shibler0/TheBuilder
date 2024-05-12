package com.shibler.thefinalsjpc.db

import kotlinx.coroutines.flow.Flow

class LocalSourceDAO (private val buildDAO: builDAO){

    fun getAllEntity() : Flow<List<BuildEntity>> = buildDAO.getAllItems()

    fun insert(entity: BuildEntity) = buildDAO.insert(entity)

    suspend fun update(entity: BuildEntity) = buildDAO.update(entity)

    suspend fun delete(listName: String) = buildDAO.delete(listName)

    suspend fun deleteAll() = buildDAO.deleteAll()

    suspend fun getListWithClassNumber(classNumber: Int): List<ItemData> = buildDAO.getListWithClassNumber(classNumber)

    suspend fun getAllClassNumber(): List<Int> = buildDAO.getAllClassNumber()


}