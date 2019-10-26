package mx.edu.utng.sharepreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Context
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("agenda",Context.MODE_PRIVATE)


        btnGuardar.setOnClickListener {
            //Objeto para edicion
            val editor = preferencias.edit()
            editor.putString(etxtNombre.text.toString(),
                            etxtDatos.text.toString())

            editor.commit()
            Toast.makeText(this, "Dates saved",Toast.LENGTH_LONG).show()
            etxtNombre.setText("")
            etxtDatos.setText("")
        }

        btnRecuperar.setOnClickListener {
            val datos = preferencias.getString(etxtNombre.text.toString(), "")
            if (datos.isNullOrEmpty()) {
                Toast.makeText(this, "No found" , Toast.LENGTH_LONG).show()
            }else {
                etxtDatos.setText(datos)
            }


        }
    }
}
