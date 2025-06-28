# 👚🧥 StyleMe — Sistema de Provador Virtual com Java e Banco de Dados Relacional

O **StyleMe** é um sistema de provador virtual voltado para o e-commerce de moda, desenvolvido como parte das disciplinas de **Programação Orientada a Objetos** e **Banco de Dados Relacional** do curso de Análise e Desenvolvimento de Sistemas da **FICR**.

A proposta é simples, mas poderosa: permitir que os usuários criem avatares com suas medidas reais e simulem o uso de roupas antes da compra, aumentando a segurança da experiência online para consumidores e otimizando a gestão de estoque para lojistas.

---

## 📌 Descrição Geral

- 💻 Backend em **Java (POO)** com simulação de usuários e controle total via terminal
- 🗄️ Banco de dados relacional desenvolvido em **SQL Server**, com procedures, triggers e consultas otimizadas
- 🛍️ Funcionalidades voltadas tanto para clientes (experiência de prova virtual) quanto para lojistas (cadastro e gerenciamento de roupas)

---

## 👤 Tipos de Usuários

### 🧍 Cliente
- Visualiza peças disponíveis
- Cria e edita avatar com medidas reais (tórax, cintura, quadril, etc.)
- Simula a prova de roupas
- Realiza pedidos e pagamentos
- Consulta histórico de pedidos

### 🧑‍💼 Lojista
- Login pré-cadastrado:  
  `Email:` styleme@gmail.com  
  `Senha:` loj4567
- Cadastra camisas e calças com medidas específicas
- Atualiza, remove ou visualiza peças no estoque

---

## 🧠 Banco de Dados Relacional

### 📋 Entidades principais
- Cliente
- Avatar (ligado a um cliente, com medidas corporais)
- Roupa (Camisa ou Calça)
- Pedido e Itens de Pedido
- Pagamento (via Pix ou Cartão)
- AvatarProvaRoupa (relaciona avatar com roupas provadas)

### 📌 Funcionalidades SQL
- Criação de tabelas com relacionamentos e integridade referencial
- Stored Procedure para cadastro de roupas (e inserção nas tabelas específicas)
- Trigger para atualização automática de estoque após pedidos
- Function para validação de CPF
- Consultas analíticas:
  - Total gasto por cliente
  - Preço médio, peça mais cara e mais barata
  - Quantidade de roupas em estoque

---

## ⚙️ Tecnologias Usadas

| Tecnologia         | Aplicação                                  |
|--------------------|---------------------------------------------|
| Java (POO)         | Backend e interação com usuário (via terminal) |
| SQL Server         | Modelagem e implementação do banco de dados |
| T-SQL (DDL, DML)   | Procedures, triggers, funções e consultas   |
| Git/GitHub         | Versionamento e hospedagem do projeto       |

---

## 📁 Estrutura do Projeto

📦 styleme-project
├── 📄 StylemeApplication.java # Lógica Java (POO)
├── 📄 BancoDeDados_StyleMe.docx # Documentação e scripts SQL
├── 📄 README.md # Este arquivo

yaml
Copiar
Editar

---

## 👥 Equipe StyleMe

- Caio Henrique  
- Wenderson Artur  
- Nicolas Klayvert  
- Diego Luiz  
- Jefferson Ribeiro  
- Sergio Roberto  

---

## 🎓 Orientadores
- Prof. Fred Lucena
- Prof. Lenin Abadié

---

## 🧾 Observações Finais

Este projeto representa a integração de múltiplas competências aprendidas no semestre, desde modelagem de banco de dados (conceitual, lógica e física) até aplicação de princípios da programação orientada a objetos em Java. O StyleMe propõe uma solução inovadora e realista para o mercado de moda online, com foco em experiência do usuário e gestão eficiente.
