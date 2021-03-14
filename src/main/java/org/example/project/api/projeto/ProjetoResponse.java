package org.example.project.api.projeto;

public class ProjetoResponse {
    public int id;
    public int codigo;
    public String titulo;
    public String data_Inicio;
    public String data_fim;


    public ProjetoResponse(int id,  String titulo, String data_Inicio, String data_fim) {
        this.id = id;
        this.titulo = titulo;
        this.data_Inicio = data_Inicio;
        this.data_fim = data_fim;
    }

    public ProjetoResponse (Projeto projeto){
        this.id = projeto.getId();
        this.titulo = projeto.getTitulo();
        this.data_Inicio= projeto.getData_Inicio();
        this.data_fim = projeto.getData_fim();
    }
}
