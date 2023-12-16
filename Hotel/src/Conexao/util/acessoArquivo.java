/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao.util;


import DAO_hotel.Configuracao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 *
 * @author cesar
 */
public class acessoArquivo {

    public static void grava(Configuracao CF) {
        try {
            FileOutputStream arquivo = new FileOutputStream("lib/agenda.cfg");
            ObjectOutputStream fluxo = new ObjectOutputStream(arquivo);
            fluxo.writeObject(CF);
            fluxo.flush();
            System.out.println("Dados gravados com sucesso no arquivo agenda.cfg");
        } catch (Exception e) {
            System.out.println("Falha na gravação do arquivo" + (e));

        }

    }

    public static Configuracao le() {
        Configuracao CF = new Configuracao ();
        try {
            FileInputStream arquivo = new FileInputStream("lib/agenda.cfg");
            ObjectInputStream fluxo = new ObjectInputStream(arquivo);
            CF = (Configuracao) fluxo.readObject();
            System.out.println("Dados lidos com sucesso no arquivo dados.txt");
        } catch (Exception e) {
            System.out.println("Falha na leitura do arquivo" + (e));
        }
        return CF;
    }
}