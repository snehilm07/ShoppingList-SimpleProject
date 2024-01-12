package com.quickandroidapps.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.quickandroidapps.shoppinglist.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDatabase: RoomDatabase() {

    abstract fun getShoppingDao(): ShoppingDao

    companion object {

        //We have to create only ONE instance of this database so the following mechanism is used
        @Volatile
        private var instance: ShoppingDatabase? = null
        private val LOCK = Any()

        //Operator is called when ever the instance of this class is made
        //LOGIC : if instance is null then it will go to synchronised block to make an instance of it
        //LOCK is used here so that only ONE thread can access it
        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ShoppingDatabase::class.java, "ShoppingDB.db").build()
    }
}