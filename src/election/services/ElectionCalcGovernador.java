package election.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesGovernador;
import enums.State;
import voter.entities.Voter;

public class ElectionCalcGovernador implements ElectionCalc {

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c5, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesGovernador && c.getState() == State.valueOf(state)) {
				Double porcent = (double) (100 * c.getVote() / (voters.size() - c5.getNullVote()));
				c.setPorcent(porcent);
			}
		}
	}
	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c) {
		// TODO Auto-generated method stub
		
	}
}
