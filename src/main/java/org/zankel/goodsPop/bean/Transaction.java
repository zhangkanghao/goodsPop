package org.zankel.goodsPop.bean;

import com.sun.istack.internal.NotNull;
import org.nutz.dao.entity.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
     * 皮革ID,映射
     */
    @Column
    private int leatherId;
    /**
     * 交易皮革
     */
    @One(field = "leatherId")
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
    @Column
    private Date transacDate;
    /**
     * 是否完成交易
     */
    @Column
    private String transacStatu;
    /**
     * 结账时间
     */
    @Column
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

    public int getLeatherId() {
        return leatherId;
    }

    public void setLeatherId(int leatherId) {
        this.leatherId = leatherId;
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

    public String getTransacDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(transacDate);
    }

    public void setTransacDate(Date transcaDate) {
        this.transacDate = transcaDate;
    }

    public String getTransacStatu() {
        return transacStatu;
    }

    public void setTransacStatu(String transacStatu) {
        this.transacStatu = transacStatu;
    }

    public String getFinishDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(finishDate);
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

}
