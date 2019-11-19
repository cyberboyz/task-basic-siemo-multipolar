package com.demo.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class Helper {
    public static String DUPLICATE_CONSECUTIVE_WORDS_REGEX = "(\\w+)(\\s+\\1)+";
    public static String removeDuplicateConsecutiveWords(String stringInput){
        Pattern p = Pattern.compile(DUPLICATE_CONSECUTIVE_WORDS_REGEX);
        Matcher m = p.matcher(stringInput);
        String stringOutput = m.replaceAll("$1");
        return stringOutput;
    }

    public static String findDuplicateConsecutiveWordsDetail(String stringInput) {
        try {
            Pattern regex = Pattern.compile(DUPLICATE_CONSECUTIVE_WORDS_REGEX);
            Matcher regexMatcher = regex.matcher(stringInput);
            String[] splitSentence = stringInput.split("\\.\\s*");
            String duplicateConsecutiveWordsDetail = "";

            while (regexMatcher.find()) {
                String matchedConsecutiveText = regexMatcher.group(0);
                String[] splitMatchedConsecutiveText = matchedConsecutiveText.split(" ");
                String matchedText = splitMatchedConsecutiveText[0];

                duplicateConsecutiveWordsDetail += "[" + matchedText;
                String repeatedWordSentence = "";
                for (String sentence: splitSentence) {
                    if (sentence.matches(".*\\s" + matchedText + "\\s.*")) {
                        repeatedWordSentence = sentence;
                    }
                }
                duplicateConsecutiveWordsDetail += ", " + splitMatchedConsecutiveText.length;
                int wordIndexOfRepeatedWords = findWordIndexOfRepeatedWords(matchedText, repeatedWordSentence);
                duplicateConsecutiveWordsDetail += ", " + wordIndexOfRepeatedWords + "]\n";
            }
            return duplicateConsecutiveWordsDetail;
        } catch (PatternSyntaxException ex) {
            // Syntax error in the regular expression
        }
        return "";
    }

    public static int findWordIndexOfRepeatedWords(String repeatedWord, String sentence) {
        String[] splittedSentence = sentence.split(" ");
        int index = 0;
        for (String word: splittedSentence) {
            if (word.equals(repeatedWord)) {
                return index;
            } else {
                index += 1;
            }
        }
        return index;
    }
}
