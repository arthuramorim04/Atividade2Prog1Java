package com.arthuramorim.controller;


import com.arthuramorim.Main;
import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class JsonController {
    private List<FreteDemanda> listaDemanda;
    private List<FreteRegular> listaRegular;
    private List<Mercadoria> listaMercadoria;

    public void lerJSONMercadorias() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader filereader = new FileReader("mercadorias.json");

        TypeToken<List<Mercadoria>> tokenMercadoria = new TypeToken<List<Mercadoria>>(){};

         listaMercadoria = new ArrayList<Mercadoria>();

        listaMercadoria = gson.fromJson(filereader,tokenMercadoria.getType());

        if(listaMercadoria.isEmpty() || listaMercadoria == null){
            Main.getMain().setMercadorias(listaMercadoria);
        }

        filereader.close();

    }

    public void lerJSONDemanda() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader filereader = new FileReader("freteDemanda.json");

        TypeToken<List<FreteDemanda>> tokenDemanda = new TypeToken<List<FreteDemanda>>(){};

        listaDemanda = new ArrayList<FreteDemanda>();

        listaDemanda = gson.fromJson(filereader,tokenDemanda.getType());

        if(listaDemanda.isEmpty() || listaDemanda == null){
            Main.getMain().setDemanda(listaDemanda);
        }

        filereader.close();

    }

    public void lerJSONRegular() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileReader filereader = new FileReader("freteRegular.json");

        TypeToken<List<FreteRegular>> tokenRegular = new TypeToken<List<FreteRegular>>(){};

        listaRegular = new ArrayList<FreteRegular>();

        listaRegular = gson.fromJson(filereader,tokenRegular.getType());

        if(listaRegular.isEmpty() || listaRegular == null){
            Main.getMain().setRegular(listaRegular);
        }

        filereader.close();

    }

    public void salvarJSONRegular() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileWriter = new FileWriter("freteRegular.json");

        TypeToken<List<FreteRegular>> tokenRegular = new TypeToken<List<FreteRegular>>(){};

        listaRegular = new ArrayList<FreteRegular>();
        listaRegular = Main.getMain().getRegular();



        fileWriter.write(gson.toJson(listaRegular));


        fileWriter.close();

    }

    public void salvarJSONDemanda() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileWriter = new FileWriter("freteDemanda.json");

        TypeToken<List<FreteDemanda>> tokenRegular = new TypeToken<List<FreteDemanda>>(){};

        listaDemanda = new ArrayList<FreteDemanda>();
        listaDemanda = Main.getMain().getDemanda();



        fileWriter.write(gson.toJson(listaRegular));


        fileWriter.close();

    }
    public void salvarJSONMercadoria() throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter fileWriter = new FileWriter("mercadorias.json");

        TypeToken<List<Mercadoria>> tokenRegular = new TypeToken<List<Mercadoria>>(){};

        listaMercadoria = new ArrayList<Mercadoria>();
        listaMercadoria = Main.getMain().getMercadorias();



        fileWriter.write(gson.toJson(listaMercadoria));


        fileWriter.close();

    }


}
