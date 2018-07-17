package domain;

public class RecodeBean {
	private String recodeSeq, sum, avg,grade;

	public String getRecodeSeq() {
		return recodeSeq;
	}

	public void setRecodeSeq(String recodeSeq) {
		this.recodeSeq = recodeSeq;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "RecodeBean [recodeSeq=" + recodeSeq + ", sum=" + sum + ", avg=" + avg + ", grade=" + grade + "]";
	}
	
}
