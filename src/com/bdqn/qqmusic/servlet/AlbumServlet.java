package com.bdqn.qqmusic.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bdqn.qqmusic.pojo.Record;
import com.bdqn.qqmusic.pojo.Song;
import com.bdqn.qqmusic.service.RecordService;
import com.bdqn.qqmusic.service.SongService;

public class AlbumServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		PrintWriter out = response.getWriter();
		
	
		
		RecordService recordService=new RecordService();
		List<Record> mod_playlist=new ArrayList<Record>();
		mod_playlist=recordService.getAllRecord();
		System.out.println("hah");
		for (Record record : mod_playlist) {
			System.out.println(record.getRname()+" "+record.getRdate());
		}
		request.getSession().setAttribute("all", mod_playlist);
		response.sendRedirect("../qqmusic/albumContext.jsp");//重定向 2次转发
		out.flush();//输出来
		out.close();//关闭
		
		
//		
//		//陆嘉豪写的作用域--这个是取歌曲名字
//		   SongService songService=new SongService();
//		   List<Song> albumContext=new ArrayList<Song>();
//		  
//		   
//		   albumContext=songService.getAllSongs();
//		   System.out.println("嘻嘻");
//		   for(Song song:albumContext){
//			   System.out.println(song.getSname()+song.getArtist());			   
//		   }
//		   request.getSession().setAttribute("name",albumContext);
//		   response.sendRedirect("../qqmusic/albumContext.jsp");
//		   out.flush();
//		   out.close();
		
	}

	
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}

}
