# Odontoprev - API de Consultas e Redução de Sinistros

# Cronograma do Projeto

### Equipe:
- **Lívia**: Responsável pela API em Java e DevOps.
- **Celeste**: Responsável pela API em C# e desenvolvimento do modelo preditivo.
- **Luana**: Responsável pelo desenvolvimento do banco de dados e compliance e quality assurance do projeto.
- **Todas**: Responsáveis pelo desenvolvimento mobile.

---

## Sprint 1 
**Objetivo:** Configurações iniciais, prototipação e modelagem do banco.

- **Lívia**:
  - Configuração do ambiente para desenvolvimento da API em Java.
  - Estudo e planejamento da infraestrutura DevOps (CI/CD).
  - Início do desenvolvimento dos endpoints principais da API.
  
- **Celeste**:
  - Prototipação das telas no Figma.
  - Criação do ambiente de desenvolvimento em C#.
  - Planejamento do desenvolvimento do modelo preditivo.

- **Luana**:
  - Modelagem do banco de dados (diagrama DER).
  - Criação do ambiente de banco de dados.
  - Declaração de visão e escopo do projeto.

---

## Sprint 2 
**Objetivo:** Desenvolvimento da API e integração inicial.

- **Lívia**:
  - Desenvolvimento completo de todas as entidades da API (CRUD).
  - Realizar o deployment de máquinas virtuais.
   - Diagrama demonstrando a integração/comunicação do aplicativo com APIs/banco
de dados e sistemas externos.
  
- **Celeste**:
  - Implementação da Camada Web (ASP.NET Core) .
  - Criação da versão Beta do modelo.
  - Programação visual de 5 telas do aplicativo funcional.
- **Luana**:
  - Desenho da Arquitetura da solução.
  -  Procedures para Operações CRUD.
  - Realizar chamadas a uma API (pelo menos 3 telas fazendo requisições).

---

## Sprint 3
**Objetivo:** Testes e refinamentos.

- **Lívia**:
  - Refatoração e otimização da API (melhoria de performance, validações extras, tratamento de erros).
  - Implementação do pipeline CI/CD e automação de testes.
  
- **Celeste**:
  - Integração do modelo preditivo com a camada web (ASP.NET Core).
  - Testes do modelo preditivo com base em diferentes cenários e ajustes necessários.
  
- **Luana**:
  - Implementação final das procedures e triggers no banco de dados para garantir integridade dos dados.
  - Integração final do aplicativo mobile com a API.


---

## Sprint 4
**Objetivo:** Conclusão e entrega final.

- **Lívia**:
  - Realizar testes de integração end-to-end para garantir que a API, banco de dados e front-end estão funcionando perfeitamente juntos.
  - Deploy da API e testes finais.

- **Celeste**:
  - Finalização e validação do front-end integrado ao modelo preditivo e à API.
  - Ajustes finais no front-end com base nos testes de usabilidade.
  
- **Luana**:
  - Revisão final do fluxo do aplicativo e ajustes com base no feedback dos testes.
  - Revisão final do banco de dados.

---



##  Instruções para rodar a aplicação
1. Certifique-se de ter o **Java 17+** instalado.
2. Clone o repositório:
`git clone https://github.com/LiviaMarianaLopes/odontoprev-api.git`
3. Navegue até o diretório do projeto: `cd odontoprev-api-master`
4. Execute o comando: `./mvnw spring-boot:run` para iniciar a aplicação.
5. Acesse a API em `http://localhost:8080/consultas`.

## 4. Diagramas da Aplicação
![Diagrama de classe](caminho/para/diagrama.png)
![Diagrama de Entidade e
Relacionamento](caminho/para/diagrama.png)


##  Apresentação da Proposta Tecnológica
[Link para o vídeo de apresentação](link-do-video)

### Proposta Tecnológica
A aplicação visa reduzir os casos de sinistros odontológicos através da coleta e análise de dados de consultas realizadas, possibilitando a identificação de pacientes e dentistas suspeitos.

### Público-alvo
O público-alvo são empresas de seguros odontológicos, como a Odontoprev, interessadas em melhorar a precisão na análise de sinistros.

