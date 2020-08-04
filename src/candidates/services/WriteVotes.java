package candidates.services;

import java.io.BufferedWriter;
import java.util.List;

import candidates.entities.Candidates;

public interface WriteVotes {
	public void writing(List<Candidates> cand, String state, BufferedWriter bw);
	public void writing(List<Candidates> cand, BufferedWriter bw);
}
