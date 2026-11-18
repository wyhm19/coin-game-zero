import zero.ui.Element;
import zero.ui.Label;

public class ScoreDisplay {
    private final Label label = new Label("Score: 0");

    public void setScore(int points) {
        label.setText("Score: " + points);
    }

    public Element view() {
        return label;
    }
}
