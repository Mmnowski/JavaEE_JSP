package com.example.servletjspdemo.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import javax.print.AttributeException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/data")
public class DataServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String> errors = new ArrayList<String>();
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        
        if(request.getParameter("firstName") != "") {
        	boolean checkImie = imieCheck(request.getParameter("firstName"));
        	if(!checkImie) errors.add("Imie moze zawierac tylko litery!");
        }else {
        	errors.add("Nie podano imienia!");
        }

        if (request.getParameter("hobby") == null) {
        	errors.add("Nie wybrano hobby!");
        }
        
        if (request.getParameter("info") == null) {
        	errors.add("Brak opisu!");
        }
        //plec
        if (request.getParameter("gender") == null) {
        	errors.add("Nie wybrano płci!");
        }
        //auto
        if (request.getParameterValues("food") == null) {
        	errors.add("Nie wybrano jedzenia!");
        }
        
        if (request.getParameterValues("favFood") == null) {
        	errors.add("Nie wybrano ulubionego jedzenia!");
        }
        //data urodzenia
        if(request.getParameter("bday") != "") {
        	boolean checkData = dataCheck(request.getParameter("bday"));
        	if(!checkData) errors.add("Zły format daty, wymagany format: DD-MM-RRRR!");
        }else {
        	errors.add("Nie podano daty urodzenia!");
        }
        
        if(errors.size() == 0) {
        	//lista hobby
            String selectedHobby = "";
            for (String hobby : request.getParameterValues("hobby")) {
                selectedHobby += hobby + " ";
            }
            //lista aut
    		String selectedFoods = "";
    		for (String food : request.getParameterValues("food")) {
    			selectedFoods += food + " ";
    		}      
            
            //zamiana string to date
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        	LocalDate date = LocalDate.parse(request.getParameter("bday"), formatter);
        	LocalDate now = LocalDate.now();
        	//obliczanie wieku
            int age = Period.between(date, now).getYears();
            String adult ="";
            if(age>=18) {
            	adult="tak";
            }
            else {
            	adult="nie";
            }
            //wypis html
                out.println("<html><body><h2>Your data</h2>" +
                		"<p>First name: " + request.getParameter("firstName") + "<br />" +
        				"<p>Your hobby: " + selectedHobby + "<br />" +
        				"<p>Info:" + request.getParameter("info") + "<br />" +
        				"<p>Gender:" + request.getParameter("gender") + "<br />" +
        				"<p>Favourite food:" + selectedFoods + "<br />" +
        				"<p>Most favourite food:" + request.getParameter("favfood") + "<br />" +
        				"<p>Birthday " + date + "<br />" +
        				"<p>Age: " + age + "<br />" +
        				"<p>Over 18?: " + adult + "<br />" +
                		"</body></html>");
            out.close();
        }else {
            for(String element : errors) {
          		out.print(element + "<br />");
          }
        }
    }
    
    boolean imieCheck(String imie) {
    	Pattern p = Pattern.compile("[0-9]");
    	Matcher m = p.matcher(imie);
    	if(m.find()) {
    	    return false;
    	}
    	else return true;
    }
    
    boolean dataCheck(String data) {
    	Pattern p = Pattern.compile("[0-9][0-9][-][0-9][0-9][-][0-9][0-9][0-9][0-9]");
    	Matcher m = p.matcher(data);
    	if(m.find()) {
    	    return true;
    	}
    	else return false;
    }

}
