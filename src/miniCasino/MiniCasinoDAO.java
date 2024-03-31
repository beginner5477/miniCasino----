package miniCasino;

public class MiniCasinoDAO extends DBConn{
	private String sql = "";
	private MiniCasinoVO vo = new MiniCasinoVO();
	
	public int getLoginInfo(String id, String password) {
		int res = 0;
		try {
			sql = "select * from cstInfo where id = ? && password = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				res = 1;
			}
			else res = 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		
		return res;
	}

	public int getCashInfo(String id) {
		int cash = 0;
		try {
			sql = "select cash from cstInfo where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				cash = rs.getInt("cash");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return cash;
	}
	
}
