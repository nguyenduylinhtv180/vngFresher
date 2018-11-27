import java.util.Date;
import java.lang.String;
public class Information {


    private String id;
    private String content;
    private long created_date;
    private String created_by;
    private long lastupdated_date;
    private String lastupdated_by;

    // Constructor mặc định này là bắt buộc nếu có thêm cấu tử khác.
    public Information() {

    }

    public Information(String id, String content, long created_date,String created_by,long lastupdated_date, String lastupdated_by) {
        this.id = id;
        this.content = content;
        this.created_date = created_date;
        this.created_by =created_by;
        this.lastupdated_date= lastupdated_date;
        this.lastupdated_by=lastupdated_by;

    }

    public String getId() {
        return id;
    }

    public void setEmpNo(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content,String lastupdated_by) {
        this.content = content;
        this.lastupdated_by=lastupdated_by;
        this.lastupdated_date= new Date().getTime();
    }

    public long getCreated_date() {
        return created_date;
    }

    public void setCreate_date(long create_date) {
        this.created_date = create_date;
    }
    public String getCreated_by() {
        return created_by;
    }

    public void setCreate_by(String create_by) {
        this.created_by = create_by;
    }
    public String getLastupdated_by() {
        return lastupdated_by;
    }

    public void setLastupdated_by(String lastupdated_by) {
        this.lastupdated_by = lastupdated_by;
    }
    public long getLastupdated_date() {
        return lastupdated_date;
    }

    public void setLastupdated_date(long lastupdated_date) {
        this.lastupdated_date = lastupdated_date;
    }

}
