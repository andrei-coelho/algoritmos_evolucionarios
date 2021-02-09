# Algoritmo Genético para Problema de Cargas

Este algoritmo tenta encontrar solução para carregar um caminhão com os produtos mais valiosos sem estourar o seu limite máximo de espaço.

## Sem uso do crossover para realizar descendentes e mutações

População de 1.000 individuos:

```
Nota Avalicao: 24055.000000000004
Espaco Usado: 2.7014890000000005
Produtos: 
 [ 
    Geladeira Dako
    Iphone 6
    TV 55'
    TV 50'
    TV 42'
    Notebook Dell
    Microondas Panasonic
    Notebook Lenovo
    Notebook Asus
 ]


```

População de 100.000 individuos:

```
Nota Avalicao: 24993.460000000003
Espaco Usado: 2.9172890000000002
Produtos: 
 [ 
    Iphone 6
    TV 55'
    TV 50'
    TV 42'
    Notebook Dell
    Microondas Electrolux
    Microondas LG
    Microondas Panasonic
    Geladeira Consul
    Notebook Lenovo
    Notebook Asus
 ]
 ```
## Com uso do crossover para realizar descendentes e mutações

Com uma população de 1.000 individuos de duas gerações, o que dá cerca de 1500 individuos gerados, chegamos ao mesmo resultado do anterior com 100.000 individuos gerados. Veja:

População de 1.000 individuos com 2 gerações:

 ```
Nota Avalicao: 24993.460000000003
Espaco Usado: 2.9172890000000002
Produtos: 
 [ 
    Iphone 6
    TV 55'
    TV 50'
    TV 42'
    Notebook Dell
    Microondas Electrolux
    Microondas LG
    Microondas Panasonic
    Geladeira Consul
    Notebook Lenovo
    Notebook Asus
 ]
```

Isso mostra a importância do crossover e das mutações dentro algorítmo genético em problemas em que a quantidade de indivíduos precisam ser reduzidas em função da sua complexidade e do custo computacional.