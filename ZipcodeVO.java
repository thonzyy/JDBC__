package day0817;

public class ZipcodeVO {
	private String zipcode,sido,gugun,dong,bunji	;
	
	public ZipcodeVO () {
		
	}

	/**
	 * @return the zipcod
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @param zipcod the zipcod to set
	 */
	public void setZipcode(String zipcod) {
		this.zipcode = zipcod;
	}

	/**
	 * @return the sido
	 */
	public String getSido() {
		return sido;
	}

	/**
	 * @param sido the sido to set
	 */
	public void setSido(String sido) {
		this.sido = sido;
	}

	/**
	 * @return the gugun
	 */
	public String getGugun() {
		return gugun;
	}

	/**
	 * @param gugun the gugun to set
	 */
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}

	/**
	 * @return the dong
	 */
	public String getDong() {
		return dong;
	}

	/**
	 * @param dong the dong to set
	 */
	public void setDong(String dong) {
		this.dong = dong;
	}

	/**
	 * @return the bunji
	 */
	public String getBunji() {
		return bunji;
	}

	/**
	 * @param bunji the bunji to set
	 */
	public void setBunji(String bunji) {
		this.bunji = bunji;
	}

	@Override
	public String toString() {
		return "ZipcodeVO [zipcod=" + zipcode + ", sido=" + sido + ", gugun=" + gugun + ", dong=" + dong + ", bunji="
				+ bunji + "]";
	}

	public ZipcodeVO(String zipcod, String sido, String gugun, String dong, String bunji) {
		super();
		this.zipcode = zipcod;
		this.sido = sido;
		this.gugun = gugun;
		this.dong = dong;
		this.bunji = bunji;
	}

	
}


