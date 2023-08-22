package com.example.evaluacion_final.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.evaluacion_final.model.NbaPlayer


@Dao
interface NbaPlayerDao {

    @Query("SELECT * FROM player")
    fun getFavorites(): List<NbaPlayer>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFavorite(player: NbaPlayer)

    @Delete
    suspend fun deleteFavorite(player: NbaPlayer)
}