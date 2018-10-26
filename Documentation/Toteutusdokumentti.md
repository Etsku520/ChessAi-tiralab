## Yleisrakenne
Ohjelmaan kuuluu shakki, joka sisältää kaikki ne luokat jotka liittyvät shakin toimintaan kuten sen logiikka ja lauta, käyttöliittymä, joka sisältää käyttöliittymän, tietorakenteet, joka sisältää kaikki itse tehdyt tietorakenteet ja tekoäly, joka sisältää tekoälyn ja apuluokan joka tekee arvointia vatrten matriiseja. Sen lisäksi on vielä main, sekä benchmark, jonne laitoin aika testejä ohjelmaa varten.

## Aika- ja tilavaativuus
Aikavaativuus on melko suuri, tekoäly tekee puuta kaikista liikkeistä joten sen aika vaativuus on luokkaa k^n, missä
k esittää liikkeiden määrää ja n on kerroksien määrä. k:n kokoa ei oikein voi sanoa, sillä se vaihtuu koko ajan jopa kerroksien välillä ja se voi joko olla todella suuri tai toisessa ääritapauksessa jopa 0. Aikaa tietenkin kuluu myös logiikassa, koska lauta käydään monta kertaa läpi, mutta se ei aikavaativuuden luokkaan juuri vaikuta.


Tilavaativuus on lähellä samaa. Koska sen pitää tallentaa puu, jossa on k^n kappaetta solmuja. Sen lisäksi jokaiseen solmuun on tallennettu oman tilanteen shakkilauta.

## Puutteet ja parannukset
Työn optimointi olisi vielä mahdollista. En esimerkiksi ehtinyt käyttää optimointi menetelmää nimeltä "Alpha-beta pruning", jossa puita ei aina tarvitsisi, tehdä loppuun asti.
Käyttöliittymä voisi aina parantaa, mutta tekstikäyttöliittymäksi se on mielestäni ihan hyvä.

Tekoälyä voisi parantaa vielä monella tavalla. Sen loppu peli on kauheaa, sillä se ei näe tarpeeksi pitkälle, että se osaisi siirtää nappuloita toiselta puolelta lautaa lähemmäs vihollisten kuningasta. Tämä yleensä johtaa kahden tekoälyn välillä tilanteeseen, jossa ne jäävät pyörimään paikoilleen. Tekoäly on myös todella helppo päihittää jos tietää mitään valmiita strategioita, sillä botti ei kauhean pitkälle osaa ennustaa.
Viimeisenä on se, että testejä voisi olla enemmän. Jos saisin oikeasti kaiken testattua täydellisesti olisi se melko hyödyllistä, 
mutta testien tekeminen vie todella paljon aikaa ja tekoälyssä en edes tiedä mitä testaisin. 

## Lähteet
Arvoja shakkinappuloille ja sijainneille: 

Lauri Hartikka, Mar 30, 2017, https://medium.freecodecamp.org/simple-chess-ai-step-by-step-1d55a9266977

Tarkempaa muistelua min-maxista:

Rashmi Jain, March 31, 2017, https://www.hackerearth.com/blog/artificial-intelligence/minimax-algorithm-alpha-beta-pruning/
