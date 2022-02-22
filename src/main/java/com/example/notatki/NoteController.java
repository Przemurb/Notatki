package com.example.notatki;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "NoteController", value = "/save")
public class NoteController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Note note = createNote(request);
        saveNote(note, request);
        String noteUrl = NoteUtils.buildNoteUrl(note);
        request.setAttribute("noteUrl", noteUrl);
        request.getRequestDispatcher("/conf.jsp").forward(request, response);
    }

    private void saveNote(Note note, HttpServletRequest request) {
        if(note.getType().equals(Note.TYPE_PRIVATE)) {
            request.getSession().setAttribute(note.getId(), note.getContent());
        } else if(note.getType().equals(Note.TYPE_PUBLIC)) {
            request.getServletContext().setAttribute(note.getId(), note.getContent());
        }
    }

    private Note createNote(HttpServletRequest request) {
        String noteId = request.getParameter("noteId");
        String noteContent = request.getParameter("noteContent");
        String noteType = request.getParameter("noteType");
        return new Note(noteId, noteContent, noteType);
    }
}
