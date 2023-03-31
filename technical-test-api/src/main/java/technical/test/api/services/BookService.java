package java.technical.test.api.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.technical.test.api.dto.BookDto;

public interface BookService {
    Mono<BookDto> saveBook(BookDto BookDto);

    Mono<BookDto> getBook(String bookId);

    Flux<BookDto> getAllBooks();

    Mono<BookDto> updateBook(BookDto BookDto, String bookId);

    Mono<Void> deleteBook(String bookId);
}
