package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * forum对象 forum_record
 * 
 * @author ruoyi
 * @date 2023-05-03
 */
public class Forum extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 性质 */
    @Excel(name = "性质")
    private Integer attrib;

    /** 论坛名称 */
    @Excel(name = "论坛名称")
    private Long forumId;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floor;

    /** 帖子内容 */
    @Excel(name = "帖子内容")
    private String itemContext;

    /** 发布时间 */
    @Excel(name = "发布时间")
    private Long publishTime;

    /** 发布人 */
    @Excel(name = "发布人")
    private Long publishUserId;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long upvote;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAttrib(Integer attrib) 
    {
        this.attrib = attrib;
    }

    public Integer getAttrib() 
    {
        return attrib;
    }
    public void setForumId(Long forumId) 
    {
        this.forumId = forumId;
    }

    public Long getForumId() 
    {
        return forumId;
    }
    public void setFloor(Long floor) 
    {
        this.floor = floor;
    }

    public Long getFloor() 
    {
        return floor;
    }
    public void setItemContext(String itemContext) 
    {
        this.itemContext = itemContext;
    }

    public String getItemContext() 
    {
        return itemContext;
    }
    public void setPublishTime(Long publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Long getPublishTime() 
    {
        return publishTime;
    }
    public void setPublishUserId(Long publishUserId) 
    {
        this.publishUserId = publishUserId;
    }

    public Long getPublishUserId() 
    {
        return publishUserId;
    }
    public void setUpvote(Long upvote) 
    {
        this.upvote = upvote;
    }

    public Long getUpvote() 
    {
        return upvote;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("attrib", getAttrib())
            .append("forumId", getForumId())
            .append("floor", getFloor())
            .append("itemContext", getItemContext())
            .append("publishTime", getPublishTime())
            .append("publishUserId", getPublishUserId())
            .append("upvote", getUpvote())
            .toString();
    }
}
