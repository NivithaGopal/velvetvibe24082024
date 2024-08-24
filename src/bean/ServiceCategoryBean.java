package bean;

public class ServiceCategoryBean {
	private int categoryId;
	private String categoryName;
	private int serviceCategory;
	private String serviceDescription;
	public ServiceCategoryBean(int categoryId, String categoryName, int serviceCategory, String serviceDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.serviceCategory = serviceCategory;
		this.serviceDescription = serviceDescription;
	}
	public ServiceCategoryBean() {
		super();
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getServiceCategory() {
		return serviceCategory;
	}
	public void setServiceCategory(int serviceCategory) {
		this.serviceCategory = serviceCategory;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	@Override
	public String toString() {
		return "ServiceCategoryBean [categoryId=" + categoryId + ", categoryName=" + categoryName + ", serviceCategory="
				+ serviceCategory + ", serviceDescription=" + serviceDescription + "]";
	}
	

}
