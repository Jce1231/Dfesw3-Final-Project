package uk.jordanellis.domain;

public interface Stats {
	int intel;
	int str;
	int dex;
	int con;
	int health;
	int maxHealth;
	int speed;

	public void attack();

	public void defend();

	public boolean checkStats();
}
