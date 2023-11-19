public class PrimaryEmotion {

    private List<SecondaryEmotion> secondaryEmotions;
    private String name;

    public PrimaryEmotion(String name, List<secondaryEmotion> secondaryEmotions) {
        this.secondaryEmotions = new ArrayList()<>;
        this.name = name;
    }


    public void addEmotion(secondaryEmotion emotion) {
        secondaryEmotions.add(emotion);
    }

    public ArrayList<secondaryEmotion> getEmotionList() {
        return secondaryEmotions;
    }

    public String getName() {
        return name;
    }
}