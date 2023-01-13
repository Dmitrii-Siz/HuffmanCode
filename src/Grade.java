public class Grade {

    //private variables:
    private String subject;
    private double score;


    //constructor:
    public Grade(String subject, double score){
        this.subject = subject;
        this.score = score;
    }


    //getters and setters
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    //static method getLetterGrade which returns the grade depending on the score
    //return a char
    public static char getLetterGrade(double score) {
        if(score >= 70 & score < 101){
            return (char)'A';
        }
        else if (score >= 60 & score < 70) {
            return (char)'B';
        }
        else if (score >= 50 & score < 60) {
            return (char)'C';
        }
        else if (score >= 40 & score < 50) {
            return (char)'D';
        }
        else if (score < 40 & score >= 0){
            return (char)'F';
        }
        return (char) 'E';
    }

    @Override
    public String toString() {
            return subject + ' ' + getLetterGrade(score);
    }
}
