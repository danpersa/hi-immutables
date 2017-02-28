package com.danix.dtos.styles;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.immutables.value.Value.Immutable;
import static org.immutables.value.Value.Style;
import static org.immutables.value.Value.Style.ImplementationVisibility;

@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS) // Make it class retention for incremental compilation
@Style(
        get = {"is*", "get*"}, // Detect 'get' and 'is' prefixes in accessor methods
        init = "with*", // Builder initialization methods will have 'set' prefix
        typeAbstract = {"Abstract*"}, // 'Abstract' prefix will be detected and trimmed
        typeImmutable = "Immutable*", // No prefix or suffix for generated immutable type
        builder = "builder", // construct builder using 'new' instead of factory method
        build = "build", // rename 'build' method on builder to 'create'
        visibility = ImplementationVisibility.PUBLIC, // Generated class will be always public
        defaults = @Immutable(copy = true), // Enable copy methods by default
        depluralize = true, // enable feature
        depluralizeDictionary = {"person:people", "foot:feet"}) // specifying dictionary of exceptio)
@JsonSerialize
public @interface BuilderStyle {
}
