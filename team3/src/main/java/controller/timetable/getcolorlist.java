package controller.timetable;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Servlet implementation class getcolorlist
 */
@WebServlet("/timetable/getcolorlist")
public class getcolorlist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getcolorlist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("UTF-8");
		String[] font = {"#009688", "#795548", "#03A9F4", "#673AB7", "#E91E64", "#4CAF50", "#FF9800", "#0078FF", "#5F7F90", "#FF5722"};
		String[] background = {"#E0F2F1", "#EFEBE9", "#E1F5FE", "#EDE7F6", "#FCE4EC", "#E8F5E9", "#FFF3E0", "#EEEBFF", "#E9ECF3", "#FBE9E7"};
		String[] hover = {"#B2DFDB", "#D7CCC8", "#B3E5CE", "#D1C4E9", "#F8BBD0", "#C8E6C9", "#FFE0B2", "#BBCAFB", "#CDD7E0", "#FFCCBC"};
		
		JSONObject jsonObject = new JSONObject();
		JSONArray font_array = new JSONArray();
		JSONArray background_array = new JSONArray();
		JSONArray hover_array = new JSONArray();
		
		try {
			for(int i = 0; i < 10; i++) {
				
				font_array.put(font[i]);
				background_array.put(background[i]);
				hover_array.put(hover[i]);
			}
			jsonObject.put("font", font_array);
			jsonObject.put("background", background_array);
			jsonObject.put("hover", hover_array);
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			response.getWriter().print(jsonObject.toString());
			
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
