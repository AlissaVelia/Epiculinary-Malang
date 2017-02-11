package id.sch.smktelkom_mlg.project2.xirpl40306091734.epiculinarymalang.model;

import java.io.Serializable;

/**
 * Created by USER on 11/02/2017.
 */
public class food4 implements Serializable {
    public String judul;
    public String deskripsi;
    public String detail;
    public String lokasi;
    public String foto;

    public food4(String judul, String deskripsi, String detail, String lokasi, String foto) {
        this.judul = judul;
        this.deskripsi = deskripsi;
        this.detail = detail;
        this.lokasi = lokasi;
        this.foto = foto;
    }
}
