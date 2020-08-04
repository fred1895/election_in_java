package application;

import java.util.Collections;
import java.util.List;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoEstadual;
import candidates.entities.CandidatesDeputadoFederal;
import candidates.entities.CandidatesGovernador;
import candidates.entities.CandidatesPresidente;
import candidates.entities.CandidatesSenador;
import enums.State;

public class UI {
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static void printEstadual(List<Candidates> cand, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoEstadual && c.getState() == State.valueOf(state)) {
				System.out.println(c);
			}
		}
	}
	public static void printFederal(List<Candidates> cand, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
				System.out.println(c);
			}
		}
	}
	public static void printSenador(List<Candidates> cand, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesSenador && c.getState() == State.valueOf(state)) {
				System.out.println(c);
			}
		}
	}
	public static void printGovernador(List<Candidates> cand, String state) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesGovernador && c.getState() == State.valueOf(state)) {
				System.out.println(c);
			}
		}
	}
	public static void printPresidente(List<Candidates> cand) {
		for (Candidates c : cand) {
			if(c instanceof CandidatesPresidente) {
				System.out.println(c);
			}
		}
	}
	
	public static void printEstadualVotes(List<Candidates> cand, Candidates c2, String state) {
		System.out.println();
		Collections.sort(cand);
		System.out.println("Deputados Estaduais");
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoEstadual && c.getState() == State.valueOf(state)) {
				System.out.println(c.getName() + ", " + c.getPoliticalParty() + " obteve " + c.getVote());
			}
		}
		System.out.println("Votos nulos: " + c2.getNullVote());
	}
	
	public static void printFederalVotes(List<Candidates> cand, Candidates c3, String state) {
		System.out.println();
		Collections.sort(cand);
		System.out.println("Deputados Federais");
		for (Candidates c : cand) {
			if(c instanceof CandidatesDeputadoFederal && c.getState() == State.valueOf(state)) {
				System.out.println(c.getName() + ", " + c.getPoliticalParty() + " obteve " + c.getVote());
			}
		}
		System.out.println("Votos nulos: " + c3.getNullVote());
	}
	
	public static void printSenadorVotes(List<Candidates> cand, Candidates c4, String state) {
		System.out.println();
		Collections.sort(cand);
		System.out.println("Senadores");
		for (Candidates c : cand) {
			if(c instanceof CandidatesSenador && c.getState() == State.valueOf(state)) {
				System.out.println(c.getName() + ", " + c.getPoliticalParty() + " obteve " + c.getVote());
			}
		}
		System.out.println("Votos nulos: " + c4.getNullVote());
	}
	
	public static void printGovernadorVotes(List<Candidates> cand, Candidates c5, String state) {
		System.out.println();
		Collections.sort(cand);
		System.out.println("Governadores");
		for (Candidates c : cand) {
			if(c instanceof CandidatesGovernador && c.getState() == State.valueOf(state)) {
				System.out.println(c.getName() + ", " + c.getPoliticalParty() + " obteve " + c.getVote());
			}
		}
		System.out.println("Votos nulos: " + c5.getNullVote());
	}
	
	public static void printPresidenteVotes(List<Candidates> cand, Candidates c6) {
		System.out.println();
		Collections.sort(cand);
		System.out.println("Presidente");
		for (Candidates c : cand) {
			if(c instanceof CandidatesPresidente) {
				System.out.println(c.getName() + ", " + c.getPoliticalParty() + " obteve " + c.getVote());
			}
		}
		System.out.println("Votos nulos: " + c6.getNullVote());
	}
}
