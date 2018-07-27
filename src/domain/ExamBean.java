package domain;

import lombok.Data;

@Data 
public class ExamBean {
	private String examSeq,subSeq,recodeSeq,month,score,memId;

	@Override
	public String toString() {
		return "ExamBean [examSeq=" + examSeq + ", subSeq=" + subSeq + ", recodeSeq=" + recodeSeq + ", month=" + month
				+ ", score=" + score + ", memId=" + memId + "]";
	}
	
	
}