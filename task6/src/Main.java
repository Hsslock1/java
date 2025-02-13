import model.CargoFlight;
import model.PassengerFlight;

public class Main {
    public static void main(String[] args) {
        // Создание аэропорта
        Airport airport = new Airport("Международный аэропорт");

        // Создание экземпляров пассажирского и грузового рейсов
        PassengerFlight passengerFlight = new PassengerFlight("SU123", "Москва", "Boeing 737");
        CargoFlight cargoFlight = new CargoFlight("SU456", "Нью-Йорк", "Airbus A330", "Хрупкий", "Высокая");

        // Добавление рейсов в аэропорт
        airport.addFlight(passengerFlight);
        airport.addFlight(cargoFlight);

        // Вывод информации о рейсах
        airport.listFlights();
        System.out.print("\n");

        // Создание менеджера рейсов
        FlightManager flightManager = new FlightManager();

        // Операции с пассажирским рейсом
        flightManager.refuelFlight(passengerFlight, 1000);
        flightManager.loadCargo(passengerFlight, 2.5);
        flightManager.unloadCargo(passengerFlight, 1.0);
        flightManager.sendFlight(passengerFlight);
        flightManager.repairFlight(passengerFlight);

        System.out.print("\n");

        // Операции с грузовым рейсом
        flightManager.refuelFlight(cargoFlight, 2000);
        flightManager.unloadCargo(cargoFlight, 2.0);
        flightManager.repairFlight(cargoFlight);
        flightManager.loadCargo(cargoFlight, 5.0);

    }
}
