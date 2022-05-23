Feature:  Brandstore1

  Background: : Background Project
    Given user goes to "https://brandstore.e-shopland.ch/"
    And go to Login page
    When login with username "kursjava@gmail.com" and password "kurs.java.123"


  Scenario: Senaryo10 (Enson tiklanan ürün sol kategoriler altinda bulunan "Son görüntülenenler" kisminda listeleniyor mu?)
    Given go to alle produkte
    When click random product
    Then driver quit

  Scenario: Senaryo13 (sepete ürün ekle ve satın al)
    Given user goes to homepage
    And go to alle produkte
    When add product to cart
    And buy product









