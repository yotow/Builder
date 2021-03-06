public class Main {
    public static void main(String[] args) {
        Person person = new PersonBuilder("Антошка", "Лопатов")
                .setAge(48)
                .build();

        System.out.println(person.toString());

        person = new PersonBuilder("Антошка", "Лопатов")
                .setAge(55).setAddress("Москва")
                .build();

        System.out.println(person.toString());

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(31)
                .setAddress("Сидней")
                .build();
        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);
        System.out.println("у " + mom.getName() + (mom.hasAddress() ? " есть адрес" : " не  адреса"));
        System.out.println("Адрес " + mom.getName() + " " + mom.getAddress());

        try {
            // Не хватает обяхательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
