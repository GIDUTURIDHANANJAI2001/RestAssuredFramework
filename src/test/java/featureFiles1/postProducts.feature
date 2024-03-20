Feature:we are sending one request based on values and get result of that json

  @POST
  Scenario Outline: fetching details
    Given to set the uri of that site
    When set the values as "<Title>" and <price> and "<description>" and "<image>" and "<catagorey>"
    Then validate the id is present or not
    Examples:
      | Title        | price | description     | image                 | catagorey   |
      | test product | 13.5  | lorem ipsum set | https://i.pravatar.cc | electronic" |


