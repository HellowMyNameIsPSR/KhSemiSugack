package com.kh.semi.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.semi.member.model.vo.Address;
import com.kh.semi.member.model.vo.Member;
import static com.kh.semi.common.JDBCTemplate.*;

public class MemberDao {
	private Properties prop = new Properties();
	
	public MemberDao() {
		String fileName = MemberDao.class.getResource("/sql/member/member-query.properties").getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getMemberName());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getPassword());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public Member loginMember(Connection con, String email, String password) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("loginMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member();
				loginUser.setMemberId(rset.getInt("MEMBER_ID"));
				loginUser.setEmail(rset.getString("EMAIL"));
				loginUser.setPassword(rset.getString("PASSWORD"));
				loginUser.setMemberName(rset.getString("MEMBER_NAME"));
				loginUser.setPhone(rset.getString("PHONE"));
				loginUser.setGender(rset.getString("GENDER"));
				loginUser.setBirthDate(rset.getDate("BIRTH_DATE"));
				loginUser.setEnrollDate(rset.getDate("ENROLL_DATE"));
				loginUser.setMemberType(rset.getString("MEMBER_TYPE"));
				loginUser.setAuthorDate(rset.getDate("AUTHOR_DATE"));
				loginUser.setOutDate(rset.getDate("OUT_DATE"));
				loginUser.setModifyDate(rset.getDate("L_MODIFY_DATE"));
				loginUser.setStatus(rset.getString("STATUS"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public int updateMember(Connection con, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, m.getPassword());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getGender());
			pstmt.setDate(4, m.getBirthDate());
			pstmt.setInt(5, m.getMemberId());
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public int idCheck(Connection con, String email) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("idCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}

		return result;
	}
	
	public int passwordCheck(Connection con, String email, String password) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("passwordCheck");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int insertAddress(Connection con, Address add) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, add.getAddressName());
			pstmt.setString(2, add.getAddress());
			pstmt.setString(3, add.getPhone1());
			pstmt.setString(4, add.getPhone2());
			pstmt.setInt(5, add.getMemberId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public ArrayList<Address> addressList(Connection con, int memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Address add = null;
		ArrayList<Address> list = null;
		
		String query = prop.getProperty("addressList");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, memberId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Address>();
			while(rset.next()) {
				add = new Address();
				add.setAddressId(rset.getInt("ADDRESS_ID"));
				add.setAddressName(rset.getString("ADDRESS_NAME"));
				add.setAddress(rset.getString("ADDRESS"));
				add.setPhone1(rset.getString("PHONE1"));
				add.setPhone2(rset.getString("PHONE2"));
				add.setMemberId(rset.getInt("MEMBER_ID"));
				add.setAddType(rset.getString("ADD_TYPE"));
				
				list.add(add);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int deleteAddress(Connection con, int addressId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, addressId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	public Address selectAddress(Connection con, int addressId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Address add = null;
		
		String query = prop.getProperty("selectAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, addressId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				add = new Address();
				add.setAddressId(rset.getInt("ADDRESS_ID"));
				add.setAddressName(rset.getString("ADDRESS_NAME"));
				add.setAddress(rset.getString("ADDRESS"));
				add.setPhone1(rset.getString("PHONE1"));
				add.setPhone2(rset.getString("PHONE2"));
				add.setMemberId(rset.getInt("MEMBER_ID"));
				add.setAddType(rset.getString("ADD_TYPE"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return add;
	}

	public int updateAddress(Connection con, Address add) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateAddress");
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, add.getAddressName());
			pstmt.setString(2, add.getAddress());
			pstmt.setString(3, add.getPhone1());
			pstmt.setString(4, add.getPhone2());
			pstmt.setInt(5, add.getAddressId());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	

}






















