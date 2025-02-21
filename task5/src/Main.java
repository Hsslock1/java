//5.	Создать класс Department с внутренним классом, с помощью объектов ко- торого можно хранить информацию
// обо всех должностях отдела и обо всех сотрудниках, когда-либо занимавших конкретную должность.
public class Main {
    public static void main(String[] args) {
        Department department = new Department("IT Отдел");
        department.addPosition("Разработчик");
        department.addPosition("Тестировщик");

        department.addEmployeeToPosition("Разработчик", "Бондарь Владислав");
        department.addEmployeeToPosition("Тестировщик", "Иконников Данил");
        department.addEmployeeToPosition("Разработчик", "Яковлев Александр");

        department.printEmployees();
        // добавляем сотрудника, не добавив перед этим должность
        department.addEmployeeToPosition("Верстальщик", "Иванов Иван");
    }
}
