package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDAOimpl implements StudentDAO {

	public StudentDAOimpl() {
	}

	@Override
	public int add(Student student) {
		int i = 0;
		String sql = "INSERT INTO STUDENT VALUES(?,?,?,?)";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getMarks());

			java.util.Date utilDate = student.getDob();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			ps.setDate(4, sqlDate);

			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAOimpl add " + e);
		}
		return i;
	}

	@Override
	public int delete(int id) {
		int i = 0;
		String sql = "DELETE FROM STUDENT WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAOimpl delete " + e);
		}
		return i;
	}

	@Override
	public int update(Student student) {
		int i = 0;
		String sql = "UPDATE STUDENT SET name=?,marks=?,dob=? WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, student.getName());
			ps.setDouble(2, student.getMarks());
			java.util.Date utilDate = student.getDob();
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
			ps.setDate(3, sqlDate);
			ps.setInt(4, student.getId());
			i = ps.executeUpdate();
		} catch (Exception e) {
			System.out.println("StudentDAOimpl update " + e);
		}
		return i;
	}

	@Override
	public Student getbyid(int id) {
		String sql = "SELECT * FROM STUDENT WHERE id=?";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
				return student;
			}
		} catch (Exception e) {
			System.out.println("StudentDAOimpl getbyid " + e);
		}
		return null;
	}

	@Override
	public List<Student> getall() {
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("StudentDAOimpl getall " + e);
		}
		return list;
	}

	public List<Student> sortByName() {
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT ORDER BY name ASC";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("StudentDAOimpl sortByName " + e);
		}
		return list;
	}

	@Override
	public List<Student> sortById() {
		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT ORDER BY id ASC";
		try (Connection con = DBUtility.getDBConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
				list.add(student);
			}
		} catch (Exception e) {
			System.out.println("StudentDAOimpl sortById " + e);
		}
		return list;
	}

	@Override
	public List<Student> sortByMarks() {
		List<Student> list=new ArrayList<Student>();
		String sql="SELECT * FROM STUDENT ORDER BY marks ASC";
		try(Connection con=DBUtility.getDBConnection(); PreparedStatement ps=con.prepareStatement(sql))
		{
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Student student=new Student(rs.getInt(1), rs.getString(2), rs.getDouble(3), rs.getDate(4));
				list.add(student);
			}
		}
		catch(Exception e) {
			System.out.println("StudentDAOimpl sortByMarks "+e);
		}
		return list;
	}
}
