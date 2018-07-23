package domain;

import lombok.Data;

@Data
public class MemberBean {
	private String memberId,TeamId,name,ssn,roll,pass,age;

	@Override
	public String toString() {
		return "MemberBean [memberId=" + memberId + ", TeamId=" + TeamId + ", name=" + name + ", ssn=" + ssn + ", roll="
				+ roll + ", pass=" + pass + ", age=" + age + "]";
	}
	
}
