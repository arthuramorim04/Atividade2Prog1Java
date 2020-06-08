package com.arthuramorim.entity;

public class Mercadoria {

    private String descricao;
    private String tipo;
    private Double peso;
    private String nfs;
    private Boolean auditado;
    private String orgaoInspetor;
    private String dataInspecao;


    public Mercadoria(String descricao, String tipo, Double peso, String nfs, Boolean auditado) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.peso = peso;
        this.nfs = nfs;
        this.auditado = auditado;
    }


    public Mercadoria(String descricao, String tipo, Double peso, String nfs, Boolean auditado, String orgaoInspetor, String dataInspecao) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.peso = peso;
        this.nfs = nfs;
        this.auditado = auditado;
        this.orgaoInspetor = orgaoInspetor;
        this.dataInspecao = dataInspecao;
    }


    public String getDescricao() {
        return descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public Double getPeso() {
        return peso;
    }

    public String getNfs() {
        return nfs;
    }

    public Boolean getAuditado() {
        return auditado;
    }

    public String getOrgaoInspetor() {
        return orgaoInspetor;
    }

    public String getDataInspecao() {
        return dataInspecao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setNfs(String nfs) {
        this.nfs = nfs;
    }

    public void setAuditado(Boolean auditado) {
        this.auditado = auditado;
    }

    public void setOrgaoInspetor(String orgaoInspetor) {
        this.orgaoInspetor = orgaoInspetor;
    }

    public void setDataInspecao(String dataInspecao) {
        this.dataInspecao = dataInspecao;
    }

    @Override
    public String toString() {
        if(getAuditado()){
            return "Mercadoria{" +
                    "descricao='" + descricao + '\n' +
                    ", tipo='" + tipo + '\'' +
                    ", peso=" + peso +
                    ", nfs='" + nfs + '\'' +
                    ", auditado=" + auditado +
                    ", orgaoInspetor='" + orgaoInspetor + '\n' +
                    ", dataInspecao='" + dataInspecao + '\n' +
                    '}';
        }else{
            return "Mercadoria{" +
                    "descricao='" + descricao + '\n' +
                    ", tipo='" + tipo + '\n' +
                    ", peso=" + peso +
                    ", nfs='" + nfs + '\n' +
                    ", auditado=" + auditado +
                    '}';
        }

    }
}
