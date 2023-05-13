package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 自习状况对象 study_room
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public class StudyRoom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private Long userId;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floor;

    /** 座号 */
    @Excel(name = "座号")
    private Long site;

    /** 开始时间 */
    @Excel(name = "开始时间")
    private Long startTime;

    /** 内容 */
    @Excel(name = "内容")
    private String context;

    /** 鼓励语句 */
    @Excel(name = "鼓励语句")
    private String encourage;

    /** 时长 */
    @Excel(name = "时长")
    private Long length;

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
    public void setFloor(Long floor) 
    {
        this.floor = floor;
    }

    public Long getFloor() 
    {
        return floor;
    }
    public void setSite(Long site) 
    {
        this.site = site;
    }

    public Long getSite() 
    {
        return site;
    }
    public void setStartTime(Long startTime) 
    {
        this.startTime = startTime;
    }

    public Long getStartTime() 
    {
        return startTime;
    }
    public void setContext(String context) 
    {
        this.context = context;
    }

    public String getContext() 
    {
        return context;
    }
    public void setEncourage(String encourage) 
    {
        this.encourage = encourage;
    }

    public String getEncourage() 
    {
        return encourage;
    }
    public void setLength(Long length) 
    {
        this.length = length;
    }

    public Long getLength() 
    {
        return length;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("floor", getFloor())
            .append("site", getSite())
            .append("startTime", getStartTime())
            .append("context", getContext())
            .append("encourage", getEncourage())
            .append("length", getLength())
            .toString();
    }
}
