package org.example.project.api.funcionarios;

//Classo que respponde as requisições enviadas
public class FuncionarioResponse {
    public int id;
    public  String CPF;
    public String nome;
    public String email;
    public int codigo_departamento;

    public FuncionarioResponse(int id, String CPF, String nome, String email, int codigo_departamento) {
        this.id = id;
        this.CPF = CPF;
        this.nome = nome;
        this.email = email;
        this.codigo_departamento = codigo_departamento;
    }

    public FuncionarioResponse(Funcionarios funcionarios) {
        this.id = funcionarios.getId();
        this.nome = funcionarios.getNome();
        this.email = funcionarios.getEmail();
        this.codigo_departamento = funcionarios.getCodigo_departamento();

    }
}
