Feature: Change Management

  Scenario Outline: Create a new Change with body
    When place the post request with short_description as <short_description> and type as <type>
    Then verify the status code for change as 201
    And verify change content type as 'json'
    And verify short_description as <short_description> and type as <type>
    And print response for change
    Examples:
      | short_description | type      |
      | Add RAM           | normal    |
      | Display issue     | normal |