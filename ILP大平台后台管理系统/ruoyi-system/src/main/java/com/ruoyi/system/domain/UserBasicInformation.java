package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户信息对象 user_basic_information
 * 
 * @author ruoyi
 * @date 2023-05-01
 */
public class UserBasicInformation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userId;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userName;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userNickname;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Integer userSex;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userSchool;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userMajor;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userSelfIntroduction;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userAvatar;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String userPassword;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long userRegisterTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserNickname(String userNickname) 
    {
        this.userNickname = userNickname;
    }

    public String getUserNickname() 
    {
        return userNickname;
    }
    public void setUserSex(Integer userSex) 
    {
        this.userSex = userSex;
    }

    public Integer getUserSex() 
    {
        return userSex;
    }
    public void setUserSchool(String userSchool) 
    {
        this.userSchool = userSchool;
    }

    public String getUserSchool() 
    {
        return userSchool;
    }
    public void setUserMajor(String userMajor) 
    {
        this.userMajor = userMajor;
    }

    public String getUserMajor() 
    {
        return userMajor;
    }
    public void setUserSelfIntroduction(String userSelfIntroduction) 
    {
        this.userSelfIntroduction = userSelfIntroduction;
    }

    public String getUserSelfIntroduction() 
    {
        return userSelfIntroduction;
    }
    public void setUserAvatar(String userAvatar) 
    {
        this.userAvatar = userAvatar;
    }

    public String getUserAvatar() 
    {
        return userAvatar;
    }
    public void setUserPassword(String userPassword) 
    {
        this.userPassword = userPassword;
    }

    public String getUserPassword() 
    {
        return userPassword;
    }
    public void setUserRegisterTime(Long userRegisterTime) 
    {
        this.userRegisterTime = userRegisterTime;
    }

    public Long getUserRegisterTime() 
    {
        return userRegisterTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userNickname", getUserNickname())
            .append("userSex", getUserSex())
            .append("userSchool", getUserSchool())
            .append("userMajor", getUserMajor())
            .append("userSelfIntroduction", getUserSelfIntroduction())
            .append("userAvatar", getUserAvatar())
            .append("userPassword", getUserPassword())
            .append("userRegisterTime", getUserRegisterTime())
            .toString();
    }
}
