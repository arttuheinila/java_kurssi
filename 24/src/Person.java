public class Person {
    String name;
    int age;
    int height;
    
    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", " + height;
    }
}
