package com.scrummaster.arboretocarmelopalma.utils

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.scrummaster.arboretocarmelopalma.R
import com.scrummaster.arboretocarmelopalma.model.Tree
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_tree.view.*

class AdapterTree () : RecyclerView.Adapter<AdapterTree.ViewHolder>() {

    lateinit var items: ArrayList<Tree>

    fun setTree (items: List<Tree>){
        this.items = items as ArrayList<Tree>
        notifyDataSetChanged()
    }

    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each picture to
        val treeImg: ImageView = view.tree_img
        val nombre: TextView = view.nombre
        val descripcion: TextView = view.descripcion
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_tree, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model= items[position]
        holder.nombre.text = model.name
        holder.descripcion.text = model.description
        Picasso.get()
            .load(model.image)
            .into(holder.treeImg)
    }

    override fun getItemCount(): Int {
        return if(::items.isInitialized){
            items.size
        }else{
            0
        }
    }
}