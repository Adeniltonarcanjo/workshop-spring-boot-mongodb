package com.github.adeniltonarcanjo.workshopmongo.services;

import java.lang.invoke.CallSite;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.adeniltonarcanjo.workshopmongo.domain.Post;
import com.github.adeniltonarcanjo.workshopmongo.domain.User;
import com.github.adeniltonarcanjo.workshopmongo.dto.UserDTO;
import com.github.adeniltonarcanjo.workshopmongo.repository.PostRepository;
import com.github.adeniltonarcanjo.workshopmongo.repository.UserRepository;
import com.github.adeniltonarcanjo.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;


	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("user id not exist"));
	}

	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
	}

	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() +24*60*60*1000);
		return repository.fullSearch(text,minDate,maxDate);
	}

}
