package deloitte.sanli.domain.dto;
import java.util.List;
import lombok.Data;


/**
 * @author hasan.sanli
 *
 * Feb 27, 2020
 */
@Data
public class TaxonamyAPIResponseEntity {
	private List<Category> categories;

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
}
