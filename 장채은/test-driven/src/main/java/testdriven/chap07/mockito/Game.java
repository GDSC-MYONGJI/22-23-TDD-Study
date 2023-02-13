package testdriven.chap07.mockito;

public class Game {
    private GameNumGen genMock;
    private GameLevel level;
    public Game(GameNumGen genMock) {
        this.genMock = genMock;
    }

    public void init(GameLevel level) {
        this.level = level;
    }
}
