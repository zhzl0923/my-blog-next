package indi.zhzl.myblognext.pojo.dto;

import java.util.List;

public class TopLevelCategory {
    private Long id;

    private String categoryName;

    private Long blogCount;

    private List<SecondLevelCategory> children;

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

    public List<SecondLevelCategory> getChildren() {
        return children;
    }

    public void setChildren(List<SecondLevelCategory> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TopLevelCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", blogCount=" + blogCount +
                ", children=" + children +
                '}';
    }
}
