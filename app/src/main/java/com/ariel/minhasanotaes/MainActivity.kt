package com.ariel.minhasanotaes

import android.os.Bundle
import android.widget.EditText
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.ariel.minhasanotaes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var preferencias: AnotacaoPreferencias
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var editAnotacao = findViewById<EditText>(R.id.editAnotacao)
        preferencias = AnotacaoPreferencias()
        preferencias.anotacaoPreferencias(applicationContext)

        binding.fab.setOnClickListener { view ->
            val textoRecuperado: String = editAnotacao.text.toString()
            if (textoRecuperado == "") {
                Snackbar.make(view, "Por quê salvar um texto vazio?", Snackbar.LENGTH_LONG).show()
            } else {
                preferencias.salvarAnotacao(textoRecuperado)
                Snackbar.make(view, "Anotação salva! o/", Snackbar.LENGTH_LONG).show()
            }
        }

        val anotacao: String = preferencias.recuperarAnotacao()

        if (anotacao != "") {
            editAnotacao.setText(anotacao)
        }
    }

}
