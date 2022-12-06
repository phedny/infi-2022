Infi AoC 2022
=============

Deze repository bevat een inzending voor de Infi AoC uitdaging van 2022.

Uitvoeren
---------

Vanaf de command line kan de applicatie direct gestart worden:

```shell
./gradlew run
```

Bouwen
------

Om een jar-bestand van de applicatie te maken die geschikt is voor distribute,
gebruik het volgende commando:

```shell
./gradlew clean build
```

Dit jar-bestand is geschikt om middels `java` uit te voeren:

```shell
java -jar build/libs/infi-2022-1.0-all.jar
```

Mooiere uitvoer
---------------

Standaard genereert de applicatie output met enkel karakters die in ASCII
voorkomen, waardoor de uitvoer op elke terminal leesbaar is. Het is mogelijk om
uitvoer te vragen die gebruik maakt van Unicode-karakters om de kerstman en
dienst voetstappen in de sneeuw te zien. Deze versie is te activeren door `-u`
of `--unicode` mee te geven als argument aan de applicatie:

```shell
./gradlew run --args="--unicode"
```

Of wanneer een gebouwd jar-bestand wordt gebruikt:

```shell
java -jar build/libs/infi-2022-1.0-all.jar --unicode
```

De uitvoer van de Unicode-versie geeft enkel een correct resultaat wanneer de
gebruikte terminal het voetstap-karakter (U+1F463) even breed rendert als de
ideografische spatie (U+3000). Indien dit niet het geval is, zal er bij deel 2
geen goed leesbaar woord zichtbaar zijn.
