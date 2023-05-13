package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户目标对象 user_aim_table
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public class UserAimTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private Long userId;

    /** 目标 */
    @Excel(name = "目标")
    private String aim;

    /** 设定时间 */
    @Excel(name = "设定时间")
    private Long aimSetTime;

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
    public void setAim(String aim) 
    {
        this.aim = aim;
    }

    public String getAim() 
    {
        return aim;
    }
    public void setAimSetTime(Long aimSetTime) 
    {
        this.aimSetTime = aimSetTime;
    }

    public Long getAimSetTime() 
    {
        return aimSetTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("aim", getAim())
            .append("aimSetTime", getAimSetTime())
            .toString();
    }
}
