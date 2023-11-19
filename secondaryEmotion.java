import java.util.HashMap;
import java.util.Map;

public class SecondaryEmotion {

    private Map<String, String> emotions;

    public SecondaryEmotion() {
        emotions = new HashMap<>();
    }

    public void addSecondary(String name, String message) {
        emotions.put(name, message);

    }

    public String getMessage(String name) {
        return emotions.get(name);

    }
}