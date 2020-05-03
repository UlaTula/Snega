Feature: Weather

  Scenario: Check correct Weather data
    Given show test name

  Scenario: Checking coordinates for city
    Given city "London"
    And country "UK"

    When we are requesting weather data

    Then coord_lon is -0.13
    And coord_lat is 51.51

    Then weather_id is 300
    And weather_main is "Drizzle"
    And weather_description is "light intensity drizzle"
    And weather_icon is "09d"

    Then base is "stations"

    Then main_temp is 280.32
    And main_pressure is 1012
    And main_humidity is 81
    And main_temp_min is 279.15
    And main_temp_max is 281.15

    Then visibility is 10000

    Then wind_speed is 4.1
    And wind_deg is 80

    Then clouds_all is 90

    Then dt is 1485789600

    Then sys_type is 1
    And sys_id is 5091
    And sys_message is 0.0103
    And sys_country is "GB"
    And sys_sunrise is 1485762037
    And sys_sunset is 1485794875

    Then id is 2643743

    Then name is "London"

    Then cod is 200



