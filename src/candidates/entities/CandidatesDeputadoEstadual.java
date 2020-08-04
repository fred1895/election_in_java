package candidates.entities;

import enums.State;

public class CandidatesDeputadoEstadual extends Candidates {
	public CandidatesDeputadoEstadual() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CandidatesDeputadoEstadual(String name, String politicalParty, Integer number) {
		super(name, politicalParty, number);
		// TODO Auto-generated constructor stub
	}
	
	public CandidatesDeputadoEstadual(String name, String politicalParty, Integer number, State state) {
		super(name, politicalParty, number, state);
		// TODO Auto-generated constructor stub
	}
}
