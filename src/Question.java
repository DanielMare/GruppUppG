public class Question {
    private String question1;
    private String choice1;
    private String choice2;
    private String choice3;
    private String correctAnswer;

    public Question(String question1, String choice1, String choice2, String choice3, String correctAnswer) {
        this.question1 = question1;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion1() {
        return question1;
    }

    public void setQuestion1(String question1) {
        this.question1 = question1;
    }

    public String getChoice1() {
        return choice1;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
