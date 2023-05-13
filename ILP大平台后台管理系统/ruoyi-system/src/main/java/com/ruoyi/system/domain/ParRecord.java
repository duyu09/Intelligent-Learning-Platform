package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 心理管理对象 par_record
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public class ParRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private Long userId;

    /** $column.columnComment */
    private Integer parMode;

    /** 输入内容 */
    @Excel(name = "输入内容")
    private String inputContext;

    /** 输出内容 */
    @Excel(name = "输出内容")
    private String outputContext;

    /** 提问时间 */
    @Excel(name = "提问时间")
    private Long parTime;

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
    public void setParMode(Integer parMode) 
    {
        this.parMode = parMode;
    }

    public Integer getParMode() 
    {
        return parMode;
    }
    public void setInputContext(String inputContext) 
    {
        this.inputContext = inputContext;
    }

    public String getInputContext() 
    {
        return inputContext;
    }
    public void setOutputContext(String outputContext) 
    {
        this.outputContext = outputContext;
    }

    public String getOutputContext() 
    {
        return outputContext;
    }
    public void setParTime(Long parTime) 
    {
        this.parTime = parTime;
    }

    public Long getParTime() 
    {
        return parTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("parMode", getParMode())
            .append("inputContext", getInputContext())
            .append("outputContext", getOutputContext())
            .append("parTime", getParTime())
            .toString();
    }
}
