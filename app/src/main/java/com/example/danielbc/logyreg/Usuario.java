package com.example.danielbc.logyreg;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.Parcel;


public class Usuario implements Parcelable {

    String userName;
    String nom;
    String cognoms;
    String email;
    String password;
    String telefono;

    public Usuario (){

    }


    public Usuario(String nom, String cognoms, String email, String telefono, String password, String userName) {

        this.userName = userName;
        this.nom = nom;
        this.cognoms = cognoms;
        this.email = email;
        this.password = password;
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelefon() {
        return telefono;
    }

    public void setTelefon(String telefon) {
        this.telefono = telefon;
    }

    protected Usuario(Parcel in) {
        userName= in.readString();//Aqui estaba el fallo
        nom = in.readString();
        cognoms = in.readString();
        email = in.readString();
        password = in.readString();
        telefono = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userName);
        dest.writeString(nom);
        dest.writeString(cognoms);
        dest.writeString(email);
        dest.writeString(password);
        dest.writeString(telefono);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}