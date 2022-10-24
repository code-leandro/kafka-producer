# Criando um produtor de mensagens com kafka e spring boot

## Instruções
1. Faça o download do kafka em https://kafka.apache.org/downloads
Depois de descompactar, execute
```
./bin/zookeeper-server-start.sh config/zookeeper.properties 
./bin/kafka-server-start.sh config/server.properties 
```

2. Clone esse projeto. Tendo o maven instalado na máquina, execute: 
```
mvn spring-boot:run
```

## Chame uma requisição post com curl ou postman para enviar uma mensagem para o Kafka:
```
curl -X POST localhost:8080/person
```

## Escutando as mensagens produzidas pelo terminal
./bin/kafka-console-consumer.sh --topic topic-person --from-beginning --bootstrap-server localhost:9092
