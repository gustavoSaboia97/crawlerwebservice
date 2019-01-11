# Crawler
Teste para desenvolvedor back-end

Esta aplicação é um web service simula uma situação na qual através de login com as credenciais corretas você tem acesso a um json extraido a partir do seguinte link de xml:

````
http://revistaautoesporte.globo.com/rss/ultimas/feed.xml
````

* Link do teste: https://github.com/Infoglobo/desafio-back-end

## Container Docker

Este repositório, conta com um diretório que contém um Dockerfile para que a aplicação apenas seja executada a partir de um container.

### Criar imagem
A partir do diretório Dockerfile, para executar a aplicação a partir do container:
#### Docker build
````
docker build -t crawler .
````
#### Docker run
````
docker run -it --rm -p 8080:8080 crawler /bin/bash
````
* Aonde: ' -p PORTA_DESEJADA:8080 '

## Credenciais

A autenticação é feita por Basic Auth:
```
user: user
password: 123456
```