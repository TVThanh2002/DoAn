/**
 * 
 */
package ObjectDoiBong;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBKetNoi.DBConnect;
import GiaoDien.BangDau;
import GiaoDien.ChiTietBangDau;
import GiaoDien.GiaiDau;
import GiaoDien.TranDau;



public class XepHang {

	public XepHang() {}
	public static void XepHang(DBConnect dbconnect) {
		ArrayList<ObjectDB> doiBong = new ArrayList<ObjectDB>();
		ResultSet rs;
		try {
			rs = dbconnect.getStmt().executeQuery("SELECT ID,ten FROM XepHang WHERE bangDau ='"+BangDau.maBang+"'");
			while(rs.next()) {
				ObjectDB x = new ObjectDB();
				x.maDoi = rs.getString(1);
				x.tenDoi = rs.getString(2);
				doiBong.add(x);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		for(int i=0;i<doiBong.size();i++) {
			ObjectDB x = new ObjectDB();
			try {
				rs = dbconnect.getStmt().executeQuery("SELECT doi1, banthang1,doi2,banthang2,tinhtrang,BangDau,GiaiDau FROM TranDau WHERE tinhtrang=N'Đã thi đấu' AND BangDau='"+BangDau.tenBang+"' AND GiaiDau='"+GiaiDau.maGiai+"'");
				while(rs.next()) {					
					if(rs.getString(1).equals(doiBong.get(i).maDoi)) {
						String bt1 = rs.getString(2);
						String bt2 = rs.getString(4);
						int banthang = Integer.parseInt(bt1);
						int banthua = Integer.parseInt(bt2);
						x.soTran = x.soTran + 1;
						x.banThang = x.banThang + banthang;
						x.banThua = x.banThua + banthua;
						x.hieuSo =x.banThang - x.banThua;
						if(banthang>banthua) {
							x.thang = x.thang + 1;
							x.diem = x.diem +3;
						}
						else if (banthang==banthua){
							x.hoa = x.hoa + 1;
							x.diem = x.diem+1;
						}
						else {
							x.thua = x.thua + 1;
						}
					}
					
					if(rs.getString(3).equals(doiBong.get(i).maDoi)) {
						String bt1 = rs.getString(2);
						String bt2 = rs.getString(4);
						int banthang = Integer.parseInt(bt2);
						int banthua = Integer.parseInt(bt1);
						x.soTran = x.soTran + 1;
						x.banThang = x.banThang + banthang;
						x.banThua = x.banThua + banthua;
						x.hieuSo =x.banThang - x.banThua;
						if(banthang>banthua) {
							x.thang = x.thang + 1;
							x.diem = x.diem +3;
						}
						else if (banthang==banthua){
							x.hoa = x.hoa + 1;
							x.diem = x.diem+1;
						}
						else {
							x.thua = x.thua + 1;
						}
					}
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x.maDoi = doiBong.get(i).maDoi;
			x.tenDoi = doiBong.get(i).tenDoi;
			doiBong.set(i, x);
			
		}
		
		try {
			dbconnect.getStmt().execute("DELETE FROM XepHang WHERE BangDau='"+BangDau.maBang+"'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<doiBong.size();i++) {
			try {
				dbconnect.getStmt().execute("INSERT INTO XepHang(ID,ten,soTran,thang,thua,hoa,soBanThang,soBanThua,hieuSo,diem,bangDau) VALUES('"+doiBong.get(i).maDoi+"','"+doiBong.get(i).tenDoi+
						"',"+doiBong.get(i).soTran+","+doiBong.get(i).thang+","+doiBong.get(i).thua+","+doiBong.get(i).hoa+","+doiBong.get(i).banThang+","+doiBong.get(i).banThua+","+doiBong.get(i).hieuSo+","+doiBong.get(i).diem+",'"+BangDau.maBang+"')");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			rs = dbconnect.getStmt().executeQuery("SELECT ten,soTran,thang,thua,hoa,soBanThang,soBanThua,hieuSo,diem FROM XepHang WHERE BangDau='"+BangDau.maBang+"'ORDER BY diem DESC,hieuSo DESC");
			int i=1;
			ChiTietBangDau.modelChiTiet.setNumRows(0);
			while(rs.next()) {
				String s = Integer.toString(i);
				ChiTietBangDau.modelChiTiet.addRow(new String[] {s,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
 