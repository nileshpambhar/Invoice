package app.invoice.com.invoiceapp.model;

/**
 * Created by Angle on 1/20/2016.
 */
public class ClientModel {
    private int id;
    private String name, email, mobile, phone, fax, website;
    private String contact, line1, line2, line3;
    private String shipping_name, ship_addr1, ship_addr2, ship_addr3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public String getLine2() {
        return line2;
    }

    public void setLine2(String line2) {
        this.line2 = line2;
    }

    public String getLine3() {
        return line3;
    }

    public void setLine3(String line3) {
        this.line3 = line3;
    }

    public String getShipping_name() {
        return shipping_name;
    }

    public void setShipping_name(String shipping_name) {
        this.shipping_name = shipping_name;
    }

    public String getShip_addr1() {
        return ship_addr1;
    }

    public void setShip_addr1(String ship_addr1) {
        this.ship_addr1 = ship_addr1;
    }

    public String getShip_addr2() {
        return ship_addr2;
    }

    public void setShip_addr2(String ship_addr2) {
        this.ship_addr2 = ship_addr2;
    }

    public String getShip_addr3() {
        return ship_addr3;
    }

    public void setShip_addr3(String ship_addr3) {
        this.ship_addr3 = ship_addr3;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getWebsite() {
        return website;
    }
}
