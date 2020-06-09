package com.arthuramorim.manager;

import com.arthuramorim.JsonController;
import com.arthuramorim.Main;
import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;

import java.util.List;
import java.util.Scanner;

public class FreteManager {

    public Scanner sc;
    public Mercadoria mercadoria;
    public Main main;


    public void criaMercadoria(List<Mercadoria> list) {
        String descricao, tipo, nfs, orgaoInspetor, dataInspecao;
        Double peso;
        Boolean auditado;
        String opcAuditada;
        Integer id;

        System.out.println("Mercadoria: ");
        sc = new Scanner(System.in);
        System.out.println("\nTipo: ");
        tipo = sc.next();
        System.out.println("\nID: ");
        id = sc.nextInt();
        System.out.println("\nDescricao: ");
        descricao = sc.next();
        System.out.println("\nPeso em Kilos: ");
        peso = sc.nextDouble();
        System.out.println("\nNFS: ");
        nfs = sc.next();
        System.out.println("\nAuditada: S / N");
        opcAuditada = sc.next();
        if (opcAuditada.equalsIgnoreCase("s")) {
            auditado = true;
            System.out.println("\nOrgao Inspetor: ");
            orgaoInspetor = sc.next();
            System.out.println("\nData Inspecao: ");
            dataInspecao = sc.next();
            mercadoria = new Mercadoria(id, descricao, tipo, peso, nfs, auditado, orgaoInspetor, dataInspecao);

        } else {
            auditado = false;
            mercadoria = new Mercadoria(id, descricao, tipo, peso, nfs, auditado);

        }

        list.add(mercadoria);


    }

    public void novoFrete(List<FreteRegular> listRegular, List<FreteDemanda> listDemanda) {

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

        while (opcFrete < 1 || opcFrete > 2) {
            System.out.println("Escolha o tipo de frete: \n 1. Regular\n 2. Demanda\n");
            opcFrete = sc.nextInt();
        }

        if (opcFrete == 1) {
            System.out.println("\nQuantidade de Operacoes: S / N");
            quantidadeOperacoes = sc.nextInt();
            System.out.println("\nFrequencia de Operacoes: S / N");
            frequenciaOperacoes = sc.nextInt();
            System.out.println("\nUnidade de Frequencia( D - Dia / S- Semana / M - Mes / A - Ano): ");
            unidadeFrequencia = sc.next();
            tipoFrete = "Regular";

            FreteRegular freteRegular = new FreteRegular(tipoFrete, cidadeOrigem, cidadeDestino, distancia, unidadeFrequencia, quantidadeOperacoes, frequenciaOperacoes, id);
            listRegular.add(freteRegular);
        }
        if (opcFrete == 2) {

            System.out.println("\nData Postagem: ");
            dataPostagem = sc.next();
            System.out.println("\nPrevisao Entrega: ");
            previsaoEntrega = sc.next();
            tipoFrete = "Demanda";
            FreteDemanda freteDemanda = new FreteDemanda(tipoFrete, cidadeOrigem, cidadeDestino, distancia, dataPostagem, previsaoEntrega, id);
            listDemanda.add(freteDemanda);
        }


    }


    public void cadastrarMercadoria(List<FreteDemanda> listDemanda, List<FreteRegular> listRegular, List<Mercadoria> listMercadoria) {
        sc = new Scanner(System.in);

        System.out.println("\nQual tipo de fretamento deseja vincular uma mercadoria\n1. Regular \n2.Demanda\n");
        int opcTipo = 0;
        opcTipo = sc.nextInt();

        switch (opcTipo){
            case 1:{

                System.out.println("\nDigite o id do frete: ");
                int idFrete  = sc.nextInt();
                for(FreteRegular frete : listRegular){
                    if(frete.getId() == idFrete){
                        System.out.println("\n\n");
                        System.out.println("Digite o codigo da mercadoria que deseja vincular: ");
                        int idMercadoria = sc.nextInt();
                        for(Mercadoria merc : listMercadoria){
                            if(merc.getId() == idMercadoria){
                                frete.setMercadoria(merc);
                                break;
                            }
                        }
                    }
                }
                break;

            }
            case 2:{
                System.out.println("\nDigite o id do frete: ");
                int idFrete  = sc.nextInt();
                for(FreteDemanda frete : listDemanda){
                    if(frete.getId() == idFrete){
                        System.out.println("\n\n");
                        System.out.println("Digite o codigo da mercadoria que deseja vincular: ");
                        int idMercadoria = sc.nextInt();
                        for(Mercadoria merc : listMercadoria){
                            if(merc.getId() == idMercadoria){
                                frete.setMercadoria(merc);
                                break;
                            }
                        }
                    }
                }
                break;
            }
            default:
                System.out.println("\nOpcao invalida");
                break;
        }




    }


}
