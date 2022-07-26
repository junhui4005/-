package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.ReplyDao;

/**
 * Servlet implementation class saverelike
 */
@WebServlet("/board/saverelike")
public class saverelike extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saverelike() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rno = Integer.parseInt(request.getParameter("rno"));
		String mid = request.getParameter("mid");
		System.out.println(rno);
		
		int result = ReplyDao.getReplyDao().replylike(rno, BoardDao.getBoardDao().getmno(mid));
		
		if(result == 1) {response.getWriter().print(result);}
		else if(result==2) {response.getWriter().print(result);}
		else if(result==3) {response.getWriter().print(result);}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
