package controller.timetable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LectureDao;
import dto.Lecture;

/**
 * Servlet implementation class getdepartment
 */
@WebServlet("/timetable/getdepartment")
public class getdepartment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getdepartment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		
		String college = request.getParameter("college");
		
		ArrayList<Lecture> list = LectureDao.getLectureDao().getdepartmentlist(college);
		Set<String> department = new TreeSet<String>();
		String html = "<select id=\"departmentbox\" onchange=\"departmentchange()\" class=\"form-select\">";
		
		PrintWriter out = response.getWriter();
		
		for (Lecture lecture : list) {
			if (lecture.getLdepartment() != null){
				department.add(lecture.getLdepartment());
			}
		}
		for (String lecture : department) {
			
				html += "<option>" + lecture.toString() + "</option>";
			
		}
		
		html += "</select>";
		
		out.print(html);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
