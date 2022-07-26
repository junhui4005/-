package controller.bookstore;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BookstoreDao;
import dao.MemberDao;
import dto.Textbook;

/**
 * Servlet implementation class bookadd
 */
@WebServlet("/bookstore/bookadd")
public class bookadd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookadd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uploadpath = request.getSession().getServletContext().getRealPath("/bookstore/bookimg");
//		String uploadpath = "C:\\Users\\504\\git\\jsp\\team3\\src\\main\\webapp\\bookstore\\bookimg";
		
		MultipartRequest multi = new MultipartRequest(
				request, // 요청방식
				uploadpath,	//파일저장경로
				1024*1024*10 , //파일 최대 용량 허용 범위
				"UTF-8",	//인코딩 타입
				new DefaultFileRenamePolicy() //동일한 파일명이 있을 경우 자동 이름 변환
				);
		
		request.setCharacterEncoding("UTF-8");
		String ttitle = multi.getParameter("ttitle");
		String timg = multi.getFilesystemName("timg");
		String tcontent = multi.getParameter("tcontent");
			String price = multi.getParameter("tprice");
		int tprice = Integer.parseInt(price.replaceAll("[^0-9]",""));
		int tcondition = Integer.parseInt(multi.getParameter("tcondition"));
			HttpSession session = request.getSession();
			String mid = (String)session.getAttribute("login");
		String tauthor = multi.getParameter("tauthor");
		String tcompany = multi.getParameter("tcompany");
		String tyear = multi.getParameter("tyear");
		String tclass = multi.getParameter("tclass");
		int mno = MemberDao.getMemberDao().getmno(mid);
		
		Textbook textbook = new Textbook(0 , timg, ttitle, tcontent, tprice, tcondition, tauthor, tcompany, tyear, tclass, mno);
		
		boolean result = BookstoreDao.getBookstoreDao().bookadd(textbook);
		
		if( result ) { 
			response.sendRedirect("/team3/bookstore/booklist.jsp");
		}else { 
			System.out.println("오류");
		}
	}

}
