package com.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.project.model.User;
import com.project.util.DBConnection;
import java.sql.ResultSet;
public class UserDAO {

    private Connection con;

    public UserDAO() {
        con = DBConnection.getConnection();
    }

    public boolean registerUser(User user) {

        boolean status = false;

        try {

            String sql =
                    "INSERT INTO users(name,email,password,department,role) VALUES(?,?,?,?,?)";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getDepartment());
            ps.setString(5, user.getRole());

            int rows = ps.executeUpdate();

            if(rows > 0) {
                status = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }
    public User loginUser(String email,String password) {

        User user = null;

        try {

            String sql =
                    "SELECT * FROM users WHERE email=? AND password=?";

            PreparedStatement ps =
                    con.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,password);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                user = new User();

                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setDepartment(rs.getString("department"));
                user.setRole(rs.getString("role"));
            }

        } catch(Exception e) {

            e.printStackTrace();
        }

        return user;
    }
}