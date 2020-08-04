package exceptions;

public class CandidatesException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public CandidatesException (String msg) {
		super(msg);
	}
}
