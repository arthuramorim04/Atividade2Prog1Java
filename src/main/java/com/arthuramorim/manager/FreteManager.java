package com.arthuramorim.manager;

import com.arthuramorim.Main;
import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;

import java.util.Scanner;

public class FreteManager {

    private Scanner sc;
    private Mercadoria mercadoria;
    private static Main main;




    public void criaMercadoria() {
        String descricao,tipo,nfs,orgaoInspetor,dataInspecao;
        Double peso;
        Boolean auditado;
        String opcAuditada;

        System.out.println("Mercadoria: ");
        sc = new Scanner(System.in);
        System.out.println("\nTipo: ");
        tipo = sc.next();
        System.out.println("\nDescricao: ");
        descricao = sc.next();
        System.out.println("\nPeso em Kilos: ");
        peso = sc.nextDouble();
        System.out.println("\nNFS: ");
        nfs = sc.next();
        System.out.println("\nAuditada: S / N");
        opcAuditada = sc.next();
        if(opcAuditada.equalsIgnoreCase("s")){
            auditado = true;
            System.out.println("\nOrgao Inspetor: ");
            orgaoInspetor = sc.next();
            System.out.println("\nData Inspecao: ");
            dataInspecao = sc.next();
            mercadoria = new Mercadoria(descricao,tipo,peso,nfs,auditado,orgaoInspetor,dataInspecao);

        }else{
            auditado = false;
            mercadoria = new Mercadoria(descricao,tipo,peso,nfs,auditado);

        }

        Main.getMain().getMercadorias().add(mercadoria);

    }

    public void novoFrete() {
        System.out.println("\nInforme o tipo de fretamento desejado: ");

        String tipoFrete;
        String cidadeOrigem;
        String cidadeDestino;
        String unidadeFrequencia;
        Double distancia;
        Integer quantidadeOperacoes;
        Integer frequenciaOperacoes;
        String dataPostagem;
        String previsaoEntrega;
        Integer id = -1;
        int opcFrete = 0;

        sc = new Scanner(System.in);
        System.out.println("\nInforme o id desse frete: ");
        id = sc.nextInt();
        System.out.println("\nCidade de Origem: ");
        cidadeOrigem = sc.next();
        System.out.println("\nCidade Destino: ");
        cidadeDestino = sc.next();
        System.out.println("\nDistancia: ");
        distancia = sc.nextDouble();

        while (opcFrete < 1 || opcFrete > 2){
            System.out.println("Escolha o tipo de frete: \n 1. Regular\n 2. Demanda\n");
            opcFrete = sc.nextInt();
        }

        if(opcFrete == 1){
            System.out.println("\nQuantidade de Operacoes: S / N");
            quantidadeOperacoes = sc.nextInt();
            System.out.println("\nFrequencia de Operacoes: S / N");
            frequenciaOperacoes = sc.nextInt();
            System.out.println("\nUnidade de Frequencia( D - Dia / S- Semana / M - Mes / A - Ano): ");
            unidadeFrequencia = sc.next();
            tipoFrete = "Regular";

            FreteRegular freteRegular = new FreteRegular(tipoFrete,cidadeOrigem,cidadeDestino,distancia,unidadeFrequencia,quantidadeOperacoes,frequenciaOperacoes,id);
            Main.getMain().getRegular().add(freteRegular);
        }
        if (opcFrete == 2){

            System.out.println("\nData Postagem: ");
            dataPostagem = sc.next();
            System.out.println("\nPrevisao Entrega: ");
            previsaoEntrega = sc.next();
            tipoFrete = "Demanda";
            FreteDemanda freteDemanda = new FreteDemanda(tipoFrete,cidadeOrigem,cidadeDestino,distancia,dataPostagem,previsaoEntrega,id);
            Main.getMain().getDemanda().add(freteDemanda);
        }




    }


    public void cadastrarMercadoria(){
        sc = new Scanner(System.in);

        System.out.println("\nQual tipo de fretamento deseja vincular uma mercadoria\n1. Reguar \n2.Demanda\n");
        int opcTipo = 0;
        opcTipo = sc.nextInt();


        if(opcTipo == 1)
        System.out.println("\nDigite o nome codigo do frete que deseja vincular uma mercadoria:");

        Integer id;
        id = sc.nextInt();

        main.get

    }



}
