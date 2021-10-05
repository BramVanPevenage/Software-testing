# Logboek Software Testing- Bram Van Pevenage
## Week 1:
* bepalen in welke test omgeving ik zal werken
* zoeken van een cursus die ik ga volgen omtrent JUnit
## Week 2:
* de eerste 6 hoofstukken afgewerkt van de cursus die ik volg
    * deze hoofdstukken gingen over best practises van software testing en de eerste JUint testen schrijven
* zo heb ik dus ook men testomgeving opgezet.
* heb men eerste testen gescherven voor een bepaalde klasse
* heb daarna verder geleerd van TDD (Test Driven Development)
* test geschreven in zowel JUnit 4 als JUnit5 
* verder heb ik leren gebruik te maken van maven plugins die helpen bij het opleveren van testen en goede kwaliteitsvolle code.

## Week 3
* Het tweede deel van de drie delige cursus begonnen. Hierbij zijn er 6 hoofstukken die af te werken vallen. Deze gaan verdiepend in op hoe test best geschreven worden.
* Onderdelen die aanbod kwamen  
  * Groepen
    * Tag
    * Suite
    * Category
  * Zorgen dat je testen leesbaar zijn door goede benaming en de annotatie DisplayName. Zodat andere je tests ook kunnen lezen.
  * Princiepe FIRST toepassen om nog betere testen te schrijven.
    * F: hoe je test zo snel mogelijk maken
    * I: zorgen dat je tests onafhankelijk zijn van andere testen, ook de data dat ze gebruiken.
    * R: zorgen dat je testen keer op keer lukken en niet eens om de zoveel keer of soms wel soms niet. belangrijk om rekening te houden met verchillende besturingssytemen.
    * S: zorg ervoor dat je test duideliujk aangeefd of hij geslaagd of gefaald is
    * T: grondig testen ook testen voor zaken dat niet logisch zijn. denk aan happy en sad paths + security
  * naam geving princiepes
  * beschermen tegen het onverwachte
    * edgecases
      * business: hoe gaat je software omgaan met bepaalde problemen -> wat als er 2 liedjes worden aangeduid op het zelfde moment, worden ze beiden afgespeeld?
      * technical & physical: int max 2.147 .... wat als er een groter getal wordt ingegeven
    * corner cases : situaties waar uw programma zick kan in bevinden
  * Mockito gaan geruiken
    * gebruik maken van mock data and mock klassen
      * waarom zodat je geen meerdere klassen in 1 unit test gaat testen-> bv. iets loggen daarvoor heb je ook de logger klasse nodig.
      * spying: gebruik maken van echte instanties niet zoals bij mocking waar je een valse instantie gaat gebruiken -> is tegen het FIRST princiepe.
      * doAwnser: gebruikt voor een mock dat meerdere keren geroepen moet worden
      * mock static methodes gebruik maken van powermock, liefst zo min mogelijk. probeer je code anders op te bouwen indien mogelijk.
      * argumentCaptor: om effectief de argumenten vastteleggen waarmee je de mock gaat oproepen. handig wanneer je argumenten niet direct zichaar zijn.
  * pratice implementing subration using red-green-refactor
    * een oefening van hun voorgescholteld -> afgewerkt.
* ik heb al deze voorbeelden ook al geïmplementeerd op hun voorbeeld oefeningen en ben daarnaast bezig met een eigen project op te bouwen.
  * tot 2.1 op eigen geïmplmenteerd.
* verder ben ik begonnen aan derde en eveneens het laatste deel van de cursus
  * heb bekeken hoe we units hun samenwerking gaan testen.
    * integration tests
      * component: tests of een aantal units met alkaar kan samenwerken
      * system: test datje units in een gedeeltelijke draaiend systeem kunnen werken.
    * end-to-end: heel het systeem runnen en testen met een user 
    * acceptance : business testing kan in verschillende lagen gebeuren.

# Bronnenlijst
| #   | Links                                                                                                                                                                                                                                           |
| --- | ------------------------------------------------------------------- |
| #01 |  [Cursus](https://openclassrooms.com/en/courses/5661466-use-testing-in-java-to-achieve-quality-applications)             |
| #02 |  []()   |
| #03 |  []()   |
| #04 |  []()   |
| #05 |  []()   |
| #06 |  []()   |
