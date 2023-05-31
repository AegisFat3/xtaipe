package com.example.xtypee;

public class ListData {
    private String dataTitle;
    private String dataTipo;
    private String dataDirec;
    private String dataTam;
    private String dataHabi;
    private String dataBanos;
    private String dataEs;
    private String dataLang;
    private String dataDesc;
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
    public String getDataLang() {
        return dataLang;
    }
    public String getDataDesc() {
        return dataDesc;
    }
    public String getDataImage() {
        return dataImage;
    }


    public ListData(String dataTitle, String dataTipo, String dataDirec, String dataTam, String dataHabi, String dataBanos, String dataEs, String dataLang, String dataDesc, String dataImage) {
        this.dataTitle = dataTitle;
        this.dataTipo = dataTipo;
        this.dataDirec = dataDirec;
        this.dataTam = dataTam;
        this.dataHabi = dataHabi;
        this.dataBanos = dataBanos;
        this.dataEs = dataEs;
        this.dataLang = dataLang;
        this.dataDesc = dataDesc;
        this.dataImage = dataImage;

    }

    public ListData(){
    }
}
