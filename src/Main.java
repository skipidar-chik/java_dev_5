public class Main {
    public static void main(String[] args) {

        // Створюємо слова з літер
        Word hello = new Word(new Letter[]{
                new Letter('H'),
                new Letter('e'),
                new Letter('l'),
                new Letter('l'),
                new Letter('o')
        });

        Word human = new Word(new Letter[]{
                new Letter('h'),
                new Letter('u'),
                new Letter('m'),
                new Letter('a'),
                new Letter('n')
        });

        Word cool = new Word(new Letter[]{
                new Letter('c'),
                new Letter('o'),
                new Letter('o'),
                new Letter('l')
        });

        Word how = new Word(new Letter[]{
                new Letter('H'),
                new Letter('o'),
                new Letter('w')
        });

        Word are = new Word(new Letter[]{
                new Letter('a'),
                new Letter('r'),
                new Letter('e')
        });

        Word you = new Word(new Letter[]{
                new Letter('y'),
                new Letter('o'),
                new Letter('u')
        });

        Word keep = new Word(new Letter[]{
                new Letter('K'),
                new Letter('e'),
                new Letter('e'),
                new Letter('p')
        });

        Word going = new Word(new Letter[]{
                new Letter('g'),
                new Letter('o'),
                new Letter('i'),
                new Letter('n'),
                new Letter('g')
        });

        // Знаки пунктуації
        Punctuation space = new Punctuation(' ');
        Punctuation dot = new Punctuation('.');
        Punctuation comma = new Punctuation(',');
        Punctuation exclamationMark = new Punctuation('!');
        Punctuation questionMark = new Punctuation('?');
        Punctuation tabulation = new Punctuation('\t');

        // Створюємо речення зі слів та знаків пунктуації

        Sentence sentence1 = new Sentence(
                hello,
                comma,
                tabulation,
                tabulation,
                tabulation,
                human,
                comma,
                space,
                you,
                space,
                are,
                space,
                cool,
                dot
        );

        Sentence sentence2 = new Sentence(
                how,
                space,
                are,
                space,
                you,
                questionMark
        );

        Sentence sentence3 = new Sentence(
                keep,
                space,
                space,
                space,
                going,
                exclamationMark
        );

        // Створюємо текст з речень
        Text text = new Text(new Sentence[]{
                sentence1,
                sentence2,
                sentence3
        });

        // Вивід створеного речення
        System.out.println("Created sentence:");
        System.out.println(text.getValue());

        // Вивід речення після заміни послідовності пробілів та табуляцій на одиничні пробіли
        System.out.println("\nSentence after formatting:");
        System.out.println(WhiteSpacesReplacement(text));

        // Нове слово для аналізу
        Word go = new Word(new Letter[]{
                new Letter('g'),
                new Letter('o')
        });

        Word[] words = {are, you, hello, go}; // масив слів для аналізу

        // Аналізуємо текст на наявність повторів слів в реченнях та виводимо текст
        System.out.println('\n');
        analyzeText(text, words);
    }

    static String WhiteSpacesReplacement(Text text) {
        return text.getValue().replaceAll("[\t ]+", " ");
    }


    // Метод для підрахунку кількості речень в яких зустрічаються слова з масиву
    static void analyzeText(Text text, Word[] words) {
        Sentence[] sentences = text.getText();

        System.out.println("Text analysis: ");
        for(Word word : words){
            int counter = 0;
            for(Sentence sentence : sentences){
                if(containsWord(sentence, word)){
                    counter++;
                }
            }
            System.out.printf("Word \"%s\" occurs in \"%s\" sentences%n", word.getWord(), counter);
        }
    }

    // Метод, що перевіряє наявність слова в реченні
    private static boolean containsWord(Sentence sentence, Word word) {
        Object[] sentenceElements = sentence.getSentence();

        for(Object element : sentenceElements){
            if (element instanceof Word && element == word)
                return true;
        }
        return false;
    }
}
