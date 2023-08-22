package com.example.evaluacion_final.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "player")
@Parcelize
data class NbaPlayer(
    @PrimaryKey
    val id: Int,
    val name: String,
    val age: Int,
    val games:Int,
    @SerializedName("minutes_pg")
    val minutes_pg: String,
    @SerializedName("PTS")
    val PTS: String,
    val team: String,
    @SerializedName("field_percent")
    val field_percent: String,
    var isFavorite: Boolean = false
) : Parcelable

fun getDataPlayer(): List<NbaPlayer>{
    return listOf(
        NbaPlayer(1,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(2,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(3,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(4,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(5,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(6,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%"),
        NbaPlayer(7,"Kevin Porter Jr.", 22, 59, "34.30", "19.20", "HOU", "44.2%")
    )
}
