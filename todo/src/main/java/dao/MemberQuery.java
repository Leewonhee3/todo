package dao;

public class MemberQuery {
	
	public static final String LOGIN;
	public static final String DELETE_MEMBER;
	public static final String ADMIN_LOGIN;
	
	static {
		
		LOGIN = "SELECT member_id memberId FROM member WHERE member_id=? AND member_pw =?";
		DELETE_MEMBER = "DELETE FROM member WHERE member_id=? AND member_pw=?";
		ADMIN_LOGIN = "SELECT admin_id adminId, create_date createDate, update_date updateDate FROM admin WHERE admin_id=? AND admin_pw =?";
		
	}
	
}
