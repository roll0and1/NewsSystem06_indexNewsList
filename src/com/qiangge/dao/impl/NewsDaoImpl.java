package com.qiangge.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.qiangge.dao.NewsDao;
import com.qiangge.model.News;
import com.qiangge.utils.AppException;
import com.qiangge.utils.DBUtil;

public class NewsDaoImpl implements NewsDao {
	@Override
	public boolean add(News news) throws AppException {
		// 操作标志
		boolean flag = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		conn = DBUtil.getConnection(); // 创建数据库连接
		// 声明操作语句：将用户信息保存到数据库中， “？”为占位符
		String sql = "insert into t_news(user_id,newsType_id,title,author,keywords,source,content,createTime,click,state,del) values (?,?,?,?,?,?,?,?,?,?,?);";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, news.getUserId());
			psmt.setInt(2, news.getNewsTypeId());
			psmt.setString(3, news.getTitle());
			psmt.setString(4, news.getAuthor());
			psmt.setString(5, news.getKeywords());
			psmt.setString(6, news.getSource());
			psmt.setString(7, news.getContent());
			psmt.setString(8, news.getCreateTime());
			psmt.setInt(9, news.getClick());
			psmt.setInt(10, news.getState());
			psmt.setInt(11, news.getDel());
			psmt.executeUpdate();
			flag = true;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new AppException("com.qiangge.dao.impl.NewsImpl.add");
		} finally {
			DBUtil.closeStatement(psmt);
			DBUtil.closeConnection(conn);
		}

		return flag;
	}

}
