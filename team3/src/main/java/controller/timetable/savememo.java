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
 * Servlet implementation class savememo
 */
@WebServlet("/timetable/savememo")
public class savememo extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public savememo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String memo = request.getParameter("memo");
		int table_code = Integer.parseInt(request.getParameter("table_code"));
		String mid = request.getParameter("mid");
		int mno = MemberDao.getMemberDao().getmno(mid);

		boolean result = LectureDao.getLectureDao().savememo(memo, mno, table_code);

		if(result) {
			response.getWriter().print(memo);
		} else {
			response.getWriter().print("error");
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