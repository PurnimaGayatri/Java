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
import com.purnima.cnp.dao.ProductDAO;
import com.purnima.cnp.model.Coupon;
import com.purnima.cnp.model.Product;

/**
 * Servlet implementation class ProductController
 */
@WebServlet("/products")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CouponDAO c = new CouponDAO();
	ProductDAO p = new ProductDAO();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String couponCode = request.getParameter("couponCode");
		Coupon coupon = c.findByCode(couponCode);
		String price = request.getParameter("price");

		Product pro = new Product();
		pro.setName(name);
		pro.setDescription(description);
		pro.setPrice(new BigDecimal(price).subtract(coupon.getDiscount()));

		p.save(pro);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("</h2>Product Created!!</h1>");
		out.print("<br><a href='/CandPapp'>Home</a></br>");

	}

}
