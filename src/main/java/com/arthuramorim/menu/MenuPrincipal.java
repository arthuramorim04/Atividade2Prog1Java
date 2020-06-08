package com.arthuramorim.menu;

import com.arthuramorim.Main;
import com.arthuramorim.manager.FreteManager;

import java.util.Scanner;

public class MenuPrincipal {

    private Main main;
    private FreteManager freteManager = new FreteManager();

    public MenuPrincipal(Main main){
        this.main = main;
    }


    public void menu() {
        System.out.println("\n" +
                "1. Cadastrar mercadoria.\n" +
                "2.Cadastrar frete\n" +
                "3.Mostrar fretes cadastrados\n" +
                "4.Mostrar mercadorias cadastradass\n" +
                "5.Vincular mercadoria ao frete");

        Scanner sc = new Scanner(System.in);
        int opc = 0;
        opc = sc.nextInt();

        switch (opc){
            case 1: {
                freteManager.criaMercadoria();
                break;
            }
            case 2:{
                freteManager.novoFrete();
                break;
            }
            case 3:{
                main.toStringFrete();
                break;
            }
            case 4:{
                main.toStringMercadoria();
                break;
            }
            case 5:{

            }

        }

    }

}
