<img alt="Logo" src="http://coderslab.pl/svg/logo-coderslab.svg" width="400">

#  Tworzenie bazy danych i tabel

Wszystkie zapytania do bazy wykonuj w **konsoli**, dodatkowo zapisz treść zapytań do plików ``java`` przygotowanych do każdego zadania.  
Zadania z wykładowcą i zadania samodzielne będą wykonywane na **2 różnych** bazach danych.

#### Zadanie 1 - rozwiązywane z wykładowcą.
W pliku `Main1.java`:

1. Stwórz nową bazę danych o nazwie ```products_ex```. Zapytanie SQL zapisz w zmiennej `query`.
2. Następnie napisz kod w metodzie `main`, który stworzy połączenie do tej bazy danych.


#### Zadanie 2 - rozwiązywane z wykładowcą.
W pliku `Main2.java`:

W bazie danych o nazwie ```products_ex``` stwórz następujące tabele:
```SQL
* Products:
  * id: int
  * name: string
  * description: string
  * price: decimal (2 decimal places)
* Orders:
  * id:int
  * description: string
* Clients:
  * id: int
  * name: string
  * surname: string
```

Zapytania SQL zapisz w przygotowanym pliku.
**Pamiętaj aby użyć odpowiednich typów danych dla każdej kolumny w bazie.**

-----------------------------------------------------------------------------

#### Zadanie 3
W pliku `Main3.java`:

1. Stwórz nową bazę danych o nazwie ```cinemas_ex```. Pamiętaj że, jeżeli baza już istnieje, to nie da się jej stworzyć.  
2. Następnie napisz kod w metodzie `main`, który stworzy połączenie do tej bazy danych.

#### Zadanie 4
W pliku `Main4.java`:

W bazie danych o nazwie ```cinemas_ex``` stwórz następujące tabele (Jeżeli tabela już istnieje, to nie da się jej stworzyć - SQL zwróci błąd):
```SQL
* Cinemas:
  * id: int
  * name: string
  * address: string
* Movies:
  * id: int
  * name: string
  * description: string
  * rating: decimal (2 decimal places)
* Tickets:
  * id: int
  * quantity: int
  * price: decimal (2 decimal places)
* Payments:
  * id: int
  * type: string
  * date: date
```

Zapytania SQL zapisz w przygotowanym pliku.  
Pamiętaj o:  
1. Zakładaniu odpowiednich atrybutów na pola (np. każde **id** powinno być kluczem głównym i być automatycznie numerowane).  
2. **Używaniu odpowiednich typów danych dla każdej kolumny w bazie.**  
3. **Dokładnym czytaniu kodu błędów zwracanych przez MySQL.**  
