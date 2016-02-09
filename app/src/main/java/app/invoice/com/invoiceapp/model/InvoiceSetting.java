package app.invoice.com.invoiceapp.model;

import java.io.Serializable;

/**
 * Created by Angle on 2/4/2016.
 */
public class InvoiceSetting implements Serializable
{
    String invoiceRemoteId,termsDay,discount,discountType,optionQtyRate,optionShipping,optionProductNum,taxType,taxRate
            ,txtInclusive,isFullyPaid,comment,txtLabel,discountAmount,remoteId,updated,deleted;

    public String getInvoiceRemoteId() {
        return invoiceRemoteId;
    }

    public void setInvoiceRemoteId(String invoiceRemoteId) {
        this.invoiceRemoteId = invoiceRemoteId;
    }

    public String getTermsDay() {
        return termsDay;
    }

    public void setTermsDay(String termsDay) {
        this.termsDay = termsDay;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public String getOptionQtyRate() {
        return optionQtyRate;
    }

    public void setOptionQtyRate(String optionQtyRate) {
        this.optionQtyRate = optionQtyRate;
    }

    public String getOptionShipping() {
        return optionShipping;
    }

    public void setOptionShipping(String optionShipping) {
        this.optionShipping = optionShipping;
    }

    public String getOptionProductNum() {
        return optionProductNum;
    }

    public void setOptionProductNum(String optionProductNum) {
        this.optionProductNum = optionProductNum;
    }

    public String getTaxType() {
        return taxType;
    }

    public void setTaxType(String taxType) {
        this.taxType = taxType;
    }

    public String getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(String taxRate) {
        this.taxRate = taxRate;
    }

    public String getTxtInclusive() {
        return txtInclusive;
    }

    public void setTxtInclusive(String txtInclusive) {
        this.txtInclusive = txtInclusive;
    }

    public String getIsFullyPaid() {
        return isFullyPaid;
    }

    public void setIsFullyPaid(String isFullyPaid) {
        this.isFullyPaid = isFullyPaid;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getTxtLabel() {
        return txtLabel;
    }

    public void setTxtLabel(String txtLabel) {
        this.txtLabel = txtLabel;
    }

    public String getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(String discountAmount) {
        this.discountAmount = discountAmount;
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
