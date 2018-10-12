## Testit
Junitilla on tehty jonkin verran testejä, jotta saataisiin kaikki vaihtoehdot käytyä läpi taritaan todennäköisesti satoja testejä.
Testeissä on testattu tietorakentaita ja logiikkaa. Kaikkien testien syötteet ovat melko sattuman varaisia, koska testeissä olen testannut yleistä toimivuutta, kun kaikkien yksityiskohtien testaamiseen menisi todella paljon aikaa.

Ainut testin oloinen asia, jota ei tehty junit:lla oli testi siitä monta vuoroa peliä voin simuloida. 
Ohjelma onnistui simuloimaan 4 vuoroa. Kun yritti 5 vuoroa, kesti se kauan ja lopulta tuli muistin ylivuoto.
Näitä voi itse testata vaihtamalla makeTree() metodin syötettä, tosin tekoäly ei toimi, jos syöte on pariton luku. 
Kannattaa myös huomata, että vuoroja simuloidaan syöte + 1.
