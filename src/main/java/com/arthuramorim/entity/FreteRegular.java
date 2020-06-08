package com.arthuramorim.entity;

import com.arthuramorim.interfaces.InterfaceFrete;

public class FreteRegular extends Frete implements InterfaceFrete {

    private String unidadeFrequencia;
    private Integer quantidadeOperacoes;
    private Integer frequenciaOperacoes;


    public FreteRegular(String tipoFrete, String cidadeOrigem, String cidadeDestino, Double distancia,
                        String unidadeFrequencia,Integer quantidadeOperacoes, Integer frequenciaOperacoes,Integer id) {
        super(tipoFrete, cidadeOrigem, cidadeDestino, distancia,id);
        this.unidadeFrequencia = unidadeFrequencia;
        this.frequenciaOperacoes = frequenciaOperacoes;
        this.quantidadeOperacoes = quantidadeOperacoes;
        this.setValor(calculaFrete(distancia));


    }

    public double calculaFrete(Double distancia) {

        return  (200 + 0.5 * distancia);
    }

    public String getUnidadeFrequencia() {
        return unidadeFrequencia;
    }

    public void setUnidadeFrequencia(String unidadeFrequencia) {
        this.unidadeFrequencia = unidadeFrequencia;
    }

    public Integer getQuantidadeOperacoes() {
        return quantidadeOperacoes;
    }

    public void setQuantidadeOperacoes(Integer quantidadeOperacoes) {
        this.quantidadeOperacoes = quantidadeOperacoes;
    }

    public Integer getFrequenciaOperacoes() {
        return frequenciaOperacoes;
    }

    public void setFrequenciaOperacoes(Integer frequenciaOperacoes) {
        this.frequenciaOperacoes = frequenciaOperacoes;
    }
}
