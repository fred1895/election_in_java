package voting.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesPresidente;

public class VotingPresidente implements Voting {

	@Override
	public void saveVote(List<Candidates> cand, Candidates c, int number, String state) {
		
	}

	@Override
	public void saveVote(List<Candidates> cand, Candidates c6, int number) {
		Candidates voted = null;
		for (Candidates c : cand) {
			if (c instanceof CandidatesPresidente) {
				if (c.getNumber() == number) {
					voted = c;
					System.out.printf("Seu voto: %s %n ", voted);
					voted.addVote();
				}
			}
		}
		
		if (voted == null) {
			System.out.println("Voto nulo ");
			c6.addNullVote();
		}

	}

}
