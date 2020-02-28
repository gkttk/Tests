package service;

import dto.History;
import dto.Question;
import dto.Questionnaire;

public class QuestionnaireService implements IService<Questionnaire>{
    private static QuestionnaireService questionnaireService;

    private QuestionnaireService() {
    }

    public static synchronized QuestionnaireService getSingletonQuestionnaireService() {
        if (questionnaireService == null) {
            questionnaireService = new QuestionnaireService();
        }
        return questionnaireService;
    }

    @Override
    public Questionnaire createInstance() {
        Questionnaire questionnaire = new Questionnaire();
        IService<Question> service = QuestionService.getSingletonQuestionService();
        Question question;
        int newID;
        do{
            questionnaire.getQuestions().clear();
            newID = 0;
            for (; questionnaire.getQuestions().size() < 5; ) {//пока лист вопросов не будет иметь 5 элементов, цикл не закончится(цикл добавляет УНИКАЛЬНЫЙ вопрос в вопросник)
                question = service.createInstance();
                if (questionnaire.getQuestions().contains(question)) {
                    continue;
                }
                newID += question.getqID();
                questionnaire.getQuestions().add(question);
            }
            questionnaire.setQuestionnaireID(newID/3);
            History.getListOfQuestionnaires().add(questionnaire);
        }while(!History.getListOfQuestionnaires().contains(questionnaire));

        return questionnaire;
    }

    @Override
    public void readInstance(Questionnaire obj) {
        System.out.println("Questionnaire id = " + obj.getQuestionnaireID());
        System.out.println(obj.getQuestions().toString());
    }

    @Override
    public void updateInstance(Questionnaire obj) {

    }

    @Override
    public boolean deleteInstance(Questionnaire obj) {
        return false;
    }
}
