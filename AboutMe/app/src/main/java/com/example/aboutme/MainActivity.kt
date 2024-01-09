package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("emi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener { addNickname(it) }
        binding.doneButton.setOnClickListener { addNickname(it) }
    }

    private fun addNickname(view: View) {
        //val editText = findViewById<EditText>(R.id.nickname_edit)
        //val nickNameTextView = findViewById<TextView>(R.id.nickname_text)

        /*
        binding.apply { ... }: Esto es una extensión de Kotlin llamada apply. La función apply toma un objeto y le permite ejecutar un bloque de código en el contexto de ese objeto.
        En este caso, binding.apply se utiliza para aplicar una serie de operaciones en el objeto binding.
         */
        binding.apply {
        //binding.nicknameText.text = binding.nicknameEdit.text
        /*
        invalidateAll(): Esta función se usa para indicar al sistema de enlace de datos que debe invalidar todas las asignaciones y forzar una actualización de la interfaz de usuario.
        En el contexto de Android Data Binding, invalidateAll() es comúnmente usado para notificar a la interfaz de usuario que los datos subyacentes han cambiado y que debe volver a evaluar
        todas las expresiones de enlace.
         */
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            binding.nicknameEdit.visibility = View.GONE
            binding.doneButton.visibility = View.GONE
            binding.nicknameText.visibility = View.VISIBLE
        }
        //hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}