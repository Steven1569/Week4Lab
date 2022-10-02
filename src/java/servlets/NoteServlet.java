
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import models.Note;

/**
 *
 * @author Steven
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Note note;
        //text path
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //read files
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
         String title = br.readLine();
         String content = br.readLine();
         
       
        note = new Note(title, content);
        request.setAttribute("note", note);

        br.close();
        

        if (request.getParameter("edit") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Note note2;
        //text path
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        //Write files
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        pw.println(title);
        pw.println(content);

        note2 = new Note(title, content);
        request.setAttribute("note", note2);

        pw.close();

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

}
