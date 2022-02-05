package indi.zhzl.myblognext.pojo.dto;

public class ThirdLevelCategory {
    private Long id;

    private String categoryName;

    private Long blogCount;

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

    @Override
    public String toString() {
        return "ThirdLevelCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", blogCount=" + blogCount +
                '}';
    }
}
