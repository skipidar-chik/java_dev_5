// Клас, який представляє слово
class Word {
    private Letter[] letters;

    public Word(Letter[] letters) {
        this.letters = letters;
    }

    // Повертає слово як масив літер
    public Letter[] getValue() {
        return letters;
    }

    // Повертає слово у форматі "String"
    public String getWord() {
        StringBuilder result = new StringBuilder(); //змінна для запису слова
        // Додаємо літери з масива слова до результату
        for (Letter letter : letters) {
            result.append(letter.getLetter());
        }
        return result.toString().toLowerCase();
    }
}
