package fr.aubin.opiyou.domaine;

import java.math.BigInteger;

public class Youtuber {

	// attributs
	private int id;
	private String name;
	private String firstName;
	private String username;
	private String channelName;
	private BigInteger subCount;
	private String login;
	private String pass;
	private String linkChannel;

	public Youtuber(int id, String name, String firstName, String username, String channelName, BigInteger subCount,
			String login, String pass, String linkChannel) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.username = username;
		this.channelName = channelName;
		this.subCount = subCount;
		this.login = login;
		this.pass = pass;
		this.linkChannel = linkChannel;
	}

	public Youtuber(int id, String name, String firstName, String username, String channelName, String login,
			String pass, String linkChannel) {
		super();
		this.id = id;
		this.name = name;
		this.firstName = firstName;
		this.username = username;
		this.channelName = channelName;
		this.login = login;
		this.pass = pass;
		this.linkChannel = linkChannel;
	}

	public Youtuber(String name, String firstName, String username, String channelName, String login, String pass,
			String linkChannel) {
		super();
		this.name = name;
		this.firstName = firstName;
		this.username = username;
		this.channelName = channelName;
		this.login = login;
		this.pass = pass;
		this.linkChannel = linkChannel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public BigInteger getSubCount() {
		return subCount;
	}

	public void setSubCount(BigInteger subCount) {
		this.subCount = subCount;
	}

	public String getLinkChannel() {
		return linkChannel;
	}

	public void setLinkChannel(String linkChannel) {
		this.linkChannel = linkChannel;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Youtuber [id=" + id + ", name=" + name + ", firstName=" + firstName + ", username=" + username
				+ ", channelName=" + channelName + ", subCount=" + subCount + ", login=" + login + ", pass=" + pass
				+ ", linkChannel=" + linkChannel + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getFirstName()=" + getFirstName() + ", getUsername()=" + getUsername() + ", getChannelName()="
				+ getChannelName() + ", getSubCount()=" + getSubCount() + ", getLinkChannel()=" + getLinkChannel()
				+ ", getLogin()=" + getLogin() + ", getPass()=" + getPass() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
