package controller.bookstore;

import java.io.File;
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
 * Servlet implementation class bookupdate
 */
@WebServlet("/bookstore/bookupdate")
public class bookupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int tno = Integer.parseInt(request.getParameter("tno"));
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
			//기존파일 가져오기
			Textbook temp = BookstoreDao.getBookstoreDao().getBook(tno);
			String oldimg = temp.getTimg();
			
			if (timg == null) {
				timg = oldimg;
			}else {
//				String upload = "/team3/bookstore/bookimg"+oldimg;
				String upload = request.getSession().getServletContext().getRealPath("/bookstore/bookimg"+oldimg);
				File file = new File(upload);
				file.delete();
			}
		
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
		
		Textbook textbook = new Textbook(tno , timg, ttitle, tcontent, tprice, tcondition, tauthor, tcompany, tyear, tclass, mno);
		System.out.println(textbook.toString());
		boolean result = BookstoreDao.getBookstoreDao().bookupdate(textbook);
		
		if( result ) { 
			response.sendRedirect("/team3/bookstore/booklist.jsp");
		}else { 
			System.out.println("오류");
		}
	}
	

}
