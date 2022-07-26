package controller.timetable;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.LectureDao;
import dao.MemberDao;
import dto.Timetable;

/**
 * Servlet implementation class gettimetable
 */
@WebServlet("/timetable/gettimetable")
public class gettimetable extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public gettimetable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		int mno = MemberDao.getMemberDao().getmno(mid);
		ArrayList<Timetable> arrayList = LectureDao.getLectureDao().gettimetabe(mno);
		
		
		
		try {
			JSONArray array = new JSONArray();
			for (int i = 0; i < arrayList.size(); i++) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", arrayList.get(i).getTable_name());
				jsonObject.put("professor", arrayList.get(i).getTable_professor());
				jsonObject.put("time", arrayList.get(i).getTable_time());
				jsonObject.put("code", arrayList.get(i).getTable_code());
				array.put(jsonObject);
			}
			response.setContentType("application/json");
			response.getWriter().print(array.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
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
