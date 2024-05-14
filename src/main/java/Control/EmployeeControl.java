package Control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ModelEmployee.EmployeeModel;


public class EmployeeControl {

    Statement state ;

    public void insert(EmployeeModel  emp) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            state = connection.createStatement();
            state.executeUpdate("INSERT INTO `employees` (`emp_Name`, `emp_Salary`, `join_Year`, `emp_Rank`, `city`, `street`) VALUES ('" + emp.getEmp_Name() + "', " + emp.getEmp_Salary() + ",'" + emp.getJoin_Year() + "','" + emp.getRank() + "' ,'" + emp.getCity() + "','" + emp.getStreet() + "')");
            ConnectionDB.closeConnection(connection);
        } catch (SQLException ex) {
            ConnectionDB.closeConnection(connection);
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int id) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            state = connection.createStatement();
            state.executeUpdate("DELETE FROM `employees` WHERE emp_ID = " + id);
            ConnectionDB.closeConnection(connection);
        } catch (SQLException ex) {
            ConnectionDB.closeConnection(connection);
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void update(EmployeeModel emp) {
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            state = connection.createStatement();
            state.executeUpdate("UPDATE employees SET `emp_Name` = '" + emp.getEmp_Name() + "', `emp_Salary` = " + emp.getEmp_Salary() + ", `join_Year` = '" + emp.getJoin_Year() + "', `emp_Rank` = '" + emp.getRank() + "', `city` = '" + emp.getCity() + "', `street` = '" + emp.getStreet() + "' WHERE emp_ID = " + emp.getEmp_ID());
            ConnectionDB.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection(connection);
        }
    }


    public ObservableList<EmployeeModel> getAllEmployee() {
        ObservableList<EmployeeModel> employee = FXCollections.observableArrayList();
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            state = connection.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM employees");

            while (result.next()) {
                EmployeeModel emp = new EmployeeModel();
                emp.setEmp_ID(result.getInt(1));
                emp.setEmp_Name(result.getString(2));
                emp.setEmp_Salary(result.getDouble(3));
                emp.setJoin_Year(result.getDate(4));
                emp.setRank(result.getString(5));
                emp.setCity(result.getString(6));
                emp.setStreet(result.getString(7));
                employee.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return employee;
    }


    public ObservableList<EmployeeModel> getSearchEmployee(String name) {
        ObservableList<EmployeeModel> employee = FXCollections.observableArrayList();
        Connection connection = null;
        try {
            connection = ConnectionDB.openConnection();
            state = connection.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM employees WHERE emp_Name LIKE '%" + name + "%'");

            while (result.next()) {
                EmployeeModel emp = new EmployeeModel();
                emp.setEmp_ID(result.getInt(1));
                emp.setEmp_Name(result.getString(2));
                emp.setEmp_Salary(result.getDouble(3));
                emp.setJoin_Year(result.getDate(4));
                emp.setRank(result.getString(5));
                emp.setCity(result.getString(6));
                emp.setStreet(result.getString(7));
                employee.add(emp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionDB.closeConnection(connection);
        }

        return employee;
    }




}
