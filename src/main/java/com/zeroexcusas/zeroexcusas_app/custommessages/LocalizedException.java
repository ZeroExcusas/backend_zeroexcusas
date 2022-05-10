package com.zeroexcusas.zeroexcusas_app.custommessages;

import org.testng.annotations.Test;

import java.util.Locale;

public class LocalizedException extends Exception {

    private final String messageKey;
    private final Locale locale;

    public LocalizedException(String messageKey) {
        this(messageKey, Locale.getDefault());
    }

    public LocalizedException(String messageKey, Locale locale) {
        this.messageKey = messageKey;
        this.locale = locale;
    }

    public String getLocalizedMessage() {
        return Messages.getMessageForLocale(messageKey, locale);
    }

/*
        @Test
        public void givenUsEnglishDefaultLocale_whenLocalizingMessage_thenMessageComesFromDefaultMessages() {
            Locale.setDefault(Locale.US);

            LocalizedException localizedException = new LocalizedException("message.exception");
            String usEnglishLocalizedExceptionMessage = localizedException.getLocalizedMessage();

            assertThat(usEnglishLocalizedExceptionMessage).isEqualTo("I am an exception.");
        }

        @Test
        public void givenFranceFrenchDefaultLocale_whenLocalizingMessage_thenMessageComesFromFrenchTranslationMessages() {
            Locale.setDefault(Locale.FRANCE);

            LocalizedException localizedException = new LocalizedException("message.exception");
            String franceFrenchLocalizedExceptionMessage = localizedException.getLocalizedMessage();

            assertThat(franceFrenchLocalizedExceptionMessage).isEqualTo("Je suis une exception.");
        }

 */



}