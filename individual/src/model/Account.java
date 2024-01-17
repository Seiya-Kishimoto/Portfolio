package model;

public class Account {
	private int userId;//ユーザーID
	private String pass;//パスワード
	private String name;
	private String qtype;
	private String food;
	private String store;
	private String coment;

	public Account(int userId) {
		this.userId = userId;

	}

	public Account(String pass,String name) {
		this.pass = pass;
		this.name = name;

	}

	public Account(int userId, String pass,String name) {
		this.userId = userId;
		this.pass = pass;
		this.name = name;

	}

	public Account(int userId, String name,String qtype, String food, String store, String coment) {
		this.userId = userId;
		this.name = name;
		this.qtype = qtype;
		this.food = food;
		this.store = store;
		this.coment = coment;

	}


	public int getUserId() {return userId;}
	public String getPass() {return pass;}
	public String getName() {return name;}
	public String getQtype() {return qtype;}
	public String getFood() {return food;}
	public String getStore() {return store;}
	public String getComent() {return coment;}


}
