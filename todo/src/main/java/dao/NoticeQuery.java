package dao;

public class NoticeQuery {
	
	public static final String SELECT_NOTICE_LIST="SELECT notice_no noticeNo, notice_title noticeTitle, create_date createDate, update_date updateDate FROM notice ORDER BY createDate DESC LIMIT 0,5";
	
}
