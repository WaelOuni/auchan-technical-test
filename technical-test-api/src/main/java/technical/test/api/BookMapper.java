package java.technical.test.api;

import java.technical.test.api.dto.BookDto;
import java.technical.test.api.model.Book;

public class BookMapper {
    public static BookDto mapToBookDto(Book book) {
        return BookDto.builder().id(book.getId())
                .title(book.getTitle())
                .publicationDate(book.getPublicationDate())
                .build();
    }

    public static Book mapToBook(BookDto bookDto) {
        return Book.builder().id(bookDto.getId())
                .title(bookDto.getTitle())
                .publicationDate(bookDto.getPublicationDate())
                .build();
    }
}
