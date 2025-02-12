import classes.Continent;
import classes.Island;
import classes.Ocean;
import classes.Planet;

public class Main {
    public static void main(String[] args) {
        // Создаем планету
        Planet earth = new Planet("Земля");

        // Создаем материки
        Continent asia = new Continent("Азия");
        Continent africa = new Continent("Африка");

        // Добавляем острова к материкам
        asia.addIsland(new Island("Суматра"));
        asia.addIsland(new Island("Борнео"));
        africa.addIsland(new Island("Мадагаскар"));
        africa.addIsland(new Island("Сейшелы"));

        // Создаем океаны
        Ocean indianOcean = new Ocean("Индийский");
        Ocean pacificOcean = new Ocean("Тихий");

        // Добавляем океаны к материкам
        asia.addOcean(pacificOcean);
        africa.addOcean(indianOcean);

        // Добавляем материки к планете
        earth.addContinent(asia);
        earth.addContinent(africa);

        // Выводим информацию о планете
        earth.displayInfo();
    }
}
