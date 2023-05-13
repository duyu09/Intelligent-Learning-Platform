package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 能力测试对象 ability_test_record
 * 
 * @author ruoyi
 * @date 2023-05-02
 */
public class AbilityTestRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 账号 */
    @Excel(name = "账号")
    private Long userId;

    /** 输入内容 */
    @Excel(name = "输入内容")
    private String inputContext;

    /** 薪资 */
    @Excel(name = "薪资")
    private Integer salary;

    /** 差距 */
    @Excel(name = "差距")
    private String diff;

    /** 工作模式 */
    @Excel(name = "工作模式")
    private Long workMode;

    /** 期待薪资 */
    @Excel(name = "期待薪资")
    private Long expectSalary;

    /** 期待城市 */
    @Excel(name = "期待城市")
    private String expectCity;

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
    public void setInputContext(String inputContext) 
    {
        this.inputContext = inputContext;
    }

    public String getInputContext() 
    {
        return inputContext;
    }
    public void setSalary(Integer salary) 
    {
        this.salary = salary;
    }

    public Integer getSalary() 
    {
        return salary;
    }
    public void setDiff(String diff) 
    {
        this.diff = diff;
    }

    public String getDiff() 
    {
        return diff;
    }
    public void setWorkMode(Long workMode) 
    {
        this.workMode = workMode;
    }

    public Long getWorkMode() 
    {
        return workMode;
    }
    public void setExpectSalary(Long expectSalary) 
    {
        this.expectSalary = expectSalary;
    }

    public Long getExpectSalary() 
    {
        return expectSalary;
    }
    public void setExpectCity(String expectCity) 
    {
        this.expectCity = expectCity;
    }

    public String getExpectCity() 
    {
        return expectCity;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("inputContext", getInputContext())
            .append("salary", getSalary())
            .append("diff", getDiff())
            .append("workMode", getWorkMode())
            .append("expectSalary", getExpectSalary())
            .append("expectCity", getExpectCity())
            .toString();
    }
}
