package controller.timetable;

import java.io.IOException;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



/**
 * Servlet implementation class lecturechoice
 */
@WebServlet("/timetable/lecturechoice")
public class lecturechoice extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public lecturechoice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		String name = request.getParameter("name");
//		String time = request.getParameter("time");
//		System.out.println("강의명 : " + name + " 시간 : " +time);
//		String temp[] = time.split("_");
		
		try {
			JSONObject jsonObject = new JSONObject(request.getParameter("jsondata"));
			JSONArray array = new JSONArray();
			for (int i = 0; i < jsonObject.length()-1; i++) {
				array.put(jsonObject.get("time").toString().split("_"));
			}
			
			
			
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

//		System.out.println(Arrays.toString(temp));
//
//		Hashtable<String, String> temp3 = new Hashtable<String, String>();
//		for (int i = 0; i < temp.length; i++) {
//			temp3.put(temp[i].split("/")[0], temp[i].split("/")[1]);
//		}
//		
//		for(Map.Entry<String, String> e : temp3.entrySet()) {
//			System.out.println("Key : " + e.getKey() + ", Value : " + e.getValue());
//		}

		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
