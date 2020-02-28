package dto;

import java.util.LinkedList;
import java.util.List;

public class Questionnaire {
    private int questionnaireID;
    private boolean isPassed = false;
    private List<Question> questions = new LinkedList<>();


    public int getQuestionnaireID() {
        return questionnaireID;
    }

    public void setQuestionnaireID(int questionnaireID) {
        this.questionnaireID = questionnaireID;
    }

    public boolean isPassed() {
        return isPassed;
    }

    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object obj){
        if(super.equals(obj)) return true;
        if(obj == null || !(obj instanceof Questionnaire)) return false;
        Questionnaire questionnaire = (Questionnaire)obj;
        return this.getQuestionnaireID() == questionnaire.getQuestionnaireID() && this.getQuestions().size() == questionnaire.getQuestions().size();
    }
    @Override
    public int hashCode(){
        return this.getQuestionnaireID()*4 + this.getQuestions().size()*5;
    }


    @Override
    public String toString() {
        return "Вопросник № " + questionnaireID + "\n" + "Вопросы " + "\n" + questions;
    }
}
