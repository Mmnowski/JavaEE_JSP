package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/form")
public class FormServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>Simple form servlet</h2>" +
				"<form action='data'>" +
				"Imię: <input type='text' name='firstName' /> <br />" +
				"Data urodzenia (DD-MM-YYYY): <input type='text' name='bday' /> <br />" +
				"<input type='checkbox' name='hobby' value='music'>Muzyka<br />" +
				"<input type='checkbox' name='hobby' value='movies'>Filmy<br />" +
				"<input type='checkbox' name='hobby' value='games'>Gry<br />" +
				"<input type='checkbox' name='hobby' value='books'>Książki<br />" +
				"O mnie:<br/><textarea rows='8' cols='30' name='info'></textarea>" +
				"<br/>Wybierz płeć:<br/>" +
				"  <input type='radio' name='gender' value='male'> Male<br/>" + 
				"  <input type='radio' name='gender' value='female'> Female<br/>" + 
				"  <input type='radio' name='gender' value='other'> Other<br/>" +
				"Ulubione jedzenie: <br/>" +
				"<select multiple name='food'>" + 
				"  <option value='fish'>fish</option>" + 
				"  <option value='crab'>crab</option>" + 
				"  <option value='beef'>beef</option>" + 
				"</select><br/>" +
				"Najulubieńsze jedzenie: <br/>" +
				"<select name='favfood'>" + 
				"  <option value='fish'>fish</option>" + 
				"  <option value='crab'>crab</option>" + 
				"  <option value='beef'>beef</option>" + 
				"</select><br/>" +
				"<input type='submit' value='OK' />" +
				"</form>" +
				"</body></html>");
		out.close();
	}

}

