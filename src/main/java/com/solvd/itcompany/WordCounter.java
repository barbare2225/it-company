package com.solvd.itcompany;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WordCounter {

    private static final Logger LOGGER = LogManager.getLogger(WordCounter.class);

    public static void countUniqueWords() throws Exception {

        String text = Files.readString(
                Path.of("src/main/resources/thegreatwizardofoz.txt"));

        if (StringUtils.isBlank(text)) {
            LOGGER.warn("book.txt is empty");
            return;
        }

        Set<String> uniqueWords =
                Arrays.stream(
                                StringUtils.lowerCase(text)
                                        .replaceAll("[^a-z ]", " ")
                                        .split("\\s+"))
                        .filter(StringUtils::isNotBlank)
                        .collect(Collectors.toSet());

        Files.writeString(
                Path.of("result.txt"),
                "Unique words: " + uniqueWords.size());
    }
}