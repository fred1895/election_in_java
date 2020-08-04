package voting.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoEstadual;
import enums.State;
import exceptions.CandidatesException;

public class VotingEstadual implements Voting {

	@Override
	public void saveVote(List<Candidates> cand, Candidates c2, int number, String state) {
		Candidates voted = null;
		for (Candidates c : cand) {
			if (c instanceof CandidatesDeputadoEstadual && c.getState() == State.valueOf(state)) {
				if (c.getNumber() == number) {
					voted = c;
					System.out.printf("Seu voto: %s %n ", voted);
					voted.addVote();
				}
			}
		}
		
		if (voted == null) {
			System.out.println("Voto nulo ");
			c2.addNullVote();
		}
	}

	@Override
	public void saveVote(List<Candidates> cand, Candidates c, int number) {
		// TODO Auto-generated method stub

	}

}
