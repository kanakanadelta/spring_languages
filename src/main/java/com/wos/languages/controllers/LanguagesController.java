package com.wos.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wos.languages.models.Language;
import com.wos.languages.services.LanguageService;


@Controller
@RequestMapping("/languages")
public class LanguagesController {
	// dependency injection
	public final LanguageService langService;
	
	public LanguagesController(LanguageService langService) {
		this.langService = langService;
	}
	
	//RESTFUL ROUTES SET UP
	
	//1. INDEX - Display all languages
	@RequestMapping("")
	public String index(Model model, @ModelAttribute("language") Language language) {
		List<Language> languages = langService.allLanguages();
		model.addAttribute("languages", languages);
		return "index.jsp";
	}
	
	//2. NEW - Show form to make new languages
	// NOT APPLICABLE
	
	//3. CREATE - Add new language to the database
	@PostMapping("")
	public String create(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			langService.createOrUpdateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//4. SHOW - Show info about language
	@GetMapping("/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language", language);
		return "show.jsp";
	}
	
	//5. EDIT - Show edit form of the language
	@GetMapping("/{id}/edit")
	public String edit(@PathVariable("id")Long id, Model model) {
		Language language = langService.findLanguage(id);
		model.addAttribute("language", language);
		return "edit.jsp";
	}
	
	//6. UPDATE - Make changes to the item in the DB, then redirect
	@PutMapping("/{id}")
	public String update(@Valid @ModelAttribute("language")Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			langService.createOrUpdateLanguage(language);
			return "redirect:/languages";
		}
	}
	
	//7. DESTROY
	@DeleteMapping("/{id}")
	public String destroy(@PathVariable("id")Long id) {
		langService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	// END CONTROLLER
}
