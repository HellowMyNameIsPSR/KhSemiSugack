package com.kh.semi.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.semi.board.model.service.ProQnaService;
import com.kh.semi.board.model.vo.ProQnaComment;
import com.kh.semi.member.model.vo.Member;

/**
 * Servlet implementation class InsertProQnaCommentServlet
 */
@WebServlet("/insertProQnaComment.bo")
public class InsertProQnaCommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProQnaCommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String content = request.getParameter("content");
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		Member m = (Member)request.getSession().getAttribute("loginUser");
		
		ProQnaComment comment = new ProQnaComment();
		comment.setBno(bno);
		comment.setContent(content);
		comment.setWriterId(m.getMemberId());
		
		System.out.println(comment);
		int result = new ProQnaService().insertComment(comment);
		
		if(result>0) {
			response.getWriter().print(comment);
		}else {
			response.getWriter().print("fail");
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
