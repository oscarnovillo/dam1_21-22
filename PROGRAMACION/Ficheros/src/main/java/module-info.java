module Ficheros {
    requires org.apache.logging.log4j;
    requires weld.se.core;
    requires com.google.gson;
    requires  lombok;
    requires jakarta.inject;
    requires jakarta.cdi;

    opens ui;
    opens domain.modelo;

    exports ui;



}
