package cn.edu.nju.userstorymappingtool.entity;

public class MapCode {
	
	private Long userid;
	private Long mapid;
	private String code;
	
	public MapCode(Long userid, Long mapid, String code) {
		super();
		this.userid = userid;
		this.mapid = mapid;
		this.code = code;
	}

	/**
	 * @return the userid
	 */
	public Long getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(Long userid) {
		this.userid = userid;
	}

	/**
	 * @return the mapid
	 */
	public Long getMapid() {
		return mapid;
	}

	/**
	 * @param mapid the mapid to set
	 */
	public void setMapid(Long mapid) {
		this.mapid = mapid;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	
}
