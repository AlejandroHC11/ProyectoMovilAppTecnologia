package com.cibertec.lastore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class VentaAdapter (private val mList:List<Venta>):RecyclerView.Adapter<VentaAdapter.ViewHolder>(){
    class ViewHolder(ItemView: View):RecyclerView.ViewHolder(ItemView){
        val txtIdVenta : TextView = ItemView.findViewById(R.id.txtviewIdVenta)
        val txtCodPro : TextView = ItemView.findViewById(R.id.txtviewCodProducto)
        val txtNomPro : TextView = ItemView.findViewById(R.id.txtviewNomProducto)
        val txtMonto : TextView = ItemView.findViewById(R.id.txtviewMonto)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_venta, parent, false)
        return VentaAdapter.ViewHolder(view)
    }
    override fun getItemCount(): Int {
        return mList.size
    }
    override fun onBindViewHolder(holder: VentaAdapter.ViewHolder, position: Int) {
        val Venta = mList[position]
        holder.txtIdVenta.text = Venta.idVenta.toString()
        holder.txtCodPro.text = Venta.codpro.toString()
        holder.txtNomPro.text= Venta.nombrepro
        holder.txtMonto.text=Venta.monto.toString()


    }
}