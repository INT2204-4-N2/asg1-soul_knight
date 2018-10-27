package dictionary;

import java.util.ArrayList;

public class Dictionary {
    public ArrayList<Word> words = new ArrayList<>();
    public ArrayList<Word> getWords() {
        return words;
    }
    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }
    public void push(Word word) {
        int length = words.size();
        int index = searchIndexInsert(0, length - 1, word.getSpelling());
        if (index <= length && index >= 0) words.add(index, word);
    }
    private int searchIndexInsert(int start, int end, String spelling) {
        if (end < start) return start;
        int mid = start + (end - start) / 2;
        if (mid == words.size()) return mid;
        Word word = words.get(mid);
        int compare = word.getSpelling().compareTo(spelling);
        if (compare == 0) return -1;
        if (compare > 0) return searchIndexInsert(start, mid - 1, spelling);
        return searchIndexInsert(mid + 1, end, spelling);
    }
}