package java.technical.test.api.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "books")
public class Book {
    @Id
    private String id;
    private String title;
    private Date publicationDate;
}
