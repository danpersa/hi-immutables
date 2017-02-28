package com.danix.dtos;

import com.danix.dtos.styles.FactoryStyle;
import org.immutables.value.Value;

@FactoryStyle
@Value.Immutable
public abstract class Color implements Identifiable, Named {

    public static Color createColor(long id, String name) {
        return ImmutableColor.of(id, name);
    }
}
