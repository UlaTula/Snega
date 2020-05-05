package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.*;
import requesters.WeatherRequester;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

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

    @Then ("lon is {float}")
    public void check_lon(float lon) {
        assertEquals(lon, response.getCoord().getLon(), "Wrong coord lon");
    }

    @Then("lat is {float}")
    public void check_lat(float lat) {
        assertEquals(lat, response.getCoord().getLat(), "Wrong coord lat");
    }

    @Then("base is {string}")
    public void check_base(String base) {
        assertEquals(base, response.getBase(), "Wrong base");
    }

    @Then("weather is:")
    public void check_weather(Map<String, String> params) {
        Weather weather = response.getWeathers().get(0);
        assertEquals(Long.parseLong(params.get("id")), weather.getId(), "Wrong weather id");
        assertEquals(params.get("main"), weather.getMain(), "Wrong weather main");
        assertEquals(params.get("description"), weather.getDescription(),"Wrong weather description");
        assertEquals(params.get("icon"), weather.getIcon(), "Wrong weather icon");
    }

    @Then("main is:")
    public void check_main(Map<String, Float> params) {
        Main main = response.getMain();
        assertEquals(params.get("temp"),main.getTemp(),"Wrong main temp");
        assertEquals(params.get("pressure"), main.getPressure(), "Wrong main pressure");
        assertEquals(params.get("humidity"), main.getHumidity(),"Wrong main humidity");
        assertEquals(params.get("temp_min"), main.getTemp_min(),"Wrong main temp_min");
        assertEquals(params.get("temp_max"), main.getTemp_max(),"Wrong main temp_max");
    }

    @Then("visibility is {int}")
    public void check_visibility(int visibility) {
        assertEquals(visibility, response.getVisibility(), "Wrong visibility");
    }

    @Then("wind is:")
    public void check_wind(Map <String, Float> params) {
        Wind wind = response.getWind();
        assertEquals(params.get("speed"),wind.getSpeed(), "Wrong wind speed");
        assertEquals(params.get("deg"), wind.getDeg(),"Wrong wind deg");
    }

    @Then("clouds_all is {int}")
    public void check_all_clouds(int clouds_all) {
        assertEquals(clouds_all, response.getClouds().getAll(), "Wrong clouds all");
    }

    @Then("dt is {int}")
    public void check_dt(int dt) {
        assertEquals(dt, response.getDt(), "Wrong dt");
    }

    @Then("sys is:")
    public void check_sys(Map<String, String> params) {
        Sys sys = response.getSys();
        assertEquals(Integer.parseInt(params.get("type")), sys.getType(), "Wrong type");
        assertEquals(Long.parseLong(params.get("id")), sys.getId(), "Wrong id");
        assertEquals(Float.parseFloat(params.get("message")), sys.getMessage(), "Wrong message");
        assertEquals(params.get("country"), sys.getCountry(), "Wrong country");
        assertEquals(Integer.parseInt(params.get("sunrise")), sys.getSunrise(), "Wrong sunrise");
        assertEquals(Integer.parseInt(params.get("sunset")), sys.getSunset(), "Wrong sunset");
    }

    @Then("id is {int}")
    public void check_id(int id) {
        assertEquals(id, response.getId(), "Wrong id");
    }

    @Then("name is {string}")
    public void check_name(String name) {
        assertEquals(name, response.getName(), "Wrong name");
    }

    @Then("cod is {int}")
    public void check_cod(int cod) {
        assertEquals(cod, response.getCod(), "Wrong cod");
    }


}
