/**
 * Created by Joss on 04/04/2017.
 */
public class ConnectDatabase {

    /**
     * user cua phpMyAdmin
     */
    public String u="root";

    /**
     * mat khau cua phpMyAdmin
     */
    public String p="";

    /**
     * ten vi trinh ket noi phpMyAdmin
     */
    public String j_d="com.mysql.cj.jdbc.Driver";

    /**.
     * cac tuy chinh de khong bi bao loi trong qua trinh chay code
     */
    public String option= "useSSL=false" +
            "&useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false" +
            "&serverTimezone=UTC";

    /**
     * ten duong dan de ket noi database
     */
    public String DB_URL = "jdbc:mysql://127.0.0.1:3306/deandb?" + option;
}

