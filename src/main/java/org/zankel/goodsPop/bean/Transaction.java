package org.zankel.goodsPop.bean;

import com.sun.istack.internal.NotNull;
import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

/**
 * @author kanghao
 * @date 18-12-19 下午8:40
 */
@Table("Transaction")
public class Transaction {
    /**
     * 交易记录id
     */
    @Id
    private int transacId;
    /**
     * 交易商户
     */
    @Column
    @NotNull
    private String customerName;
    /**
     * 交易皮革
     */
    @Column
    @NotNull
    private Leather leather;
    /**
     * 交易量
     */
    @Column
    private String transacAmount;
    /**
     * 交易额
     */
    @Column
    private String transacVolumn;
    /**
     * 交易时间
     */
    private Date transcaDate;
    /**
     * 结账时间
     */
    private Date finishDate;

    public int getTransacId() {
        return transacId;
    }

    public void setTransacId(int transacId) {
        this.transacId = transacId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Leather getLeather() {
        return leather;
    }

    public void setLeather(Leather leather) {
        this.leather = leather;
    }

    public String getTransacAmount() {
        return transacAmount;
    }

    public void setTransacAmount(String transacAmount) {
        this.transacAmount = transacAmount;
    }


    public String getTransacVolumn() {
        return transacVolumn;
    }

    public void setTransacVolumn(String transacVolumn) {
        this.transacVolumn = transacVolumn;
    }

    public Date getTranscaDate() {
        return transcaDate;
    }

    public void setTranscaDate(Date transcaDate) {
        this.transcaDate = transcaDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }
}
