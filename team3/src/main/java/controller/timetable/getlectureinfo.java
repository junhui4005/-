package controller.timetable;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dao.LectureDao;
import dto.Lecture;

/**
 * Servlet implementation class getlectureinfo
 */
@WebServlet("/timetable/getlectureinfo")
public class getlectureinfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getlectureinfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		int lno = Integer.parseInt(request.getParameter("lno"));

		ArrayList<String> temp = new ArrayList<String>();
		Lecture lecture = LectureDao.getLectureDao().getlectureinfo(lno);
			
		String[] l = lecture.getLtime().split("_");
		
		temp = new ArrayList<String>();
		if (l.length == 1) {
			temp.add(l[0].split("/")[0] + "(" + l[0].split("/")[1] + ")");
		} else if (l.length == 2) {
			for (int i = 0; i < l.length; i ++) {
				for (int j = i+1; j < l.length; j++) {
					if (l[i].split("/")[0].equals(l[j].split("/")[0])) {
						temp.add(l[i].split("/")[0] + "(" + l[i].split("/")[1] + "-" + l[j].split("/")[1] + ")");
					} else {
						temp.add(l[i].split("/")[0] + "(" + l[i].split("/")[1] + ") " + l[j].split("/")[0] + "(" + l[j].split("/")[1] + ")"); 
					}
				}
			}
		} else if (l.length == 3) {
			
			for (String item : l) {
				temp.add(item);
			}
			
			
			if (temp.get(0).split("/")[0].equals(temp.get(1).split("/")[0]) && temp.get(1).split("/")[0].equals(temp.get(2).split("/")[0])) {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + "-" + temp.get(2).split("/")[1] + ")");
				temp.remove(1);
				temp.remove(1);
			} else if (temp.get(0).split("/")[0].equals(temp.get(1).split("/")[0])) {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + "-" + temp.get(1).split("/")[1] + ")");
				temp.set(1, temp.get(2).split("/")[0] + "(" + temp.get(2).split("/")[1] + ")");
				temp.remove(2);
			} else if (temp.get(1).split("/")[0].equals(temp.get(2).split("/")[0])) {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + ")");
				temp.set(1, temp.get(1).split("/")[0] + "(" + temp.get(1).split("/")[1] + "-" + temp.get(2).split("/")[1] + ")");
				temp.remove(2);
			} else {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + ")");
				temp.set(1, temp.get(1).split("/")[0] + "(" + temp.get(1).split("/")[1] + ")");
				temp.set(2, temp.get(2).split("/")[0] + "(" + temp.get(2).split("/")[1] + ")");
			}
			
		} else if (l.length == 4) {
			
			for (String item : l) {
				temp.add(item);
			}
			
			if(temp.get(0).split("/")[0].equals(temp.get(1).split("/")[0]) && temp.get(1).split("/")[0].equals(temp.get(2).split("/")[0]) && temp.get(2).split("/")[0].equals(temp.get(3).split("/")[0])) {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + "-" + temp.get(3).split("/")[1] + ")");
				temp.remove(1);
				temp.remove(1);
				temp.remove(1);
			} else if (temp.get(0).split("/")[0].equals(temp.get(1).split("/")[0]) && temp.get(2).split("/")[0].equals(temp.get(3).split("/")[0])) {
				temp.set(0, temp.get(0).split("/")[0] + "(" + temp.get(0).split("/")[1] + "-" + temp.get(1).split("/")[1] + ")");
				temp.set(1, temp.get(2).split("/")[0] + "(" + temp.get(2).split("/")[1] + "-" + temp.get(3).split("/")[1] + ")");
				temp.remove(2);
				temp.remove(2);
			}
			
		} else {
			temp.add("미지원 기능");
		}
		
		
		
		
		
		
		JSONArray jsonArray = new JSONArray();
		

		try {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("lname",lecture.getLname());
			jsonObject.put("ltime",temp);
			jsonObject.put("lno", lecture.getLno());
			jsonObject.put("lprofessor",lecture.getLprofessor());
			jsonObject.put("ltime_db",lecture.getLtime());
			
			jsonArray.put(jsonObject);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonObject.toString());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
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
