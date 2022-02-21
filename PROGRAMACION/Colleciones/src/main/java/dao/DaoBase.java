package dao;

import modelo.Clonable;
import modelo.Producto;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

abstract class DaoBase {


    private BD bd;

    protected  <T> List<T> dameListaInmutableClonada(Collection<Clonable<T>> collection)
    {
        return collection.stream()
                .map(Clonable::clonar)
                .collect(Collectors.toUnmodifiableList());
    }

    protected <T> T dameElemento(Clonable<T> t)
    {
        return t.clonar();
    }
}
