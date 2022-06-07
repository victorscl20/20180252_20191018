package com.example.laboratorio7.Daos;

import com.example.laboratorio7.Beans.Actores;

import java.sql.*;
import java.util.ArrayList;

public class ActoresDao {

public ArrayList<Actores> listarActores(){

    ArrayList<Actores> listaActores = new ArrayList<>();

    String user = "root";
    String pass = "root";
    String url = "jdbc:mysql://localhost:3306/sakila";

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url,user,pass);

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT a.actor_id, first_name, a.last_name, COUNT(f.film_id), COUNT(c.category_id)\n" +
                "FROM actor a, film f, film_actor fa, category c, film_category fc\n" +
                "WHERE a.actor_id = fa.actor_id AND f.film_id = fa.film_id AND f.film_id = fc.film_id AND c.category_id = fc.category_id AND\n" +
                "        (SELECT COUNT(f.film_id) FROM actor a, film f, film_actor fa, category c, film_category fc\n" +
                "         WHERE a.actor_id = fa.actor_id AND f.film_id = fa.film_id AND f.film_id = fc.film_id AND c.category_id = fc.category_id) > 20\n" +
                "GROUP BY a.actor_id\n" +
                "ORDER BY a.actor_id ASC");

        while (rs.next()){
            Actores actores = new Actores();
            actores.setId(rs.getInt(1));
            actores.setNombre(cambiarFormatoNombre(rs.getString(2)));
            actores.setApellido(cambiarFormatoNombre(rs.getString(3)));
            actores.setN_categorias(rs.getInt(4));
            actores.setN_peliculas(rs.getInt(5));
            listaActores.add(actores);
        }


    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
    }
    return listaActores;
}

    public String cambiarFormatoNombre(String palabra){
        String cadena;

        StringBuilder sb = new StringBuilder();
        char mayus  = palabra.charAt(0);
        sb.append(mayus);

        for(int i = 1; i < palabra.length(); i++){
            char letra  = palabra.charAt(i);
            sb.append(letra);
        }
        cadena = sb.toString();
        return cadena;
    }
}
