package com.example.externalpractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bma_external.R
import com.example.bma_external.ViewAllPizza
import kotlinx.android.synthetic.main.viewallrecyclerstruct.view.*

class PizzaAdapter(val context: Context, var arr:ArrayList<Pizza>)
    : RecyclerView.Adapter<PizzaAdapter.ViewHolder>()

{

    class ViewHolder(var view: View): RecyclerView.ViewHolder(view)
    {
        fun bind(f:Pizza)
        {
            view.txtStructFId.setText(f.P_Id.toString())
            view.txtStructFName.setText(f.P_Name)
            view.txtStructFPrice.setText(f.P_Price.toString())
            view.txtStructFQty.setText(f.P_Qty.toString())
            view.txtStructFSize.setText(f.P_Size.toString())
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var inflater=LayoutInflater.from(parent.context)
        var view= inflater.inflate(R.layout.viewallrecyclerstruct,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arr[position])
        holder.view.imgUpdate.setOnClickListener {
            if(context is ViewAllPizza)
            {
                context.Update(position)
            }
        }
        holder.view.imgDelete.setOnClickListener {
            if(context is ViewAllPizza)
            {
                context.Delete(position)
            }
        }
    }

    override fun getItemCount(): Int {
        return arr.size
    }
}