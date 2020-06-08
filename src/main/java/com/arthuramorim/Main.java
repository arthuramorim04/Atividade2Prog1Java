package com.arthuramorim;

import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;
import com.arthuramorim.menu.MenuPrincipal;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private Gson gson;
    private List<FreteDemanda> demanda = new ArrayList<FreteDemanda>();
    private List<FreteRegular> regular = new ArrayList<FreteRegular>();
    private List<Mercadoria> mercadorias = new ArrayList<Mercadoria>();
    private static Main main;
    private static MenuPrincipal menuPrincipal;

    public static void main(String[] args) {
        main = new Main();
        menuPrincipal = new MenuPrincipal(main);

    }

    public Gson getGson() {
        return gson;
    }

    public List<FreteDemanda> getDemanda() {
        return demanda;
    }

    public List<FreteRegular> getRegular() {
        return regular;
    }

    public List<Mercadoria> getMercadorias() {
        return mercadorias;
    }

    public static Main getMain() {
        return main;
    }

    public void setDemanda(List<FreteDemanda> demanda) {
        this.demanda = demanda;
    }

    public void setRegular(List<FreteRegular> regular) {
        this.regular = regular;
    }

    public void setMercadorias(List<Mercadoria> mercadorias) {
        this.mercadorias = mercadorias;
    }


    public String toStringFrete() {
        return "Main{" +
                "regular=" + regular.toString() +
                "demanda=" + demanda.toString() +
                '}';
    }

    public String toStringMercadoria() {
        return "Main{" +
                "mercadorias=" + mercadorias.toString() +
                '}';
    }
}
