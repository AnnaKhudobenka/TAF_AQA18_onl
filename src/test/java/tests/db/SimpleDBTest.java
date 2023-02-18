package tests.db;

import baseEntities.BaseApiTest;
import dbServices.CustomerService;
import dbTables.CustomersTable;
import models.Customer;
import models.CustomerBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import services.DataBaseService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SimpleDBTest extends BaseApiTest {

    Logger logger = LogManager.getLogger(DataBaseService.class);

    @Test
    public void simpleBDTest() {
        String sql = "SELECT * FROM public.customers;";

        ResultSet rs = dbService.executeQuery(sql);

        try {
            while (rs.next()) {
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID: " + userID);
                logger.info("Firstname: " + firstname);
                logger.info("Lastname: " + lastname);
                logger.info("Email: " + email);
                logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void advancedDBTest() throws SQLException {
        CustomersTable customersTable = new CustomersTable(dbService);

        customersTable.dropTable();
        customersTable.createTable();

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Anna")
                .lastname("Khudobenka")
                .email("test@test1.com")
                .age(44)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Alex")
                .lastname("Khudobenka")
                .email("test@test2.com")
                .age(28)
                .build());

        customersTable.addCustomer(CustomerBuilder.builder()
                .firstname("Olya")
                .lastname("Bu")
                .email("test@test3.com")
                .age(21)
                .build());

        ResultSet rs = customersTable.getCustomer();

        try {
            while (rs.next()) {
                int userID = rs.getInt("id");
                String firstname = rs.getString("firstname");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int age = rs.getInt(5);

                logger.info("ID: " + userID);
                logger.info("Firstname: " + firstname);
                logger.info("Lastname: " + lastname);
                logger.info("Email: " + email);
                logger.info("Age: " + age);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        rs = customersTable.getCustomerById(2);
        rs.next();

        logger.info("ID: " + rs.getString("id"));
        logger.info("FirstName: " + rs.getString("firstname"));
        logger.info("LastName: " + rs.getString("lastname"));
        logger.info("Email: " + rs.getString("email"));
        logger.info("Age: " + rs.getString("age"));
    }

    @Test
    public void hibernateTest() {
        CustomerService customerService = new CustomerService();
        Customer customer = new Customer("Ivan", "Grigoriev",
                "grtest@test.com", 30);

        customerService.saveUser(customer);

        List<Customer> customerList = customerService.findAllUsers();
        for (Customer user : customerList) {
            System.out.println(user.toString());
        }
    }
}
