package model; // директория, в которой находится класс

// класс CargoFlight реализует интерфейс Flight
public class CargoFlight implements Flight {
    private String flightNumber; // номер рейса
    private String destination; // пункт назначения
    private String aircraftType; // тип самолета
    private String status; // статус рейса
    private final double averageFlightTime; // в часах, среднее время полета
    private double loadedWeight; // в тоннах, загруженный вес
    private double fuelAmount; // в литрах, количество топлива
    private final String cargoFragility; // хрупкость груза
    private final String cargoValue; // ценность груза

    // конструктор класса, инициализирует поля рейса
    public CargoFlight(String flightNumber, String destination, String aircraftType, String cargoFragility, String cargoValue) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.aircraftType = aircraftType;
        this.status = "Готов к вылету";
        this.averageFlightTime = 3.0; // примерное среднее время полета
        this.loadedWeight = 0.0; // начальный загруженный вес
        this.fuelAmount = 15000.0; // примерное количество топлива
        this.cargoFragility = cargoFragility;
        this.cargoValue = cargoValue;
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

    @Override
    public void loadCargo(double weight) { // метод для загрузки груза
        loadedWeight += weight;
        // выводит сообщение о загрузке
        System.out.println("Загружено " + weight + " тонн на грузовой рейс " + flightNumber);
    }

    @Override
    public void unloadCargo(double weight) { // метод для разгрузки груза
        loadedWeight -= weight;
        System.out.println("Разгружено " + weight + " тонн с грузового рейса " + flightNumber);
    }

    @Override
    public void refuel(double amount) { // метод для заправки топлива
        fuelAmount += amount;
        System.out.println("Заправлено " + amount + " литров топлива на " + flightNumber);
    }

    @Override
    public void sendToDestination() { // метод для отправки рейса в пункт назначения
        status = "В пути";
        System.out.println("Грузовой рейс " + flightNumber + " отправлен в " + destination);

    }

    @Override
    public void repair() { // метод для ремонта рейса
        status = "В ремонте";
        System.out.println("Грузовой рейс " + flightNumber + " находится в ремонте.");
    }

    // метод для получения информации о хрупкости груза
    public String getCargoFragility() {
        return cargoFragility;
    }

    // метод для получения информации о ценности груза
    public String getCargoValue() {
        return cargoValue;
    }
}
