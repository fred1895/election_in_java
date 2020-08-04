package election.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoFederal;
import enums.State;
import voter.entities.Voter;

public class ElectionCalcFederal implements ElectionCalc {

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c3, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
				Double porcent = (double) (100 * c.getVote() / (voters.size() - c3.getNullVote()));
				c.setPorcent(porcent);
			}
		}
	}

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c) {
		// TODO Auto-generated method stub
		
	}
}
