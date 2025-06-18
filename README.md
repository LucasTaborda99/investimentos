# 📈 Projeto de Investimentos com Java, Spring Boot e Inteligência Artificial

## 🧠 Descrição

Este projeto é uma API RESTful desenvolvida com **Java + Spring Boot**, focada na integração de dados do mercado financeiro com **Inteligência Artificial**. O sistema permite consultar informações de ações da bolsa brasileira em tempo real e fornece uma **análise automatizada de investimento**, utilizando um modelo de IA via **OpenRouter (Mistral 7B)**.

O objetivo é simular uma solução que auxilia usuários a tomarem decisões com base em dados reais e recomendações inteligentes.

---

## 🚀 Funcionalidades

- 🔎 Consulta de ações em tempo real via [API BRAPI](https://brapi.dev/)
- 🤖 Análise inteligente das ações com agente de IA (OpenRouter)
- 📊 Exibição de preço atual e variação percentual diária
- 🧠 Recomendações automáticas de **compra**, **venda** ou **manutenção**
- 🧪 Testes unitários com JUnit e Mockito (padrão AAA)
- 🌐 Documentação interativa com Swagger UI

---

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot**
- **Spring Web (RESTful APIs)**
- **Lombok**
- **MapStruct**
- **MySQL** (persistência)
- **JPA / Hibernate**
- **Swagger / OpenAPI**
- **JUnit 5 + Mockito**
- **Integração com API externa (BRAPI)**
- **Integração com OpenRouter (modelo Mistral 7B)**

---

## 💾 Banco de Dados

O projeto utiliza **MySQL** como banco de dados principal.


## 📂 Organização do Projeto
controller: endpoints da API REST

service: regras de negócio e integração com IA

dto: transferência de dados

client: consumo de APIs externas (BRAPI, OpenRouter)

config: configurações globais

tests: testes unitários com cobertura AAA

## 🎯 Objetivo
Este projeto foi desenvolvido como prática para reforçar conhecimentos em:

Desenvolvimento backend com Spring Boot

Integração com serviços externos via API

Uso de modelos de linguagem (LLMs) em cenários reais

Criação de projetos prontos para produção

## 📌 Próximos passos
Criar uma interface front-end

Armazenar histórico de análises

Melhorar a estrutura de logs e tratamento de erros

## 📎 Este projeto também está sendo divulgado no meu LinkedIn como portfólio.
Contribuições, sugestões ou feedbacks são sempre bem-vindos!

### 📄 `.env` - Configuração necessária

```env
MYSQL_USER=seuUsuario
MYSQL_PASSWORD=suaSenha
OPENROUTER_TOKEN=suaChaveDaOpenRouter
Obs: Você deve configurar seu token pessoal da OpenRouter (https://openrouter.ai) para ativar a análise por IA.

▶️ Execução Local
Certifique-se de ter o MySQL instalado e configurado corretamente. Após clonar o repositório:

Crie o arquivo .env com suas variáveis.

Execute o projeto com o comando abaixo:

bash
Copiar
Editar
mvn spring-boot:run

Acesse a documentação Swagger em:
http://localhost:8080/swagger-ui.html