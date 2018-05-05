package com.catalin.facultate.locationtracker.util;

import lombok.experimental.UtilityClass;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@UtilityClass
public class MapperUtils {

    public static <T, V> List<V> convertList(Collection<T> collection, Function<T, V> mapper) {
        return Optional.ofNullable(collection)
                .orElseGet(Collections::emptyList)
                .stream()
                .map(mapper)
                .collect(Collectors.toList());
    }

}
