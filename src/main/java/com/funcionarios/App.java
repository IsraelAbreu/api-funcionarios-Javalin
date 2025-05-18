package com.funcionarios;

import com.funcionarios.controller.FuncionarioController;

import io.javalin.Javalin;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var app = Javalin.create();

        var funcionarioController = new FuncionarioController();
        //Rotas
        app.get("/", ctx -> ctx.result("Api de Funcionarios no ar! 🚀"));
        
        app.get("/funcionarios", funcionarioController::listarTodos);
        // app.post("/funcionarios", FuncionarioController::criar);
        // app.get("/funcionarios/{id}", FuncionarioController::buscarFuncionario);
        // app.delete("/funcionarios/{id}", FuncionarioController::deletarFuncionario);

        app.start(7000);
        
    }
}
