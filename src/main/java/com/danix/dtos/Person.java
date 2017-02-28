package com.danix.dtos;

import com.danix.dtos.styles.BuilderStyle;
import java.util.List;
import java.util.Optional;
import org.immutables.value.Value;

@BuilderStyle
@Value.Immutable
public interface Person extends Named, Identifiable {

    Optional<String> comment();

    List<Book> favoriteBooks();

    Color favoriteColor();
}
