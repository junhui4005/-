package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.ReplyDao;
import dto.Reply;

/**
 * Servlet implementation class rereplyupdate
 */
@WebServlet("/board/rereplyupdate")
public class rereplyupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rereplyupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("xxx");
		request.setCharacterEncoding("UTF-8");
    	int rno = Integer.parseInt(request.getParameter("rno") );
    	int bno = Integer.parseInt(request.getParameter("bno") );
    	String upcontent2 = request.getParameter("upcontent2");
    	String mid = (String)request.getSession().getAttribute("login");
		int mno = BoardDao.getBoardDao().getmno(mid);
		String anonymous = request.getParameter("anonymous");
		System.out.println(anonymous.toString());
		System.out.println(upcontent2);
		
		if(anonymous.equals("true")) {
			Reply reply = new Reply(rno, upcontent2, "익명", null, 0, 0, bno, mno);
			boolean result = ReplyDao.getReplyDao().replyupdate(reply);
			if(result) {
				 response.getWriter().print( 1 );
			}
			else {
				 response.getWriter().print( 2 );
			}
			
			
		} else {
			Reply reply = new Reply(rno, upcontent2, mid, null, 0, 0, bno, mno);
			boolean result = ReplyDao.getReplyDao().replyupdate(reply);
			if(result) {
				 response.getWriter().print( 1 );
			}
			else {
				 response.getWriter().print( 2 );
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
