package app.invoice.com.invoiceapp.model;

import java.io.Serializable;

/**
 * Created by Angle on 1/13/2016.
 */
public class MyBusinessModel implements Serializable
{
    private String currency,name,website,phone,email,address1,address2,address3,logo;
    private String what_do_you_invoice_for,who_do_you_invoice,repeat_business,expense_per_job,
    invoice_per_month,years_in_business,business_revenue,prefer_invoice_design,comments;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getWhat_do_you_invoice_for() {
        return what_do_you_invoice_for;
    }

    public void setWhat_do_you_invoice_for(String what_do_you_invoice_for) {
        this.what_do_you_invoice_for = what_do_you_invoice_for;
    }

    public String getWho_do_you_invoice() {
        return who_do_you_invoice;
    }

    public void setWho_do_you_invoice(String who_do_you_invoice) {
        this.who_do_you_invoice = who_do_you_invoice;
    }

    public String getRepeat_business() {
        return repeat_business;
    }

    public void setRepeat_business(String repeat_business) {
        this.repeat_business = repeat_business;
    }

    public String getExpense_per_job() {
        return expense_per_job;
    }

    public void setExpense_per_job(String expense_per_job) {
        this.expense_per_job = expense_per_job;
    }

    public String getInvoice_per_month() {
        return invoice_per_month;
    }

    public void setInvoice_per_month(String invoice_per_month) {
        this.invoice_per_month = invoice_per_month;
    }

    public String getYears_in_business() {
        return years_in_business;
    }

    public void setYears_in_business(String years_in_business) {
        this.years_in_business = years_in_business;
    }

    public String getBusiness_revenue() {
        return business_revenue;
    }

    public void setBusiness_revenue(String business_revenue) {
        this.business_revenue = business_revenue;
    }

    public String getPrefer_invoice_design() {
        return prefer_invoice_design;
    }

    public void setPrefer_invoice_design(String prefer_invoice_design) {
        this.prefer_invoice_design = prefer_invoice_design;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
