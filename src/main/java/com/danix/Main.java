package com.danix;

import com.danix.dtos.Color;
import com.danix.dtos.ImmutableBook;
import com.danix.dtos.ImmutablePerson;
import com.danix.dtos.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.guava.GuavaModule;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.google.common.collect.ImmutableList;

public class Main {

    public static void main(String[] args) throws JsonProcessingException {

        final ImmutableBook book = ImmutableBook.builder()
                .withAuthor("Asimov")
                .withName("Foundation")
                .withId(123l)
                .build();

        final ImmutableList<ImmutableBook> books = ImmutableList.of(book);

        final Person valueOb =
                ImmutablePerson.builder()
                        .withId(10)
                        .withName("hello")
                        .withFavoriteBooks(books)
                        .withFavoriteColor(Color.createColor(10, "red"))
                        .build();

        final ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new GuavaModule());
        mapper.registerModule(new Jdk8Module());

        final String json = mapper.writeValueAsString(valueOb);


        System.out.println("Hello world " + json);
    }
}
