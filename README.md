 # Desafio PactoMais
Esta é a documentação da API que descreve os endpoints disponíveis e suas funcionalidades. Abaixo, você encontrará informações sobre como usar cada endpoint e exemplos de solicitações e respostas.

## Endpoints

### 1. Cadastrar Transação

**Descrição:** Este endpoint permite cadastrar uma nova transação.

- **URL:** `/transacao`
- **Método:** `POST`
- **Tags:** `transacao-controller`
- **OperationId:** `cadastrarTransacao`
- **RequestBody:**
  - Content-Type: `application/json`
  - Schema: [TransacaoDTO](#transacaodto)
- **Resposta de Sucesso (200 OK):**
  - Schema: [Transacao](#transacao)

### 2. Saque em Conta

**Descrição:** Este endpoint permite realizar um saque em uma conta específica.

- **URL:** `/transacao/{id}/saque`
- **Método:** `POST`
- **Tags:** `transacao-controller`
- **OperationId:** `saqueConta`
- **Parâmetros:**
  - `id` (Path, Integer): O ID da conta da qual você deseja fazer o saque.
  - `valor` (Query, Number): O valor a ser sacado.
- **Resposta de Sucesso (200 OK):**
  - Schema: [Transacao](#transacao)

### 3. Depósito em Conta

**Descrição:** Este endpoint permite realizar um depósito em uma conta específica.

- **URL:** `/transacao/{id}/deposito`
- **Método:** `POST`
- **Tags:** `transacao-controller`
- **OperationId:** `depositoConta`
- **Parâmetros:**
  - `id` (Path, Integer): O ID da conta na qual você deseja fazer o depósito.
  - `valor` (Query, Number): O valor a ser depositado.
- **Resposta de Sucesso (200 OK):**
  - Schema: [Transacao](#transacao)

### 4. Listar Contas

**Descrição:** Este endpoint permite listar todas as contas disponíveis.

- **URL:** `/conta`
- **Método:** `GET`
- **Tags:** `conta-controller`
- **OperationId:** `listarConta`
- **Resposta de Sucesso (200 OK):**
  - Schema: [ContaListagemDTO](#contalistagemdto)

### 5. Cadastrar Conta

**Descrição:** Este endpoint permite cadastrar uma nova conta.

- **URL:** `/conta`
- **Método:** `POST`
- **Tags:** `conta-controller`
- **OperationId:** `cadastrarConta`
- **RequestBody:**
  - Content-Type: `application/json`
  - Schema: [ContaDTO](#contadto)
- **Resposta de Sucesso (200 OK):**
  - Schema: [Conta](#conta)

## Schemas

Aqui estão os schemas utilizados na API:

### TransacaoDTO

- Tipo: Object
- Propriedades:
  - contaListagemDto: [ContaListagemDTO](#contalistagemdto)
  - tipoOperacao: String (Enum: COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE, PAGAMENTO)
  - valor: Number (Double)
  - dataTransicao: String (Formato: date-time)

### ContaListagemDTO

- Tipo: Object
- Propriedades:
  - id: Integer (Formato: int64)

### ContaDTO

- Tipo: Object
- Propriedades:
  - id: Integer (Formato: int64)
  - numeroConta: String
  - saldoConta: Number (Double)

### Conta

- Tipo: Object
- Propriedades:
  - id: Integer (Formato: int64)
  - numeroConta: String
  - saldoConta: Number (Double)
  - transacoes: Array de [Transacao](#transacao)

### Transacao

- Tipo: Object
- Propriedades:
  - id: Integer (Formato: int64)
  - tipoOperacao: String (Enum: COMPRA_A_VISTA, COMPRA_PARCELADA, SAQUE, PAGAMENTO)
  - valor: Number (Double)
  - dataTransacao: String (Formato: date-time)
  - contas: Array de [Conta](#conta)
