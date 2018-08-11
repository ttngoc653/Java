import javax.swing.DefaultListModel;

public class Thoai {
	private String user_name;
	private DefaultListModel<String> list_messenger;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public DefaultListModel<String> getList_messenger() {
		return list_messenger;
	}
	public void setList_messenger(DefaultListModel<String> list_messenger) {
		this.list_messenger = list_messenger;
	}
}
