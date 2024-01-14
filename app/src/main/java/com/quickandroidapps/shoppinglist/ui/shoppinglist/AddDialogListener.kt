package com.quickandroidapps.shoppinglist.ui.shoppinglist

import com.quickandroidapps.shoppinglist.data.db.entities.ShoppingItem

interface AddDialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}