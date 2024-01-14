package com.quickandroidapps.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.quickandroidapps.shoppinglist.data.db.entities.ShoppingItem
import com.quickandroidapps.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item.view.*

class ShoppingListAdapter (
    var items: List<ShoppingItem>,
    private val viewModel: ShoppingViewModel
        ): RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder>() {
        inner class ShoppingListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingListViewHolder {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item, parent, false)
                return ShoppingListViewHolder(view)
        }

        override fun onBindViewHolder(holder: ShoppingListViewHolder, position: Int) {
                val curShoppingItem = items[position]
                holder.itemView.tvName.text = curShoppingItem.name
                holder.itemView.tvAmount.text = "${curShoppingItem.amount}"

                holder.itemView.tvDelete.setOnClickListener {
                        viewModel.delete(curShoppingItem)
                }

                holder.itemView.tvPlus.setOnClickListener {
                        curShoppingItem.amount++
                        viewModel.upsert(curShoppingItem)
                }

                holder.itemView.tvMinus.setOnClickListener {
                        if (curShoppingItem.amount > 0) {
                                curShoppingItem.amount--
                                viewModel.upsert(curShoppingItem)
                        }
                }
        }

        override fun getItemCount(): Int {
                return items.size
        }


}