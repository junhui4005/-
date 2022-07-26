package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDao;
import dao.MemberDao;
import dto.Board;



/**
 * Servlet implementation class boardwrite
 */
@WebServlet("/board/boardwrite")
public class boardwrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public boardwrite() {
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
		System.out.println("통신");
		// 서버 경로 찾기 : request.getSession().getServletContext().getRealPath( 경로 ) ;
		System.out.println("서버의 경로찾기 : " +request.getServletContext().getRealPath("/upload"));
		
		String uploadpath =request.getServletContext().getRealPath("/board/upload");
		// 첨부파일 업로드
		MultipartRequest multi = new MultipartRequest(
				request,  // 1.요청방식
				uploadpath, // 2.파일 저장 경로
				1024*1024*10, // 3.파일최대 용량 허용 범위 [10mb]
				"UTF-8", // 4.인코딩타입
				new DefaultFileRenamePolicy()); // 4.보안방식 : 동일한 파일명이 있을경우 자동 이름 변환
		HttpSession session = request.getSession();
		String mid = (String)session.getAttribute("login");
		
		int mno = BoardDao.getBoardDao().getmno(mid);
		request.setCharacterEncoding("UTF-8");
		String btitle = multi.getParameter("btitle");
		String bcontent = multi.getParameter("bcontent");
		bcontent = bcontent.replace("\r\n", "<br>");
		String bimg = multi.getFilesystemName("bimg");
		String radio = multi.getParameter("anonymous");
		//System.out.println(radio.toString());
		
		
		
		
		
		if(radio.equals("익명")) { // 라디오버튼 익명이면
			Board board = new Board(0, btitle, bcontent, mno, bimg, 0, 0, "익명", null);
			boolean result = BoardDao.getBoardDao().boardwrite(board);
			if(result) {
				System.out.println("익명넣기성공");
				response.sendRedirect("/team3/board/boardlist.jsp?key=&keyword=");
			} else { // 디비처리 실패시 행동
				response.sendRedirect("/team3/board/boardwrite.jsp");
			}
		} else { // 라디오버튼 익명이아니면
			Board board = new Board(0, btitle, bcontent, mno, bimg, 0, 0, mid, null);
			boolean result = BoardDao.getBoardDao().boardwrite(board);
			if(result) {
				System.out.println("mid넣을거");
				response.sendRedirect("/team3/board/boardlist.jsp");
			} else { // 디비처리 실패시 행동
				response.sendRedirect("/team3/board/boardwrite.jsp");
			}
		}
		
//		HttpSession session = request.getSession();
//		String mid = (String)session.getAttribute("login");
//		int mno = MemberDao.getmemberDao().getmno(mid);
		
	}

}
