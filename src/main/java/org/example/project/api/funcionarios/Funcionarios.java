package org.example.project.api.funcionarios;

public class Funcionarios {
    private  int id ;
    private  String CPF;
    private  String nome;
    private String email;
    private int codigo_departamento;
    private static  int coutId = 1;

    public Funcionarios(String CPF, String nome, String email, int codigo_departamento) {
        this.id = coutId ++;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.codigo_departamento = codigo_departamento;
    }
    public Funcionarios(int id, String CPF, String nome, String email, int codigo_departamento) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.codigo_departamento = codigo_departamento;
    }

    public int getId() {
        return id;
    }

    public String getCPF() {
        return CPF;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getCodigo_departamento() {
        return codigo_departamento;
    }
}
