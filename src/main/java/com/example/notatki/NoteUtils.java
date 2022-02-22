package com.example.notatki;

public class NoteUtils {
    static final String PRIVATE_PATH = "private";
    static final String PUBLIC_PATH = "public";

    public static String buildNoteUrl(Note note) {
//        path: private?id=[noteId]
//        path: public?id=[noteId]
        if(note.getType().equals(Note.TYPE_PUBLIC)) {
            return String.format("%s?id=%s", PUBLIC_PATH, note.getId());
        } else if (note.getType().equals(Note.TYPE_PRIVATE)) {
            return String.format("%S?=%s", PRIVATE_PATH, note.getId());
        }
        throw new IllegalArgumentException("invalid note type " + note.getType());
    }
}
