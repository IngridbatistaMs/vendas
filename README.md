# vendas

## Rotas:
* Cadastrar um Produto:  
    * Método: POST
    * Rota: /products
    * Body: 
    ```
    {
	    "name": "Produto A",
	    "value": 20.99
    }
    ```
* Exibir Produtos: 
    * Método: GET
    * Rota: /products

<br/>

* Adicionar Produto ao Carrinho: 
    * Método: PUT
    * Rota: /cart/addToCart/{cartId}/{productId}    

<br/>

* Cadastrar um Carrinho: 
    * Método: POST
    * Rota: /cart

<br/>

* Exibir Carrinhos: 
    * Método: GET
    * Rota: /cart

<br/>

* Exibir um carrinho: 
    * Método: GET
    * Rota: /cart/{cartId}

<br/>

* Efetuar Compra (Finalizar Carrinho): 
    * Método: PUT
    * Rota: /cart/make/{cartId}

<br/>

* Exibir Histórico de Compras: 
    * Método: GET
    * Rota: /cart/history
