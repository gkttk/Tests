package service;

import dto.History;
import dto.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class StudentService implements IService<Student> {
    private static StudentService studentService;
    private Random random = new Random();

    private StudentService(){}

    public static synchronized StudentService getSingletonStudentService(){
        if(studentService == null) {
            studentService = new StudentService();
        }
        return studentService;
    }

    @Override
    public synchronized Student createInstance() {
        Student student;
        do {
            int newID = random.nextInt(10) + 1;
            try (BufferedReader reader = new BufferedReader(new FileReader("src\\students\\student" + newID + ".txt"))) {
                 student = new Student(newID, reader.readLine());

            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
                return null;
            } catch (IOException e) {
                System.out.println("Ошибка ввода-вывода");
                return null;
            }
        } while (History.getHistory().containsKey(student)) ;
        History.getHistory().put(student, new ArrayList<>());
        History.getListOfStudents().add(student);
        return student;
    }


    @Override
    public void readInstance(Student student) {
        System.out.println(student.toString());
    }

    @Override
    public void updateInstance(Student student) {

    }

    @Override
    public boolean deleteInstance(Student student) {
        if(History.getHistory().containsKey(student)){
            History.getHistory().remove(student);
            return true;
        }
        return true;
    }
}
