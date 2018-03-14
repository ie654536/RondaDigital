package com.example.isaque.rondadigital.model;

import android.support.annotation.Nullable;

import com.example.isaque.rondadigital.objetos.Usuario;

/**
 * Created by isaque on 14/03/18.
 */

public class ModelUsuario extends ModelBasic {


    ListenerWhenAutenticado escuta;



    public void tentarAutenticar(ListenerWhenAutenticado escutar, Usuario usuario) {
        this.escuta = escutar;

        new Thread(new Runnable() {
            @Override
            public void run() {

                //faz requisicao

                //para pegar o objeto que faz requisicoes por rede:
                //getRequisicao()
                //use os metodos do getRequisicao() para requerer por redere
                //exemplo, para pegar um GET simples do servidor//

                int PARAM_QUALQUER = 1;
                getRequisicao().get( PARAM_QUALQUER , Usuario.class , "caminhos do servidor" );


            }
        }).start();
    }

    @Override
    public void onDadosReceives(int param, @Nullable Object object, int responseCode) {
        boolean autenticou;

        //200 e o numero padrao de resposta ok de um servidor http
        //404 nao encontrado
        //500 erro
        //existe uma lista gigantesca de parametros que podem ser retornados no responseCode
        if(param == 1) {
            if( responseCode == 200 ) {
                autenticou = true;
            } else {
                autenticou = false;
            }

            escuta.whenFinish( autenticou );

        }

    }
}
