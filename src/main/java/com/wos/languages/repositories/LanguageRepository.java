package com.wos.languages.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.wos.languages.models.Language;

public interface LanguageRepository extends CrudRepository<Language, Long>{
//	// this method retrieves all the languages from the db
	List<Language> findAll();

	// this method will delete a language by their name
	Long deleteByNameStartingWith(String search);
//	
//	// this method will create or edit a language
	void save(Optional<Language> optionalLanguage);
//	
//	// this method will delete a language by its id
	void deleteById(Long id);
	
}
