package com.shibler.thefinalsjpc.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface builDAO {

    @Update
    suspend fun update(entity: BuildEntity)

    @Query("SELECT * FROM BuildList_table")
    fun getAllItems(): Flow<List<BuildEntity>>

    @Query ("SELECT classNumber FROM BuildList_table ")
    suspend fun getAllClassNumber(): List<Int>

    @Query("SELECT image FROM BuildList_table WHERE classNumber = :classNumber")
    suspend fun getListWithClassNumber(classNumber: Int): List<ItemData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity: BuildEntity)

    @Query("DELETE FROM BuildList_table WHERE listName = :id")
    suspend fun delete(id : String)

    @Query("DELETE FROM BuildList_table")
    suspend fun deleteAll()
}