
# API Restaurantes - Backend

Uma API para funcionar como backend para um sistema que lista restaurantes e salva quais restrições alimentares aquele restaurante está capacitado para atender.


## Referência da API

Todos os endpoints estão disponíveis através do endpoint:
/api/v1/restaurantes

#### Get all items

```http
  GET /restaurantes
```

(Sim é necessário colocar/restaurantes/restaurantes)



#### Get restaurante por tipo de restrição

```http
  GET /restaurante?restricao=${restricao}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `restricao`      | `string` | **Required**. restricao que o restaurante deve atender |


#### Post restaurante

```http
  POST /adicionar
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nome`      | `string` | **Required**. Nome do restaurante |
| `endereco` | `string` | **Required**. Endereco do restaurante|
| `restricao` | `string`| **Required**. Restrição que o restaurante atende|


  
