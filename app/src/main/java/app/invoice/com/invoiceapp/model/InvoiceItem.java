package app.invoice.com.invoiceapp.model;

import java.io.Serializable;

/**
 * Created by Angle on 2/4/2016.
 */
public class InvoiceItem implements Serializable
{
    String invoiceRemoteId,code,description,quantity,discount,rate,taxable,txtRate,remoteId,updated,deleted;

    public String getInvoiceRemoteId() {
        return invoiceRemoteId;
    }

    public void setInvoiceRemoteId(String invoiceRemoteId) {
        this.invoiceRemoteId = invoiceRemoteId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public String getTxtRate() {
        return txtRate;
    }

    public void setTxtRate(String txtRate) {
        this.txtRate = txtRate;
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
