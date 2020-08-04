package election.services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoEstadual;
import candidates.entities.CandidatesDeputadoFederal;
import candidates.entities.CandidatesGovernador;
import candidates.entities.CandidatesSenador;
import enums.State;
import voter.entities.Voter;

public class Election {
	private ElectionCalc ec;

	public Election(ElectionCalc ec) {
		this.ec = ec;
	}

	public ElectionCalc getEc() {
		return ec;
	}

	public void processElection(List<Candidates> cand, List<Voter> voters, BufferedWriter bw, String state) {
		try {
			bw.write("ELEIÇÃO");
			bw.newLine();
			bw.write("Deputados Estaduais:");
			for (Candidates c : cand) {
				if (c instanceof CandidatesDeputadoEstadual && c.getState() == State.valueOf(state)) {
					ec = new ElectionCalcEstadual();
					ec.porcentage(voters, cand, c, state);
					bw.write(c + " obeteve " + c.getPorcent() + "% de votos");
					bw.newLine();
				}
			}
			bw.newLine();
			bw.write("Deputados Federais:");
			for (Candidates c : cand) {
				if (c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
					ec = new ElectionCalcFederal();
					ec.porcentage(voters, cand, c, state);
					bw.write(c + " obeteve " + c.getPorcent() + "% de votos");
					bw.newLine();
				}
			}
			bw.newLine();
			bw.write("Senadores:");
			for (Candidates c : cand) {
				if (c instanceof CandidatesSenador && c.getState() == State.valueOf(state)) {
					ec = new ElectionCalcSenador();
					ec.porcentage(voters, cand, c, state);
					bw.write(c + " obeteve " + c.getPorcent() + "% de votos");
					bw.newLine();
				}
			}
			bw.newLine();
			bw.write("Governadores:");
			for (Candidates c : cand) {
				if (c instanceof CandidatesGovernador && c.getState() == State.valueOf(state)) {
					ec = new ElectionCalcGovernador();
					ec.porcentage(voters, cand, c, state);
					bw.write(c + " obeteve " + c.getPorcent() + "% de votos");
					bw.newLine();
				}
			}
			bw.newLine();
			bw.write("Presidentes:");
			for (Candidates c : cand) {
				if (c instanceof CandidatesGovernador && c.getState() == State.valueOf(state)) {
					ec = new ElectionCalcPresidente();
					ec.porcentage(voters, cand, c);
					bw.write(c + " obeteve " + c.getPorcent() + "% de votos");
					bw.newLine();
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

	}
}
