package com.example.najo.ipaddresslocator;

public class IPAddressLocator {

    private String country ;
    private String city ;
    private String region ;
    private Double longitude ;
    private Double latitude ;

    public IPAddressLocator(String country, Double longitude, Double latitude) {
        this.country = country;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public IPAddressLocator(String country, String city, String region, Double longitude, Double latitude) {
        this.country = country;
        this.city = city;
        this.region = region;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public IPAddressLocator(Double longitude, Double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
}
