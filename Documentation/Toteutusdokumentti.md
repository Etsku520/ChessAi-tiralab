## Yleisrakenne
Ohjelmaan kuuluu shakki, käyttöliittymä, tietorakenteet ja tekoäly. Shakkiin sisältyy muun muassa lauta, logiikka ja 
apuluokkia kordinaatti ja liike.

## Aika- ja tilavaativuus
Aika hirvittävätlä näyttää, tekoäly tekee puuta kaikista liikkeistä joten sen aika vaativuus on luokkaa k^n, missä
k esittää liikkeiden määrää ja n on kerroksien määrä. Kertoimia tulee melko hirveästi lisää, 
koska ohjelma ei ole optimoinnista ikinä kuullutkaan. 
Tällä hetkellä ohjelma pystyy simuloimaan 4 vuoroa eteenpäin ennen kuin jää jumiin.

Tilavaativuus on lähellä samaa, mutta vielä hirveämpi. Koska sen pitää ensinnäkin tallentaa puu 
joka on saman kokoinen kuin aikavaativuus. Sen lisäksi jokaiseen solmuun on tallennettu oman tilanteen shakkilauta. 
Muistaakseni oli vielä jotain joka söi muistia.

## Puutteet ja parannukset
Työ on tällä hetkellä pelkkiä puutteita joten kitjoitan niistä myöhemmin.

## Lähteet
Arvoja shakkinappuloille ja sijainneille: 

Lauri Hartikka, Mar 30, 2017, https://medium.freecodecamp.org/simple-chess-ai-step-by-step-1d55a9266977

Tarkempaa muistelua min-maxista:

Rashmi Jain, March 31, 2017, https://www.hackerearth.com/blog/artificial-intelligence/minimax-algorithm-alpha-beta-pruning/
