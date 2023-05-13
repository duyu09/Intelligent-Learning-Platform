package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社团总表对象 organization_table
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public class OrganizationTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 社团名称 */
    @Excel(name = "社团名称")
    private String orgName;

    /** 社团性质 */
    @Excel(name = "社团性质")
    private Integer orgAttrib;

    /** 社团描述 */
    @Excel(name = "社团描述")
    private String orgDescription;

    /** 成立时间 */
    @Excel(name = "成立时间")
    private Long orgAddTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrgName(String orgName) 
    {
        this.orgName = orgName;
    }

    public String getOrgName() 
    {
        return orgName;
    }
    public void setOrgAttrib(Integer orgAttrib) 
    {
        this.orgAttrib = orgAttrib;
    }

    public Integer getOrgAttrib() 
    {
        return orgAttrib;
    }
    public void setOrgDescription(String orgDescription) 
    {
        this.orgDescription = orgDescription;
    }

    public String getOrgDescription() 
    {
        return orgDescription;
    }
    public void setOrgAddTime(Long orgAddTime) 
    {
        this.orgAddTime = orgAddTime;
    }

    public Long getOrgAddTime() 
    {
        return orgAddTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orgName", getOrgName())
            .append("orgAttrib", getOrgAttrib())
            .append("orgDescription", getOrgDescription())
            .append("orgAddTime", getOrgAddTime())
            .toString();
    }
}
