package com.example.xtypee;

public class HelperClass {

    String nombrei, correoi, usuarioi, contrasenai, nacimi, telefonoi;

    public HelperClass(String nombrei, String correoi, String usuarioi, String contrasenai, String nacimi, String telefonoi) {
        this.nombrei = nombrei;
        this.correoi = correoi;
        this.usuarioi = usuarioi;
        this.contrasenai = contrasenai;
        this.nacimi = nacimi;
        this.telefonoi = telefonoi;
    }

    public String getNombrei() {
        return nombrei;
    }

    public void setNombrei(String nombrei) {
        this.nombrei = nombrei;
    }

    public String getCorreoi() {
        return correoi;
    }

    public void setCorreoi(String correoi) {
        this.correoi = correoi;
    }

    public String getUsuarioi() {
        return usuarioi;
    }

    public void setUsuarioi(String usuarioi) {
        this.usuarioi = usuarioi;
    }

    public String getContrasenai() {
        return contrasenai;
    }

    public void setContrasenai(String contrasenai) {
        this.contrasenai = contrasenai;
    }

    public String getNacimi() {
        return nacimi;
    }

    public void setNacimi(String nacimi) {
        this.nacimi = nacimi;
    }

    public String getTelefonoi() {
        return telefonoi;
    }

    public void setTelefonoi(String telefonoi) {
        this.contrasenai = telefonoi;
    }

    public HelperClass() {
    }
}
