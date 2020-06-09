package com.arthuramorim;


import com.arthuramorim.entity.FreteDemanda;
import com.arthuramorim.entity.FreteRegular;
import com.arthuramorim.entity.Mercadoria;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonController {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();


    public static void loadLists(List<FreteDemanda> listDemanda, List<FreteRegular> listRegular, List<Mercadoria> listMercadoria) throws FileNotFoundException {
        try {
            FileReader mercadoriaFile = new FileReader("mercadoria.json");

            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            TypeToken<List<Mercadoria>> tokenMercadoria = new TypeToken<List<Mercadoria>>() {};

            List<Mercadoria> mercadoriaTemp = new ArrayList<Mercadoria>();
            mercadoriaTemp = gson.fromJson(mercadoriaFile, tokenMercadoria.getType());

            if (!mercadoriaTemp.isEmpty()) {
                for (Mercadoria merc : mercadoriaTemp) {
                    listMercadoria.add(merc);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            FileReader demanda = new FileReader("freteDemanda.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            TypeToken<List<FreteDemanda>> tokenDemandaLoad = new TypeToken<List<FreteDemanda>>() {
            };
            List<FreteDemanda> freteDemandas = new ArrayList<FreteDemanda>();
            freteDemandas = gson.fromJson(demanda, tokenDemandaLoad.getType());

            if (!freteDemandas.isEmpty()) {
                for (FreteDemanda dem : freteDemandas) {
                    listDemanda.add(dem);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

        try {
            FileReader regular = new FileReader("freteRegular.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            TypeToken<List<FreteRegular>> tokenRegularLoad = new TypeToken<List<FreteRegular>>() {
            };
            List<FreteRegular> freteRegular = new ArrayList<FreteRegular>();
            freteRegular = gson.fromJson(regular, tokenRegularLoad.getType());

            if (!freteRegular.isEmpty()) {
                for (FreteRegular dem : freteRegular) {
                    listRegular.add(dem);
                }
            }

        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    public static void saveLists(List<FreteDemanda> listDemanda, List<FreteRegular> listRegular, List<Mercadoria> listMercadoria) throws IOException {
        try {
            FileWriter mercadoria = new FileWriter("mercadoria.json");

            TypeToken<List<Mercadoria>> tokenMercadoria = new TypeToken<List<Mercadoria>>() {
            };

            List<Mercadoria> tempMercadoria = new ArrayList<Mercadoria>();

            tempMercadoria = listMercadoria;

            mercadoria.write(gson.toJson(tempMercadoria));
            mercadoria.flush();
            System.out.println("\nFoi salvado a lista de mercadoria");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileWriter demandaFile = new FileWriter("freteDemanda.json");

            List<FreteDemanda> demandas = listDemanda;

            demandaFile.write(gson.toJson(listDemanda));
            demandaFile.flush();
            System.out.println("\nFoi salvado a lista de fretes sob demanda");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            FileWriter regularFile = new FileWriter("freteRegular.json");
            TypeToken<List<FreteRegular>> tokenRegular = new TypeToken<List<FreteRegular>>() {
            };

            List<FreteRegular> regular = listRegular;

            regularFile.write(gson.toJson(regular));
            regularFile.flush();
            System.out.println("\nFoi salvado a lista de mercadoria");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }


}
