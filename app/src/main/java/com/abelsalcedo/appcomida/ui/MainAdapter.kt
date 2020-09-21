package com.abelsalcedo.appcomida.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.recyclerview.widget.RecyclerView
import com.abelsalcedo.appcomida.R
import com.abelsalcedo.appcomida.base.BaseViewHolder
import com.abelsalcedo.appcomida.data.model.Eat
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.comidas_row.view.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainAdapter(private val context: Context, private val comidaList: List<Eat>,
            private val itemClickLister:OnComidaClickListener) :

    RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnComidaClickListener{
        fun onComidaClick(eat: Eat)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return MainViewHolder(
            LayoutInflater.from(context).inflate(R.layout.comidas_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return comidaList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(comidaList[position], position)
        }
    }

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Eat>(itemView) {
        override fun bind(item: Eat, position: Int) {
            Glide.with(context).load(item.imagen).centerCrop().into(itemView.img_comida)
            itemView.txt_titulo.text = item.nombre
            itemView.txt_descripcion.text = item.descripcion
            itemView.setOnClickListener {itemClickLister.onComidaClick(item)}
        }
    }
}