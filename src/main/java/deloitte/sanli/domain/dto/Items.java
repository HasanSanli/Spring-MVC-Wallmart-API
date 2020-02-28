package deloitte.sanli.domain.dto;

import deloitte.sanli.util.DisplayUtil;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


/**
 * @author hasan.sanli
 *
 * Feb 27, 2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
	
	private int itemId;
	private String name;
	private double salePrice;
	private String categoryPath;
	private String shortDescription;
	private String longDescription;
	private String thumbnailImage;
	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(double salePrice) {
		this.salePrice = salePrice;
	}

	public String getCategoryPath() {
		return categoryPath;
	}

	public void setCategoryPath(String categoryPath) {
		this.categoryPath = categoryPath;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public String getMediumImage() {
		return mediumImage;
	}

	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	private String mediumImage;
	private String largeImage;
	private String stock;

	public String shDispWeb() {
		return DisplayUtil.clearAndResize(this.shortDescription, 30);
	}

	public String nameDispWeb() {
		return DisplayUtil.clearAndResize(this.name, 10);
	}
}
