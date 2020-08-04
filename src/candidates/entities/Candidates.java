package candidates.entities;

import enums.State;
import exceptions.CandidatesException;


public abstract class Candidates implements Comparable<Candidates> {
	private String name;
	private String politicalParty;
	private Integer number;
	private State state;
	private Integer votes;
	private Integer nullVotes;
	private Double porcent;
	
	public Candidates () {
		this.nullVotes = 0;
	}

	public Candidates(String name, String politicalParty, Integer number, State state) {
		this.name = name;
		this.politicalParty = politicalParty;
		this.number = number;
		if (state.toString() != "RJ" && state.toString() != "SP" && state.toString() != "MG" && state.toString() != "ES") {
			throw new CandidatesException("Informe um estado válido: ");
		}
		this.state = state;
		this.votes = 0;
		this.nullVotes = 0;
		this.porcent = 0.0;
	}
	
	
	public Candidates(String name, String politicalParty, Integer number) {
		this.name = name;
		this.politicalParty = politicalParty;
		this.number = number;
		this.votes = 0;
		this.nullVotes = 0;
		this.porcent = 0.0;
	}

	public Double getPorcent() {
		return porcent;
	}

	public void setPorcent(Double porcent) {
		this.porcent = porcent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPoliticalParty() {
		return politicalParty;
	}

	public void setPoliticalParty(String politicalParty) {
		this.politicalParty = politicalParty;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	
	public Integer getVote() {
		return votes;
	}
	
	public Integer getNullVote() {
		return nullVotes;
	}
	
	public void addVote() {
		votes ++;
	}
	
	public void addNullVote() {
		nullVotes ++;
	}
	
	public void vote(int number, Candidates c) {
		if (c.getNumber() == number) {
				c.addVote();
			}
	}
	
	public int compareTo(Candidates o) {
		return - this.votes.compareTo(o.getVote());
	}

	@Override
	public String toString() {
		return "Candidato: " + name + ", " + politicalParty + ", " + number + ", "
				+ state;
	}
	
	
}
