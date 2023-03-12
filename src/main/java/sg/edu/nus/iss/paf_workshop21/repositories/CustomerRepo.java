package sg.edu.nus.iss.paf_workshop21.repositories;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.node.ArrayNode;

import sg.edu.nus.iss.paf_workshop21.models.Customer;
import sg.edu.nus.iss.paf_workshop21.models.Order;

@Repository
public class CustomerRepo {
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private final String findAllSQL = "select * from customers limit ? offset ?";
    private final String findByIdSQL = "select * from customers where id = ?";
    private final String findOrdersByIdSQL = "select * from orders where customer_id = ?";

    public List<Customer> getAllCustomers(int limit, int offset){

        // // =======  Alternative Approach 1 ===============
        // List<Customer> custList=new ArrayList<>();
        // custList = jdbcTemplate.query(findAllSQL,BeanPropertyRowMapper.newInstance(Customer.class),limit,offset);
        // return Collections.unmodifiableList(custList);
        
        // =======  Alternative Approach 2 ===============
        final List<Customer> custList = new ArrayList<>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findAllSQL, limit, offset);

        while(rs.next()){
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setCompany(rs.getString("company"));
            customer.setLastName(rs.getString("last_name"));
            customer.setFirstName(rs.getString("first_name"));
            customer.setEmailAddress(rs.getString("email_address"));
            customer.setJobTitle(rs.getString("job_title"));
            customer.setBusinessPhone(rs.getString("business_phone"));
            customer.setHomePhone(rs.getString("home_phone"));
            customer.setMobilePhone(rs.getString("mobile_phone"));
            customer.setFaxNumber(rs.getString("fax_number"));
            customer.setAddress(rs.getString("address"));
            customer.setCity(rs.getString("city"));
            customer.setStateProvince(rs.getString("state_province"));
            customer.setZipPostalCode(rs.getString("zip_postal_code"));
            customer.setCountryRegion(rs.getString("country_region"));
            customer.setWebPage(rs.getString("web_page"));
            customer.setNotes(rs.getString("notes"));

            // // check data type of Blob 
            // Object att = rs.getObject("attachments");
            // System.out.println(" attachment is type: " + att.getClass().getSimpleName());  // output: byte[]

            customer.setAttachments((byte[])rs.getObject("attachments"));
            // System.out.println(Arrays.toString((byte[])rs.getObject("attachments"))); // debug
            custList.add(customer);
        }

        return Collections.unmodifiableList(custList);
    }

    public Optional<Customer> getCustomerById(int id){
        
        Customer customer = null;
        
        try{

            customer = jdbcTemplate.queryForObject(findByIdSQL, 
            BeanPropertyRowMapper.newInstance(Customer.class), id);

            if (null == customer){
                return Optional.empty();
            }else{
                return Optional.of(customer);
            }


        // catch exception because jdbcTemplate.queryForObject() raise exception instead of return null when ID not found
        }catch(Exception ex){     

            if (null == customer){
                return Optional.empty();
            }else{
                return Optional.of(customer);
            }
    
        }
    }

    public List<Order> getOrdersByCustomerId(int id){

        // // ============= Alternative Approach 1 =================
        // List<Order> orderList = new ArrayList<>();
        // orderList = jdbcTemplate.query(findOrdersByIdSQL, BeanPropertyRowMapper.newInstance(Order.class),id);
        // return Collections.unmodifiableList(orderList);

        // // ============= Alternative Approach 2 =================
        
        final List<Order> orderList = new ArrayList<>();
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(findOrdersByIdSQL, id);

        // // !!!!! Check meta data for order_date data type !!!!!
        // SqlRowSetMetaData md = rs.getMetaData();
        // System.out.println("Metadata: " + md.toString());
        // System.out.println("column type name: " + md.getColumnTypeName(4));  // output: DATETIME
        // System.out.println("column class name: " + md.getColumnClassName(4));  // output: java.sql.Timestamp

        while(rs.next()){
            Order order = new Order();
            order.setId(rs.getInt("id"));
            order.setEmployeeId(rs.getInt("employee_id"));
            order.setCustomerId(rs.getInt("customer_id"));

            // // !!!!!  rs.getTimestamp("order_date") does not work for some unknown reason !!!!!
            // Timestamp ts = rs.getTimestamp("order_date");
            // Object ots = rs.getTimestamp("order_date");
            // System.out.println("========= o is " + ots.getClass().getName());
            // Object o = rs.getObject("order_date");
            // System.out.println("========= o is " + o.getClass().getName()); // output: java.time.LocalDateTime
            

            order.setOrderDate((LocalDateTime) rs.getObject("order_date"));
            order.setShippedDate((LocalDateTime) rs.getObject("shipped_date"));
            order.setShipperId(rs.getInt("shipper_id"));
            order.setShipName(rs.getString("ship_name"));
            order.setShipAddress(rs.getString("ship_address"));
            order.setShipCity(rs.getString("ship_city"));
            order.setShipStateProvince(rs.getString("ship_state_province"));
            order.setShipZipPostalCode(rs.getString("ship_zip_postal_code"));
            order.setShipCountryRegion(rs.getString("ship_country_region"));
            order.setShippingFee(rs.getFloat("shipping_fee"));
            order.setTaxes(rs.getFloat("taxes"));
            order.setPaymentType(rs.getString("payment_type"));
            order.setPaidDate((LocalDateTime) rs.getObject("paid_date"));
            order.setNotes(rs.getString("notes"));
            order.setTaxRate(rs.getDouble("tax_rate"));
            order.setTaxStatusId(rs.getInt("tax_status_id"));
            order.setStatusId(rs.getInt("status_id"));
            
            orderList.add(order);
        }

        return Collections.unmodifiableList(orderList);

    }

}
