import zero.Key;
import zero.Color;
import zero.GameApp;

public class Main extends GameApp {
    private Player player;
    private PlayerInput input;
    private Coin coin;
    private int points;
    @Override public void settings() {
        padding(20);
        size(640, 400);
    }

    @Override public void setup() {
        input = new PlayerInput(this);
        player = new Player(40, 180);
        coin = new Coin(220, 180);
    }

    @Override public void update(double seconds) {
        int horizontal = input.horizontal();
        int vertical = input.vertical();
        player.update(horizontal, vertical, seconds, width(), height());
        if (!coin.isCollected() && coin.touches(player)) {
            coin.collect();
            points++;
        }
    }

    @Override public void draw() {
        background(Color.rgb(240, 248, 255));
        fill(Color.rgb(47, 79, 79));
        textSize(20);
        text("Click the canvas, then hold the arrow keys.", 20, 30);
        fill(Color.rgb(47, 79, 79));
        text("Score: " + points, 20, 60);
        coin.draw(this);
        player.draw(this);
    }

    public static void main(String[] args) { launch(args); }
}
