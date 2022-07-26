package controller.review;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDao;
import dto.Review;

/**
 * Servlet implementation class reviewadd
 */
@WebServlet("/review/reviewadd")
public class reviewadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public reviewadd() {
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
		int lno = Integer.parseInt( request.getParameter("lno"));
		int test = Integer.parseInt( request.getParameter("test"));
		int team = Integer.parseInt( request.getParameter("team"));
		int home = Integer.parseInt( request.getParameter("home"));
		int star = Integer.parseInt( request.getParameter("star"));
		String text = request.getParameter("text");
		text = text.replace("\r\n", "<br>");
		
		Review review = new Review(0, lno, mno, text, star, home, team, test);
		boolean result = ReviewDao.getreviewDao().reviewadd(review);
		if(result) {
			response.getWriter().print( 1 );
		}
		else {response.getWriter().print( 2 );}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
