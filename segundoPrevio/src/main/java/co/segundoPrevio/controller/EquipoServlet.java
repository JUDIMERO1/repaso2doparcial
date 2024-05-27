package co.segundoPrevio.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import co.segundoPrevio.dao.CountryDao;
import co.segundoPrevio.dao.CountryDaoFactory;
import co.segundoPrevio.dao.TeamDao;
import co.segundoPrevio.dao.TeamDaoFactory;
import co.segundoPrevio.model.Country;
import co.segundoPrevio.model.Team;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/")
public class EquipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CountryDao countryDao;
	private TeamDao teamDao;

	/**
	 * Default constructor.
	 */
	public EquipoServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		this.countryDao = CountryDaoFactory.getCountryDao("postgresql");
		this.teamDao = TeamDaoFactory.getTeamDao("postgresql");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/listTeams":
				ListTeams(request, response);
				break;
			case "/newTeam":
				showNewTeamForm(request, response);
				break;
			case "/delete":
				eliminarEquipo(request, response);
				break;
			default:
				ListTeams(request, response);
				break;

			}
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void ListTeams(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {
		List<Team> teams = this.teamDao.selectAll();
		System.out.println(teams.toString());
		request.setAttribute("teams", teams);
		RequestDispatcher dispatcher = request.getRequestDispatcher("equipo.jsp");
		dispatcher.forward(request, response);
		/*
		 * List<Country> countrys = this.countryDao.selectAll();
		 * System.out.println(countrys.toString());
		 */
	}

	private void showNewTeamForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, SQLException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("registroEquipo.jsp");
		dispatcher.forward(request, response); 
	}

	private void eliminarEquipo(HttpServletRequest request, HttpServletResponse response)throws ServletException, SQLException, IOException {
		String id = request.getParameter("id");
		this.teamDao.delete(id);
		response.sendRedirect("listTeams");
	}

}
