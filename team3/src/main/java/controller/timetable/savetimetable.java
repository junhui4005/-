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
 * Servlet implementation class savetimetable
 */
@WebServlet("/timetable/savetimetable")
public class savetimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public savetimetable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String table_name = request.getParameter("name");
		String table_professor = request.getParameter("professor");
		String table_time = request.getParameter("time");
		int table_code = Integer.parseInt(request.getParameter("code"));
		String mid = request.getParameter("mid");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		boolean result = LectureDao.getLectureDao().savetimetable(table_name, table_professor, table_time, table_code, mno);
		
		if (result) {
			response.getWriter().print("database save success");
		} else {
			response.getWriter().print("database save failure");
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
