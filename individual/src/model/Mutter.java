package model;

//import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Mutter implements Serializable {
	private int id;//コメントID
	private String userName;//ユーザー名
	private String qtype;//種類
	private String store;//店舗名
	private String memo;//感想
	private String star;//評価
	private String time;//時刻
	private int userId;//ユーザーID

	public Mutter(){}
	public Mutter(String userName, String qtype, String store, String memo, String star, String time, int userId) {
		this.userName = userName;
		this.store = store;
		this.qtype = qtype;
		this.memo = memo;
		this.star = star;
		this.time = time;
		this.userId = userId;
	}
	public Mutter(int id, String userName, String qtype, String store, String memo, String star, String time, int userId) {
		this.id = id;
		this.userName = userName;
		this.store = store;
		this.qtype = qtype;
		this.memo = memo;
		this.star = star;
		this.time = time;
		this.userId = userId;

	}
	public Mutter(int id) {
		this.id = id;
	}

	public int getId() {return id;}
	public String getUserName() {return userName;}
	public String getQtype() {return qtype;}
	public String getStore() {return store;}
	public String getMemo() {return memo;}
	public String getStar() {return star;}
	public String getTime() {return time;}
	public int getUserId() {return userId;}

}
