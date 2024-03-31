package miniCasino;

public class MiniCasinoVO {
	private int idx;
	private String name;
	private String id;
	private String password;
	private int cash;
	private int payed;
	private String grade;
	
	private double discnt;

	@Override
	public String toString() {
		return "MiniCasinoVO [idx=" + idx + ", name=" + name + ", id=" + id + ", password=" + password + ", cash="
				+ cash + ", payed=" + payed + ", grade=" + grade + ", discnt=" + discnt + ", getIdx()=" + getIdx()
				+ ", getName()=" + getName() + ", getId()=" + getId() + ", getPassword()=" + getPassword()
				+ ", getCash()=" + getCash() + ", getPayed()=" + getPayed() + ", getGrade()=" + getGrade()
				+ ", getDiscnt()=" + getDiscnt() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}

	public int getPayed() {
		return payed;
	}

	public void setPayed(int payed) {
		this.payed = payed;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getDiscnt() {
		return discnt;
	}

	public void setDiscnt(double discnt) {
		this.discnt = discnt;
	}
}
