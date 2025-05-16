package com.empresa;

import com.empresa.api.controller.FuncionarioController;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var app = Javalin.create();

        //Rotas
        app.get("/", ctx -> ctx.result("Api de Funcionarios no ar! 🚀"));
        app.get("/funcionarios", FuncionarioController::listarFuncionarios);
        app.post("/funcionarios", FuncionarioController::criar);
        app.get("/funcionarios/{id}", FuncionarioController::buscarFuncionario);
        app.delete("/funcionarios/{id}", FuncionarioController::deletarFuncionario);

        app.start(7000);
        
    }
}
