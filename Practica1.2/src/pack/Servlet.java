package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Servlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	//Creamos sesion
    		HttpSession sesion = request.getSession(true);
    		response.setContentType("text/html");
    		PrintWriter html = response.getWriter();
    		html.print("<strong>");
    		//Cambiamos  el tiempo de inactividad de sesión entre peticiones
    		int seconds=5;
    		sesion.setMaxInactiveInterval(seconds);
    		
    		
    		Date date = (Date)sesion.getAttribute("date");
    		if(date != null) {
    		html.print("Último acceso de la sesión: " + date + "<br>");
    		}
    		else {
    		html.print("Este es el primer acceso de la sesión <br>");
    		}
    		date = new Date();
    		sesion.setAttribute("date", date);
    		html.print("Fecha actual: " + date);
    		html.print("</strong>");
    		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	
}
