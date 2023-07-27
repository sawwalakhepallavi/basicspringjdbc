package com.bootcoding.basicspringjdbc.repo;


import com.bootcoding.basicspringjdbc.model.Students;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class StudentRepoImp implements StudentRepo {
    @Override
    public void insertStudent(Students s1) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement pst = con.prepareStatement("insert into students values('" + s1.getId() + "','" + s1.getName() + "','" + s1.getMail() + "')");
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    @Override
    public Students selectStudent(int id ) {
        Students s=new Students();
        try{
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            Statement st=con.createStatement();
            ResultSet rs=st.executeQuery("select * from students");
            while(rs.next()){
               s.setId(rs.getInt(1));
               s.setName(rs.getString(2));
               s.setMail(rs.getString(3));
            }
        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return s;
    }
}
