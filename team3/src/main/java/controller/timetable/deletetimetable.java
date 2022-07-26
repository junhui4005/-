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
 * Servlet implementation class deletetimetable
 */
@WebServlet("/timetable/deletetimetable")
public class deletetimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deletetimetable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String mid = request.getParameter("mid");
		int mno = MemberDao.getMemberDao().getmno(mid);
		String table_code = request.getParameter("code");
		
		boolean result = LectureDao.getLectureDao().deletetimetable(table_code, mno);
		
		if (result) {
			response.getWriter().print("database delete success");
		} else {
			response.getWriter().print("database delete failure");
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
