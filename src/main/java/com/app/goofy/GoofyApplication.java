package com.app.goofy;

import com.app.goofy.entity.Item;
import com.app.goofy.repository.ItemRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.core.DatabaseClient;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import reactor.core.publisher.Flux;

import java.util.stream.Stream;

@EnableR2dbcRepositories
@SpringBootApplication
public class GoofyApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoofyApplication.class, args);
	}

	@Bean
	ApplicationRunner init(ItemRepository repository, DatabaseClient client) {
		return args -> {
			client.execute("create table IF NOT EXISTS ITEM" +
					"(ID BIGINT PRIMARY KEY, ITEM_NAME varchar (255) not null, ITEM_PRICE DOUBLE not null, CATEGORY varchar (255) not null);").fetch().first().subscribe();
			//client.execute("DELETE FROM ITEM;").fetch().first().subscribe();

//			Stream<Item> stream = Stream.of(new Item(1L,"Pen",90.5,"Stationary"),
//					new Item(2L,"Pencil",90.5,"Stationary"),
//					new Item(3L,"Eraser",90.5,"Stationary"));

			// initialize the database

//			repository.saveAll(Flux.fromStream(stream))
//					.then()
//					.subscribe(); // execute

		};
	}

}
