module Ficheros {
    requires org.apache.logging.log4j;
    requires weld.se.core;
    requires com.google.gson;
    requires lombok;
    requires jakarta.inject;
    requires jakarta.cdi;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.dataformat.yaml;

    opens ui;
    opens domain.modelo;
    opens config;
    opens servicios.impl;


    exports servicios;
    exports ui;
    exports dao.impl;
    exports di;
}
