package com.cibertec.lastore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import android.widget.VideoView
import android.net.Uri
import android.widget.Button

class SobreNosotros : AppCompatActivity() {
    lateinit var videoView : VideoView;
    var urlVideo1: String = "https://media.istockphoto.com/id/1143705676/es/v%C3%ADdeo/joven-pareja-casada-hombre-y-mujer-en-aparatos-de-ropa-casual-tienda-elegir-comprar-lavadora.mp4?s=mp4-640x640-is&k=20&c=DT7RJ6oXSoNRPiE5ucNmDaqwnI2qOhDRm-c-xJ72dw0="
    var urlVideo2: String = "https://media.istockphoto.com/id/1305761853/es/v%C3%ADdeo/electrodom%C3%A9sticos.mp4?s=mp4-640x640-is&k=20&c=w9fOhdZkILBs2znbMEVBpel6l43zHQ8uyliK7UB2Brk="
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sobre_nosotros)

        val buttonAtras : Button = findViewById(R.id.btnAtras)
        buttonAtras.setOnClickListener {
            val MenuPrincipalWindow = Intent(this, MenuPrincipal::class.java)
            startActivity(MenuPrincipalWindow)
            finish()
        }

        videoView = findViewById(R.id.vdSobreUno)
        val uri: Uri = Uri.parse(urlVideo1)
        videoView.setVideoURI(uri)

        videoView = findViewById(R.id.vdSobreDos)
        val urii: Uri = Uri.parse(urlVideo2)
        videoView.setVideoURI(urii)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)
        mediaController.setMediaPlayer(videoView)
        videoView.setMediaController(mediaController)

        videoView.start()
    }
}