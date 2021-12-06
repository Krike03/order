package be.christophe.order.domain.users;

public class City {
    private final String zipCode;
    private final String cityName;


    public City(String zipCode, String cityName) {
        this.zipCode = zipCode;
        this.cityName = cityName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCityName() {
        return cityName;
    }
}
