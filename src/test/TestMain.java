package test;

public class TestMain {
    public static void main(String[] args) {
        Student student1 = new Student("Кирилл");
        student1.startTest();
        student1.startTest();
        student1.startTest();

        System.out.println(History.getHistory());
        History.showStudent(student1);

    }
}
