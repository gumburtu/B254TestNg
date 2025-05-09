# yorum satiri icin ctrl + /
# Her bir feature file Feature: keywordu ile baslamak zorundadir ve sadece 1 tane kullanilabilir
# Feature file da test scenariolarimizi Scenario keywordu ile tanimlariz, ve istedigmiz kadar kullanabiliriz


Feature: US001 Amazon Home Page Test

  Scenario: TC01 Search for iphone in the search box
    Given Kullanici amazon sayfasina gider
    When Arama kutusunda iphone aratir
    And Sayfayi kapatir

  Scenario: TC02 Search for samsung in the search box
    Given Kullanici amazon sayfasina gider
    When Arama kutusunda samsung aratir
    And Sayfayi kapatir