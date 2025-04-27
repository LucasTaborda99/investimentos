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
- **Docker**: Para containerização do banco de dados MySQL.
- **H2** (em modo de teste): Para testes locais e rápidos.

## Configuração

### 1. Banco de Dados

O projeto utiliza o MySQL como banco de dados principal. Certifique-se de configurar o banco de dados no arquivo `.env` para que o Spring Boot consiga se conectar corretamente.

### 2. Variáveis de Ambiente

As seguintes variáveis de ambiente devem ser configuradas no arquivo `.env`:

### 3. Docker

Este projeto usa o Docker para rodar um container MySQL. Para levantar o banco de dados, basta executar o seguinte comando:

```bash
docker-compose up -d