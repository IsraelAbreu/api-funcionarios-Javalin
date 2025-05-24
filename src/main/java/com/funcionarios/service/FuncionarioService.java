package com.funcionarios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.funcionarios.model.Funcionario;


public class FuncionarioService {

    // Validação
    public void validarFuncionario(Funcionario funcionario) {
        if (funcionario.getNome() == null || funcionario.getNome().isBlank()) {
            throw new IllegalArgumentException("O nome é obrigatorio");
        }
        if (funcionario.getEmail() == null || funcionario.getEmail().isBlank()) {
            throw new IllegalArgumentException("E-mail inválido");
        }
    }

    private final List<Funcionario> funcionarios = new ArrayList<>();
    private int proximoId = 1;
    //Services para o CRUD
    public List<Funcionario> listarTodos() {
        return funcionarios;
    }

    public Optional<Funcionario> buscarFuncionario(int id) {
        return funcionarios.stream()
            .filter(u -> u.getId() == id)
            .findFirst();
    }

    public Funcionario criar(Funcionario funcionario) {

        validarFuncionario(funcionario);

        funcionario.setId(proximoId++); 
        funcionarios.add(funcionario);
        return funcionario;
    }

    public Funcionario atualizar(int id, Funcionario dadosAtualizados) {

        if (dadosAtualizados.getNome() == null || dadosAtualizados.getNome().isBlank()) {
            throw new IllegalArgumentException("O campo nome é obrigatório");
        }

        if (dadosAtualizados.getEmail() == null || dadosAtualizados.getEmail().isBlank()) {
            throw new IllegalArgumentException("O campo e-mail é obrigatório");
        }
    
        Funcionario existente = buscarFuncionario(id)
            .orElseThrow(() -> new IllegalArgumentException("Funcionário com ID " + id + " não encontrado"));

        existente.setNome(dadosAtualizados.getNome());
        existente.setEmail(dadosAtualizados.getEmail());
        
        return existente;
    }

    public boolean deletar(int id) {
        return funcionarios.removeIf(u -> u.getId() == id);
    }
}
