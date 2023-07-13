package Object;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBKetNoi.DBConnect;
import GiaoDien1.PanelBangXepHang;
import GiaoDien1.PanelDoiBong;
import GiaoDien1.PanelLichThidau;

public class XepHang {
	public XepHang() {}
	public void XepHangDB(DBConnect dbconnect) {
		//Lay danh sach doi bong
				// TODO Auto-generated method stub
				ArrayList<DoiBong> dsDoiBong = new  ArrayList<DoiBong>();
				for(int i=0;i<PanelDoiBong.model.getRowCount();i++) {
					DoiBong x = new DoiBong();
					x.maDoiBong = (String) PanelDoiBong.model.getValueAt(i,0);
					dsDoiBong.add(x);
				}
				
				//cong diem cho cac doi bong
				for(int i=0;i<dsDoiBong.size();i++){
					DoiBong x = new DoiBong();
					for(int j=0;j<PanelLichThidau.model.getRowCount();j++){
						//duyet cac doi bong 1
						if(PanelLichThidau.model.getValueAt(j, 4).equals(dsDoiBong.get(i).maDoiBong)) {
							if(PanelLichThidau.model.getValueAt(j, 5)==null) continue;
							String s1 = PanelLichThidau.model.getValueAt(j, 5).toString();
							String s2 = PanelLichThidau.model.getValueAt(j, 6).toString();
							int sbthang = Integer.parseInt(s1);
							int sbthua = Integer.parseInt(s2);
							x.soTran = x.soTran + 1;
							x.banThang = x.banThang + sbthang;
							x.banThua = x.banThua + sbthua;
							x.hieuSo = x.hieuSo + x.banThang - x.banThua;
							if(sbthang>sbthua) {
								x.thang = x.thang + 1;
								x.diem = x.diem +3;
							}
							else if (sbthang==sbthua){
								x.hoa = x.hoa + 1;
								x.diem = x.diem+1;
							}
							else {
								x.thua = x.thua + 1;
							}
						}
						//duyet cac doi bong 2
						if(PanelLichThidau.model.getValueAt(j, 7).equals(dsDoiBong.get(i).maDoiBong)) {
							if(PanelLichThidau.model.getValueAt(j, 5)==null) continue;
							x.soTran = x.soTran + 1;
							String s1 = PanelLichThidau.model.getValueAt(j, 6).toString();
							String s2 = PanelLichThidau.model.getValueAt(j, 5).toString();
							int sbthang = Integer.parseInt(s1) ;
							int sbthua = Integer.parseInt(s2);
							x.banThang = x.banThang + sbthang;
							x.banThua = x.banThua + sbthua;
							x.hieuSo = x.hieuSo + sbthang - sbthua;

							if(sbthang > sbthua) {
								x.thang = x.thang + 1;
								x.diem = x.diem +3;
							}
							else if (sbthang == sbthua){
								x.hoa = x.hoa + 1;
								x.diem = x.diem+1;
							}
							else {
								x.thua = x.thua + 1;
							}
						}
					}
					x.maDoiBong = dsDoiBong.get(i).maDoiBong;
					dsDoiBong.set(i,x);	
				}
				
				
				
				try {
					//reset bxh
				dbconnect.getStmt().executeUpdate("DELETE FROM ["+PanelDoiBong.maGiai+"_Bảng xếp hạng];");
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				for(int i=0;i<dsDoiBong.size();i++) {
					int j=i+1;
					try {
						//cap nhat bxh trong database
								
						dbconnect.getStmt().execute("INSERT INTO ["+PanelDoiBong.maGiai+"_Bảng xếp hạng] VALUES(N'"+dsDoiBong.get(i).maDoiBong+"','"+dsDoiBong.get(i).soTran+"','"+dsDoiBong.get(i).thang+"','"+dsDoiBong.get(i).hoa+"','"+dsDoiBong.get(i).thua+"','"+dsDoiBong.get(i).banThang+"','"+dsDoiBong.get(i).banThua+"','"+dsDoiBong.get(i).hieuSo+"','"+dsDoiBong.get(i).diem+"')");
						
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
				PanelBangXepHang.model.setNumRows(0);
				try {
					ResultSet rs = dbconnect.getStmt().executeQuery("SELECT*FROM["+PanelDoiBong.maGiai+"_Bảng xếp hạng] ORDER BY Điểm DESC,[Hiệu số] DESC");
					int i=1;
					while(rs.next()) {
						String s = Integer.toString(i);
						PanelBangXepHang.model.addRow(new String[] {s,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)});
						i++;
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//tab1.update1();
				
				//for( int i=0;i<dsDoiBong.size();i++) {
					//dsDoiBong.get(i).xuat();
				//	System.out.print("Thuc hien");
				//}
			}	
	}
	

