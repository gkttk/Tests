import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Questionnaire {
    private String theme;
    private int variant;
    private List<Question> questions = new LinkedList<>();
    private boolean isPast = false;


   public Questionnaire(String theme,int variant){
        this.theme = theme;
        this.variant = variant;
        for(int i = 0; i<40; i++){
            this.addQuestions();
        }
    }

    public boolean isPast() {
        return isPast;
    }
    public void setPast(boolean past) {
        isPast = past;
    }
    public List<Question> getQuestions() {
        return questions;
    }

    public static Questionnaire createQuestionnaire(String theme, int variant){
        return new Questionnaire(theme, variant);
    }

    public void addQuestions(Question...quest){
        questions.addAll(Arrays.asList(quest));
    }

    public void addQuestions(Collection<Question> quest){
        addQuestions(quest.toArray(new Question[quest.size()]));
    }

    public void removeQuestions(Question...quest){
        for(Question q: quest){
            if(questions.contains(q)){
                questions.remove(q);
            }
        }
    }



    public String toString(){
        return questions.toString();
    }

    }



