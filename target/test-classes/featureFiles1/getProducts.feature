Feature: get products in the site

  @checking
  Scenario: get all the products in the site
    Given to set the uri of that site
    When to get the products from the site
    Then validate the products