package candidates.services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesPresidente;

public class WritePresident implements WriteVotes {
	@Override
	public void writing(List<Candidates> cand, String state, BufferedWriter bw) {
	}

	@Override
	public void writing(List<Candidates> cand, BufferedWriter bw) {
		for (Candidates c : cand) {
			if (c instanceof CandidatesPresidente) {
				try {
					bw.write(c + " obeteve " + c.getVote() + " votos");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					bw.newLine();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
