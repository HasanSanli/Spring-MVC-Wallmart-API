package deloitte.sanli.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import deloitte.sanli.SanliApplication;
import deloitte.sanli.domain.dto.Items;
import deloitte.sanli.service.WalmartService;

/**
 * @author hasan.sanli
 *
 * Feb 27, 2020
 */
@Controller
public class WalmartApiController {

	private final Logger log = LoggerFactory.getLogger(WalmartApiController.class);

	@Autowired
	WalmartService walmartService;
	
	@RequestMapping("/HelloWorld")
	public ModelAndView firstPage() {
		return new ModelAndView("test");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getCategories(Model model) {
		log.info("Getting All Movie Categories");
		model.addAttribute("movieCategories", SanliApplication.movieCategories);
		return new ModelAndView("movieList");
	}

	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
	public ModelAndView getBooksOfSubCategory(Model model, @PathVariable(name = "categoryId") String categoryId,
			@RequestParam(required = false) Integer page) {
		
		model.addAttribute("movieCategories", SanliApplication.movieCategories);
		model.addAttribute("categoryId", categoryId);

		List<Items> subCategoryBooks = walmartService.getCategoryItems(categoryId);
		
		if (subCategoryBooks != null) {
			PagedListHolder<Items> pagedListHolder = new PagedListHolder<>(subCategoryBooks);
			pagedListHolder.setPageSize(20);

			if (page == null || page < 1 || page > pagedListHolder.getPageCount())
				page = 1;
			model.addAttribute("page", page);
			model.addAttribute("maxPages", pagedListHolder.getPageCount());

			if (page == null || page < 1 || page > pagedListHolder.getPageCount()) {
				pagedListHolder.setPage(0);
				model.addAttribute("subCategoryMovies", pagedListHolder.getPageList());
			} else if (page <= pagedListHolder.getPageCount()) {
				pagedListHolder.setPage(page - 1);
				model.addAttribute("subCategoryMovies", pagedListHolder.getPageList());
			}
		} else
			model.addAttribute("isCategoryEmpty", "Y");
		return new ModelAndView("movieList");
	}

	@RequestMapping(value = "/movie", method = RequestMethod.GET)
	public ModelAndView getBookById(Model model, @RequestParam int itemId) {
		model.addAttribute("movie", walmartService.getItemById(itemId));
		return new ModelAndView("movieDetail");
	}
}
