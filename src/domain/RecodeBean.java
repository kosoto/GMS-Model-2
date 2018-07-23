package domain;

import lombok.Data;

@Data
public class RecodeBean {
	private String recodeSeq, sum, avg,grade;

	@Override
	public String toString() {
		return "RecodeBean [recodeSeq=" + recodeSeq + ", sum=" + sum + ", avg=" + avg + ", grade=" + grade + "]";
	}
	
}
