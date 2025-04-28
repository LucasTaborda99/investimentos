# Projeto de Investimentos - Sistema Bancário

## Descrição

Este projeto é um sistema de investimentos bancários, onde os usuários podem gerenciar suas contas, visualizar o saldo e realizar investimentos. O sistema também integra com uma API externa para consultar os preços das ações da bolsa de valores brasileira.

## Funcionalidades

- Cadastro de usuários
- Gestão de contas bancárias (saques, depósitos e saldo)
- Investimentos em ações (com consulta ao preço atual das ações)
- Consulta de preço de ações em tempo real via API externa
- Armazenamento das informações no banco de dados MySQL

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para desenvolvimento do back-end.
- **JPA/Hibernate**: Para persistência de dados no banco de dados.
- **MySQL**: Banco de dados para armazenar informações dos usuários e investimentos.
- **MapStruct**: Para conversões entre objetos de diferentes camadas (DTOs e Entidades).
- **JUnit**: Para testes unitários do código.
- **H2** (em modo de teste): Para testes locais e rápidos.

## Configuração

### Banco de Dados

O projeto utiliza o MySQL como banco de dados principal. Certifique-se de configurar o banco de dados no arquivo `.env` para que o Spring Boot consiga se conectar corretamente. No arquivo `.env`, defina as seguintes variáveis:

### Execução Local

Para rodar o projeto localmente, certifique-se de que o MySQL esteja instalado e configurado corretamente em sua máquina. Configure as variáveis de ambiente no .env e execute a aplicação através do seguinte comando:

mvn spring-boot:run


### .env
```plaintext
MYSQL_USER=seuUsuario
MYSQL_PASSWORD=suaSenha

