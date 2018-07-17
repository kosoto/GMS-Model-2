package domain;

public class ExamBean {
	private String examSeq,subSeq,recodeSeq,month,score,memId;
	public String getExamSeq() {
		return examSeq;
	}
	public void setExamSeq(String examSeq) {
		this.examSeq = examSeq;
	}
	public String getSubSeq() {
		return subSeq;
	}
	public void setSubSeq(String subSeq) {
		this.subSeq = subSeq;
	}
	@Override
	public String toString() {
		return "ExamBean [examSeq=" + examSeq + ", subSeq=" + subSeq + ", recodeSeq=" + recodeSeq + ", month=" + month
				+ ", score=" + score + ", memId=" + memId + "]";
	}
	public String getRecodeSeq() {
		return recodeSeq;
	}
	public void setRecodeSeq(String recodeSeq) {
		this.recodeSeq = recodeSeq;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	
	
	
}