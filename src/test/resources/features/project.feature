Feature: project

  @schools
  Scenario: copy tutorial
    Given I open the "w3schools.com"
    When I copy "Tutorial" word
    When I open the "google.com"
    When I paste "Tutorial" to the search field and click the Enter
    Then I check that all result links contain the word "Tutorial"

  @demo
  Scenario: select all
    Given I open "demoQA.com"
    When I click on the Select Value Dropdown
    Then I select Group1 Option1
    Then I click on the Select One Dropdown
    Then I select Dr
    Then I select Blue Of Old Style Select Menu
    Then I click on the Multi Select Dropdown
    Then I select Green
    Then I select Audi in the Standard Multi Select
    Then I check that all fields are selected

