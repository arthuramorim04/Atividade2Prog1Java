package com.arthuramorim.menu;

import com.arthuramorim.JsonController;
import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;
import com.arthuramorim.manager.FreteManager;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuPrincipal {
    private FreteManager freteManager;

    public List<FreteDemanda> listDemandaPrincipal;
    public List<FreteRegular> listRegularPrincipal;
    public List<Mercadoria> listMercadoriaPrincipal;
    public Gson gson = new Gson();


    public void menu() throws Exception {

        listDemandaPrincipal = new ArrayList<FreteDemanda>();
        listRegularPrincipal = new ArrayList<FreteRegular>();
        listMercadoriaPrincipal = new ArrayList<Mercadoria>();

        freteManager = new FreteManager();

        JsonController.loadLists(listDemandaPrincipal, listRegularPrincipal, listMercadoriaPrincipal);
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n" +
                    "1. Cadastrar mercadoria.\n" +
                    "2.Cadastrar frete\n" +
                    "3.Mostrar fretes cadastrados\n" +
                    "4.Mostrar mercadorias cadastradass\n" +
                    "5.Vincular mercadoria ao frete\n" +
                    "6.Sair do sistema."
            );

            Scanner sc = new Scanner(System.in);
            int opc = 0;
            opc = sc.nextInt();

            switch (opc) {
                case 1: {
                    freteManager.criaMercadoria(listMercadoriaPrincipal);
                    break;
                }
                case 2: {
                    freteManager.novoFrete(listRegularPrincipal, listDemandaPrincipal);
                    break;
                }
                case 3: {
                    System.out.println(gson.toJson(listDemandaPrincipal));
                    System.out.println(gson.toJson(listRegularPrincipal));
                    break;
                }
                case 4: {
                    System.out.println(gson.toJson(listMercadoriaPrincipal));
                    break;
                }
                case 5: {
                    freteManager.cadastrarMercadoria(listDemandaPrincipal, listRegularPrincipal, listMercadoriaPrincipal);
                    break;
                }
                case 0: {
                    JsonController.saveLists(listDemandaPrincipal, listRegularPrincipal, listMercadoriaPrincipal);
                    continuar = false;
                }

            }

        }
    }

    public List<FreteDemanda> getListDemandaPrincipal() {
        return listDemandaPrincipal;
    }

    public void setListDemandaPrincipal(List<FreteDemanda> listDemandaPrincipal) {
        this.listDemandaPrincipal = listDemandaPrincipal;
    }

    public List<FreteRegular> getListRegularPrincipal() {
        return listRegularPrincipal;
    }

    public void setListRegularPrincipal(List<FreteRegular> listRegularPrincipal) {
        this.listRegularPrincipal = listRegularPrincipal;
    }

    public List<Mercadoria> getListMercadoriaPrincipal() {
        return listMercadoriaPrincipal;
    }

    public void setListMercadoriaPrincipal(List<Mercadoria> listMercadoriaPrincipal) {
        this.listMercadoriaPrincipal = listMercadoriaPrincipal;
    }

}
