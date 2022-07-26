package controller.bookstore;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookstoreDao;

/**
 * Servlet implementation class bimgdelete
 */
@WebServlet("/bookstore/bimgdelete")
public class bimgdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bimgdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
		String timg = BookstoreDao.getBookstoreDao().getBook(tno).getTimg();
		boolean result = BookstoreDao.getBookstoreDao().bimgdelete(tno);
		if(result) {
			String uploadpath = request.getSession().getServletContext().getRealPath("/bookstore/bookimg"+timg);
//			String uploadpath = "/team3/bookstore/bookimg"+timg;
			File file = new File(uploadpath);
			file.delete();
			response.getWriter().print("1");
		}else {
			response.getWriter().print("2");
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
