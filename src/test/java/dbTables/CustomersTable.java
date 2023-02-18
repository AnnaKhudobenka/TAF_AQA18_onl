package dbTables;

import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import services.DataBaseService;

import java.sql.ResultSet;

public class CustomersTable {
    private DataBaseService dbService;
    Logger logger = LogManager.getLogger(CustomersTable.class);

    public CustomersTable(DataBaseService dbService) {
        this.dbService = dbService;
    }

    public void createTable() {
        logger.info("Создаем customers таблицу");

        String createTableSQL = "" +
                "create table public.customers " +
                "(id SERIAL PRIMARY KEY," +
                "    firstname CHARACTER VARYING(30)," +
                "    lastname CHARACTER VARYING(30)," +
                "    email CHARACTER VARYING(30)," +
                "    age INTEGER" +
                ");";

        dbService.executeSQL(createTableSQL);
    }

    public void dropTable() {
        logger.info("Удаляем customers таблицу");

        String dropTableSQL = "DROP TABLE public.customers;";

        dbService.executeSQL(dropTableSQL);
    }

    public ResultSet getCustomer() {
        String sql = "SELECT * FROM public.customers;";
        return dbService.executeQuery(sql);
    }

    public ResultSet getCustomerById(int id) {
        String sql = "SELECT * FROM public.customers WHERE id = " + id + ";";

        return dbService.executeQuery(sql);
    }

    public void addCustomer(CustomerBuilder customer) {
        String insertTableSQL = "INSERT INTO public.Customers(" +
                "firstname, lastname, email, age)" +
                "VALUES ('" + customer.getFirstname() + "', '" + customer.getLastname() +
                "', '" + customer.getEmail() + "', " + customer.getAge() + ");";
        dbService.executeSQL(insertTableSQL);
    }

    public void updateCustomer(CustomerBuilder customer) {

    }

    public void deleteCustomer(int id) {

    }

}
