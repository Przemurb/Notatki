<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang=" =pl
">
<head>
    <title>Notatnik</title>
</head>
<body>
<h1>Notatnik</h1>
<form action="save" method="post">
    <fieldset>
        <label for="noteId">Identyfikator notatki</label>
        <input type="text" id="noteId" name="noteId">
    </fieldset>
    <fieldset>
        <label for="noteContent">Treść notatki</label>
        <textarea id="noteContent" name="noteContent"></textarea>
    </fieldset>
    <fieldset>
        <label for="privateNote">Notatka prywatna</label>
        <input type="radio" id="privateNote" name="noteType" value="priv" checked>
        <label for="publicNote">Notatka publiczna</label>
        <input type="radio" id="publicNote" name="noteType" value="pub">
    </fieldset>
    <input type="submit" value="Zapisz">
</form>
</body>
</html>