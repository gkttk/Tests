import dao.Controller;
import dto.Questionnaire;
import dto.Student;
import service.IService;
import service.StudentService;



public class Main {
    public static void main(String[] args) {
   IService<Student> service = StudentService.getSingletonStudentService();
   Student stud1 = service.createInstance();
        Controller contr = new Controller();
        contr.startTest(stud1);
        for(Questionnaire q: stud1.getPastTests()){
            System.out.println(q.isPassed());
        };





    }
}
