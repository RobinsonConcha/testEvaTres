package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import bean.UsuarioBean;
/**
 * Servlet implementation class UsuarioServlet
 */
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UsuarioServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDao loginDao = new UsuarioDao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsuarioBean loginBean = new UsuarioBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		if (loginDao.validate(loginBean))
		{
			HttpSession session = request.getSession();
		    session.setAttribute("user",username);
		   
		
			response.sendRedirect("principal.jsp");
			
			
		}
		else 
		{
			//HttpSession session = request.getSession();
			response.sendRedirect("index.jsp");
			
		}
		
	}

}

