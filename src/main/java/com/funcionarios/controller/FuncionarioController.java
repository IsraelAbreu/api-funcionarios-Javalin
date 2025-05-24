package com.funcionarios.controller;

import com.funcionarios.model.Funcionario;
import com.funcionarios.response.ApiResponse;
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
        try {
            Funcionario novoFuncionario = ctx.bodyAsClass(Funcionario.class);
            Funcionario criado = service.criar(novoFuncionario);
            ctx.status(201).json(new ApiResponse<>(true, "Funcionário criar com sucesso!", criado));
        } catch (IllegalArgumentException e) {
            //Falha na validação
            ctx.status(400).json(new ApiResponse<>(false, e.getMessage(), null));
        } catch (Exception e) {
            //Segundo cath para pegar qualquer outro erro inesperado
            ctx.status(500).json(new ApiResponse<>(false, e.getMessage(), null));
        }
    }

    public void atualizarFuncionario(Context ctx) {
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            Funcionario dadosAtualizados = ctx.bodyAsClass(Funcionario.class);
            
            Funcionario funcionarioAtualizado = service.atualizar(id, dadosAtualizados);

            ctx.status(200).json(new ApiResponse<>(true, "Funcionário atualizado!", funcionarioAtualizado));
        } catch (IllegalArgumentException e) {
            ctx.status(400).json(new ApiResponse<>(false, e.getMessage(), null));
        } catch (Exception e) {
            ctx.status(500).json(new ApiResponse<>(false, "Erro interno no servidor.", null));
        }
    }

    public void deletar(Context ctx) { 
        try {
            int id = Integer.parseInt(ctx.pathParam("id"));
            service.deletar(id);
            ctx.status(202).json(new ApiResponse<>(true, "Funcionário removido!", null));

        } catch (IllegalArgumentException e) {
            ctx.status(400).json(new ApiResponse<>(false, e.getMessage(), null));
        } catch (Exception e) {
            ctx.status(500).json(new ApiResponse<>(false, "Erro interno no servidor.", null));
        }
    }
}
