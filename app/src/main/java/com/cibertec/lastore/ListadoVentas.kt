package com.cibertec.lastore

import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.json.responseJson
import com.google.android.material.textfield.TextInputEditText
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject

class ListadoVentas : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_ventas)

        val btnAtras : Button = findViewById(R.id.btnAtras)

        btnAtras.setOnClickListener {
            val MenuPrincipalWindow = Intent(this, MenuPrincipal::class.java)
            startActivity(MenuPrincipalWindow)
            finish()
        }


        val recycleViewVentas : RecyclerView = findViewById(R.id.lstVentas)
        recycleViewVentas.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<Venta>();

        val adapter = VentaAdapter(data)
        recycleViewVentas.adapter = adapter

        val ipServicio = getString(R.string.ipServicio)
        Fuel.get("https://${ipServicio}/GetVenta")
            .header("Content-Type", "application/json;charset=utf-8")
            .responseJson { _, _, result ->
                result.fold(
                    success = { json ->
                        try {
                            val gson = Gson()
                            val tipoListaVenta = object : TypeToken<List<Venta>>() {}.type
                            val listaVenta: List<Venta> = gson.fromJson(json.content, tipoListaVenta)
                            listaVenta?.let {
                                data.clear()
                                data.addAll(it)
                                adapter.notifyDataSetChanged()
                            }
                        } catch (e: Exception) {
                            showDialog("Error de JSON parse")
                        }
                    },
                    failure = { error ->
                        showDialog("Error de conexion")
                    }
                )
            }

    }
    private fun showDialog(mensaje: String){
        val dialogConfirm = Dialog(this)
        dialogConfirm.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialogConfirm.setCancelable(false)
        dialogConfirm.setContentView(R.layout.dialog_mensaje)

        dialogConfirm.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val modalMessageTextView: TextView = dialogConfirm.findViewById(R.id.textViewMensaje)
        modalMessageTextView.text = mensaje

        val btnDialogAceptar : Button = dialogConfirm.findViewById(R.id.btnDialogAceptar)

        btnDialogAceptar.setOnClickListener {
            dialogConfirm.dismiss()
        }

        dialogConfirm.show()
    }
}