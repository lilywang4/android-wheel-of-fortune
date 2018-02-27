package edu.gatech.seclass.sdpguessit.data.models;

import android.text.TextUtils;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PuzzleRecord extends SugarRecord<PuzzleRecord> {
    private static final Character HIDDEN_CHAR_SEQUENCE = '*';

    Player player;
    Puzzle puzzle;
    int prizeValue;
    List<Character> guessedLetters;
    int remainingGuessCount;
    boolean isComplete;

    public PuzzleRecord() {
    }

    public PuzzleRecord(Player player, Puzzle puzzle, int prizeValue, List<Character> guessedLetters, int remainingGuessCount, boolean isComplete) {
        this.player = player;
        this.puzzle = puzzle;
        this.prizeValue = prizeValue;
        this.guessedLetters = guessedLetters;
        this.remainingGuessCount = remainingGuessCount;
        this.isComplete = isComplete;
    }

    public String getPuzzlePhrase() {
        char[] puzzlePhrase = puzzle.getPhrase().toUpperCase().toCharArray();
        StringBuilder sb = new StringBuilder(puzzlePhrase.length);

        for (Character character : puzzlePhrase) {
            if (guessedLetters.contains(character) || !Character.isLetter(character)) {
                sb.append(character);
            } else {
                sb.append("*");
            }
        }

        return sb.toString();
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    public int getRemainingGuessCount() {
        return remainingGuessCount;
    }

    public int generatePrizeValue() {
        return generateMultipleOf100();
    }

    public List<Character> getUnChosenLetters() {
        List<Character> unchosen = new ArrayList<>(getPossibleLetters());
        unchosen.removeAll(guessedLetters);
        unchosen.removeAll(getVowelLetters());

        return unchosen;
    }

    public List<Character> getUnChosenVowels() {
        List<Character> unchosen = new ArrayList<>(getVowelLetters());
        unchosen.removeAll(guessedLetters);

        return unchosen;
    }

    public void guessConsonantForPrizeValue(Character character, int prizeValue) {
        guessedLetters.add(Character.toUpperCase(character));

        List<Character> upperCasePhrase = phraseToUpperCharacterList();
        Character upperCharacter = Character.toUpperCase(character);

        if (upperCasePhrase.contains(upperCharacter)) {
            this.prizeValue += (prizeValue * Collections.frequency(upperCasePhrase, upperCharacter));

            if(TextUtils.equals(getPuzzlePhrase(), puzzle.phrase.toUpperCase())){
                isComplete = true;
            }
        } else {
            remainingGuessCount--;
        }
    }

    public void buyVowel(Character character){
        guessedLetters.add(Character.toUpperCase(character));

        List<Character> upperCasePhrase = phraseToUpperCharacterList();

        if (upperCasePhrase.contains(Character.toUpperCase(character))) {
            this.prizeValue -= 300 ;

            if(TextUtils.equals(getPuzzlePhrase(), puzzle.phrase.toUpperCase())){
                isComplete = true;
            }
        } else {
            remainingGuessCount--;
        }
    }

    public void solve(String phrase){
        if(TextUtils.equals(phrase.toUpperCase(), puzzle.phrase.toUpperCase())){
            int hiddenCharCount = 0;
            for(Character character : getPuzzlePhrase().toCharArray()){
                if(character == HIDDEN_CHAR_SEQUENCE){
                    hiddenCharCount++;
                }
            }

            prizeValue += (1000 * hiddenCharCount);
            isComplete = true;
        }else{
            remainingGuessCount = 0;
        }
    }

    public boolean isOutOfGuesses() {
        return remainingGuessCount <= 0;
    }

    public boolean isPuzzleSolved() {
        return isComplete;
    }

    private List<Character> phraseToUpperCharacterList(){
        List<Character> upperPhraseList = new ArrayList<>(puzzle.getPhrase().length());
        for(Character character : puzzle.getPhrase().toUpperCase().toCharArray()){
            upperPhraseList.add(character);
        }

        return upperPhraseList;
    }

    private int generateMultipleOf100() {
        return 100 * (new Random().nextInt((10 - 1) + 1) + 1);
    }

    private List<Character> getPossibleLetters() {
        return Arrays.asList(new Character[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'});
    }

    private List<Character> getVowelLetters() {
        return Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'});
    }

    public void complete() {
        prizeValue = 0;
        remainingGuessCount = 0;
        isComplete = true;
    }
}
