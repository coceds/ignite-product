package capstone.product.dto;

import org.apache.ignite.cache.query.annotations.QuerySqlField;

import java.io.Serializable;
import java.math.BigDecimal;

public class Product implements Serializable {

    @QuerySqlField(index = true, name = "uniq_id")
    private String productId;
    @QuerySqlField(name = "sku")
    private String sku;
    @QuerySqlField(name = "name_title")
    private String nameTitle;
    @QuerySqlField(name = "description")
    private String description;
    @QuerySqlField(name = "list_price")
    private Double listPrice;
    @QuerySqlField(name = "sale_price")
    private Double salePrice;
    @QuerySqlField(name = "category")
    private String category;
    @QuerySqlField(name = "category_tree")
    private String categoryTree;
    @QuerySqlField(name = "average_product_rating")
    private String averageProductRating;
    @QuerySqlField(name = "product_url")
    private String productUrl;
    @QuerySqlField(name = "product_image_urls")
    private String productImageUrls;
    @QuerySqlField(name = "brand")
    private String brand;
    @QuerySqlField(name = "total_number_reviews")
    private Integer totalNumberReviews;
    @QuerySqlField(name = "reviews")
    private String reviews;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getListPrice() {
        return listPrice;
    }

    public void setListPrice(Double listPrice) {
        this.listPrice = listPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryTree() {
        return categoryTree;
    }

    public void setCategoryTree(String categoryTree) {
        this.categoryTree = categoryTree;
    }

    public String getAverageProductRating() {
        return averageProductRating;
    }

    public void setAverageProductRating(String averageProductRating) {
        this.averageProductRating = averageProductRating;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getProductImageUrls() {
        return productImageUrls;
    }

    public void setProductImageUrls(String productImageUrls) {
        this.productImageUrls = productImageUrls;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getTotalNumberReviews() {
        return totalNumberReviews;
    }

    public void setTotalNumberReviews(Integer totalNumberReviews) {
        this.totalNumberReviews = totalNumberReviews;
    }

    public String getReviews() {
        return reviews;
    }

    public void setReviews(String reviews) {
        this.reviews = reviews;
    }
}
