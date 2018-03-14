package com.example.isaque.rondadigital.model;

import android.support.annotation.Nullable;

import com.example.isaque.rondadigital.interfaces.Interfaces;
import com.example.isaque.rondadigital.requisicoes.Requisicoes;

/**
 * Created by isaque on 14/03/18.
 */

public abstract class ModelBasic implements Interfaces.ModelBasic {

    public static final int RESPONSE_OK = 200;
    public static final int RESPONSE_INTERNAL_ERROR = 500;
    public static final int RESPONSE_NOT_FOUND = 404;
    public static final int NOT_CONNECTED = 235;
    public static final int RESPONSE_DESCONHECIDO = -1;


    Requisicoes requisicao;

    public Requisicoes getRequisicao() {
        return requisicao == null ? requisicao = new Requisicoes(this) : requisicao;
    }
}
