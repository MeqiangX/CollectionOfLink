package com.defin.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.defin.bean.Bean;
import com.defin.dao.CollecDao;
import com.defin.util.DButil;

public class CollecDaoImpl implements CollecDao{

	@Override
	public void save(Bean bean) {
		DButil db = new DButil();
		Connection ct = db.openConnection();
		
		String sql = "insert into collection (name,url) value(?,?)";
		
		try {
			PreparedStatement pstm = ct.prepareStatement(sql);
			pstm.setString(1, bean.getName());
			pstm.setString(2, bean.getUrl());
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.CloseCon(ct);
		}
		
		
	}

	@Override
	public void delete(String[] s) {
		DButil db = new DButil();
		Connection ct = db.openConnection();
		
		String sql = "delete from collection where id=?";
		
		try {
			PreparedStatement psmt ;
			if (s != null && s.length > 0) {
				for (int i = 0; i < s.length;i++) {
					psmt = ct.prepareStatement(sql);
					psmt.setInt(1, (new Integer(s[i])).intValue());
					psmt.executeUpdate();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.CloseCon(ct);
		}
		
	}

	@Override
	public void update(Bean bean) {
		DButil db = new DButil();
		Connection ct = db.openConnection();
		
		String sql = "update collection set name=?,url=? where id=?";
		
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setString(1, bean.getName());
			psmt.setString(2, bean.getUrl());
			psmt.setInt(3, bean.getId());
			
			psmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.CloseCon(ct);
		}
		
	}

	@Override
	public List list() {
		DButil db = new DButil();
		Connection ct = db.openConnection();
		
		String sql = "select * from collection";
		List list = new ArrayList();
		try {
			Statement st = ct.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Bean bean = new Bean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setUrl(rs.getString("url"));
				
				list.add(bean);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.CloseCon(ct);
		}
		
		return null;
	}

	@Override
	public Bean getfromid(int id) {
		DButil db = new DButil();
		Connection ct = db.openConnection();
		
		String sql = "select * from collection where id=?";
		try {
			PreparedStatement psmt = ct.prepareStatement(sql);
			psmt.setInt(1, id);
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				Bean bean = new Bean();
				bean.setId(rs.getInt("id"));
				bean.setName(rs.getString("name"));
				bean.setUrl(rs.getString("url"));
				return bean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
