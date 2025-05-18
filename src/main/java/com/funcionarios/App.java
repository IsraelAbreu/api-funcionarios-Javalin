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
        
        app.get("/funcionarios", ctx -> funcionarioController.listarTodos(ctx));
        app.post("/funcionarios", ctx -> funcionarioController.criarFuncionario(ctx));
        app.get("/funcionarios/{id}", ctx -> funcionarioController.buscarFuncionario(ctx));
        app.put("/funcionarios/{id}", ctx -> funcionarioController.atualizarFuncionario(ctx));
        app.delete("/funcionarios/{id}", ctx -> funcionarioController.deletar(ctx));

        app.start(7000);
        
    }
}
