Feature:we are sending one request based on values and get result of that json

  @nt-thai
  Scenario Outline: fetching details
    Given to set the uri of that site in nt thai
    When set the values as <price> and "<description>"
    Then validate the id is present or not in nt thai
    Examples:
      |    price  | description  |
       |  13.5| lorem ipsum set |
