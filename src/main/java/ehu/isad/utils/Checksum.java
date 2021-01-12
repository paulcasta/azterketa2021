package ehu.isad.utils;

public class Checksum {
    private int idCMS;
    private String version;
    private String md5;
    private int path;

    public Checksum(int idCMS, String version, String md5, int path) {
        this.idCMS = idCMS;
        this.version = version;
        this.md5 = md5;
        this.path = path;
    }

    public int getIdCMS() {
        return idCMS;
    }

    public void setIdCMS(int idCMS) {
        this.idCMS = idCMS;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public int getPath() {
        return path;
    }

    public void setPath(int path) {
        this.path = path;
    }
}
