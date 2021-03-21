package com.rk.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rk.dto.CountryClubDTO;
import com.rk.service.CountryClubService;
import com.rk.vo.CountryClubVO;



public  class CountryClubController extends HttpServlet{
	
	public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
	    String name=req.getParameter("name");
		String addr=req.getParameter("addr");
		String country=req.getParameter("country");
		String amount=req.getParameter("hpddl");
		//out.println(name+"\n"+addr+"\n"+country+"\n"+packagePrice);
		
		//create VO class object having form data
		CountryClubVO vo=new CountryClubVO();
				vo.setName(name);
				vo.setAddr(addr);
				vo.setCountry(country);
				vo.setHpddl(amount);
				
				//convert Vo class object to DTO class object
				CountryClubDTO dto=new CountryClubDTO();
				dto.setName(vo.getName());
				dto.setAddr(vo.getAddr());
				dto.setCountry(vo.getCountry());
				dto.setHpddl(Integer.parseInt(vo.getHpddl()));
				
				//use service class
				CountryClubService service=new CountryClubService();
				String result=service.Calculate(dto);
				
				
				//dispaly result
				out.println("<h2>Result "+result+"</h2>");
				res.sendRedirect("success.html");
				//add hyperlink for home page
				out.println("<a href='register.html'>Home</a>");
				
				//close
				out.close();
				
		
		
		
	}

}
