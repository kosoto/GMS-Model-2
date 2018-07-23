package domain;

import lombok.Data;

@Data
public class SubjectBean {	
	private String subSeq,subName;

	@Override
	public String toString() {
		return "SubjectBean [subSeq=" + subSeq + ", subName=" + subName + "]";
	}
	
}
