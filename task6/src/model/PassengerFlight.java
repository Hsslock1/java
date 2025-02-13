package model; // директория с классом

// класс PassengerFlight реализует интерфейс Flight
public class PassengerFlight implements Flight {
    private String flightNumber; // номер рейса
    private String destination; // пункт назначения
    private String aircraftType; // тип самолета
    private String status; // статус рейса
    private final double averageFlightTime; // среднее время полета (в часах)
    private double loadedWeight; // загруженный вес (в тоннах)
    private double fuelAmount; // количество топлива (в литрах)

    public PassengerFlight(String flightNumber, String destination, String aircraftType) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.aircraftType = aircraftType;
        this.status = "Готов к вылету";
        this.averageFlightTime = 2.0; // примерное среднее время полета
        this.loadedWeight = 0.0; // начальный загруженный вес
        this.fuelAmount = 10000.0; // примерное количество топлива
    }

    @Override
    public String getFlightNumber() { // метод для получения номера рейса
        return flightNumber;
    }

    @Override
    public String getDestination() { // метод для получения пункта назначения
        return destination;
    }

    @Override
    public String getAircraftType() { // метод для получения типа самолета
        return aircraftType;
    }

    @Override
    public String getStatus() { // метод для получения статуса рейса
        return status;
    }

    @Override
    public double getAverageFlightTime() { // метод для получения среднего времени полета
        return averageFlightTime;
    }

    @Override
    public double getLoadedWeight() { // метод для получения загруженного веса
        return loadedWeight;
    }

    @Override
    public double getFuelAmount() { // метод для получения количества топлива
        return fuelAmount;
    }

    @Override
    public void setFlightNumber(String flightNumber) { // метод для установки номера рейса
        this.flightNumber = flightNumber;
    }

    @Override
    public void setDestination(String destination) { // метод для установки пункта назначения
        this.destination = destination;
    }

    @Override
    public void setAircraftType(String aircraftType) { // метод для установки типа самолета
        this.aircraftType = aircraftType;
    }

    @Override
    public void setStatus(String status) { // метод для установки статуса рейса
        this.status = status;
    }

    // метод для загрузки груза
    @Override
    public void loadCargo(double weight) {
        loadedWeight += weight; // увеличивает загруженный вес
        // выводит ифнормацию о загрузке
        System.out.println("Загружено " + weight + " тонн на пассажирский рейс " + flightNumber);
    }

    // метод для разгрузки груза
    @Override
    public void unloadCargo(double weight) {
        loadedWeight -= weight;
        System.out.println("Разгружено " + weight + " тонн с рейса " + flightNumber);
    }

    // метод для заправки топлива
    @Override
    public void refuel(double amount) {
        fuelAmount += amount;
        System.out.println("Заправлено " + amount + " литров топлива на рейс " + flightNumber);
    }

    // метод для отправки рейса в пункт назначения
    @Override
    public void sendToDestination() {
        status = "В пути"; // обновляет статус рейса
        System.out.println("Пассажирский рейс " + flightNumber + " отправлен в " + destination); // выводит сообщение об отправке
    }

    // метод для ремонта рейса
    @Override
    public void repair() {
        status = "В ремонте";
        System.out.println("Пассажирский рейс " + flightNumber + " находится в ремонте.");
    }
}
