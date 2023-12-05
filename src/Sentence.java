// Клас, який представляє речення
class Sentence {
    private Object[] elements;

    public Sentence(Object... elements) {
        this.elements = elements;
    }

    // Повертає речення у вигляді масиву зі знаків пунктуації та слів
    public Object[] getSentence() {
        return elements;
    }

    // Повертає речення в форматі "String"
    public String getValue() {
        StringBuilder result = new StringBuilder(); //змінна для запису тексту

        for (Object element : elements) {
            // Додаємо слова по буквах до результату
            if (element instanceof Word) {
                for (Letter letter : ((Word) element).getValue()) {
                    result.append(letter.getLetter());
                }
            // Додаємо знаки пунктуації до результату
            } else if (element instanceof Punctuation) {
                result.append(((Punctuation) element).getValue());
            }
        }
        return result.toString().trim();
    }
}