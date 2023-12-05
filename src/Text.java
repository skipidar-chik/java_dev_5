// Клас, який представляє текст
class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    //Повертає увесь текст у форматі "String"
    public String getValue() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : sentences) {
            result.append(sentence.getValue()).append(" ");
        }
        return result.toString().trim();
    }

    // Повертає масив речень
    public Sentence[] getText() {
        return sentences;
    }
}