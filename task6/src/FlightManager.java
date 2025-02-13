import model.Flight;

// класс FlightManager, управляющий рейсами
// просто вызывает различные методы у рейсов
public class FlightManager {
    // метод для ремонта рейса
    public void repairFlight(Flight flight) {
        flight.repair();
    }

    // метод для заправки рейса
    public void refuelFlight(Flight flight, double amount) {
        // вызов метода заправки для переданного рейса с указанным количеством топлива
        flight.refuel(amount);
    }

    // метод для отправки рейса в пункт назначения
    public void sendFlight(Flight flight) {
        flight.sendToDestination();
    }

    // метод для загрузки груза на рейс
    public void loadCargo(Flight flight, double weight) {
        // вызов метода загрузки груза для переданного рейса с указанным весом
        flight.loadCargo(weight);
    }

    // метод для разгрузки груза с рейса
    public void unloadCargo(Flight flight, double weight) {
        // вызов метода разгрузки груза для переданного рейса с указанным весом
        flight.unloadCargo(weight);
    }
}
