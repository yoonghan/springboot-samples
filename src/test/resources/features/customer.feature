Feature: the customer can be retrieved
  Scenario: client makes call to GET /customer/
    When the client calls /customer/
    Then the client receives status code of 200
    And the client receives response with json [{"id":"0", "firstName": "_firstname", "lastName": "_lastname"}]
  Scenario: client makes call to POST /customer/
    When the client posts /customer/ with {"id":"0", "firstName": "_firstname", "lastName": "_lastname"}
    Then the client receives status code of 200