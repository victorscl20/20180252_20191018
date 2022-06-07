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
        ResultSet rs = stmt.executeQuery("");

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
