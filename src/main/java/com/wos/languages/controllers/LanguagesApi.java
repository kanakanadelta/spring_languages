package com.wos.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wos.languages.models.Language;
import com.wos.languages.services.LanguageService;

@RestController
public class LanguagesApi {
	// dependency injection
	private final LanguageService langService;
	
	// constructor
	public LanguagesApi(LanguageService langService) {
		this.langService = langService;
	}
	
	
	//1. INDEX -- get all languages
	@RequestMapping("/api/languages")
	public List<Language> index() {
		return langService.allLanguages();
	}
	
	//2. CREATE -- Create a language row for languages
	@PostMapping("/api/languages")
	public Language create(
			@RequestParam(value="name") String name,
			@RequestParam(value="creator") String creator,
			@RequestParam(value="currentVersion") String currentVersion
			) {
		Language language = new Language(name, creator, currentVersion);
		return langService.createOrUpdateLanguage(language);
	}
	
	//3. SHOW -- Retrieve a language by its id
	@GetMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		return language;
	}
	
	//4. UPDATE -- Change information of a particular language
	@PutMapping("/api/languages/{id}")
	public Language update(
			@PathVariable("id") Long id,
			@RequestParam("name") String name,
			@RequestParam("creator") String creator,
			@RequestParam("currentVersion") String currentVersion
			) {
		Language language = langService.updateLanguage(id, name, creator, currentVersion);
		return language;
	}
	
	//5. DESTROY - Delete the particular language from the db by id
	@DeleteMapping("/api/languages/{id}")
	public Language destroy(@PathVariable("id") Long id) {
		Language language = langService.findLanguage(id);
		langService.deleteLanguage(id);
		return language;
	}
	
}
