package com.wos.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.wos.languages.models.Language;
import com.wos.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	// add the language repository as a dependency
	private final LanguageRepository langRepo;
	
	public LanguageService(LanguageRepository langRepo) {
		this.langRepo = langRepo;
	}
	
	// return all languages
	public List<Language> allLanguages() {
		return langRepo.findAll();
	}
	
	// creates a new language or updates an existing language
	public Language createOrUpdateLanguage(Language language) {
		return langRepo.save(language);
	}
	
	// retrieve a language (for show)
	public Language findLanguage(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	// update a language's information in the db
	public Language updateLanguage(
			Long id,
			String name,
			String creator,
			String currentVersion
			) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			Language language = optionalLang.get();
			language.setName(name);
			language.setCreator(creator);
			language.setCurrentVersion(currentVersion);
			langRepo.save(language);
			return optionalLang.get();
		} else {
			return null;
		}
	}
	
	public Language deleteLanguage(Long id) {
		Optional<Language> optionalLang = langRepo.findById(id);
		if(optionalLang.isPresent()) {
			Language language = optionalLang.get();
			langRepo.deleteById(id);
			return language;
		} else {
			return null;
		}
	}
	
}
