package java.technical.test.api.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.technical.test.api.model.Book;

public interface BookRepository extends ReactiveMongoRepository<Book, String> {
}
