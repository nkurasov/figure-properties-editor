package ru.spb.nkurasov.figure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public final class FigureType {

    private final String name;

    private final List<FigurePropertyType> properties = new ArrayList<>();

    FigureType(String name, Collection<? extends FigurePropertyType> properties) {
        if (name == null) {
            throw new IllegalArgumentException("figure name is null");
        }

        if (properties == null || properties.isEmpty()) {
            throw new IllegalArgumentException("figure properties must contain at least one value");
        }

        this.name = name;
        this.properties.addAll(properties);
    }

    public String getName() {
        return name;
    }

    public Collection<FigurePropertyType> getProperties() {
        return Collections.unmodifiableCollection(properties);
    }

    public Optional<FigurePropertyType> getProperty(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }

        return properties.stream().filter(p -> p.getName().equals(name)).findFirst();
    }
}