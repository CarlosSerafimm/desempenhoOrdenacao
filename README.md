DesempenhoOrdenação
Este programa Java avalia o desempenho de diversos algoritmos de ordenação em vetores de diferentes tamanhos e configurações (aleatório, ordenado e reverso). Ele mede o tempo de execução e o número de trocas realizadas por cada método de ordenação.

Funcionalidades
Implementa seis algoritmos de ordenação:
Selection Sort
Insertion Sort
Bubble Sort
Merge Sort
Quick Sort
Método Arrays.sort do Java
Suporta avaliação para vetores de tamanhos variados: 100, 1000, 5000, 10000 e 20000.
Testa três tipos de dados de entrada:
Aleatório: Gerado com números inteiros aleatórios.
Ordenado: Pré-ordenado em ordem crescente.
Reverso: Pré-ordenado em ordem decrescente.
Calcula:
Tempo de execução (em segundos).
Número de trocas realizadas (exceto para Arrays.sort).
Como o Programa Funciona
Geração de Dados:

Os vetores são gerados aleatoriamente e, dependendo do tipo de dados selecionado, podem ser ordenados ou invertidos antes de serem processados.
Testes de Algoritmos:

Cada vetor é clonado para evitar interferências entre os testes de diferentes algoritmos.
O desempenho de cada algoritmo é avaliado com base no tempo de execução e, quando aplicável, no número de trocas realizadas.
Saída:

Para cada combinação de tamanho de vetor e tipo de dado, o programa exibe os resultados dos algoritmos no console.
Algoritmos de Ordenação Implementados
Selection Sort: Seleciona o menor elemento e troca com a posição correta.
Insertion Sort: Insere cada elemento na posição correta em um subconjunto já ordenado.
Bubble Sort: Repetidamente troca elementos adjacentes fora de ordem.
Merge Sort: Divide o vetor em partes menores, ordena e mescla.
Quick Sort: Usa um pivô para particionar e ordenar recursivamente.
Arrays.sort: Algoritmo interno otimizado do Java (não rastreia trocas).
Como Executar
Compile o código usando:
bash
Copy code
javac DesempenhoOrdenacao.java
Execute o programa:
bash
Copy code
java DesempenhoOrdenacao
Estrutura de Código
Geração de vetores:

Função gerarVetor(int tamanho, String tipo): Cria os vetores com os tipos de dados especificados.
Função reverterVetor(int[] vetor): Inverte a ordem dos elementos no vetor.
Testes de Algoritmos:

Cada algoritmo possui um método específico para executar os testes, como testarSelectionSort(int[] vetor).
Medição de Desempenho:

O tempo é medido em nanosegundos usando System.nanoTime().
O número de trocas é contado por uma variável global trocas.
Exemplo de Saída
yaml
Copy code
Tamanho: 100, Tipo de Dados: Aleatório
Selection Sort: 0.001230 segundos, Trocas: 4950
Insertion Sort: 0.000420 segundos, Trocas: 240
Bubble Sort: 0.002340 segundos, Trocas: 4950
Merge Sort: 0.000150 segundos, Trocas: 600
Quick Sort: 0.000070 segundos, Trocas: 105
Arrays.sort: 0.000050 segundos (não rastreia trocas)
Autor
Este programa foi desenvolvido para fins educacionais, demonstrando como diferentes algoritmos de ordenação se comportam com vetores de diferentes tamanhos e características.
