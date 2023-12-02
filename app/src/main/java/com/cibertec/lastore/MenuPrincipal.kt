package com.cibertec.lastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenuPrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val buttonVerProductos : Button = findViewById(R.id.btnProductos)
        val buttonVerUsuarios : Button = findViewById(R.id.btnUsuarios)
        val buttonSalir : Button = findViewById(R.id.btnSalir)
        val buttonVentas: Button = findViewById(R.id.btnVentas)
        val buttonSobreNosotros: Button = findViewById(R.id.btnSobreNosotros)

        buttonSobreNosotros.setOnClickListener{
            val sobrenosotros = Intent(this,SobreNosotros::class.java)
            startActivity(sobrenosotros)
        }

        buttonVerProductos.setOnClickListener{
            val ListadoProductosWindow = Intent(this, ListadoProductos::class.java)
            startActivity(ListadoProductosWindow)
        }

        buttonVerUsuarios.setOnClickListener {
            val ListadoUsuariosWindow = Intent(this, ListadoUsuarios::class.java)
            startActivity(ListadoUsuariosWindow)
        }

        buttonSalir.setOnClickListener {
            val InicioWindow = Intent(this,Inicio::class.java)
            startActivity(InicioWindow)
            finish()
        }
        buttonVentas.setOnClickListener{
            val ListadoVentasWindow=Intent(this, ListadoVentas::class.java)
            startActivity(ListadoVentasWindow)
        }
    }
}