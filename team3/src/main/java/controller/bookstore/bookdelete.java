package controller.bookstore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookstoreDao;
import dto.Textbook;

/**
 * Servlet implementation class delete
 */
@WebServlet("/bookstore/bookdelete")
public class bookdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int tno = Integer.parseInt(request.getParameter("tno"));
		
		Textbook textbook = BookstoreDao.getBookstoreDao().getBook(tno);
		String timg = textbook.getTimg();
		
		boolean result = BookstoreDao.getBookstoreDao().bookdelete(tno);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();//html로 내보내기 메소드
		// *java 에서 html 작성하기
		if (result) {
			//*삭제 성공시 해당 파일도 서버에서 지우기
			String uploadpath = request.getSession().getServletContext().getRealPath("/bookstore/bookimg"+timg);
//			String uploadpath = "C:\\Users\\504\\git\\jsp\\team3\\src\\main\\webapp\\bookstore\\bookimg"+timg;
			File file = new File(uploadpath);
			file.delete();

			out.println("<script>");
			out.println("alert('삭제 되었습니다.');");
			out.println("location.href='booklist.jsp';");
			out.println("</script>");
		}else {
			out.println("<script>");
			out.println("alert('삭제 실패[관리자에게 문의]');");
			out.println("history.back();");
			out.println("</script>");
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
