package fr.eni.chifoumi.traitements;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Traitement")
public class Traitement extends HttpServlet {
	
	private static final String PIERRE = "pierre";
	private static final String FEUILLE = "feuille";
	private static final String CISEAUX = "ciseaux";
	
	private static final long serialVersionUID = 1L;
	
	private int nbRand;
	private final int NB_MAX_RAND = 3;
	private String coupIa;
	private String coupUser;
	private String win;
	private int coupGagnantUser = 0;
	private int coupGagnantIa = 0;
	private int victoiresUser = 0;
	private int victoiresIa = 0;
	private int nbParties = 1;
	
	private String imgWin = "img/win.jpg";
	private String imgLose = "img/lose.jpg";
	private String imgEven = "img/even.png";
	
	private String imgResult;

	@Override
	public void init() throws ServletException {	
		super.init();
		Random rand = new Random();
		nbRand = rand.nextInt(NB_MAX_RAND);
		switch (nbRand) {
		case 0: coupIa = PIERRE;
			break;
		case 1: coupIa = FEUILLE;
		break;

		default: coupIa = CISEAUX;
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//--recuperation et affichage des données saisies par le joueur
		String saisieUser = request.getParameter("chifumi");
		coupUser = saisieUser;
		System.out.println("user : " + coupUser);
		System.out.println("ia : " + coupIa);
		
		//---Conditions de victoires
		if(coupUser.equals(coupIa)) {
			win = "Egalité !";
			imgResult = imgEven;
		}else if(coupUser.equals(PIERRE)) {
			if(coupIa.equals(CISEAUX)) {
				win = "Gagné !";
				imgResult = imgWin;
			}else {
				win = "Perdu...";
				imgResult = imgLose;
			}
		}else if(coupUser.equals(CISEAUX)) {
			if(coupIa.equals(PIERRE)) {
				win = "Perdu...";
				imgResult = imgLose;
			}
			else {
				win = "Gagné !";
				imgResult = imgWin;
			}
		}else {
			if(coupIa.equals(CISEAUX)) {
				win = "Perdu...";
				imgResult = imgLose;
			}
			else {
				win = "Gagné";
				imgResult = imgWin;
			}
		}
		
		//---Incremente le nombre de coup de chaque joueur		
		if(win.equals("Gagné")) coupGagnantUser++;
		else coupGagnantIa ++;
		
		//---Increment le nombre de parties gagnées si victoire d'un joueur (total de coups gagnants = 3)
		if(coupGagnantIa == 3) {		
			coupGagnantUser = 0;
			coupGagnantIa = 0;	
			nbParties++;
			victoiresIa++;
		}
		
		if(coupGagnantUser == 3) {
			victoiresUser++;
			coupGagnantUser = 0;
			coupGagnantIa = 0;
			nbParties++;
		}
		
		//----Set attribute to request 	
		request.setAttribute("valUser", coupUser);
		request.setAttribute("valIa", coupIa);
		request.setAttribute("result", win);
		request.setAttribute("coupGagnantIa", coupGagnantIa);
		request.setAttribute("coupGagnantUser", coupGagnantUser);
		request.setAttribute("victoiresUser", victoiresUser);
		request.setAttribute("victoiresIa", victoiresIa);
		request.setAttribute("nbParties", nbParties);
		request.setAttribute("urlImgResult", imgResult);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/reponse.jsp");
		rd.forward(request, response);
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//----Set attribute to request 	
		request.setAttribute("coupGagnantIa", coupGagnantIa);
		request.setAttribute("coupGagnantUser", coupGagnantUser);
		request.setAttribute("victoiresUser", victoiresUser);
		request.setAttribute("victoiresIa", victoiresIa);
		request.setAttribute("nbParties", nbParties);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/JSP/jouer.jsp");
		rd.forward(request, response);
	}

}
