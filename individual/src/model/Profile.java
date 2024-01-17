package model;

public class Profile {
	private int id;//コメントID
	private String userName;//ユーザー名
	private String qtype;//種類
	private String food;
	private String store;//店舗名
	private String coment;//感想


	public Profile(int id, String userName, String qtype, String food,String store, String coment) {
		this.id = id;
		this.userName = userName;
		this.qtype = qtype;
		this.food = food;
		this.store = store;
		this.coment = coment;

	}

	public Profile(int id, String qtype, String food,String store, String coment) {
		this.id = id;
		this.qtype = qtype;
		this.food = food;
		this.store = store;
		this.coment = coment;

	}

	public int getId() {return id;}
	public String getUserName() {return userName;}
	public String getQtype() {return qtype;}
	public String getStore() {return store;}
	public String getComent() {return coment;}
	public String getFood() {return food;}
}
