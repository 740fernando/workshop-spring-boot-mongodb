# 📚 Nivelamento sobre NoSQL eMongoDB

## 🔸 Problema 1: incompatibilidade de impedância

![image](https://user-images.githubusercontent.com/32016610/159125741-172a02cf-cf42-49b0-94fa-5d9dd0b1029f.png)

![image](https://user-images.githubusercontent.com/32016610/159125746-c8199574-7b38-4d78-82d2-6abdab3e81af.png)

#### Com ou sem ORM
- Transações e junções degradam performance!

![image](https://user-images.githubusercontent.com/32016610/159125770-c63341e1-7da4-4b5e-b1f1-27e0b4b34fda.png)


## 🔸 Problema 2: grande volume de dados e acessos

![image](https://user-images.githubusercontent.com/32016610/159125858-30d96997-ba72-430b-8c9b-cc365cb8dda0.png)

### 🛑 BD relacional vs. cluster

![image](https://user-images.githubusercontent.com/32016610/159125880-e5d91c51-1b95-4391-8330-a83fc5c0c143.png)


## 🔸 NoSQL

- Primeiras influências: Google (BigTable) e Amazon (Dynamo)
- O nome NoSQL é acidental
- Características mais comuns:
- Não utilizam modelo relacional
- Tem uma boa execução em clusters
- Código aberto
- Século XXI
- Não tem esquema

### Duas classes principais de bancos de dados
- Banco de dado orientado a agregados
   - Modelo chave-valor (Riak, Redis)
   - Modelo de documentos (MongoDB, CouchDB)
   - Modelo família de colunas (Cassandra, Apache HBase)
- Banco de dados de grafos (Neo4j) (dados com relacionamentos complexos)

### Agregado
- É um conjunto de objetos relacionados que
desejamos tratar como uma unidade.

#### Relembrando. Modelo relacional:

![image](https://user-images.githubusercontent.com/32016610/159126064-17065f53-49a6-4c01-b3cd-52808bcf931c.png)

##### Agregado: pedido
- Conjunto de objetos
relacionados, tratados
como uma unidade
- Não normalizado

![image](https://user-images.githubusercontent.com/32016610/159126105-e1bd67c0-028c-498f-b27b-2e23eda828eb.png)

![image](https://user-images.githubusercontent.com/32016610/159126110-b3fbc3c7-7dfa-4251-9c07-6a3f6daba031.png)

## 🔸 Por que o uso de agregados?

- Problema 1: incompatibilidade de impedância
- Problema 2: grande volume de dados e acessos (em cluster)

- Ele já possui a estrutura de objetos associados
- É uma unidade natural de replicação e fragmentação
- Todos os dados de um agregado estão armazenados JUNTOS e no
MESMO NODO do cluster
##### Nota: não suportam todo suporte ACID como bancos relacionais, mas garantem atomicidade no agregado.


<h2> 🤝 Contribuindo </h2>

Este repositório foi criado para fins de estudo, então contribua com ele.<br>
Se te ajudei de alguma forma, ficarei feliz em saber. E caso você conheça alguém que se identidique com o conteúdo, não deixe de compatilhar.

Se possível:

⭐️  Star o projeto

🐛 Encontrar e relatar issues


