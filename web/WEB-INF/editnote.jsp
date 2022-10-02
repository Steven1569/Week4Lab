<%-- 
    Document   : editnote
    Created on : Oct 2, 2022, 1:48:31 PM
    Author     : Steven
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
         <h2>Edit Note</h2>
        <form method = "post" action="note">
            Title: <input type = "text" name="title" value ="${note.title}" ><br>
            Contents: <textarea name="content" rows="6" cols="20">${note.content}</textarea>
            <br>
            <input type = "submit" name="save" value="Save">
        </form>
    </body>
</html>
