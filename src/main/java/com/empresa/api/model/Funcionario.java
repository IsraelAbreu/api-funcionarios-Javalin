package com.empresa.api.model;
//Model de funcionarios
public class Funcionario {
    public int id;
    public String nome;
    public String email;

    /*
     * Construtor vázio é importante para criar um novo Funcionario...
     * perdi 41 minutos preso no erro ao criar porque esqueci de definir o construtor vázio....kkk
     */
    public Funcionario (){} 

    public Funcionario(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }   
}
