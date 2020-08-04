package election.services;

import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoEstadual;
import enums.State;
import voter.entities.Voter;

public class ElectionCalcEstadual implements ElectionCalc {

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c2, String state) {
		for (Candidates c : cand) {
			if (c instanceof CandidatesDeputadoEstadual && c.getState() == State.valueOf(state)) {
				Double porcent = (double) (100 * c.getVote() / (voters.size() - c2.getNullVote()));
				c.setPorcent(porcent);
			}
		}
	}

	@Override
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c) {
		// TODO Auto-generated method stub

	}
}