package org.zankel.goodsPop.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author kanghao
 * @date 18-12-19 下午8:17
 */
@Table("Customer")
public class Customer {

    /**
     * 顾客商户
     */
    @Name
    private String customerName;
    /**
     * 联系人姓名
     */
    @Column
    private String contactName;
    /**
     * 联系人电话
     */
    @Column
    private String contactPhone;

    /**
     * 备用电话
     */
    @Column
    private String contactSpare;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactSpare() {
        return contactSpare;
    }

    public void setContactSpare(String contactSpare) {
        this.contactSpare = contactSpare;
    }
}
