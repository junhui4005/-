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
 * Servlet implementation class updatepw
 */
@WebServlet("/member/updatepw")
public class updatepw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepw() {
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
		
		HttpSession session = request.getSession();
		String mpassword = request.getParameter("mpassword");
		String oldpassword = request.getParameter("oldpassword");
		String mpasswordcheck = request.getParameter("mpasswordcheck");
		String mid = (String)session.getAttribute("login");
		String password = MemberDao.getMemberDao().findpwcheck(mid);
		if(password.equals(oldpassword)) {
			if(mpassword.equals(mpasswordcheck)){
				boolean result = MemberDao.getMemberDao().updatepw(mpassword, mid);
				if (result) {
					response.getWriter().print(1);
				}else {
					response.getWriter().print(2);
				}
	 		}else{
	 			response.getWriter().print(3);
	 		}
		}else {
			response.getWriter().print(4);
		}
	}

}
