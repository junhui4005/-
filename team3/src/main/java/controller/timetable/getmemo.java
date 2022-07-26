package controller.timetable;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LectureDao;
import dao.MemberDao;

/**
 * Servlet implementation class getmemo
 */
@WebServlet("/timetable/getmemo")
public class getmemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getmemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int table_code = Integer.parseInt(request.getParameter("table_code"));
		String mid = request.getParameter("mid");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		String memo = LectureDao.getLectureDao().getmemo(mno, table_code);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(memo);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
