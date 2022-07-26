package controller.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MessageDao;
import dao.ReviewDao;


/**
 * Servlet implementation class send
 */
@WebServlet("/message/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public send() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = (String)request.getSession().getAttribute("login");
		int mno = ReviewDao.getreviewDao().getmno(mid);
		int getno = Integer.parseInt(request.getParameter("getno"));
		String mcontent = request.getParameter("mcontent");
		mcontent = mcontent.replace("\r\n", "<br>");
		
		boolean result = MessageDao.getMessageDao().send(mno, getno, mcontent);
		if(result) {
			response.getWriter().print( result );
		}
		else{}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
	}

}
