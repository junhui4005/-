package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * Servlet implementation class login
 */
@WebServlet("/member/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
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

		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpassword = request.getParameter("mpassword");
		int result = MemberDao.getMemberDao().login(mid, mpassword);
		if(result == 1) {
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(60*60*24);
			session.setAttribute("login", mid);
			response.sendRedirect("/team3/main.jsp");
		}else if(result == 2) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(
					"<script type='text/javascript' charset='UTF-8'>"
					+ "alert('일치하는 회원 정보가 없습니다.');"
					+"location.href ='/team3/member/login.jsp';"		
					+ "</script>"
					);
			
		}else if(result == 3) {
			
			System.out.println("오류");
		}
	}

}
