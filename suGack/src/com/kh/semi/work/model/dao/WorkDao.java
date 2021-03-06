package com.kh.semi.work.model.dao;

import static com.kh.semi.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.work.model.vo.PageInfo;
import com.kh.semi.work.model.vo.PicFile;
import com.kh.semi.work.model.vo.Work;
import com.kh.semi.work.model.vo.WorkPic;

public class WorkDao {
	private Properties prop = new Properties();
	
	public WorkDao() {
		String fileName = 
				WorkDao.class
				.getResource("/sql/work/work-query.properties")
				.getPath();
		
			try {
				prop.load(new FileReader(fileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
				
	}
	
	//작품 판매 등록 메소드
	public int insertSale(Connection con, Work work) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertSale");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, work.getworkName());
			pstmt.setString(2, work.getWorkContent());
			pstmt.setInt(3, work.getDeliPrice());
			pstmt.setInt(4, work.getPrice());
			pstmt.setInt(5, work.getCid());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	//판매작품관리 리스트 보기용 메소드
	public ArrayList<Work> selectSalesList(Connection con, PageInfo pi) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Work> list = null;
		
		String query = prop.getProperty("selectSalesList");
		
		int startRow = (pi.getCurrentPage() - 1) * pi.getLimit() + 1;
		int endRow = startRow + pi.getLimit() - 1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, endRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Work>();
			
			while(rset.next()){
				Work work = new Work();
				
				work.setWorkId(rset.getInt("WORK_ID"));
				work.setworkName(rset.getString("WORK_NAME"));
				work.setPrice(rset.getInt("PRICE"));
				work.setWrDate(rset.getDate("WR_DATE"));

				list.add(work);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListCount(Connection con) {
		Statement stmt = null;
		int listCount = 0;
		ResultSet rset = null;
		
		String query = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(stmt);
			close(rset);
		}
		
		
		return listCount;
	}

	public int insertPicFile(Connection con, ArrayList<WorkPic> workPic) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPicFile");
		
		try {
			for(int i = 0; i < workPic.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, workPic.get(i).getoriginName());
				pstmt.setString(2, workPic.get(i).getchangeName());
				pstmt.setString(3, workPic.get(i).getfilePath());
				int type = 0;
				if(i == 0) type = 0;
				else type = 1;
				pstmt.setInt(4, type);
				
				result += pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int insertContentsImage(Connection con, ArrayList<PicFile> picFile) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertPicFile");
		
		try {
			for(int i = 0; i < picFile.size(); i++) {
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, picFile.get(i).getOriginName());
				pstmt.setString(2, picFile.get(i).getChangeName());
				pstmt.setString(3, picFile.get(i).getFilePath());
				pstmt.setInt(4, picFile.get(i).getBno());
				
				result += pstmt.executeUpdate();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		System.out.println("이미지 dao : " +result);
		return result;
	}

	public int selectCurrval(Connection con) {
		Statement stmt = null;
		ResultSet rset = null;
		int workId = 0;
		
		String query = prop.getProperty("selectCurrval");
		
		try {
			stmt = con.createStatement();
			rset = stmt.executeQuery(query);
			
			if(rset.next()) {
				workId = rset.getInt("currval");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		
		
		return workId;
	}
	



}




























