package org.example.project.api.funcionarios;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioRepositoy {
    private static List <Funcionarios> funcionarios = new ArrayList<>();

    public Funcionarios save (Funcionarios funcionario){
        funcionarios.add(funcionario);
        return funcionario;
    }
    public List <Funcionarios> getAll(){
        return funcionarios;
    }

    public Funcionarios getById(int id) {
        return funcionarios.stream()
                .filter(funcionarios -> funcionarios.getId() == id)
                .findAny().orElse(null);
    }

    public  Funcionarios update (Funcionarios funcionario){
        Funcionarios funFound = getById(funcionario.getId());
        int index = funcionarios.indexOf(funFound);
        funcionarios.set(index, funcionario);

        return funcionario;
    }
    public void delete (Funcionarios funcionario){
        funcionarios.remove(funcionario);
    }
}
