package Control;

import java.sql.connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ModelProduct.ProductModel;



public class ServicesControl {

    Statement state;


    public void update(String name,int number)
    {
        try {
            state = ConnectionDB.openConnection().createStatement();
            state.executeUpdate("UPDATE Products set  `number` = "+number +" where name = '"+name+"'");
            ConnectionDB.closeConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }
    }

    public ObservableList<String> getNamesProduct()
    {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT name FROM Products");



            while(result.next())
            {
                ProductModel pr = new ProductModel();
                product.add(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return product;
    }

    public ObservableList<String> getSearchNamesProduct(String name)
    {
        ObservableList<String> product =FXCollections.observableArrayList();
        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT name FROM Products WHERE name LIKE '%"+name+"%'");



            while(result.next())
            {
                product.add(result.getString(1));
                ConnectionDB.closeConnection();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductControl.class.getName()).log(Level.SEVERE, null, ex);
            ConnectionDB.closeConnection();
        }

        return product;
    }


    public ProductModel getProduct(String name)
    {
        ProductModel pr = new ProductModel();

        try {
            state = ConnectionDB.openConnection().createStatement();
            ResultSet result =  state.executeQuery("SELECT * FROM Products where name = '"+name+"'");



            while(result.next())
            {
                // if define object out while will store last row n time
                pr.setId(result.getInt(1));
                pr.setName(result.getString(2));
                pr.setNumber(result.getInt(3));
                pr.setPrice(result.getDouble(4));
                pr.setType(result.getString(5));
                pr.setDiscount(result.getInt(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServicesControl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return pr;
    }


}
