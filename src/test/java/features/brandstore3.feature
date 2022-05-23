Feature: Featuere3
  Scenario: Senaryo9 (Favorilere ürün eklenip, kaldirilabiliyor mu?)
    Given user goes to homepage
    And go to alle produkte
    When add and delete favorite random
    Then driver quit

  Scenario: Senaryo11 (Arama fonksiyonu düzenli calisiyor mu?)
    Given user goes to homepage
    And go to alle produkte
    When search product on menu and left
    Then driver quit

  Scenario: Senaryo12 (  Scenario: Senaryo12 (Ürün karsilastirmasi yapilabiliyor mu?)
    Given user goes to homepage
    And go to alle produkte
    When product comparison
    Then driver quit




