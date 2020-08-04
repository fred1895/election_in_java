package voting.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoFederal;
import enums.State;

public class VotingFederal implements Voting {

	@Override
	public void saveVote(List<Candidates> cand, Candidates c3, int number, String state) {
		Candidates voted = null;
		for (Candidates c : cand) {
			if (c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
				if (c.getNumber() == number) {
					voted = c;
					System.out.printf("Seu voto: %s %n ", voted);
					voted.addVote();
				}
			}
		}
		
		if (voted == null) {
			System.out.println("Voto nulo ");
			c3.addNullVote();
		}
	}

	@Override
	public void saveVote(List<Candidates> cand, Candidates c, int number) {
		// TODO Auto-generated method stub

	}

}
