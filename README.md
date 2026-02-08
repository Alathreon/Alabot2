# Alabot2
Discord Bot Alabot 2.0

# Requirements
- Java 25

# Setup
- Copy `config.json.template` and rename it to `config.json`
- Fill it accordingly
- [Build](#Build)
- [Run](#Run)

# Build
```shell
./mvnw clean install
```

# Run

It will by default use `config.json` at the root of the project. But can be overridden by giving a path as the program argument.

## Directly

```shell
./mvnw exec:java
```

## The Jar

```shell
java -jar ./target\alabot2-1.0-SNAPSHOT-jar-with-dependencies.jar
```
