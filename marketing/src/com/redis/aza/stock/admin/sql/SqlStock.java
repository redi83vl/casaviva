/*
 * Copyright (C) 2017 Redjan Shabani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in th hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.redis.aza.stock.admin.sql;

import com.redis.aza.stock.admin.core.Catalog;
import com.redis.aza.stock.admin.core.State;
import com.redis.aza.stock.admin.core.Stock;
import com.redis.aza.stock.admin.core.Subject;
import com.redis.aza.stock.admin.core.Warehouse;
import com.redis.aza.stock.admin.sql.state.SqlState;
import com.redis.aza.stock.admin.utils.Dataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Redjan Shabani
 */
public class SqlStock implements Stock{
	
	public static Stock getStock() {
		return SQL.getStock();
	}
	
	@Override
	public Dataset<String, Subject> suppliers() {
		return new SupplierSQL();
	}

	@Override
	public Dataset<String, Subject> customer() {
		return new CustomerSQL();
	}

	@Override
	public Dataset<String, ? extends Warehouse> warehouses() {
		return new WarehouseSQL();
	}

	@Override
	public Catalog getCatalog() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public State getState() {
		return SqlState.getState();
	}

	@Override
	public State getState(Warehouse warehouse) {
		return warehouse == null ? this.getState() : SqlState.getState(warehouse.getCode());
	}
	
	
	
	public static Stock.Item select(Connection cn, String code) {
		
		Stock.Item item = null;
		
		
		try(PreparedStatement ps = cn.prepareStatement(""
				+ "SELECT TOP 1 [code], [barcode], [description], [unit], [M01], [M02] FROM [StockItem] WHERE [code] = ? ")){
			
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Stock.Item(
					rs.getString("code"), 
					rs.getString("barcode"),
					rs.getString("description"), 
					rs.getString("unit")
				);
				
				item.put("M01", rs.getFloat("M01"));
				item.put("M02", rs.getFloat("M02"));
			}
		} 
		catch (SQLException ex) { 
			Logger.getLogger(SqlStock.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return item;
	}
	
	
	public static Stock.Item select(String code) {
		
		Stock.Item item = null;
		
		
		try(Connection cn = SQL.getConnection()) {
			PreparedStatement ps;
			ps = cn.prepareStatement(""
				+ "SELECT TOP 1 [code], [barcode], [description], [unit], [M01], [M02] FROM [StockItem] WHERE [code] = ? ");	
			ps.setString(1, code);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				item = new Stock.Item(
					rs.getString("code"), 
					rs.getString("barcode"),
					rs.getString("description"), 
					rs.getString("unit")
				);
				
				item.put("M01", rs.getFloat("M01"));
				item.put("M02", rs.getFloat("M02"));
			}
		}
		catch (SQLException ex) { 
			Logger.getLogger(SqlStock.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return item;
	}
	
	public static boolean forEach(Consumer<Stock.Item> consumer){
		boolean success = false;
		
		try(Connection cn = SQL.getConnection()) {
			PreparedStatement ps;
			ps = cn.prepareStatement(""
				+ "SELECT [code], [barcode], [description], [unit], [M01], [M02] "
				+ "FROM [StockItem] "
				+ "ORDER BY [code] ASC");	
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Stock.Item item = new Stock.Item(
					rs.getString("code"), 
					rs.getString("barcode"),
					rs.getString("description"), 
					rs.getString("unit")
				);
				
				item.setQuantity("M01", rs.getFloat("M01"));
				item.setQuantity("M02", rs.getFloat("M02"));
				
				consumer.accept(item);
			}
			
			success = true;
		} 
		catch (SQLException ex) { 
			Logger.getLogger(SqlStock.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return success;
	}

	

	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
