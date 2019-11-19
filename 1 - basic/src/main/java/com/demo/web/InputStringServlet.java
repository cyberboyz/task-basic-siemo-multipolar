package com.demo.web;

import com.demo.dao.InputStringDAO;
import com.demo.model.InputString;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ControllerServlet.java
 * This servlet acts as a page controller for the application, handling all
 * requests from the user.
 * @email Ramesh Fadatare
 */

@WebServlet("/")
public class InputStringServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InputStringDAO inputStringDAO;
	
	public void init() {
		inputStringDAO = new InputStringDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/insert":
				insertInputString(request, response);
				break;
			default:
				listInputString(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void insertInputString(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String stringInput = request.getParameter("inputString");
        String stringOutput = Helper.removeDuplicateConsecutiveWords(stringInput);
        String duplicateConsecutiveWordsDetail = Helper.findDuplicateConsecutiveWordsDetail(stringInput);

        InputString newInputString = new InputString(stringInput, stringOutput, duplicateConsecutiveWordsDetail);
		inputStringDAO.insertInputString(newInputString);
		response.sendRedirect("list");
	}

	private void listInputString(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<InputString> listInputString = inputStringDAO.selectAllInputStrings();
		InputString lastInputString = inputStringDAO.selectLastInputString();

		request.setAttribute("listInputString", listInputString);
		request.setAttribute("lastInputString", lastInputString);
		RequestDispatcher dispatcher = request.getRequestDispatcher("input-string-list.jsp");
		dispatcher.forward(request, response);
	}
}
