Feature: Jira Issue

  Scenario Outline: Create a Jira Issue
    When place the post request with key as <key> and summary as <summary> and description as <description> and name as <name>
    Then verify the status code for jira as 201
    And verify jira content type as 'json'
    And verify key as <key>
    And print response for jira
    Examples:
      | key  | summary                                        | description                          | name |
      | VEER | create issue1 in Veer project by Veer using RA | Creating of an issue1 using Cucumber | Bug  |
      | VEER | create issue2 in Veer project by Veer using RA | Creating of an issue1 using Cucumber | Bug  |

  Scenario Outline: Update a Jira Issue
    When place the put request with key as <key> and summary as <summary> and description as <description> and name as <name>
    Then verify the status code for jira as 204
    And verify jira content type as 'json'
    And print response for jira for update
    Examples:
      | key  | summary                                        | description                          | name |
      | VEER | Update issue1 in Veer project by Veer using RA | Updating of an issue1 using Cucumber | Epic  |
    Scenario: Delete a Jira Issue
      When Place the delete request with id
      Then verify the status code for jira as 204
      And verify jira content type as 'json'
      And print response for jira delete