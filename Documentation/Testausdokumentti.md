## Testit
Junitilla on tehty jonkin verran testejä, jotta saataisiin kaikki vaihtoehdot käytyä läpi taritaan todennäköisesti satoja testejä.
Testeissä on testattu tietorakentaita ja logiikkaa. Kaikkien testien syötteet ovat melko sattuman varaisia, koska testeissä olen testannut yleistä toimivuutta, kun kaikkien yksityiskohtien testaamiseen menisi todella paljon aikaa.

Olen myös tehnyt testauksia siitä kuinka paljon aikaa menee puun tekemiseen (ja samalla liikeiden arviointiin).
Ohjelma onnistui simuloimaan 4 vuoroa 5270 millisekunnissa, 3 vuoroa 284 millisekunnissa, 2 vuoroa vei 49 millisekunttia ja 1 vuoro noin 12 ms. Kun yritti 5 vuoroa, kesti se kauan ja lopulta tuli muistin ylivuoto.
Testin voi helposti tehdä käyttöliittymän kautta ohjelmassa.
Tosin tässä kaikki puut on tehty alkaen laudan alkutilanteesta.

![Test](Pictures/time_for_tree.png)

Myös itse pelissä näkyy kuinka kauan tekoäly mietti liikettään.
joka on yleensä pidempi, vaikka koko puuta ei tarvitsekkaan tehdä uudestaan.

![Test2](Pictures/time_for_move1.png)
![Test3](Pictures/time_for_move2.png)
![Test4](Pictures/time_for_move3.png)
