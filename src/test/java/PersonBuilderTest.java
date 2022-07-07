import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PersonBuilderTest {

    @Test
    public void builderTest() {
        Person createdConstructor = new Person("Юра", "Шемякин", 54);
        createdConstructor.setAddress("Moscow");

        PersonBuilder personBuilder = new PersonBuilder();
        Person createdBuilder = personBuilder.setName("Юра").setSurname("Шемякин").setAge(54).setAddress("Moscow").build();

        Assertions.assertEquals(createdConstructor, createdBuilder);
    }

    @Test
    public void ageTest() {
        int age = 54;
        PersonBuilder personBuilder = new PersonBuilder();
        Person createdBuilder = personBuilder.setName("Юра").setSurname("Шемякин").setAge(age).setAddress("Moscow").build();

        createdBuilder.happyBirthday();
        age++;
        if (createdBuilder.getAge().isPresent())
            Assertions.assertEquals(createdBuilder.getAge().getAsInt(), age);
    }

    @Test
    public void exceptionCreateTest() {
        PersonBuilder builder = new PersonBuilder();
        Throwable thrown = Assertions.assertThrows(IllegalStateException.class, builder::build);
        assertNotNull(thrown.getMessage());
    }

    @Test
    public void exceptionAgeTest() {
        Throwable thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonBuilder().setAge(-10));
        assertNotNull(thrown.getMessage());
        thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> new PersonBuilder().setAge(150));
        assertNotNull(thrown.getMessage());

    }
}
