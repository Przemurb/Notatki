package com.example.notatki;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "PrintNoteController", urlPatterns = {"/private", "/public"})
public class PrintNoteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        findNote(request).ifPresent(note -> request.setAttribute("note", note));
        request.getRequestDispatcher("/note.jsp").forward(request, response);
    }
    private Optional<String> findNote(HttpServletRequest request) {
        String servletPath = request.getServletPath();
        String noteId = request.getParameter("id");
        String note = null;
        if(servletPath.contains(NoteUtils.PRIVATE_PATH)) {
//        jeśli priv to notatka zapisana jest w atrybutach sesji
            note = (String) request.getSession().getAttribute(noteId);
        } else if(servletPath.contains(NoteUtils.PUBLIC_PATH)) {
//        jeśli public to notatka zapisana jest w atrybutach kontekstu aplikacji
            note = (String) request.getServletContext().getAttribute(noteId);
        }
        return Optional.ofNullable(note);
    }
}
