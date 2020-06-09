package com.arthuramorim.entity;

import com.arthuramorim.interfaces.InterfaceFrete;

public class FreteDemanda extends Frete implements InterfaceFrete {

    private String dataPostagem;
    private String previsaoEntrega;


    public FreteDemanda(String tipoFrete, String cidadeOrigem, String cidadeDestino, Double distancia, String dataPostagem,String previsaoEntrega,Integer id) {
        super(tipoFrete, cidadeOrigem, cidadeDestino, distancia,id);
        this.dataPostagem = dataPostagem;
        this.previsaoEntrega = previsaoEntrega;
        this.setValor(calculaFrete(distancia));
    }

    public double calculaFrete(Double distancia) {
        return (300 + 0.6*distancia);
    }

    public String getDataPostagem() {
        return dataPostagem;
    }

    public void setDataPostagem(String dataPostagem) {
        this.dataPostagem = dataPostagem;
    }

    public String getPrevisaoEntrega() {
        return previsaoEntrega;
    }

    public void setPrevisaoEntrega(String previsaoEntrega) {
        this.previsaoEntrega = previsaoEntrega;
    }


    public String toString() {

            return  "\nFretamento Demanda: \n" +
                    "\nData Postagem: " + this.getDataPostagem() +
                    "\nPrevisao Entrega:" + this.getPrevisaoEntrega() +
                    "\nTipo: " + this.getTipoFrete() +
                     this.getMercadoria().toString()+
                    "\nCidade Origem: " + this.getCidadeOrigem()+
                    "\nCidade Destino: " + this.getCidadeDestino()+
                    "\nDistancia: " + this.getDistancia() +
                    "\nValor: " + this.getValor() ;


    }
}
