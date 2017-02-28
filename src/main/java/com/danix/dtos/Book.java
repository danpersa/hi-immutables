package com.danix.dtos;

import com.danix.dtos.styles.BuilderStyle;
import org.immutables.value.Value;

@Value.Immutable
@BuilderStyle
public interface Book extends Identifiable, Named {

    String author();

}
