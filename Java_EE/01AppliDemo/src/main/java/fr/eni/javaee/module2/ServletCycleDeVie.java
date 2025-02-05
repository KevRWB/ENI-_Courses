package fr.eni.javaee.module2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycleDeVie
 */
@WebServlet("/modules/module2/ServletCycleDeVie")
public class ServletCycleDeVie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private int nombrePassageInit = 0;
	private int nombrePassageConstruction = 0;
	private int nombreAppelsServlets = 0;
	private int nombreDestruction = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCycleDeVie() {
        super();
        nombrePassageConstruction++;
    }
    
	@Override
	public void init() throws ServletException {
		nombrePassageInit++;
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nombreAppelsServlets++;
		response.getWriter().append("Nombre de passages constructeur : ").append(""+nombrePassageConstruction);
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("Nombre de passages Init : ").append(""+nombrePassageInit);
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("Nombre appels servlets : ").append(""+nombreAppelsServlets);
		response.getWriter().append(System.lineSeparator());
		response.getWriter().append("Nombre de passages destructeur : ").append(""+nombreDestruction);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

	@Override
	public void destroy() {
		nombreDestruction++;
		super.destroy();
	}
}
