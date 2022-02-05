package indi.zhzl.myblognext.pojo.dto;

import java.util.List;

public class SecondLevelCategory {
    private Long id;

    private String categoryName;

    private Long blogCount;

    private List<ThirdLevelCategory> children;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getBlogCount() {
        return blogCount;
    }

    public void setBlogCount(Long blogCount) {
        this.blogCount = blogCount;
    }

    public List<ThirdLevelCategory> getChildren() {
        return children;
    }

    public void setChildren(List<ThirdLevelCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "SecondLevelCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", blogCount=" + blogCount +
                ", children=" + children +
                '}';
    }
}
