package ch09_class.school;
import java.util.Timer;
import java.util.TimerTask;

public class ConsoleGame {

    private static final char CHARACTER = 'C';
    private static final int WIDTH = 80;
    private static final int HEIGHT = 20;
    private static final int INTERVAL_MS = 100;

    private int characterX = 0;
    private int characterY = 0;

    public ConsoleGame() {
        clearScreen();
        drawCharacter();
        startTimer();
    }

    private void startTimer() {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                moveCharacter();
                clearScreen();
                drawCharacter();
            }
        }, INTERVAL_MS, INTERVAL_MS);
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void drawCharacter() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < characterY; i++) {
            sb.append("\n");
        }
        for (int i = 0; i < characterX; i++) {
            sb.append(" ");
        }
        sb.append(CHARACTER);
        System.out.print(sb.toString());
    }

    private void moveCharacter() {
        characterX++;
        characterY++;
        if (characterX >= WIDTH) {
            characterX = 0;
        }
        if (characterY >= HEIGHT) {
            characterY = 0;
        }
    }

    public static void main(String[] args) {
        new ConsoleGame();
    }
}