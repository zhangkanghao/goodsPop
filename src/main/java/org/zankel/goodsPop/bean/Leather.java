package org.zankel.goodsPop.bean;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * @author kanghao
 * @date 18-12-19 下午8:18
 */
@Table("Leather")
public class Leather {

    /**
     * lid
     */
    @Id
    private int leatherId;
    /**
     * 名称
     */
    @Name
    private String leatherName;
    /**
     * 种类
     */
    @Column
    private String leatherType;
    /**
     * 颜色
     */
    private String leatherColor;
    /**
     * 销售单价
     */
    @Column
    private String leatherPrice;
    /**
     * 销售单位
     */
    @Column
    private String leatherUnit;
    /**
     * 备注
     */
    @Column
    private String note;

    public int getLeatherId() {
        return leatherId;
    }

    public void setLeatherId(int leatherId) {
        this.leatherId = leatherId;
    }

    public String getLeatherName() {
        return leatherName;
    }

    public void setLeatherName(String leatherName) {
        this.leatherName = leatherName;
    }

    public String getLeatherType() {
        return leatherType;
    }

    public void setLeatherType(String leatherType) {
        this.leatherType = leatherType;
    }

    public String getLeatherColor() {
        return leatherColor;
    }

    public void setLeatherColor(String leatherColor) {
        this.leatherColor = leatherColor;
    }

    public String getLeatherPrice() {
        return leatherPrice;
    }

    public void setLeatherPrice(String leatherPrice) {
        this.leatherPrice = leatherPrice;
    }

    public String getLeatherUnit() {
        return leatherUnit;
    }

    public void setLeatherUnit(String leatherUnit) {
        this.leatherUnit = leatherUnit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
