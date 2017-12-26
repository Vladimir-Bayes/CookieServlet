package com.yiibai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();

			String name = request.getParameter("username");
			String username = new String(name.getBytes("ISO-8859-1"),"utf-8");

			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"UTF-8\"><body>");
			out.print("欢迎您, " + username);

			Cookie ck = new Cookie("uname", username);// creating cookie object
			response.addCookie(ck);// adding cookie in the response

			// creating submit button

			out.print("<form action='servlet2' method='post'>");
			out.print("<p>Cookies已在浏览器中设置，现在跳转到第二个Servlet中读取Cookies的值。</p>");
			out.print("<input type='submit' value='提交到第二个Servlet'>");
			out.print("</form>");

			out.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
