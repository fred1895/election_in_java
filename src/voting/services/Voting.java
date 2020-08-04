package voting.services;

import java.util.List;

import candidates.entities.Candidates;

public interface Voting {
	public void saveVote(List<Candidates> cand, Candidates c, int number, String state);
	public void saveVote(List<Candidates> cand, Candidates c, int number);
}
