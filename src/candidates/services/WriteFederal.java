package candidates.services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoFederal;
import enums.State;

public class WriteFederal implements WriteVotes {

	@Override
	public void writing(List<Candidates> cand, String state, BufferedWriter bw) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
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

	@Override
	public void writing(List<Candidates> cand, BufferedWriter bw) {
		// TODO Auto-generated method stub
		
	}

}
