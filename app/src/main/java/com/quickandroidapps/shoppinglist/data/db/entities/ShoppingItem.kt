package com.quickandroidapps.shoppinglist.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
class ShoppingItem(
    var name : String,
    var amount : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}