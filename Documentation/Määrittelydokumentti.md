Minmax algoritmi tulee todennäköisesti olemaan koko homman ydin sillä sen avulla tekoäly tulee päättää minkä liikkeen tekee. Tietorankenteista tarvitaan listoja ja puita minmax algoritmin toteuttamiseen (ehkä kekoja saa nähdä miten käy). Shakki laudasta tulee todennäköisesti matriisi, jossa näkyy mikä nappulla missäkin kohdassa on.

Suurin ongelma on tietenkin se miten tekoälyn saa tekemään järkeviä liikkeitä, jotka johtaisivat hyvään lopputulokseen. Tätä varten minmax algoritmi on hyvä, jos vain keksii miten liikkeet arvostelee. Tälläinen minmax algoritmi toimii puu rakenteen tavoin kun se haarautuu aina kaikkiin mahdollisiin liikkeisiin, joten luonnollisesti päädyin siihen, että tarvitsen puu rakennetta. Ilman jonoja en ole monesta asiasta selvinnyt ja joudun todennäköisesti tallettamaan tietoa väliaikaiseti jonoon/kekoon.

Ohjelma saa syöttekseen shakki laudan ja sen nappulat. Tarkka muoto ei ole aivan varma mutta todennäköisesti se matriisi. Sen avulla algoritmi katsoo kaikki siirrot ja valistee niistä parhaan.

Algortimin aika- ja tilavaativuus kasvaa eksponentiaalisesti jokaisen uuden simuloidun vuoron myötä ja optimoinninkin jälkeen se on sama pahimmassa tapauksessa. Joten pitää vain kokeilla miten monta vuoroa uskaltaa simuloida ja kannattaako tarkkuutta laskea, jotta voi simuloida pidemmälle.

Lähteitä ei juuri ole vielä, mutta olen vilkuillut yhtä Lauri Hartikkan sivua https://medium.freecodecamp.org/simple-chess-ai-step-by-step-1d55a9266977 (08.09.2018)

Kyseisellä sivulla oli myös linkkejä ihan kivan näköisiin shakki kirjastoihin joita varmaan vähä vilkuilen myöhemmin.
