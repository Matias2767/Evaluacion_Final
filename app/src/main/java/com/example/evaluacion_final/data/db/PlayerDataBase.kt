package com.example.evaluacion_final.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.evaluacion_final.model.NbaPlayer

@Database(entities = [NbaPlayer::class], version = 1)
abstract class PlayerDataBase: RoomDatabase() {
    abstract fun nbaPlayerDao(): NbaPlayerDao

    companion object {
        @Volatile
        private var instance: PlayerDataBase? = null
        fun getDatabase(context: Context): PlayerDataBase{
            if(instance == null){
                synchronized(this){
                    instance = buildDatabase(context)
                }
            }
            return instance!!
        }
        private fun buildDatabase(context: Context): PlayerDataBase? {
            return Room.databaseBuilder(
                context.applicationContext,
                PlayerDataBase::class.java,
                "nba_players_database"
            ).build()
        }
    }

}