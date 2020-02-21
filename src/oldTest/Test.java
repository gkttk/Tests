import api.LettersAnswer;

public class Test {
    public static void main(String[] args) {

        Question q1 = new Question("Текст первого вопроса", null, 3, LettersAnswer.A,LettersAnswer.C);
        Question q2 = new Question("Текст второго вопроса", "Ссылка2", 5, LettersAnswer.D);
        Question q3 = new Question("Текст третьего вопроса", "Ссылка3", 4, LettersAnswer.A,LettersAnswer.C);
        Question q4 = new Question("Текст четвертого вопроса", null, 2, LettersAnswer.B);

        Questionnaire questionnaire1 = new Questionnaire("ООП", 12);
        questionnaire1.addQuestions(q1,q2,q3,q4);
        Student stud1 = new Student("Кирилл");
        stud1.startTest(questionnaire1);

        History.showStudent(stud1);




    }
}
