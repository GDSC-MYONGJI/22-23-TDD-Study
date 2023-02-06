package testdriven.chap06;

public class Score {
    int score;

    public Score(int score){
        this.score = score;
    }
    public int strikes(){
        return score;
    }

    public int balls(){
        return 0;
    }
}
