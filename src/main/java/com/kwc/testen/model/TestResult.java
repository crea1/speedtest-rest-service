package com.kwc.testen.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author Marius Kristensen
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestResult {
    int id;
    String brand;
    String model;
    String model_year;
    String engine_cc;
    int hp;
    int nm;
    String weight;
    int passengers_num;
    int speed;
    String road_conditions;
    String test_year;
    String driver;

    public TestResult(int id, String brand, String model, String model_year, String engine_cc, int hp, int nm, String weight, int passengers_num, int speed, String road_conditions, String test_year, String driver) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.model_year = model_year;
        this.engine_cc = engine_cc;
        this.hp = hp;
        this.nm = nm;
        this.weight = weight;
        this.passengers_num = passengers_num;
        this.speed = speed;
        this.road_conditions = road_conditions;
        this.test_year = test_year;
        this.driver = driver;
    }

    public TestResult() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel_year() {
        return model_year;
    }

    public void setModel_year(String model_year) {
        this.model_year = model_year;
    }

    public String getEngine_cc() {
        return engine_cc;
    }

    public void setEngine_cc(String engine_cc) {
        this.engine_cc = engine_cc;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getNm() {
        return nm;
    }

    public void setNm(int nm) {
        this.nm = nm;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public int getPassengers_num() {
        return passengers_num;
    }

    public void setPassengers_num(int passengers_num) {
        this.passengers_num = passengers_num;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getRoad_conditions() {
        return road_conditions;
    }

    public void setRoad_conditions(String road_conditions) {
        this.road_conditions = road_conditions;
    }

    public String getTest_year() {
        return test_year;
    }

    public void setTest_year(String test_year) {
        this.test_year = test_year;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }
}
