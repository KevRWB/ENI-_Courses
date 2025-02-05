package fr.eni.tpGestionListesCourses.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.tpGestionListesCourses.BusinessException;
import fr.eni.tpGestionListesCourses.bll.ListesCourseManager;
import fr.eni.tpGestionListesCourses.bo.Liste;

/**
 * Servlet implementation class ListesPredefinies
 */
@WebServlet("/ListesPredefinies")
public class ListesPredefinies extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ListesCourseManager listeCourseManager = new ListesCourseManager();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Liste> listeListes = new ArrayList<>();
		
		try {
			listeListes = listeCourseManager.selectAll();
		} catch (BusinessException e) {
			e.printStackTrace();
		}
		
		this.getServletContext().setAttribute("listeListe",listeListes );
		
		request.setAttribute("listeListes", listeListes);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/listesPredefinies.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("coucou");
	}

}
