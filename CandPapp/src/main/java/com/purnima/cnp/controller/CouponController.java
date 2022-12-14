package com.purnima.cnp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.purnima.cnp.dao.CouponDAO;
import com.purnima.cnp.model.Coupon;

/**
 * Servlet implementation class CouponController
 */
@WebServlet("/coupons")
public class CouponController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouponDAO cdao = new CouponDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CouponController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("create")) {
			createCoupon(request, response);
		} else if (action.equals("find")) {
			findCoupon(request, response);
		}
	}

	private void createCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String code = request.getParameter("couponCode");
		String discount = request.getParameter("discount");
		String expDate = request.getParameter("expiryDate");

		Coupon c = new Coupon();
		c.setCode(code);
		c.setDiscount(new BigDecimal(discount));
		c.setExp_date(expDate);

		cdao.save(c);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<b>Coupon Created!</b>");
		out.print("<br><a href='/CandPapp'>Home</a></br>");
	}

	private void findCoupon(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = cdao.findByCode(couponCode);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(coupon);
		out.print("<br><a href='/CandPapp'>Home</a></br>");
	}

}
