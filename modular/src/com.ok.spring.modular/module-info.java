module com.ok.spring.modular {
	requires java.sql;
    requires spring.beans;
    requires spring.context;
    requires spring.core;
    requires spring.jdbc;
    requires spring.tx;
	opens com.ok.spring.jdbc.config;
	opens com.ok.spring.jdbc.dao;
}

