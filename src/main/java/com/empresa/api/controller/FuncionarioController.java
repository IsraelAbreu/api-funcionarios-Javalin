package com.empresa.api.controller;

import java.util.ArrayList;
import java.util.List;

import com.empresa.api.model.Funcionario;

import io.javalin.http.Context;


public class FuncionarioController {
    /* Utilizando uma ArrayListar para salvar nosso funcionários criados.
    Como é meu primeiro projeto, não temos ainda um BD para a API.
    */ 
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static int idCounter = 1; //defindno o primeiro ID para inciar em 1   

    public static void  listarFuncionarios(Context ctx) {
        ctx.json(funcionarios);
    }

    public static void criar(Context ctx) {
        Funcionario novoFuncionario =  ctx.bodyAsClass(Funcionario.class);
        novoFuncionario.id = idCounter++;
        funcionarios.add(novoFuncionario);
        ctx.status(201).json(novoFuncionario);
    }

    public static void buscarFuncionario(Context ctx) {

        int id = Integer.parseInt(ctx.pathParam("id"));

        Funcionario funcionario = funcionarios.stream()
            .filter(u -> u.id == id)
            .findFirst()
            .orElse(null);

        if (funcionario != null) {
            ctx.json(funcionario);
        } else {
            ctx.status(404).result("Funcionário não encontrado");
        }
    }

    public static void deletarFuncionario(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        boolean foiRemovido = funcionarios.removeIf(u -> u.id == id);
        if (foiRemovido) {
            ctx.status(204).result("Funcionário Deletado!");
        } else {
            ctx.status(404).result("Funcionário não encontrado");
        }
    }

}
