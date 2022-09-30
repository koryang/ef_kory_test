@test
Feature: Play Youtube Music

  @tc_ef_001 @playing_music
  Scenario: Playing Music
#    Given user has login as youtube user
    And user visit Youtube Music home page
    When user click the play icon on the first song in the carousel
    Then user should hear the music playing
    And user should see the player bar appeared

  @tc_ef_001 @pause_music
  Scenario: Paused Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the pause icon
    Then user should not hear any music playing
    And user should see the pause icon disapeared
    And user should see the play icon appeared

  @tc_ef_001 @playback_music
  Scenario: Play Back Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the play back icon
    Then user should hear the music playing
    And user should see the music playing from the begining

  @tc_ef_001 @playnext_music
  Scenario: Play Next Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the play next icon
    Then user should hear the music playing
    And user should see next music is playing

  @tc_ef_001 @repeat_music
  Scenario: Repeat Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the repeat icon
    Then user should hear the music repeated icon is active

  @tc_ef_001 @reshuffle_music
  Scenario: Repeat Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the reshuffle icon
    Then user should hear the music reshuffle icon is active

  @tc_ef_001 @reshuffle_music
  Scenario: Repeat Youtube Music
#    Given user has login as "youtube" user
    Given user visit Youtube Music home page
    And user click the play icon on the first song in the carousel
    When user click the mute icon
    Then user should hear the music mute icon is active
