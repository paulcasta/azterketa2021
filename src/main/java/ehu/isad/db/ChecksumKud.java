package ehu.isad.db;


import ehu.isad.utils.Checksum;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChecksumKud {
    private static final ChecksumKud instance = new ChecksumKud();

    public static  ChecksumKud getInstance() {
        return instance;
    }

    private ChecksumKud() { }

    public List<Checksum> lortuChecksum(){
        String query = "select idCMS, version, md5, path from checksums";
        DBKudeatzaile dbKudeatzaile = DBKudeatzaile.getInstantzia().getInstantzia().getInstantzia();
        ResultSet rs = dbKudeatzaile.execSQL(query);

        List<Checksum> emaitza = new ArrayList<>();
        try {
            while (rs.next()) {
                String md5 = rs.getString("md5");
                String version = rs.getString("version");
                int idCMS = rs.getInt("idCMS");
                int path = rs.getInt("path");


                emaitza.add(new Checksum(idCMS, version, md5, path));
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }
        return emaitza;

    }

    public boolean badago(String hash){
        String query = "select idCMS from checksums where md5 = '"+hash+"'";
        ResultSet rs = DBKudeatzaile.getInstantzia().execSQL(query);
        try{
            rs.next();
            if(rs.getInt("idCMS")==1) {
                return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
