package com.example.xtypee;

public class ListData {
    private String dataTitle;
    private String dataTipo;
    private String dataDirec;
    private String dataTam;
    private String dataHabi;
    private String dataBanos;
    private String dataEs;
    private String dataDesc;
    private String dataLang;
    private String dataImage;
    private String key;
    public String getKey() {
        return key;
    }
    public void setKey(String key) {
        this.key = key;
    }
    public String getDataTitle() {
        return dataTitle;
    }
    public String getDataDesc() {
        return dataDesc;
    }
    public String getDataLang() {
        return dataLang;
    }
    public String getDataImage() {
        return dataImage;
    }
    public String getDataTipo() {
        return dataTipo;
    }
    public String getDataDirec() {
        return dataDirec;
    }
    public String getDataTam() {
        return dataTam;
    }
    public String getDataHabi() {
        return dataHabi;
    }
    public String getDataBanos() {
        return dataBanos;
    }
    public String getDataEs() {
        return dataEs;
    }

    public ListData(String dataTitle, String dataDesc, String dataLang, String dataImage, String dataTipo, String dataDirec, String dataTam, String dataHabi, String dataBanos, String dataEs) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
        this.dataTipo = dataTipo;
        this.dataDirec = dataDirec;
        this.dataTam = dataTam;
        this.dataHabi = dataHabi;
        this.dataBanos = dataBanos;
        this.dataEs = dataEs;
    }

    public ListData(){
    }
}
