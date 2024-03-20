Feature: post the something


  @post_02
  Scenario Outline: we are posting something
    Given to set the uri of that site
    And add the value as the userid as <user id>
    When we called the the api and printing the id
    Then validate the status code and id is not null
    Examples:
      | user id |
      | 5       |

