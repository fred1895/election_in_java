package election.services;

import java.util.List;

import candidates.entities.Candidates;
import voter.entities.Voter;

public interface ElectionCalc {
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c, String state);
	public void porcentage(List<Voter> voters, List<Candidates> cand, Candidates c);
}
