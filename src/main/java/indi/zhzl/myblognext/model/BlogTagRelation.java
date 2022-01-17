package indi.zhzl.myblognext.model;

import java.io.Serializable;

public class BlogTagRelation implements Serializable {
    private Integer id;

    private Integer blogArticleId;

    private Integer blogTagId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogArticleId() {
        return blogArticleId;
    }

    public void setBlogArticleId(Integer blogArticleId) {
        this.blogArticleId = blogArticleId;
    }

    public Integer getBlogTagId() {
        return blogTagId;
    }

    public void setBlogTagId(Integer blogTagId) {
        this.blogTagId = blogTagId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogArticleId=").append(blogArticleId);
        sb.append(", blogTagId=").append(blogTagId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}