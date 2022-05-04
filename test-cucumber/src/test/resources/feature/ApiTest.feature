Feature: Api test
  #lombock, logger(Sl4g),
#  @Debug
#  Scenario: test
#    Given Test world
#    Given get authorisation token
#    And get booking
#    And get some text
#      | text1 | text2 | text3 |
#      | 1     | 2     | 3     |
#      | 6     | 5     | 4     |
#    And get some fruit
#      | fruit1 | isFruit |
#      | apple  | true    |
#      | grushka | false |
#avtomation stori
  @Debug
  Scenario: update booking
    Given create booking details
    And update booking details
    And Assert book
    And Delete book
    And User checks that deatails is deleted
