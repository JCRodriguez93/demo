package com.example.demo.strings;

public class StringsGetNotes {

    public static String getSubstringNotes(String note) {
        int inicio = note.lastIndexOf("/") + 1;
        int fin = note.lastIndexOf(".");
        return note.substring(inicio, fin);
    }
}