### Problemas que a aplicação resolve
- Identificação de pacientes e dentistas suspeitos com base em comportamentos de sinistro.
- Melhoria na gestão de sinistros para reduzir fraudes.

##  Documentação dos Endpoints

### **POST** /consultas
- **Descrição**: Cria uma nova consulta
- **Request Body**:
    ```json
    {
      "data": "02/11/2024 15:30",
      "idPaciente": 1,
      "idDentista": 2,
      "idUnidade": 3
    }
    ```
- **Respostas**:
  - 201: Consulta criada com sucesso
  - 400: Erros de validação

---

### **GET** /consultas
- **Descrição**: Retorna todas as consultas cadastradas
- **Respostas**:
  - 200: Lista de consultas
  - 204: Nenhuma consulta encontrada

---

### **GET** /consultas/{id}
- **Descrição**: Retorna uma consulta específica pelo ID
- **Parâmetros**:
  - `id`: ID da consulta
- **Respostas**:
  - 200: Consulta encontrada
  - 204: Nenhuma consulta encontrada

---

### **PUT** /consultas/{id}
- **Descrição**: Atualiza uma consulta existente
- **Parâmetros**:
  - `id`: ID da consulta
- **Request Body**:
    ```json
    {
      "data": "05/10/2024 10:00",
      "idPaciente": 1,
      "idDentista": 2,
      "idUnidade": 3
    }
    ```
- **Respostas**:
  - 200: Consulta atualizada com sucesso
  - 400: Consulta não encontrada ou dados inválidos

---

### **DELETE** /consultas/{id}
- **Descrição**: Exclui uma consulta pelo ID
- **Parâmetros**:
  - `id`: ID da consulta
- **Respostas**:
  - 200: Consulta excluída com sucesso
  - 400: Consulta não encontrada

##  Testes da API

Os testes da API foram criados utilizando o **Postman**. Você pode importar a coleção de testes para verificar os endpoints da aplicação.

### Instruções para rodar os testes no Postman

1. Faça o download do arquivo de testes [aqui](./Odontoprev.postman_collection.json).
2. Abra o **Postman**.
3. No canto superior esquerdo, clique em **Import**.
4. Selecione o arquivo `.json` exportado.
5. A coleção de testes será importada para o Postman.
6. Configure a URL base da API se necessário (ex: `http://localhost:8080/consultas`).
7. Execute os testes para validar os endpoints da aplicação.

## Prints dos Testes

Abaixo estão os prints de alguns testes realizados na API utilizando o **Postman**:

### Testes de Criação de Consulta (POST /consultas)

#### Sucesso
![Sucesso Criação](caminho/para/print_sucesso_create.png)

Teste mostrando a criação bem-sucedida de uma nova consulta no sistema.

#### Erro
![Erro Criação](caminho/para/print_erro_create.png)

Teste mostrando um erro durante a tentativa de criar uma nova consulta, devido a dados inválidos.

### Testes de Atualização de Consulta (PUT /consultas/{id})

#### Sucesso
![Sucesso Atualização](caminho/para/print_sucesso_update.png)

Teste mostrando a atualização bem-sucedida de uma consulta existente.

#### Erro
![Erro Atualização](caminho/para/print_erro_update.png)

Teste mostrando um erro durante a tentativa de atualizar uma consulta, devido a dados inválidos ou ID inexistente.

### Testes de Listagem de Consultas (GET /consultas)

#### Sucesso
![Sucesso Listagem](caminho/para/print_sucesso_read.png)

Teste mostrando a listagem de todas as consultas cadastradas.

### Testes de Consulta por ID (GET /consultas/{id})

#### Sucesso
![Sucesso Listagem por ID](caminho/para/print_sucesso_readById.png)

Teste mostrando o retorno de uma consulta específica ao buscar por ID.

### Testes de Exclusão de Consulta (DELETE /consultas/{id})

#### Sucesso
![Sucesso Exclusão](caminho/para/print_sucesso_delete.png)

Teste mostrando a exclusão bem-sucedida de uma consulta existente no sistema.


        