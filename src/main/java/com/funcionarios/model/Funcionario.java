package com.funcionarios.model;
//Model de funcionarios
public class Funcionario {
    private int id;
    private String nome;
    private String email;

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
    // Aplicando o encapsulamento
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }  
}
