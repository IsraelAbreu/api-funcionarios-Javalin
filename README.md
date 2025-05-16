# 🚀 API Simples de Funcionários com Javalin

Este é um projeto de estudo construído com o microframework **[Javalin](https://javalin.io/)** para criar uma API REST básica de gerenciamento de funcionários. O objetivo é entender os fundamentos do desenvolvimento de APIs em Java **sem usar o Spring**, focando em conceitos como rotas, controllers e manipulação de dados em memória.

## ✅ Status do Projeto

📌 Em desenvolvimento!  
Neste momento, o projeto está na fase inicial com foco em **CRUD básico** (Create, Read) utilizando apenas:
- `Model`
- `Controller`
- `Rotas diretas` no arquivo `App`

Pretendo evoluir para:
- Implementar a camada de `Service`
- Adicionar `validações`
- Melhorar a estrutura do projeto
- Utilizar banco de dados futuramente

---
- [x] Criar um novo funcionário (POST `/funcionarios`)
- [x] Listar todos os funcionários (GET `/funcionarios`)
- [x] Buscar funcionário por ID (GET `/funcionarios/id`)
- [x] Deletar funcionário (DELETE `/funcionarios/id`)
- [ ] Atualizar funcionário (em breve)

---

## ▶️ Como rodar o projeto

### Pré-requisitos

- Java 21
- Maven
- IDE (ex: IntelliJ IDEA ou VSCode)

### Passos

1. Clone o repositório:
   ```bash
    git clone https://github.com/seu-usuario/api-funcionarios-javalin.git

    cd api-funcionarios-javalin
2. Compile e rode o projeto:
   ```
    mvn clean install
    
    mvn exec:java -Dexec.mainClass="Main"

### 🛠 Tecnologias Utilizadas
Java 21

Javalin 6.1.3

Maven

📚 Fontes e estudos
Este projeto foi construído com base em estudos pessoais e orientação via ChatGPT.
A documentação oficial do Javalin também é uma ótima referência:
👉 https://javalin.io/documentation

✍️ Autor
IsraelAbreu,
Desenvolvedor em formação focado em Java Backend.
Contato: [israel.abreu95@gmail.com]
