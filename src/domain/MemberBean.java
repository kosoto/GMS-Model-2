package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String memberId,teamId,name,ssn,roll,pass,age,gender,subject;

	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", teamId=" + teamId + ", name=" + name + ", ssn=" + ssn + ", roll="
				+ roll + ", pass=" + pass + ", age=" + age + ", gender=" + gender + ", subject=" + subject + "]";
	}
}
