# Lucas ToDoList API

API RESTful desenvolvida em Java com Spring Boot e banco de dados H2 para gerenciamento de tarefas.

## ⚙️ Tecnologias
- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database

## 📋 Funcionalidades
- Criar tarefa
- Listar todas as tarefas
- Buscar tarefa por ID
- Atualizar tarefa existente
- Remover tarefa

Cada tarefa possui:
- id
- nome
- dataEntrega
- responsavel (coloque seu nome e RU aqui!)
- status (Pendente ou Concluída)

## 🚀 Como rodar o projeto
1. Tenha o Java 17 e Maven instalados.
2. No terminal, execute:
   ```bash
   mvn spring-boot:run
   ```
3. Acesse a API em: http://localhost:8080/api/tasks  
4. Console H2 disponível em: http://localhost:8080/h2-console  
   (JDBC URL: `jdbc:h2:mem:todolistdb`)

## 🧪 Exemplos de requisições

### Criar tarefa (POST /api/tasks)
```json
{
  "nome": "Tarefa de Teste - Lucas da Silva Marques - RU: SEU_RU_AQUI",
  "dataEntrega": "2025-10-31",
  "responsavel": "Lucas da Silva Marques - RU: SEU_RU_AQUI",
  "status": "Pendente"
}
```

### Atualizar tarefa (PUT /api/tasks/{id})
```json
{
  "nome": "Tarefa Atualizada - Lucas da Silva Marques - RU: SEU_RU_AQUI",
  "dataEntrega": "2025-11-05",
  "responsavel": "Lucas da Silva Marques - RU: SEU_RU_AQUI",
  "status": "Concluída"
}
```

## 🧾 Observações
Inclua prints no Postman de cada funcionalidade (criar, listar, atualizar, remover) mostrando seu nome e RU, e envie o link do projeto (GitHub) junto ao Caderno de Atividades.
