Feature: Feature1

  Scenario: Senaryo1 (anasayfada bütün resimler tanımlı mı)
    Given user goes to "https://brandstore.e-shopland.ch/"
    When control image with getAttribute at homepage
    Then driver quit

  Scenario: Senaryo2 Tüm ürünler (Tüm ürünlerin resimleri ve fiyat bilgileri var mi)
    Given user goes to homepage
    And go to alle produkte
    When control image all produkte
    And  go to alle produkte
    When control price all produkte
    Then driver quit

  Scenario: Senaryo3 Tüm ürünler (kategoriler dropdown calisiyor mu)
    Given user goes to homepage
    And  go to alle produkte
    When control kategorien dropdown
    Then driver quit

  Scenario: Senaryo4  Tüm ürünler (siralama islemi düzgün calisiyor mu)
    Given user goes to homepage
    And  go to alle produkte
    When sort by price ascending
    And sort by price desc
    And sort by rating
    Then driver quit


  Scenario: Senaryo5  Tüm ürünler (Ürün filtreleme düzgün calisiyor mu(renk)?)
    Given user goes to homepage
    And  go to alle produkte
    When filter nach farbe(colour)
    Then driver quit

  Scenario: Senaryo6  Tüm ürünler (Ürün filtreleme düzgün calisiyor mu(boyut)?)
    Given user goes to homepage
    And go to alle produkte
    When filter nach grosse
    Then driver quit

  Scenario: Senaryo7  Tüm ürünler (Ürün filtreleme düzgün calisiyor mu(material)?)
    Given user goes to homepage
    And go to alle produkte
    When filter nach material
    Then driver quit

  Scenario: Senaryo8  Tüm ürünler (Ürün filtreleme düzgün calisiyor mu(Gender)?)
    Given user goes to homepage
    And go to alle produkte
    When filter nach gender
    Then driver quit







