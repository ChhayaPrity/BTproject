Feature: BT Website Test

  Scenario: Verify Mobile Phones and SIM Only Deals
    Given I launch the application URL "https://www.bt.com/"
    And I close the accept Cookie pop-up if it appears
    When I hover to the Mobile menu
    And I select Mobile phones from the mobile menu
    Then the number of banners below "See Handset details" should not be less than 3
    And I scroll down and click View SIM only deals
    Then validate the title for the new page
    And validate "30% off and double data" for 125GB 250GB Essential Plan, was £27 £18.90 per month
    And I close the browser & exit