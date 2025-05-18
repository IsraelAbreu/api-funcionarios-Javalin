package com.funcionarios.controller;

import com.funcionarios.service.FuncionarioService;

import io.javalin.http.Context;

public class FuncionarioController {
    private final FuncionarioService service = new FuncionarioService();

    public void listarTodos(Context ctx) {
        ctx.json(service.listarTodos());
    }
}
