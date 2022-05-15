package com.example.weatherapp;

public class WeatherReportModel {
//    {"id":6210871048011776,
//            "weather_state_name":"Showers",
//                "weather_state_abbr":"s",
//                "wind_direction_compass":"NNE",
//            "created":"2022-04-19T03:59:02.140361Z",
//            "applicable_date":"2022-04-19",
//            "min_temp":7.640000000000001,
//            "max_temp":15.280000000000001,
//            "the_temp":14.85,
//            "wind_speed":4.886969711553859,
//            "wind_direction":26.250000000000004,
//            "air_pressure":1015.5,
//            "humidity":59,
//            "visibility":9.589621609798776,
//            "predictability":73
//    }


    private int id;
    private String weather_state_name;
    private String weather_state_abbr;
    private String wind_direction_compass;
    private String created;
    private String applicable_date;
    private double min_temp;
    private double max_temp;
    private double the_temp;
    private double wind_speed;
    private double wind_direction;
    private double air_pressure;
    private int humidity;
    private double visibility;
    private int predictability;

    public WeatherReportModel(int id, String weather_state_name, String weather_state_abbr, String wind_direction_compass, String created, String applicable_date, double min_temp, double max_temp, double the_temp, double wind_speed, double wind_direction, double air_pressure, int humidity, double visibility, int predictability) {
        this.id = id;
        this.weather_state_name = weather_state_name;
        this.weather_state_abbr = weather_state_abbr;
        this.wind_direction_compass = wind_direction_compass;
        this.created = created;
        this.applicable_date = applicable_date;
        this.min_temp = min_temp;
        this.max_temp = max_temp;
        this.the_temp = the_temp;
        this.wind_speed = wind_speed;
        this.wind_direction = wind_direction;
        this.air_pressure = air_pressure;
        this.humidity = humidity;
        this.visibility = visibility;
        this.predictability = predictability;
    }

    public WeatherReportModel() {

    }

    @Override
    public String toString() {
        return  "weather=" + weather_state_name + '\n' +

                " applicable_date='" + applicable_date + '\n' +
                " Low=" + min_temp + "\n"+
                " High="+max_temp +"\n"+
                " Temprature=" + the_temp
               ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWeather_state_name() {
        return weather_state_name;
    }

    public void setWeather_state_name(String weather_state_name) {
        this.weather_state_name = weather_state_name;
    }

    public String getWeather_state_abbr() {
        return weather_state_abbr;
    }

    public void setWeather_state_abbr(String weather_state_abbr) {
        this.weather_state_abbr = weather_state_abbr;
    }

    public String getWind_direction_compass() {
        return wind_direction_compass;
    }

    public void setWind_direction_compass(String wind_direction_compass) {
        this.wind_direction_compass = wind_direction_compass;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getApplicable_date() {
        return applicable_date;
    }

    public void setApplicable_date(String applicable_date) {
        this.applicable_date = applicable_date;
    }

    public double getMin_temp() {
        return min_temp;
    }

    public void setMin_temp(double min_temp) {
        this.min_temp = min_temp;
    }

    public double getMax_temp() {
        return max_temp;
    }

    public void setMax_temp(double max_temp) {
        this.max_temp = max_temp;
    }

    public double getThe_temp() {
        return the_temp;
    }

    public void setThe_temp(double the_temp) {
        this.the_temp = the_temp;
    }

    public double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public double getAir_pressure() {
        return air_pressure;
    }

    public void setAir_pressure(double air_pressure) {
        this.air_pressure = air_pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }

    public int getPredictability() {
        return predictability;
    }

    public void setPredictability(int predictability) {
        this.predictability = predictability;
    }
}
