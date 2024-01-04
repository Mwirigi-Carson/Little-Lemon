package com.example.littlelemon

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase
import kotlinx.serialization.SerialName

@Entity
data class MenuItem(
    @PrimaryKey val id : Int,
    val title : String,
    val description : String,
    val price : String,
    val image : String,
    val category : String
)

@Dao
interface MenuDao{

}

@Database(entities = [MenuItem::class], version = 1)
abstract class MenuDatabase : RoomDatabase(){
    abstract fun menuDao() : MenuDao
}