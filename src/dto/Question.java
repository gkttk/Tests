package dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question {
    private int qID;
    private StringBuilder qData = new StringBuilder();
    private List<String> rightAnswers = new ArrayList<>();

    public int getqID() {
        return qID;
    }

    public void setqID(int qID) {
        this.qID = qID;
    }

    public StringBuilder getqData() {
        return qData;
    }


    public List<String> getRightAnswers() {
        return rightAnswers;
    }

    @Override
    public boolean equals(Object obj){
        if(super.equals(obj)) return true;
        if(obj == null || !(obj instanceof Question)) return false;
        Question question = (Question)obj;
        return this.getqID() == question.getqID() && this.getqData().toString().equals(question.getqData().toString());
    }
    @Override
    public int hashCode(){
        return this.getqID()*3 + this.getRightAnswers().size() + this.getqData().length()*2;
    }


    @Override
    public String toString() {
        return "Вопрос № " + qID + "\n" + qData + "\n" + rightAnswers;
    }
}
