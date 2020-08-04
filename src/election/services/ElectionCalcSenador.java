package election.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesSenador;
import enums.State;
import voter.entities.Voter;

public class ElectionCalcSenador implements ElectionCalc {

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c4, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesSenador && c.getState() == State.valueOf(state)) {
				Double porcent = (double) (100 * c.getVote() / (voters.size() - c4.getNullVote()));
				c.setPorcent(porcent);
			}
		}
	}
	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c) {
		// TODO Auto-generated method stub
		
	}
}
