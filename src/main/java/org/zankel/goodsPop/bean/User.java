package org.zankel.goodsPop.bean;


import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

import java.util.Date;

@Table("User")
public class User {

    /**
     * 用户ID
     */
    @Id
    private int userId;

    /**
     * 用户手机
     */
    @Name
    private String phone;

    /**
     * 邮箱
     */
    @Column
    private String email;

    /**
     * 密码
     */
    @Column
    private String password;

    /**
     * 用户昵称
     */
    @Column
    private String nickname;

    /**
     * 创建时间
     */
    @Column
    private Date createTime;

    /**
     * 最近登陆
     */
    @Column
    private Date updateTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
