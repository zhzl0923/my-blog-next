package indi.zhzl.myblognext.model;

import java.io.Serializable;

public class BlogTagRelation implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Long blogArticleId;
    private Long blogTagId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBlogArticleId() {
        return blogArticleId;
    }

    public void setBlogArticleId(Long blogArticleId) {
        this.blogArticleId = blogArticleId;
    }

    public Long getBlogTagId() {
        return blogTagId;
    }

    public void setBlogTagId(Long blogTagId) {
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