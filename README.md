# 👚 StyleMe - Projeto de Banco de Dados Relacional

## 📌 Sobre o Projeto

O **StyleMe** é uma aplicação de e-commerce voltada para venda de roupas, com um diferencial inovador: a criação de **avatares personalizados** com medidas reais dos usuários, permitindo simulações de prova de roupas. O objetivo principal é **aumentar a confiança do cliente** ao comprar online, reduzindo devoluções e ampliando as vendas.

Este projeto foi desenvolvido como parte da disciplina de **Banco de Dados Relacional**, ministrada pelo professor **Fred Lucena**.

---

## 👥 Equipe

- Wenderson Artur  
- Caio Henrique  
- Nicolas Klayvert  
- Diego Luiz  
- Jefferson Ribeiro  
- Sergio Roberto  

---

## 🧠 Objetivo

> Oferecer mais **segurança e precisão** para clientes na hora da compra de roupas online, simulando o caimento das peças por meio de avatares personalizados.

---

## 🛍️ Modelo de Negócio

- **Ramo:** E-commerce
- **Setor:** Moda
- **Cliente:** Consumidor final online
- **Diferencial:** Prova virtual de roupas com avatar 3D e medidas reais

---

## 📋 Requisitos Funcionais

### Clientes
- Cadastro com nome, e-mail, CPF e senha
- CPF e e-mail únicos
- Um cliente pode fazer múltiplos pedidos

### Avatar
- Um avatar por cliente
- Medidas: tórax, torso, braço, cintura, quadril, perna
- Usado para simulação de roupas

### Roupas
- Cadastro de roupas com código, valor, descrição, quantidade e etiqueta
- Tipos: Camisa ou Calça (com medidas específicas por tipo)
- Controle de estoque
- Simulação com avatares

### Pedidos
- Cada pedido pode conter várias roupas
- Registro de status, data e valores

### Pagamentos
- Pedido pode ter um ou mais pagamentos
- Formas aceitas: **Pix** e **Cartão**
- Registro de status de pagamento

---

## 🛠️ Tecnologias Utilizadas

- **SGBD:** SQL Server
- **Linguagem:** SQL (DDL, DML, T-SQL)
- **Stored Procedures, Triggers e Functions**
- **Java (StylemeApplication.java)**

---

## 🗂️ Estrutura do Banco

### Principais Entidades
- `Cliente`
- `Avatar`
- `Roupa` (com subtabelas `Camisa` e `Calça`)
- `Pedido` e `ItemPedido`
- `Pagamento`, `Pix`, `Cartao`
- Tabelas auxiliares: `AvatarProvaRoupa`

### Scripts Incluídos
- Criação de tabelas (`CREATE TABLE`)
- Stored Procedure para cadastro de roupas
- Function para validação de CPF
- Trigger de atualização de estoque
- Consultas analíticas (total gasto por cliente, média de preço, estoque etc.)
- Índices otimizados para desempenho de consultas

---

## 📊 Consultas Importantes

- Total gasto por cliente
- Quantidade de roupas cadastradas e em estoque
- Preço médio, roupa mais cara e mais barata

---

## ⚙️ Automação e Desempenho

- **Trigger:** Atualiza automaticamente o estoque após pedido
- **Function:** Valida estrutura do CPF
- **Procedure:** Cadastro automatizado de roupas e inserção em tabelas específicas
- **Índice:** Otimização de consultas em `Pedido`

---

## 📌 Observações Finais

Este projeto representa a aplicação prática dos conhecimentos adquiridos durante a disciplina, abordando **modelagem conceitual, lógica e física**, além de recursos avançados como **funções, procedimentos armazenados e triggers** para garantir a integridade e automação do banco de dados.

---

