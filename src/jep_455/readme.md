# Novidades do java 23: JEP 455 - Tipos Primitivos em Padrões, instanceof e switch

#### O JEP 455 vem para simplificar a vida dos desenvolvedores, trazendo suporte para tipos primitivos nos padrões de tipo do Java. Além disso, ele melhora o uso de instanceof e switch, fazendo com que trabalhar com esses tipos fique muito mais prático e seguro. Este é um recurso de pré-visualização, ou seja, é uma funcionalidade experimental que está disponível para que os desenvolvedores possam testar e dar feedback. Ainda não é uma parte oficial da linguagem e pode sofrer alterações antes de ser lançada oficialmente.

## Objetivos
1. Exploração de dados mais fluida: Agora, você pode usar padrões de tipo para todos os tipos, sejam de referência ou primitivos.
2. Consistência em instanceof e switch: Ambos agora tratam tipos primitivos, sem complicação.
3. Conversões mais seguras: Adeus ao medo de perder dados ao converter entre tipos de valor e de referência.

### O que não muda
O JEP 455 não adiciona novos tipos de conversões. Ele apenas facilita o que já existe, tornando o uso mais intuitivo.

## Motivação
### Problema 1: switch não suportava tipos primitivos em padrões

Antes do JEP 455, o switch só funcionava de forma limitada com tipos primitivos. Se você quisesse usar tipos como int ou float em padrões, ficava travado. Era só para tipos de referência, como Integer.

**Antes:**
```java
switch (x.getStatus()) {
    case 0 -> "okay";
    case 1 -> "warning";
    case 2 -> "error";
    default -> "unknown status: " + x.getStatus();
}
```
Depois do JEP 455, agora você pode usar padrões de tipo primitivo diretamente no switch, deixando o código mais simples e elegante.

**Depois:**
```java
switch (x.getStatus()) {
case 0 -> "okay";
case 1 -> "warning";
case 2 -> "error";
case int i -> "unknown status: " + i;
}
```
Não precisa mais de conversões extras ou de um default complicado. Os tipos primitivos estão lá, prontos para uso direto.

### Problema 2: Guardas para tipos primitivos no switch
O JEP 455 também permite que você use guardas (when) em switch, dando mais poder ao seu código para tratar condições mais complexas.

**Antes:**
```java
int flights = x.getYearlyFlights();
if (flights == 0) {
// ...
} else if (flights == 1) {
// ...
} else if (flights == 2) {
issueDiscount();
} else if (flights >= 100) {
issueGoldCard();
} else {
// Ação para outros casos
}
```
Depois do JEP 455, o código fica mais limpo e direto, com guardas dentro do switch:

**Depois:**
```java
switch (x.getYearlyFlights()) {
case 0 -> { /* ... */ }
case 1 -> { /* ... */ }
case 2 -> issueDiscount();
case int i when i >= 100 -> issueGoldCard();
case int i -> { /* Ação para outros casos */ }
}
```
Com o guarda when, você escreve menos e faz mais, sem precisar encadear vários if.

### Problema 3: instanceof não suportava tipos primitivos
Antes do JEP 455, o operador instanceof não funcionava com tipos primitivos. Se você precisasse verificar tipos como int ou float, tinha que fazer conversões manualmente.

**Antes:**
```java
int population = getPopulation();
float pop = (float) population;  // Conversão manual
```
Depois do JEP 455, você pode usar instanceof diretamente para tipos primitivos, o que facilita a sua vida:

**Depois:**
```java
if (getPopulation() instanceof float pop) {
// Uso seguro de pop
}
```
Agora, o compilador cuida da conversão para você, evitando dores de cabeça.

### Problema 4: Padrões de registro com tipos primitivos
Quando se usavam padrões de registro com tipos primitivos, era necessário converter manualmente os valores. Isso tornava o código mais complicado e propenso a erros.

**Antes:**
```java
if (json instanceof JsonObject(var map)
&& map.get("age") instanceof JsonNumber(double a)) {
int age = (int) a;  // Conversão manual
}
```
Depois do JEP 455, as conversões manuais são coisa do passado:

**Depois:**
```java
if (json instanceof JsonObject(var map)
&& map.get("age") instanceof JsonNumber(int age)) {
// Uso direto de age como int
}
```
Tudo fica mais seguro e direto, sem a necessidade de conversões.

### Problema 5: Suporte a mais tipos primitivos no switch
Agora, o switch também aceita mais tipos primitivos, como long, float, double e até boolean.

**Antes:**
```java
long v = ...;
if (v == 1L) {
// Ação para 1L
} else if (v == 10_000_000_000L) {
// Ação para 10 bilhões
}
```
**Depois:**
```java
switch (v) {
case 1L -> { /* Ação para 1L */ }
case 10_000_000_000L -> { /* Ação para 10 bilhões */ }
case long x -> { /* Ação para outros valores */ }
}
```
Agora o switch fica muito mais poderoso, lidando com todos esses tipos primitivos sem esforço.

## O que muda na prática?
1. instanceof mais poderoso: Agora você pode usar tipos primitivos diretamente com instanceof, sem precisar de conversões manuais.
2. switch mais flexível: O switch agora lida com todos os tipos primitivos, permitindo usar padrões de tipo e guardas para condições mais complexas.
3. Mais segurança nas conversões: Como o compilador faz a conversão para você, seu código fica mais seguro e simples.

O JEP 455 é uma adição bem-vinda para os desenvolvedores Java. Ele torna o uso de padrões de tipo mais poderoso e flexível, simplificando a maneira como lidamos com tipos primitivos no código. Como é um recurso de pré-visualização, ele ainda está em fase de testes e pode mudar antes de se tornar uma parte oficial da linguagem. No entanto, já podemos experimentar essas melhorias e, com o tempo, elas prometem deixar o desenvolvimento em Java ainda mais ágil e seguro.

Se você deseja aprofundar seus conhecimentos e aprimorar suas habilidades em programação, confira meus serviços de mentoria! Ofereço mentoria de carreira para desenvolvedores e também apoio para se preparar para certificações AWS. Estou aqui para ajudar você a alcançar seus objetivos. Acesse este link e conheça meus serviços.