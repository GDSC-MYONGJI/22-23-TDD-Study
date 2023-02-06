package testdriven.chap06;

public class BaseballGame {
    private String numbers;
    public BaseballGame(String numbers){
        this.numbers = numbers;
    }

    public Score guess(String score){
        if(this.numbers.equals(score)) return new Score(3);
        else return new Score(-1);
    }
}
