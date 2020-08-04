package candidates.entities;

public class CandidatesPresidente extends Candidates {

	public CandidatesPresidente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidatesPresidente(String name, String politicalParty, Integer number) {
		super(name, politicalParty, number);
		// TODO Auto-generated constructor stub
	}
	public String toString() {
		return "Candidato: " + super.getName() + ", " + super.getPoliticalParty() + ", " + super.getNumber();
	}
}
