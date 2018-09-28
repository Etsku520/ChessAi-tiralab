## Testit
Tällä hetkellä käytännössä kaikki testit ovat metodien testausta.
Testit on toteutettu junit:lla. Erillaisia syötteitä ei hirveänä ole jonka takia moni virheistä löytyy
kun testaa itse toimivia osia ohjelmasta. Ja no testien toisto onnistuu junit:lla.

Ainut testin oloinen asia, jota ei tehty junit:lla oli testi siitä monta vuoroa peliä voin simuloida. 
Ohjelma onnistui simuloimaan 4 vuoroa. Kun yritti 5 vuoroa, kesti se kauan ja lopulta tuli muistin ylivuoto.
Näitä voi itse testata vaihtamalla makeTree() metodin syötettä, tosin tekoäly ei toimi, jos syöte on pariton luku. 
Kannattaa myös huomata, että vuoroja simuloidaan syöte + 1.
