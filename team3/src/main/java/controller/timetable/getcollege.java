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
 * Servlet implementation class getcollege
 */
@WebServlet("/timetable/getcollege")
public class getcollege extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcollege() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setCharacterEncoding("UTF-8");
		
		ArrayList<Lecture> lecturelist = LectureDao.getLectureDao().getlecturelist();
		
		Set<String> college = new TreeSet<String>();
		
		for (Lecture lecture : lecturelist) {
			college.add(lecture.getLcollege());
		}
		
		PrintWriter out = response.getWriter();
		
		String html ="<select id=\"collegebox\" onchange=\"collegechange()\" class=\"form-select\">";
		
		for (String c : college) {
			html += "<option>" + c + "</option>";
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
