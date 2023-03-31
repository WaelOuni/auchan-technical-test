package java.technical.test.api.services.impl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.technical.test.api.BookMapper;
import java.technical.test.api.dto.BookDto;
import java.technical.test.api.model.Book;
import java.technical.test.api.repository.BookRepository;
import java.technical.test.api.services.BookService;

public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;

    @Override
    public Mono<BookDto> saveBook(BookDto bookDto) {
        Book book = BookMapper.mapToBook(bookDto);
        Mono<Book> savedBook = bookRepository.save(book);
        return savedBook
                .map(BookMapper::mapToBookDto);
    }

    @Override
    public Mono<BookDto> getBook(String bookId) {
        Mono<Book> bookMono = bookRepository.findById(bookId);
        return bookMono.map((BookMapper::mapToBookDto));
    }

    @Override
    public Flux<BookDto> getAllBooks() {
        Flux<Book> bookFlux = bookRepository.findAll();
        return bookFlux
                .map(BookMapper::mapToBookDto)
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Mono<BookDto> updateBook(BookDto bookDto, String bookId) {
        Mono<Book> bookMono = bookRepository.findById(bookId);
        return bookMono.flatMap((existingbook) -> {
            existingbook.setTitle(bookDto.getTitle());
            existingbook.setPublicationDate(bookDto.getPublicationDate());
            return bookRepository.save(existingbook);
        }).map((BookMapper::mapToBookDto));
    }

    @Override
    public Mono<Void> deleteBook(String bookId) {
        //TODO Delete not in the specs
        return null;
    }
}
