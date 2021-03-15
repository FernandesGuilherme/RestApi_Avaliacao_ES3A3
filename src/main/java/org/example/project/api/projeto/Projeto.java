package org.example.project.api.projeto;

public class Projeto {
    private  int id ;
    private int codigo;
    private String titulo;
    private String data_Inicio;
    private String data_fim;
    private static  int coutId = 1;


    public Projeto( int codigo, String titulo, String data_Inicio, String data_fim) {
        this.id = coutId ++;
        this.codigo = codigo;
        this.titulo = titulo;
        this.data_Inicio = data_Inicio;
        this.data_fim = data_fim;
    }



    public Projeto(int id, int codigo, String titulo, String data_Inicio, String data_fim) {
        this.id = id;
        this.codigo = codigo;
        this.titulo = titulo;
        this.data_Inicio = data_Inicio;
        this.data_fim = data_fim;
    }


    public int getId() {
        return id;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getData_Inicio() {
        return data_Inicio;
    }

    public String getData_fim() {
        return data_fim;
    }
}
