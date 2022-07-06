

public class PersonBuilder {
    private String name;
    private String surname;
    private int age = -1;
    private String address;

    public PersonBuilder(){

    }

    public PersonBuilder(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname= surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0 ) throw new IllegalArgumentException("Возраст должен быть больше 0");
        else if (age > 140) {
            throw  new IllegalArgumentException("Столько не живут");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null){
            throw new IllegalStateException("Не хватает обяхательных полей имя/фамилия");
        }
        return new Person(this);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}
