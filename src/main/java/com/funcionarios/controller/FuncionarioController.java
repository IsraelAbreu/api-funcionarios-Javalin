package com.funcionarios.controller;

import com.funcionarios.model.Funcionario;
import com.funcionarios.service.FuncionarioService;

import io.javalin.http.Context;
import io.javalin.http.HttpStatus;

public class FuncionarioController {
    private final FuncionarioService service = new FuncionarioService();

    public void listarTodos(Context ctx) {
        ctx.json(service.listarTodos());
    }

    public void buscarFuncionario(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));

        service.buscarFuncionario(id)
            .ifPresentOrElse(
                funcionario -> ctx.json(funcionario), 
                () -> ctx.status(HttpStatus.NOT_FOUND)
            );
    }

    public void criarFuncionario(Context ctx) { 
        Funcionario novoFuncionario = ctx.bodyAsClass(Funcionario.class);

        Funcionario criado = service.criar(novoFuncionario);

        ctx.status(HttpStatus.CREATED).json(criado);
    }

    public void atualizarFuncionario(Context ctx) {
        int id = Integer.parseInt(ctx.pathParam("id"));
        Funcionario dadosAtualizados = ctx.bodyAsClass(Funcionario.class);

        service.atualizar(id, dadosAtualizados)
            .ifPresentOrElse(atualizado -> ctx.json(atualizado), 
                () -> ctx.status(HttpStatus.NOT_FOUND)
            );  
    }

    public void deletar(Context ctx) { 
         int id = Integer.parseInt(ctx.pathParam("id"));

         boolean removido = service.deletar(id);

         if (removido) {
            ctx.status(HttpStatus.NO_CONTENT);
         } else {
            ctx.status(HttpStatus.NOT_FOUND);
         }
    }
}
