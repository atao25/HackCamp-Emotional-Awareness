import java.util.HashMap;
import java.util.Map;

public class SecondaryEmotion {

    private Map<String, String> emotions;
    private String emotionName;

    public SecondaryEmotion(String name) {
        emotions = new HashMap<>();
        this.emotionName = name;
    }

    public void addSecondary(String name, String message) {
        emotions.put(name, message);

    }

    public String getMessage(String name) {
        return emotions.get(name);

    }

    public String getName() {
        return this.emotionName;
    }
}