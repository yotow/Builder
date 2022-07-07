import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age = -1;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Person(PersonBuilder personBuilder) {
        this.name = personBuilder.getName();
        this.surname = personBuilder.getSurname();
        this.age = personBuilder.getAge();
        this.address = personBuilder.getAddress();
    }

    public boolean hasAge() {
        return age >= 0;
    }

    public boolean hasAddress() {
        return !address.isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        age++;
    }

    PersonBuilder newChildBuilder() {
        return new PersonBuilder(null, surname).setAddress(address).setAge(0);
    }

    @Override
    public String toString() {
        return "\"Person\":" +
                "{\"name\":\"" + name + "\"," +
                "\"surname\":\"" + surname + "\"," +
                "\"age\":\"" + age + "\"," +
                "\"address\":\"" + address + "\"}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person person = (Person) obj;
        if (age != -1 && age != person.age) {
            return false;
        }
        return Objects.equals(name, person.name)
                && Objects.equals(surname, person.surname)
                && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        result = 31 * result + age;
        result = 31 * result + address.hashCode();
        result = 31 * result + surname.hashCode();
        return result;
    }
}
