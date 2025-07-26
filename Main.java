import java.util.*;

public class Main {
    public static void main(String[] args) {

        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(new Address("Россия", "Новосибирск"), 200);
        costPerAddress.put(new Address("Россия", "Уфа"), 150);
        costPerAddress.put(new Address("Россия", "Москва"), 100);
        costPerAddress.put(new Address("Германия", "Берлин"), 1000);
        costPerAddress.put(new Address("Англия", "Лондон"), 1200);
        Set<String> countries = new HashSet<>();

        Scanner scan = new Scanner(System.in);
        int summ = 0;
        while (true) {
            System.out.print("Заполнение нового заказа.\n" +
                    "Введите страну (или end для выхода): ");
            String country = scan.nextLine();
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = scan.nextLine();
            System.out.print("Введите вес (кг): ");
            int weight;
            try {
                weight = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: вес введен не корректно");
                continue;
            }
            Address address = new Address(country, city);
            if (costPerAddress.containsKey(address)) {
                int costKg = costPerAddress.get(address);
                int delivery = costKg * weight;
                summ += delivery;
                countries.add(address.getCountry());
                System.out.println("Стоимость доставки составит: " + delivery + " руб.");
                System.out.println("Общая стоимость всех доставок: " + summ + " руб.");
                System.out.println("Количество уникальных стран доставки  " + countries.size());
                System.out.println();
            } else {
                System.out.println("Доставки по этому адресу нет");
            }
        }
    }
}
