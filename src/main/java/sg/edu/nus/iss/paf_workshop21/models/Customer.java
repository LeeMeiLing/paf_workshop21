package sg.edu.nus.iss.paf_workshop21.models;

import jakarta.json.Json;
import jakarta.json.JsonObject;

public class Customer {
    
    private Integer id;
    private String company;
    private String lastName;
    private String firstName;
    private String emailAddress;
    private String jobTitle;
    private String businessPhone;
    private String homePhone;
    private String mobilePhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private String zipPostalCode;
    private String countryRegion;
    private String webPage;
    private String notes;
    private byte[] attachments;  // sql BLOB type --> java byte[]  (not Byte[])

    public byte[] getAttachments() {
        return attachments;
    }

    public void setAttachments(byte[] attachments) {
        this.attachments = attachments;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public String getBusinessPhone() {
        return businessPhone;
    }
    public void setBusinessPhone(String businessPhone) {
        this.businessPhone = businessPhone;
    }
    public String getHomePhone() {
        return homePhone;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public String getMobilePhone() {
        return mobilePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public String getFaxNumber() {
        return faxNumber;
    }
    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getStateProvince() {
        return stateProvince;
    }
    public void setStateProvince(String stateProvince) {
        this.stateProvince = stateProvince;
    }
    public String getZipPostalCode() {
        return zipPostalCode;
    }
    public void setZipPostalCode(String zipPostalCode) {
        this.zipPostalCode = zipPostalCode;
    }
    public String getCountryRegion() {
        return countryRegion;
    }
    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }
    public String getWebPage() {
        return webPage;
    }
    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }
    public String getNotes() {
        return notes;
    }
    public void setNotes(String notes) {
        this.notes = notes;
    }

    // // No need to manual generate JSON object as @RestController auto converts into JSON format
    // public JsonObject toJson(Customer customer){

    //     JsonObject jo = Json.createObjectBuilder()
    //                         .add("id", this.getId())
    //                         .add("company", this.getCompany())
    //                         .add("lastName", this.getLastName())
    //                         .add("firstName", this.getFirstName())
                           
    //                         .add("emailAddress", this.getEmailAddress())
    //                         .add("jobTitle", this.getJobTitle())
    //                         .add("businessPhone", this.getBusinessPhone())
    //                         .add("homePhone", this.getHomePhone())
    //                         .add("mobilePhone", this.getMobilePhone())
    //                         .add("faxNumber", this.getFaxNumber())
    //                         .add("address", this.getAddress())
    //                         .add("city", this.getCity())
    //                         .add("stateProvince", this.getStateProvince())
    //                         .add("zipPostalCode", this.getZipPostalCode())
    //                         .add("countryRegion", this.getCountryRegion())
    //                         .add("webPage", this.getWebPage())
    //                         .add("notes", this.getNotes())
    //                         .add("attachments", this.getAttachments().toString())
    //                         .build();
    //     return jo;

    // }
    
}
