package com.ariel.minhasanotaes

import android.content.Context
import android.content.SharedPreferences

class AnotacaoPreferencias {


    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor



    var NOME_ARQUIVO: String = "anotacao.preferencias"
    var CHAVE_NOME: String = "nome"

    fun anotacaoPreferencias(context: Context) {

        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0)
        editor = preferences.edit()

    }
    fun salvarAnotacao(anotacao: String){
        editor.putString(CHAVE_NOME, anotacao)
        editor.commit()
    }

    fun recuperarAnotacao(): String {
        return preferences.getString(CHAVE_NOME, "").toString()
    }



}