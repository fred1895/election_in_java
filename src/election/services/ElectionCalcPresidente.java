package election.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesPresidente;
import voter.entities.Voter;

public class ElectionCalcPresidente implements ElectionCalc {

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c2, String state) {
		
	}

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c6) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesPresidente) {
				Double porcent = (double) (100 * c.getVote() / (voters.size() - c6.getNullVote()));
				c.setPorcent(porcent);
			}
		}
		
	}
}
