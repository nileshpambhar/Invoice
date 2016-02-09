package app.invoice.com.invoiceapp.model;

import java.io.Serializable;

/**
 * Created by Angle on 2/4/2016.
 */
public class InvoiceClient implements Serializable
{
    String invoiceRemoteId,name,email,address1,address2,address3,shipAmount,shipDate,shipVia,shipTracking,shipFob;
    String shippingAddress1,shippingAddress2,shippingAddress3,clientRemoteId,contact,shippingName,remoteId,updated,deleted;

    public String getInvoiceRemoteId() {
        return invoiceRemoteId;
    }

    public void setInvoiceRemoteId(String invoiceRemoteId) {
        this.invoiceRemoteId = invoiceRemoteId;
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

    public String getShipAmount() {
        return shipAmount;
    }

    public void setShipAmount(String shipAmount) {
        this.shipAmount = shipAmount;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipVia() {
        return shipVia;
    }

    public void setShipVia(String shipVia) {
        this.shipVia = shipVia;
    }

    public String getShipTracking() {
        return shipTracking;
    }

    public void setShipTracking(String shipTracking) {
        this.shipTracking = shipTracking;
    }

    public String getShipFob() {
        return shipFob;
    }

    public void setShipFob(String shipFob) {
        this.shipFob = shipFob;
    }

    public String getShippingAddress1() {
        return shippingAddress1;
    }

    public void setShippingAddress1(String shippingAddress1) {
        this.shippingAddress1 = shippingAddress1;
    }

    public String getShippingAddress2() {
        return shippingAddress2;
    }

    public void setShippingAddress2(String shippingAddress2) {
        this.shippingAddress2 = shippingAddress2;
    }

    public String getShippingAddress3() {
        return shippingAddress3;
    }

    public void setShippingAddress3(String shippingAddress3) {
        this.shippingAddress3 = shippingAddress3;
    }

    public String getClientRemoteId() {
        return clientRemoteId;
    }

    public void setClientRemoteId(String clientRemoteId) {
        this.clientRemoteId = clientRemoteId;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName;
    }

    public String getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(String remoteId) {
        this.remoteId = remoteId;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }
}
