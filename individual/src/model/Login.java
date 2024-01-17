package model;

public class Login {
	private int id;
	private String pass;//ユーザー名
	private String name;//パスワード

	public Login(String pass,String name) {
		this.pass = pass;
		this.name = name;
	}

	public Login(int id, String pass,String name) {
		this.id = id ;
		this.pass = pass;
		this.name = name;
	}

	public int getId() {return id;}
	public String getPass() {return pass;}
	public String getName() {return name;}

}
