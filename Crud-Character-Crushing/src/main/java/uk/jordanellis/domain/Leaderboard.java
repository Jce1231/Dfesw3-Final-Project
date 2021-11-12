package uk.jordanellis.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "leaderboard")
@NoArgsConstructor
public class Leaderboard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "leaderboard_id")
	private int lbID;
	@OneToOne
	@JoinColumn(name = "charact_id")
	private Charact attacker;
	private int wins;
	private int losses;

	public void addWin() {
		this.wins += 1;
	}

	public void addLoss() {
		this.losses += 1;
	}

	/**
	 * @param attacker
	 * @param wins
	 * @param losses
	 */
	public Leaderboard(Charact attacker, int wins, int losses) {
		super();
		this.attacker = attacker;
		this.wins = wins;
		this.losses = losses;
	}
}
