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
 * Servlet implementation class rereplywrite
 */
@WebServlet("/board/rereplywrite")
public class rereplywrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public rereplywrite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("대댓글작성");
		request.setCharacterEncoding("UTF-8");
		int rindex = Integer.parseInt( request.getParameter("rno") ); // rindex : 어떤 댓글의 대댓글인 식별번호 ( 부모 댓글번호 ) 
		int bno = Integer.parseInt(  request.getParameter("bno") ) ;	
		String rcontent = request.getParameter("rrcontent");
			String mid = (String)request.getSession().getAttribute("login");
			int mno = BoardDao.getBoardDao().getmno(mid);
			String anonymous = request.getParameter("anonymous");
			System.out.println(rcontent);
			if(anonymous.equals("true")) {
				Reply reply = new Reply(0, rcontent, "익명", null, rindex, 0, bno, mno);
				boolean result = ReplyDao.getReplyDao().replywrite(reply);
				if(result) {
					 response.getWriter().print( 1 );
				}
				else {
					 response.getWriter().print( 2 );
				}
				
				
			} else {
				Reply reply = new Reply(0, rcontent, mid, null, rindex, 0, bno, mno);
				boolean result = ReplyDao.getReplyDao().replywrite(reply);
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
