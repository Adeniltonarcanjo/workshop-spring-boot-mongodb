package com.github.adeniltonarcanjo.workshopmongo.config;

import com.github.adeniltonarcanjo.workshopmongo.domain.Post;
import com.github.adeniltonarcanjo.workshopmongo.domain.User;
import com.github.adeniltonarcanjo.workshopmongo.dto.AuthorDTO;
import com.github.adeniltonarcanjo.workshopmongo.dto.CommentDTO;
import com.github.adeniltonarcanjo.workshopmongo.repository.PostRepository;
import com.github.adeniltonarcanjo.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	@Autowired
	PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");

		userRepository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1= new Post(null,sdf.parse("21/03/2021"),"Viagem", "essa viagem foi um sucesso", new AuthorDTO(maria));
		Post post2= new Post(null, sdf.parse("21/04/2020"),"Viagem bahia", "essa viagem muito divertida,fomos em varias cachoerias", new AuthorDTO(alex));

		CommentDTO comment1 = new CommentDTO("aproveite a viagem",sdf.parse("21/03/2021"),new AuthorDTO(bob));
		CommentDTO comment2 = new CommentDTO("sucesso maria",sdf.parse("21/03/2021"),new AuthorDTO(bob));
		post1.getComments().addAll((Arrays.asList(comment1,comment2)));

		postRepository.saveAll(Arrays.asList(post1,post2));

	}

}
