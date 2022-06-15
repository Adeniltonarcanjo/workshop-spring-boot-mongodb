package com.github.adeniltonarcanjo.workshopmongo.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.adeniltonarcanjo.workshopmongo.domain.Post;
import com.github.adeniltonarcanjo.workshopmongo.domain.User;
import com.github.adeniltonarcanjo.workshopmongo.dto.UserDTO;
import com.github.adeniltonarcanjo.workshopmongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	// GET ALL USERS
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = service.findAll();
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok(listDto);
	}

	// GET USER BY ID
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(new UserDTO(obj));

	}

	// POST USER
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<UserDTO> insert(@RequestBody UserDTO bjtDto) {
		User obj = service.fromDTO(bjtDto);
		obj = service.insert(obj);
		// put the instance object in url
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();

		// return cod 201 http
		return ResponseEntity.created(uri).build();

	}

	// DELETE USER BY ID
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();

	}

	// UPDATE USER
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> update(@RequestBody UserDTO bjtDto, @PathVariable String id) {
		User obj = service.fromDTO(bjtDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();

	}
	
	
	@RequestMapping(value = "/{id}/posts", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findPosts(@PathVariable String id) {
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj.getPosts());

	}
}
