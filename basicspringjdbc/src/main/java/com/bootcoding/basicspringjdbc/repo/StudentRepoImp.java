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
            ResultSet rs=st.executeQuery("select * from students where id='"+id+"'");
            while(rs.next()){
               s.setId(rs.getInt(1));
               s.setName(rs.getString(2));
               s.setMail(rs.getString(3));
            }
        }

        catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return s;
    }


//    update students set name='namo',mail='namo@gmail.com' where id=1;
    @Override
    public Students updateStudent(Students s1) {
        Students s2=new Students();
        try {
            Class.forName("org.postgresql.Driver");
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "root");
            PreparedStatement pst = con.prepareStatement("update students set name='"+s1.getName()+"',email='"+s1.getMail()+"' where id='"+s1.getId()+"'");
            pst.executeUpdate();
            s2=selectStudent(s1.getId());

        } catch (Exception e) {
            e.printStackTrace();

        }
        return s2;
    }
}
