package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import candidates.entities.Candidates;
import candidates.entities.CandidatesDeputadoEstadual;
import candidates.entities.CandidatesDeputadoFederal;
import candidates.entities.CandidatesGovernador;
import candidates.entities.CandidatesPresidente;
import candidates.entities.CandidatesSenador;
import candidates.services.WriteEstadual;
import candidates.services.WriteFederal;
import candidates.services.WriteGovernador;
import candidates.services.WritePresident;
import candidates.services.WriteSenador;
import candidates.services.WriteVotes;
import election.services.Election;
import election.services.ElectionCalc;
import election.services.ElectionCalcEstadual;
import election.services.ElectionCalcFederal;
import election.services.ElectionCalcGovernador;
import election.services.ElectionCalcPresidente;
import election.services.ElectionCalcSenador;
import enums.State;
import exceptions.CandidatesException;
import voter.entities.Voter;
import voting.services.Voting;
import voting.services.VotingEstadual;
import voting.services.VotingFederal;
import voting.services.VotingGovernador;
import voting.services.VotingPresidente;
import voting.services.VotingSenador;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.getDefault();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		List<Voter> voter = new ArrayList<>();
		List<Candidates> cand = new ArrayList<>();
		Candidates c2 = new CandidatesDeputadoEstadual();
		Candidates c3 = new CandidatesDeputadoFederal();
		Candidates c4 = new CandidatesSenador();
		Candidates c5 = new CandidatesGovernador();
		Candidates c6 = new CandidatesPresidente();
		String path = "E:\\temp\\elections";
		String targetFolder = "E:\\temp\\elections\\votings";
		Date today = Calendar.getInstance().getTime();
		String todayAsString = sdf.format(today);
		char resp = 's';
		try {
			try(BufferedReader br1 = new BufferedReader(new FileReader(path + "\\candidatesDeputadoEstadual.csv"))) {
				String candidateLine = br1.readLine();
				while (candidateLine != null) {
					String [] field = candidateLine.split(",");
					String name = field[0];
					String politicalParty = field[1];
					Integer number = Integer.parseInt(field[2]);
					String state = field[3];
					cand.add(new CandidatesDeputadoEstadual(name, politicalParty, number, State.valueOf(state)));
					candidateLine = br1.readLine();
				} 
			}
			try(BufferedReader br1 = new BufferedReader(new FileReader(path + "\\candidatesDeputadoFederal.csv"))){
				String candidateLine = br1.readLine();
				while (candidateLine != null) {
					String [] field = candidateLine.split(",");
					String name = field[0];
					String politicalParty = field[1];
					Integer number = Integer.parseInt(field[2]);
					String state = field[3];
					cand.add(new CandidatesDeputadoFederal(name, politicalParty, number, State.valueOf(state)));
					candidateLine = br1.readLine();
				} 
			}
			try(BufferedReader br1 = new BufferedReader(new FileReader(path + "\\candidatesSenador.csv"))){
				String candidateLine = br1.readLine();
				while (candidateLine != null) {
					String [] field = candidateLine.split(",");
					String name = field[0];
					String politicalParty = field[1];
					Integer number = Integer.parseInt(field[2]);
					String state = field[3];
					cand.add(new CandidatesSenador(name, politicalParty, number, State.valueOf(state)));
					candidateLine = br1.readLine();
				} 
			}
			try(BufferedReader br1 = new BufferedReader(new FileReader(path + "\\candidatesGovernador.csv"))){
				String candidateLine = br1.readLine();
				while (candidateLine != null) {
					String [] field = candidateLine.split(",");
					String name = field[0];
					String politicalParty = field[1];
					Integer number = Integer.parseInt(field[2]);
					String state = field[3];
					cand.add(new CandidatesGovernador(name, politicalParty, number, State.valueOf(state)));
					candidateLine = br1.readLine();
				} 
			}
			try(BufferedReader br1 = new BufferedReader(new FileReader(path + "\\candidatesPresidente.csv"))){
				String candidateLine = br1.readLine();
				while (candidateLine != null) {
					String [] field = candidateLine.split(",");
					String name = field[0];
					String politicalParty = field[1];
					Integer number = Integer.parseInt(field[2]);
					cand.add(new CandidatesPresidente(name, politicalParty, number));
					candidateLine = br1.readLine();
				} 
			}
			
			System.out.println("ELECTION"); 
			System.out.print("Qual seu estado? ");
			String state = sc.next();
			
			do {
				System.out.println("Digite o número de seu título de eleitor: ");
				int voterNumber = sc.nextInt();
				voter.add(new Voter(voterNumber));
				
				System.out.println("Deputados estaduais: ");
				UI.printEstadual(cand, state);
				System.out.println("VOTO: ");
				int number = sc.nextInt();
				Voting vote = new VotingEstadual();
				vote.saveVote(cand, c2, number, state);
				System.out.println("Digite 'OK' para continuar votando.");
				sc.next();
				UI.clearScreen();
				
				System.out.println("Deputados federais: ");
				UI.printFederal(cand, state);
				System.out.println("VOTO: ");
				number = sc.nextInt();
				vote = new VotingFederal();
				vote.saveVote(cand, c3, number, state);
				System.out.println("Digite 'OK' para continuar votando.");
				sc.next();
				UI.clearScreen();
				
				System.out.println("Senadores: ");
				UI.printSenador(cand, state);
				System.out.println("Qual seu voto? ");
				number = sc.nextInt();
				vote = new VotingSenador();
				vote.saveVote(cand, c4, number, state);
				System.out.println("Digite 'OK' para continuar votando.");
				sc.next();
				UI.clearScreen();
				
				System.out.println("Governadores: ");
				UI.printGovernador(cand, state);
				System.out.println("Qual seu voto? ");
				number = sc.nextInt();
				vote = new VotingGovernador();
				vote.saveVote(cand, c5, number, state);
				System.out.println("Digite 'OK' para continuar votando.");
				sc.next();
				UI.clearScreen();
				
				System.out.println("Presidente: ");
				UI.printPresidente(cand);
				System.out.println("Qual seu voto? ");
				number = sc.nextInt();
				vote = new VotingPresidente();
				vote.saveVote(cand, c6, number);
				
				System.out.println("Continuar votando?(s/n) ");
				resp = sc.next().charAt(0);
				UI.clearScreen();
			} while (resp == 's' || resp == 'S');
			Collections.sort(cand);
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFolder +"\\election_on_"+ todayAsString +"_"+state.toString()+".txt"))){
				WriteVotes wv = new WriteEstadual();
				wv.writing(cand, state, bw);
				
				WriteVotes wv2 = new WriteFederal();
				wv2.writing(cand, state, bw);
				
				WriteVotes wv3 = new WriteSenador();
				wv3.writing(cand, state, bw);
				
				WriteVotes wv4 = new WriteGovernador();
				wv4.writing(cand, state, bw);
				
				WriteVotes wv5 = new WritePresident();
				wv5.writing(cand, bw);
			}
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(targetFolder +"\\election_on_"+ todayAsString +"_"+state.toString()+"_PORCENTAGE.txt"))){
				ElectionCalc ec = new ElectionCalcEstadual();
				Election el = new Election(ec);
				el.processElection(cand, voter, bw, state);
				
				ec = new ElectionCalcFederal();
				el = new Election(ec);
				el.processElection(cand, voter, bw, state);
				
				ec = new ElectionCalcSenador();
				el = new Election(ec);
				el.processElection(cand, voter, bw, state);
				
				ec = new ElectionCalcGovernador();
				el = new Election(ec);
				el.processElection(cand, voter, bw, state);
				
				ec = new ElectionCalcPresidente();
				el = new Election(ec);
				el.processElection(cand, voter, bw, "RJ");
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		} catch (InputMismatchException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		} catch (CandidatesException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		} catch(RuntimeException e) {
			System.out.println(e.getMessage());
			sc.nextLine();
		}
		finally {
			sc.close();
		}
		
	}

}
