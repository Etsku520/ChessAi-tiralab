## Yleisrakenne
Ohjelmaan kuuluu shakki, käyttöliittymä, tietorakenteet ja tekoäly. Shakkiin sisältyy muun muassa lauta, logiikka ja 
apuluokkia kordinaatti ja liike.

## Aika- ja tilavaativuus
Aika hirvittävätlä näyttää, tekoäly tekee puuta kaikista liikkeistä joten sen aika vaativuus on luokkaa k^n, missä
k esittää liikkeiden määrää ja n on kerroksien määrä. Aikaa tietenkin kuluu myös logiikassa, koska lauta käydään monta kertaa läpi, mutta se ei aikavaativuuteen juuri vaikuta


Tilavaativuus on lähellä samaa. Koska sen pitää ensinnäkin tallentaa puu joka on saman kokoinen kuin aikavaativuus. Sen lisäksi jokaiseen solmuun on tallennettu oman tilanteen shakkilauta.

## Puutteet ja parannukset
Työn optimointi olisi vielä mahdollista ja en edes saanut puiden uudelleen käyttöä toimimaan, koska jokin ohjelmassa sekosi pahasti.
Botti söi minun omalla nappulalla, minun nappulani. En ole vieläkään varma mites se on edes missään tapauksessa mahdollista.
Käyttöliittymä on myös vähän huono, mutta en tiedä onko sen parantamiseen kauheana aikaa.

Viimeisenä on se, että testejä voisi olla enemmän. Jos saisin oikeasti kaiken testattua täydellisesti olisi se melko hyödyllistä, 
mutta se tulisi viemään todennäköisesti vähintään 8 tuntia. Joittenkin kattavuus testien käyttöön otto voisi myös olla hyvä idea, mutta tulokset olisivat niin masentavia etten ole vielä siihen asti jaksanut mennä.

## Lähteet
Arvoja shakkinappuloille ja sijainneille: 

Lauri Hartikka, Mar 30, 2017, https://medium.freecodecamp.org/simple-chess-ai-step-by-step-1d55a9266977

Tarkempaa muistelua min-maxista:

Rashmi Jain, March 31, 2017, https://www.hackerearth.com/blog/artificial-intelligence/minimax-algorithm-alpha-beta-pruning/
