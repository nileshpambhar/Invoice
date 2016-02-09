package app.invoice.com.invoiceapp.model;

import java.io.Serializable;

/**
 * Created by Angle on 2/4/2016.
 */
public class InvoicePhoto implements Serializable
{
    String photoRemoteId,invoiceRemoteId,name,desc,remoteId,updated,deleted;

    public String getPhotoRemoteId() {
        return photoRemoteId;
    }

    public void setPhotoRemoteId(String photoRemoteId) {
        this.photoRemoteId = photoRemoteId;
    }

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
