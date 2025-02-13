import model.Flight; // импорт интерфейса Flight из пакета model

import java.util.ArrayList; // импорт для работы с динамическими массивами
import java.util.List; // импорт для работы с коллекциями

// класс Airport, представляющий аэропорт
public class Airport {
    private final String name;
    private final List<Flight> flights; // список рейсов, доступных в аэропорту


    public Airport(String name) {
        this.name = name;
        this.flights = new ArrayList<>(); // создание нового списка рейсов
    }

    // метод для добавления рейса в аэропорт
    public void addFlight(Flight flight) {
        flights.add(flight); // добавление рейса в список
        // вывод сообщения о добавлении рейса
        System.out.println("Рейс " + flight.getFlightNumber() + " добавлен в аэропорт " + name);
    }

    // метод для отображения списка рейсов в аэропорту
    public void listFlights() {
        System.out.println("Рейсы в аэропорту " + name + ":"); // вывод заголовка списка рейсов
        for (Flight flight : flights) { // перебор всех рейсов в списке
            // вывод информации о каждом рейсе: номер, пункт назначения и статус
            System.out.println(" - " + flight.getFlightNumber() + " в " + flight.getDestination() + " (Статус: " + flight.getStatus() + ")");
        }
    }
}
