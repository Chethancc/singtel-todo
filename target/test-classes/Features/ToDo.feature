Feature: To verify all the scenarios of ToDo Application

  @SmokeTest
  Scenario: To Verify the home page of todoApplication
    Given user is on the home page
    Then Verify all the elements are present in the home page

  @RegTest
  Scenario: To create multiple todos and verify its displayed on the screen
    Given user is on the home page
    When user Enters the todos in the site
    | test | test1 |
    Then all the todos must be displayed
    | test | test1 |


  @RegTest
  Scenario: To create todo and mark it completed and verify its displayed in completed Link
    Given user is on the home page
    When user Enters the todos in the site
      | test |
    And marked it as completed
      | test |
    Then it should be displayed in completed section
      | test |

  @RegTest
  Scenario: To create todo and mark it completed and verify its displayed in All link
    Given user is on the home page
    When user Enters the todos in the site
      | test |
    And marked it as completed
      | test |
    Then it should be displayed in All section
      | test |

  @RegTest
  Scenario: To create todo and mark it completed and verify its its not displayed in Active link
    Given user is on the home page
    When user Enters the todos in the site
      | test |
    And marked it as completed
      | test |
    Then it should be not displayed in active section

  @RegTest
  Scenario: To create todo and mark verify its displayed in ActiveLink
    Given user is on the home page
    When user Enters the todos in the site
      | test |
    Then it should be displayed in Active section
     | test |

#No implemented only scenarios written

#  Scenario: To clear completed and verify the data in Active

# To clear completed data and verify in Completed Tab


# To clear completed data and verify in all tab

#  To verify
