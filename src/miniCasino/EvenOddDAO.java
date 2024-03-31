package miniCasino;

public class EvenOddDAO extends DBConn{
	private String sql = "";
	private MiniCasinoVO vo = null;
	public MiniCasinoVO getInfo(String id) {
		sql = "";
		vo = new MiniCasinoVO();
		try {
			sql = "select * from cstInfo where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setId(rs.getString("id"));
				vo.setPassword(rs.getString("password"));
				vo.setCash(rs.getInt("cash"));
				vo.setPayed(rs.getInt("payed"));
				vo.setGrade(rs.getString("grade"));
				vo.setDiscnt(getDiscnt(rs.getString("id")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return vo;
	}

	public void setUpdate(String id,int money, int betting) {
		try {
			sql = "update cstInfo set cash = ?, payed = payed + ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setInt(2, betting);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
			setUpdateGrade(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
	}
	
	
	private void setUpdateGrade(String id) {
		try {
			String grade = "";
			vo = getInfo(id);
			if(vo.getPayed() > 1000000) grade = "SSS";
			else if(vo.getPayed() > 500000) grade = "SS";
			else if(vo.getPayed() > 200000) grade = "S";
			else grade = "A";
			sql = "update cstInfo set grade = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, grade);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pstmtClose();
		}
	}

	public double getDiscnt(String id) {
		double discnt = 0;
		try {
			sql = "select c.grade as grade , l.discnt as discnt from cstInfo c, level l where c.grade = l.grade && c.id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				discnt = rs.getDouble("discnt");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			rsClose();
		}
		return discnt;
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
