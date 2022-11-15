package com.repository;

import com.domain.Department;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository {
    private DataSource dataSource;

    public static final String ALL="select id,Department_Name from department";
    private static final String SELECT_ONE = "select id,Department_Name from department where id = ?";
    public static final String CREATE="insert into department (Department_Name) values (?)";
    public static final String UPDATE="update department set Department_Name = ? where id= ?";
    public static final String DELETE="delete from department where id=?";

    public DepartmentRepository(DataSource dataSource){
        this.dataSource=dataSource;
    }
    public boolean create(Department department)throws SQLException{
        Connection connection=dataSource.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(CREATE);
        preparedStatement.setString(1,department.getName());
        return preparedStatement.execute();
    }
    public boolean delete(int id)throws SQLException{
        Connection connection=dataSource.getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement(DELETE);
        preparedStatement.setInt(1,id);
        return preparedStatement.execute();
    }
    public boolean update(Department department) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);

        preparedStatement.setString(1,department.getName());
        preparedStatement.setInt(2, department.getId());
        return preparedStatement.execute();
    }
    //Fetch
    public List<Department> list() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(ALL);
        return mapper(resultSet);
    }
    private List<Department> mapper(ResultSet resultSet) throws SQLException {
        List<Department> departments = new ArrayList<>();
        while(resultSet.next()) {
            Department department = new Department();
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
            departments.add(department);
        }
        return departments;
    }

    public Department get(int id) throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ONE);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Department department = new Department();
        while (resultSet.next()) {
            department.setId(resultSet.getInt(1));
            department.setName(resultSet.getString(2));
        }
        return department;
    }
}
