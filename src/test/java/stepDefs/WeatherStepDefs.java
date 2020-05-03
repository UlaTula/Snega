package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {
    private String cityName;
    private String country;
    private Response response;

    @Given("show test name")
    public void show_test_name() {
        System.out.println("Hello, gurkis!");
    }

    @Given("city {string}")
    public void set_city(String cityName) {
        this.cityName = cityName;
    }

    @Given("country {string}")
    public void set_country(String country) {
        this.country = country;
    }

    @When("we are requesting weather data")
    public void requested_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(cityName, country);
    }

    @Then ("coord_lon is {float}")
    public void check_lon_coord(float coord_lon) {
        Assertions.assertEquals(coord_lon, response.getCoord().getLon(), "Wrong coord lon");
    }

    @Then("coord_lat is {float}")
    public void check_lat_coord(float coord_lat) {
        Assertions.assertEquals(coord_lat, response.getCoord().getLat(), "Wrong coord lat");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        Assertions.assertEquals(base, response.getBase(), "Wrong country");
    }

    @Then("weather_id is {int}")
    public void check_id_weather(int weather_id) {
        Assertions.assertEquals(weather_id, response.getWeather().get(0).getId(), "Wrong weather id");
    }

    @Then("weather_main is {string}")
    public void check_main_weather(String weather_main) {
        Assertions.assertEquals(weather_main, response.getWeather().get(0).getMain(),"Wrong weather main");
    }

    @Then("weather_description is {string}")
    public void check_description_weather(String weather_description) {
        Assertions.assertEquals(weather_description, response.getWeather().get(0).getDescription(), "Wrong weather description");
    }

    @Then("weather_icon is {string}")
    public void check_icon_weather(String weather_icon) {
        Assertions.assertEquals(weather_icon, response.getWeather().get(0).getIcon(), "Wrong weather icon");
    }

    @Then("main_temp is {float}")
    public void check_temp_main(float main_temp) {
        Assertions.assertEquals(main_temp, response.getMain().getTemp(), "Wrong main temp");
    }

    @Then("main_pressure is {int}")
    public void check_pressure_main(int main_pressure) {
        Assertions.assertEquals(main_pressure, response.getMain().getPressure(), "Wrong main pressure");
    }

    @Then("main_humidity is {int}")
    public void check_humidity_main(int main_humidity) {
        Assertions.assertEquals(main_humidity, response.getMain().getHumidity(), "Wrong main humidity");
    }

    @Then("main_temp_min is {float}")
    public void check_temp_min_main(float main_temp_min) {
        Assertions.assertEquals(main_temp_min, response.getMain().getTemp_min(), "Wrong main temp_min");
    }

    @Then("main_temp_max is {float}")
    public void check_temp_max_main(float main_temp_max) {
        Assertions.assertEquals(main_temp_max, response.getMain().getTemp_max(), "Wrong main temp_max");
    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        Assertions.assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("wind_speed is {float}")
    public void check_speed_wind(float wind_speed) {
        Assertions.assertEquals(wind_speed, response.getWind().getSpeed(), "Wrong wind speed");
    }

    @Then("wind_deg is {int}")
    public void check_deg_wind(int wind_deg) {
        Assertions.assertEquals(wind_deg, response.getWind().getDeg(), "Wrong wind deg");
    }

    @Then("clouds_all is {int}")
    public void check_all_clouds(int clouds_all) {
        Assertions.assertEquals(clouds_all, response.getClouds().getAll(), "Wrong clouds all");
    }

    @Then("dt is {int}")
    public void check_dt(int dt) {
        Assertions.assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @Then("sys_type is {int}")
    public void check_type_sys(int sys_type) {
        Assertions.assertEquals(sys_type, response.getSys().getType(), "Wrong type");
    }

    @Then("sys_id is {int}")
    public void check_id_sys(int sys_id) {
        Assertions.assertEquals(sys_id, response.getSys().getId(), "Wrong id");
    }

    @Then("sys_message is {float}")
    public void check_message_sys(float sys_message) {
        Assertions.assertEquals(sys_message, response.getSys().getMessage(), "Wrong message");
    }

    @Then("sys_country is {string}")
    public void check_country_sys(String sys_country) {
        Assertions.assertEquals(sys_country, response.getSys().getCountry(), "Wrong country");
    }

    @Then("sys_sunrise is {int}")
    public void check_sunrise_sys(int sys_sunrise) {
        Assertions.assertEquals(sys_sunrise, response.getSys().getSunrise(), "wrong sunrise");
    }

    @Then("sys_sunset is {int}")
    public void check_sunset_sys(int sys_sunset) {
        Assertions.assertEquals(sys_sunset, response.getSys().getSunset(), "Wrong sunset");
    }

    @Then("id is {int}")
    public void check_id(int id) {
        Assertions.assertEquals(id, response.getId(), "Wrong id");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        Assertions.assertEquals(name, response.getName(), "Wrong name");
    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        Assertions.assertEquals(cod, response.getCod(), "Wrong cod");
    }
}
