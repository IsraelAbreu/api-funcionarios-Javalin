package com.funcionarios.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.funcionarios.model.Funcionario;


public class FuncionarioService {

        private final List<Funcionario> funcionarios = new ArrayList<>();
        private int proximoId = 1;

        public List<Funcionario> listarTodos() {
            return funcionarios;
        }

        public Optional<Funcionario> buscarFuncionario(int id) {
            return funcionarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst();
        }

        public Funcionario criar(Funcionario funcionario) {
            funcionario.setId(proximoId++); 
            funcionarios.add(funcionario);
            return funcionario;
        }

        public Optional<Funcionario> atualizar(int id, Funcionario dadosAtualizados) {
            return buscarFuncionario(id).map(funcionarioExistente -> {
                funcionarioExistente.setNome(dadosAtualizados.getNome());
                funcionarioExistente.setEmail(dadosAtualizados.getEmail());
                return funcionarioExistente;
            });
        }

        public boolean deletar(int id) {
            return funcionarios.removeIf(u -> u.getId() == id);
        }
}
