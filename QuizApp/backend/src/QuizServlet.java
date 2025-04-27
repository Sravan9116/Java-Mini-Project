import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class QuizServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");

        int score = 0;

        if ("Paris".equals(q1)) score++;
        if ("8".equals(q2)) score++;

        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.println("You scored: " + score + "/2");
    }
}
