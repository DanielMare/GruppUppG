import java.util.ArrayList;
import java.util.List;

public class QuestionBank {
    public List<Question> questions;
    public List<Option> options;
    public QuestionBank(){
        options = new ArrayList<>();
        options.add(new Option("Football"));
        options.add(new Option("Animal"));
        questions = new ArrayList<>();
        String question = "The length of a football field is?";
        String c1 = "75 yards";
        String c2 = "90 yards";
        String c3 = "100 yards";
        String c4 = "150 yards";
        questions.add(new Question(question,c1, c2, c3, c4));

        question = "What position on offense says hike and hands the ball off or throws to another player?";
        questions.add(new Question(question, "Guard", "Tight", "Runningback", "Quarterback"));

        question = "What position on offense says hike and hands the ball off or throws to another player?";
        questions.add(new Question(question,"Guard", "Tight", "Runningback", "Runningback"));
        question = "What position on offense says hike and hands the ball off or throws to another player?";
        c1 = "Guard";
        c2 = "Tight";
        c3 = "Runningback";
        c4 = "Quarterback";
        questions.add(new Question(question,c1, c2, c3, c4));
    }
    public List getOptions(){
        return this.options;
    }
    public List getQuestions(){
        return this.questions;
    }
}
