package model;

public interface Flight {
    String getFlightNumber();
    String getDestination();
    String getAircraftType();
    String getStatus();
    double getAverageFlightTime();
    double getLoadedWeight();
    double getFuelAmount();

    void setFlightNumber(String flightNumber);
    void setDestination(String destination);
    void setAircraftType(String aircraftType);
    void setStatus(String status);

    void loadCargo(double weight);
    void unloadCargo(double weight);
    void refuel(double amount);
    void sendToDestination();
    void repair();
}
