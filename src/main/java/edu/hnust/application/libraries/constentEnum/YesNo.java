package edu.hnust.application.libraries.constentEnum;

public enum YesNo {
	YES(1),
	NO(0);
	
	private int yesOrNo;
	
	public int getYesOrNo() {
		return yesOrNo;
	}

	private YesNo(int yesOrNo) {
		this.yesOrNo = yesOrNo;
	}
}
