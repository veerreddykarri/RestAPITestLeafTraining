Feature: Incident Management

  Scenario: Create a new Incident without body
    When place the post request
    Then verify the status code as 201
    And verify content type as 'json'

  Scenario Outline: Create a new Incident with body
    When place the post request with short_description as <short_description> and category as <category>
    Then verify the status code as 201
    And verify content type as 'json'
    And verify short_description as <short_description> and category as <category>
    And print response
    Examples:
      | short_description                       | category |
      | create incident with body json as data1 | software |
      | create incident with body json as data2 | hardware |