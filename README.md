# Miniprojeto com Spring Boot(Atividade 5)

## Descrição

A atividade consiste em transformar o projeto de alunos e turmas, feito com base na definição JAX-RS, para uma aplicação Spring Boot, considerando apenas o domínio do aluno e seus endpoints, com tratamento de possíveis erros.

## Instruções 

### Pré-requisitos

- JDK versão 1.8
- JRE versão 1.8
- MySQL Server versão 8.0
- IDE java com suporte ao maven

### Instalação

- Faça o download do projeto como um arquivo ZIP.
- Extraia os arquivos em uma pasta.
- Abra a IDE de sua preferência e importe a pasta como um projeto maven.
- Abra o MySQL e crie um schema chamado "atividade5".
- Vá em **Projeto_WEB/src/main/resources** e abra o arquivo **application.properties**.
- Em **spring.datasource.username** coloque o usuário do seu servidor e em **spring.datasource.password** coloque a senha.
- Utilize o **script.sql** para adicionar os dados nas tabelas.

Para executar a aplicação abra o pacote **com.uepb.atividade** e execute a classe **Application**.

**OBS**: Verifique no arquivo **application.properties** se a porta indicada por **server.port** está livre para uso, caso não, mude o número da porta para uma acessível. 
### Testes

OBS: Realize o teste da aplicação pelo postman.

## Informações dos pacotes

- **com.transportadora.pco.domain**: contém as classes que representam as entidades.
- **com.transportadora.pco.repositories**: contém as interfaces.
- **com.transportadora.pco.services**: contém as classes que possuem a lógica de negócio reponsáveis pela comunicação com o banco de dados.
- **com.transportadora.pco.service.exception**: contém as classes de exceções para o service.
- **com.transportadora.pco.resources**: contém as classes que fazem a comunicação com a camada service.
- **src/main/resources**: contém o arquivo de configuração do banco de dados (MySQL) e a porta que contém o servidor. 

## Tecnologias utilizadas

- Spring Boot
- Tomcat
- Maven
- JPA com hibernate
- MySQL


