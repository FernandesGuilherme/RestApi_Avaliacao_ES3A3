package org.example.project.api.projeto;

import org.example.project.api.funcionarios.Funcionarios;

import java.util.ArrayList;
import java.util.List;

public class ProjetoRepository {
    private  static List <Projeto> projetos = new ArrayList<>();

    public Projeto save (Projeto projeto){
        projetos.add(projeto);
        return projeto;
    }

    public List <Projeto> getAll (){
        return projetos;
    }
    public Projeto getById(int id) {
        return projetos.stream()
                .filter(projetos -> projetos.getId() == id)
                .findAny().orElse(null);
    }
    public  Projeto update (Projeto projeto){
        Projeto projetoFound = getById(projeto.getId());
        int index = projetos.indexOf(projetoFound);
        projetos.set(index, projeto);

        return projeto;
    }

    public void delete (Projeto projeto){
        projetos.remove(projeto);
    }

}
