<p align="center">
   <img src="https://github.com/davitorress/Osiris-app/assets/104948713/5dfe90f9-43a4-442d-b499-04a74b9bfc0a" width="500">
</p>

<div align="center">
   
   ![GitHub language count](https://img.shields.io/github/languages/count/joao-arthr/osiris)
   ![GitHub last commit](https://img.shields.io/github/last-commit/joao-arthr/osiris)
   ![Build](https://github.com/joao-arthr/osiris/actions/workflows/build.yml/badge.svg)

</div>

Osiris é um projeto de graduação em andamento que promove uma alimentação mais saudável por meio do uso de Plantas Alimentícias Não Convencionais (PANCs). Ele fornece informações de cultivo, diversas receitas e PANCs e permite que os usuários criem suas próprias receitas. Esta documentação descreve como utilizar a Osiris API.

---

&nbsp;

# Documentação da Osiris API

**Tecnologias utilizadas:**

<p align="left">
    <img src="https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot">
    <img src="https://img.shields.io/badge/MongoDB-4EA94B?style=for-the-badge&logo=mongodb&logoColor=white">
</p>

**Versão da API:** 0.5

---

## Entidades

### PANCs

```java
{
    "id": "646ee56e18b4f030ce3feb5a",
    "nome": "Caruru",
    "descricao": "O caruru é uma planta rica em cálcio, magnésio e manganês, minerais essenciais...",
    "cultivo": [
        "Clima e solo: O caruru é uma planta de clima quente e tropical, ..."
    ],
    "beneficios": "O caruru tem ótimas quantidades de potássio, um mineral que ...",
    "imagem": "https://res.cloudinary.com/..."
}
```

- `id`: ID do Mongo que identifica a PANC
- `nome`: Nome da PANC
- `descricao`: Descrição geral da PANC
- `cultivo`: Informações de cultivo da PANC
- `beneficios`: Benefícios da PANC
- `imagem`: Imagem da PANC

---

### Receitas

```java
{
    "id": "646ea9158043e4ded05d94dd",
    "nome": "Molho pesto de capuchinha",
    "descricao": "A capuchinha, uma PANC popular, empresta seu sabor picante e ligeiramente apimentado a este molho...",
    "pancs": [
        "Capuchinha"
    ],
    "ingredientes": [
        "2 xícaras de folhas de capuchinha",
        "½ xícara de avelãs"
    ],
    "preparo": [
        "Tudo o que você precisa fazer para essa receita é processar todos os ingredientes até ..."
    ],
    "imagem": "https://res.cloudinary.com/...",
    "usuarioId": "646fec8aeba3067796240d45"
}
```

- `id`: ID do Mongo que identifica a receita
- `nome`: Nome da receita
- `descricao`: Descrição geral da receita
- `pancs`: PANCs que estão contidas na receita
- `ingredientes`: Lista de ingredientes da receita
- `preparo`: Informações de preparo da receita
- `imagem`: Imagem da receita
- `usuarioId`: ID do usuário que criou a receita

&nbsp;

## Endpoints

### Login

&nbsp;

### **POST** `/login`

Endpoint para efetuar o login do usuário comum.

**Parameters**

- **body**

- `email`: sem validação
- `senha`: sem validação

```java
{
    "email": "string",
    "senha": "string"
}
```

**Responses**

- **200** - Retorna o token de autenticação do usuário

```java
{
    "token": "string"
}
```

- **400** - Requisição inconsistente

- **403**

```
Usuario Admin não encontrado. ID: {id}
```

---

&nbsp;
&nbsp;

### PANCs

&nbsp;

### **GET** `/pancs`

Endpoint para obter todas as PANCs cadastradas.

**Responses**

- **200** - Retorna um array de PANCs

```java
[
    {
        "id": "string",
        "nome": "string",
        "descricao": "string",
        "cultivo": [
            "string"
        ],
        "beneficios": "string",
        "imagem": "string"
    }
]
```

---

&nbsp;

### **GET** `/pancs/{id}`

Endpoint para obter uma única PANC pelo ID.

**Parameters**

- **id**: `String` - ID da PANC a ser encontrada

**Responses**

- **200** - retorna o objeto da PANC

```java
{
    "id": "string",
    "nome": "string",
    "descricao": "string",
    "cultivo": [
        "string"
    ],
    "beneficios": "string",
    "imagem": "string"
}
```

- **404**

```
Panc não encontrada. ID: {id}
```

---

&nbsp;
&nbsp;

### Receitas

&nbsp;

### **GET** `/receitas`

Endpoint para obter todas as receitas cadastradas no sistema.

**Responses**

- **200** - Retorna um array de receitas

```java
[
    {
        "id": "string",
        "nome": "string",
        "descricao": "string",
        "pancs": [
            "string"
        ],
        "ingredientes": [
            "string"
        ],
        "preparo": [
            "string"
        ],
        "imagem": "string",
        "usuarioId": "string"
    }
]
```

---

&nbsp;

### **GET** `/receitas/{id}`

Endpoint para obter uma única receita pelo ID.

**Parameters**

- **id**: `String` - ID da receita a ser encontrada

**Responses**

- **200** - Retorna o objeto da receita

```java
{
    "id": "string",
    "nome": "string",
    "descricao": "string",
    "pancs": [
        "string"
    ],
    "ingredientes": [
        "string"
    ],
    "preparo": [
        "string"
    ],
    "imagem": "string",
    "usuarioId": "string"
}
```

- **404**

```
Receita não encontrada. ID: {id}
```

---

&nbsp;

### **POST** `/receitas`

Endpoint para cadastrar uma receita.

**Parameters**

- **body** - Receita a ser cadastrada

```java
{
    "id": "string",
    "nome": "string",
    "descricao": "string",
    "pancs": [
        "string"
    ],
    "ingredientes": [
        "string"
    ],
    "preparo": [
        "string"
    ],
    "imagem": "string",
    "usuarioId": "string"
}
```

**Responses**

- **201** - Receita foi criada com sucesso

- **400** - Requisição inconsistente

---

&nbsp;

### **PUT** `/receitas/{id}`

Endpoint para atualizar uma receita pelo ID.

**Parameters**

- **id**: `String` - ID da receita a ser editada

- **body** - Receita a ser editada

```java
{
    "id": "string",
    "nome": "string",
    "descricao": "string",
    "pancs": [
        "string"
    ],
    "ingredientes": [
        "string"
    ],
    "preparo": [
        "string"
    ],
    "imagem": "string",
    "usuarioId": "string"
}
```

**Responses**

- **200** - Receita foi editada com sucesso

- **400** - Requisição inconsistente

- **404**

```
Receita não encontrada. ID: {id}
```

---

&nbsp;

### **PATCH** `/receitas/{id}/imagem`

Endpoint para mudar a imagem de uma receita pelo ID.

**Parameters**

- **id**: `String` - ID da receita da qual a imagem será salva

**Responses**

- **200**

```
Imagem enviada com sucesso
```

- **400** - Requisição inconsistente

- **404**

```
Receita não encontrada. ID: {id}
```

---

&nbsp;

### **DELETE** `/receitas/{id}`

Endpoint para excluir uma receita pelo ID.

**Parameters**

- **id**: `String` - ID da PANC a ser encontrada

**Responses**

- **204** - Receita excluída com sucesso
