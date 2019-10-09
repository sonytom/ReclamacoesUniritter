package com.example.tom.reclamacao;

/**
 * Created by tecnico on 02/07/2015.
 */
public class Reclamacao {
    private Integer id;
    private String reclamacao;
    private String infra;
    private String docente;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamcao(String reclamcao) {
        this.reclamacao = reclamcao;
    }

    public String getInfra() {
        return infra;
    }

    public void setInfra(String infra) {
        this.infra = infra;
    }


    public String getDocente() {
        return docente;
    }


    public void setDocente(String docente) {
        this.docente = docente;
    }


}