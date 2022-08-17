package com.purnima.cnp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.purnima.cnp.model.Product;
import com.purnima.cnp.util.ConnectionUtil;

public class ProductDAO {

	public void save(Product p) {
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into product (name,description,price) values(?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescription());
			ps.setBigDecimal(3, p.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
