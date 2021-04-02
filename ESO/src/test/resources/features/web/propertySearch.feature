@regression
Feature: Search on the website
  In order to search with the different criteria
  As a user
  the matching properties should be populated

  Background: User is on the home page
    Given User is on the home page

  Scenario: Select the Search Criteria in the Search box
    When user clicks on search area
    And clicks on My Location icon
    Then the search criteria should start populating in the Search box

  Scenario Outline: Search the My Location populates correct results
    When user clicks on search area
    And clicks on My Location icon
    And clicks on button "<purpose>"
    Then the matching records should start populating on the page for My Location

    Examples:
      | purpose  |
      | FOR SALE |
      | FOR RENT |

  Scenario Outline: Search of the property using the user entered criteria populates correct results
    When user clicks on search area
    And enters the search criteria as "<searchCriteria>" in the searchbox
    And clicks on button "<purpose>"
    Then the matching records should start populating on the page
    And user clicks on the new homes

    Examples:
      | purpose  | searchCriteria |
      | FOR SALE | BT6            |
      | FOR RENT | BT6            |

  Scenario Outline: Search of the property using the INCORRECT user entered criteria populates no results
    When user clicks on search area
    And enters the search criteria as "<searchCriteria>" in the searchbox
    And clicks on button "<purpose>"
    Then no records should be found for the incorrect search

    Examples:
      | purpose  | searchCriteria |
      | FOR SALE | France         |
      | FOR RENT | $%^&*()_       |
