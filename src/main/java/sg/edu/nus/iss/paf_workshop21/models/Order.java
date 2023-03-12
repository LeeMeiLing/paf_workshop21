package sg.edu.nus.iss.paf_workshop21.models;

import java.time.LocalDateTime;

public class Order {

    private Integer id;
    private Integer employeeId;
    private Integer customerId;

    private LocalDateTime orderDate;  // sql data type is DATETIME but using java.sql.Timestamp here does not work, must use LocalDateTime
    private LocalDateTime shippedDate;

    private Integer shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private Float shippingFee;
    private Float taxes;
    private String paymentType;

    private LocalDateTime paidDate;

    private String notes;
    private Double taxRate;
    private Integer taxStatusId;
    private Integer StatusId;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public Integer getCustomerId() {
        return customerId;
    }
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
    
    public Integer getShipperId() {
        return shipperId;
    }
    public void setShipperId(Integer shipperId) {
        this.shipperId = shipperId;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public String getShipCity() {
        return shipCity;
    }
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }
    public String getShipStateProvince() {
        return shipStateProvince;
    }
    public void setShipStateProvince(String shipStateProvince) {
        this.shipStateProvince = shipStateProvince;
    }
    public String getShipZipPostalCode() {
        return shipZipPostalCode;
    }
    public void setShipZipPostalCode(String shipZipPostalCode) {
        this.shipZipPostalCode = shipZipPostalCode;
    }
    public String getShipCountryRegion() {
        return shipCountryRegion;
    }
    public void setShipCountryRegion(String shipCountryRegion) {
        this.shipCountryRegion = shipCountryRegion;
    }
    public Float getShippingFee() {
        return shippingFee;
    }
    public void setShippingFee(Float shippingFee) {
        this.shippingFee = shippingFee;
    }
    public Float getTaxes() {
        return taxes;
    }
    public void setTaxes(Float taxes) {
        this.taxes = taxes;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
   
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public LocalDateTime getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(LocalDateTime shippedDate) {
        this.shippedDate = shippedDate;
    }
    public LocalDateTime getPaidDate() {
        return paidDate;
    }
    public void setPaidDate(LocalDateTime paidDate) {
        this.paidDate = paidDate;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }
    public Double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(Double taxRate) {
        this.taxRate = taxRate;
    }
    public Integer getTaxStatusId() {
        return taxStatusId;
    }
    public void setTaxStatusId(Integer taxStatusId) {
        this.taxStatusId = taxStatusId;
    }
    public Integer getStatusId() {
        return StatusId;
    }
    public void setStatusId(Integer statusId) {
        StatusId = statusId;
    }


//   `id` int NOT NULL AUTO_INCREMENT,
//   `employee_id` int DEFAULT NULL,
//   `customer_id` int DEFAULT NULL,
//   `order_date` datetime DEFAULT NULL,
//   `shipped_date` datetime DEFAULT NULL,
//   `shipper_id` int DEFAULT NULL,
//   `ship_name` varchar(50) DEFAULT NULL,
//   `ship_address` longtext,
//   `ship_city` varchar(50) DEFAULT NULL,
//   `ship_state_province` varchar(50) DEFAULT NULL,
//   `ship_zip_postal_code` varchar(50) DEFAULT NULL,
//   `ship_country_region` varchar(50) DEFAULT NULL,
//   `shipping_fee` decimal(19,4) DEFAULT '0.0000',
//   `taxes` decimal(19,4) DEFAULT '0.0000',
//   `payment_type` varchar(50) DEFAULT NULL,
//   `paid_date` datetime DEFAULT NULL,
//   `notes` longtext,
//   `tax_rate` double DEFAULT '0',
//   `tax_status_id` tinyint DEFAULT NULL,
//   `status_id` tinyint DEFAULT '0',
}
