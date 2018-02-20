package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletSesion2
 */
@WebServlet("/ServletSesion2")
public class ServletSesion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletSesion2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    		response.setContentType("text/html");
    		PrintWriter out = response.getWriter();
    		out.println("<html><head><title>PRACTICA 1.2</title></head>");
    		out.println("<body ><center><h1> Servlet Form </h1>");
    		String answer = request.getParameter("nombre");
    		Cookie c = new Cookie("userIdCookie", answer);
    		c.setMaxAge(0);//Expire cookie
    		out.println("<h2> Your name is: " + c.getValue() + "</h2>");//Para obtener valor cookie
    		String answer2 = request.getParameter("email");
    		out.println("<h2> Your email is: " + answer2 + "</h2>");
    		String answer3 = request.getParameter("apellidos");
    		out.println("<h2> Your surname is: " + answer3 + "</h2>");
    		out.println("</center></body></html>");
    		response.addCookie(c);//Añadir cookie
    		
    		out.close();
    		
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
