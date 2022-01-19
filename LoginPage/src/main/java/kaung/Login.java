package kaung;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import kaung.login.dao.LoginDao;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/log")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String pass = request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		
		if( dao.check(name, pass) ) { 
			
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			response.sendRedirect("/LoginPage/welcome.jsp");
		} else {
			response.sendRedirect("/LoginPage/login.jsp");
		}
	}

}
