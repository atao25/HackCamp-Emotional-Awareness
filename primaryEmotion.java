import java.util.ArrayList;
import java.util.List;

public class PrimaryEmotion {

    private List<SecondaryEmotion> secondaryEmotions;
    private String name;

    public PrimaryEmotion(String name, List<SecondaryEmotion> secondaryEmotions) {
        this.secondaryEmotions = new ArrayList<>();
        this.name = name;
    }


    public void addEmotion(SecondaryEmotion emotion) {
        secondaryEmotions.add(emotion);
    }

    public List<SecondaryEmotion> getEmotionList() {
        return secondaryEmotions;
    }

    public String getName() {
        return name;
    }
}