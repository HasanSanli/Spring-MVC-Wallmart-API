package deloitte.sanli.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import deloitte.sanli.domain.dto.Items;
import deloitte.sanli.domain.dto.Category;
import deloitte.sanli.domain.dto.SearchAPIResponseEntity;
import deloitte.sanli.domain.dto.TaxonamyAPIResponseEntity;

/**
 * @author hasan.sanli
 *
 *         Feb 27, 2020
 */
@Service
public class WalmartService {

	RestTemplate restTemplate = new RestTemplate();

	@Value("${api.key}")
	private String apiUrl;

	@Value("${category.get.url}")
	private String taxonamyApiUrl; // Kategorileri çekmek için

	@Value("${search.api.url}")
	private String searchApiUrl; // Kategorilere ait ürünleri çekmek için
	
	@Value("${category.name}")
	private String categoryName;
	
	List<Items> items=null;

	private final Logger log = LoggerFactory.getLogger(WalmartService.class);

	public Category[] getCategoriesById(String categoryId) {
		log.info("Getting Categories By Id(" + categoryId + ") - Start");
		TaxonamyAPIResponseEntity categories = restTemplate.getForObject(
				taxonamyApiUrl + "?apiKey=" + apiUrl + "&format=json", TaxonamyAPIResponseEntity.class);
		Category[] filteredCategories = categories.getCategories().stream()
				.filter(moviesCategory -> moviesCategory.getId().equals(categoryId)).collect(Collectors.toList()).get(0)
				.getChildren();
		log.info("Getting Categories By Id(" + categoryId + ") - Finish");
		return filteredCategories;
	}

	public Category[] getCategoriesByName() {
		log.info("Getting Categories By Name(" + categoryName + ") - Start");
		TaxonamyAPIResponseEntity categories = restTemplate.getForObject(
				taxonamyApiUrl + "?apiKey=" + apiUrl + "&format=json", TaxonamyAPIResponseEntity.class);
		Category[] filteredCategories = categories.getCategories().stream()
				.filter(moviesCategory -> moviesCategory.getName().equals(categoryName)).collect(Collectors.toList()).get(0)
				.getChildren();
		log.info("Getting Categories By Id(" + categoryName + ") - Finish");
		return filteredCategories;

	}

	// 
	public List<Items> getCategoryItems(String categoryId) {
		log.info("Getting Category Items By(" + categoryId + "," + categoryName + ") - Start");
		SearchAPIResponseEntity response = null;
		try {
			response = restTemplate.getForObject(searchApiUrl + "?apiKey=" + apiUrl + "&categoryId=" + categoryId
					+ "&format=json&query=" + categoryName + "&responseGroup=full&numItems=25", SearchAPIResponseEntity.class);
			items = Arrays.stream(response.getItems()).collect(Collectors.toList());
			log.info("Getting Category Items By(" + categoryId + "," + categoryName + ") - Finish");
			return items;
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public Items getItemById(int itemId) {
		return this.items.stream().filter(b -> b.getItemId() == itemId).findFirst().get();
	}

}
