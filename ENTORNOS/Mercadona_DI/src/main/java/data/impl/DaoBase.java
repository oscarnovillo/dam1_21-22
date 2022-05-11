package data.impl;

import modelo.Clonable;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

abstract class DaoBase {

    protected <T> List<T> getUnmodifiableClonedList(Collection<? extends Clonable<T>> collection) {
        return collection.stream()
                .sorted()
                .map(Clonable::duplicate)
                .collect(Collectors.toUnmodifiableList());
    }

    protected <T> T getElement(Clonable<T> t) {
        return t.duplicate();
    }

}
