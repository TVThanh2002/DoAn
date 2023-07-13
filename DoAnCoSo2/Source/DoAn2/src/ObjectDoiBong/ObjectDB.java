package ObjectDoiBong;

public class ObjectDB {
	String maDoi;
	String tenDoi;
	int soTran = 0;
	int thang = 0;
	int hoa = 0;
	int thua = 0;
	int banThang = 0;
	int banThua = 0;
	int hieuSo = 0;
	int diem = 0;
	public String getMaDoi() {
		return maDoi;
	}
	public void setMaDoi(String maDoi) {
		this.maDoi = maDoi;
	}
	public String getTenDoi() {
		return tenDoi;
	}
	public void setTenDoi(String tenDoi) {
		this.tenDoi = tenDoi;
	}
	public int getSoTran() {
		return soTran;
	}
	public void setSoTran(int soTran) {
		this.soTran = soTran;
	}
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getHoa() {
		return hoa;
	}
	public void setHoa(int hoa) {
		this.hoa = hoa;
	}
	public int getThua() {
		return thua;
	}
	public void setThua(int thua) {
		this.thua = thua;
	}
	public int getBanThang() {
		return banThang;
	}
	public void setBanThang(int banThang) {
		this.banThang = banThang;
	}
	public int getBanThua() {
		return banThua;
	}
	public void setBanThua(int banThua) {
		this.banThua = banThua;
	}
	public int getHieuSo() {
		return hieuSo;
	}
	public void setHieuSo(int hieuSo) {
		this.hieuSo = hieuSo;
	}
	public int getDiem() {
		return diem;
	}
	public void setDiem(int diem) {
		this.diem = diem;
	}
	public ObjectDB() {
		super();
	}
	public ObjectDB(String maDoi, String tenDoi, int soTran, int thang, int hoa, int thua, int banThang, int banThua,
			int hieuSo, int diem) {
		super();
		this.maDoi = maDoi;
		this.tenDoi = tenDoi;
		this.soTran = soTran;
		this.thang = thang;
		this.hoa = hoa;
		this.thua = thua;
		this.banThang = banThang;
		this.banThua = banThua;
		this.hieuSo = hieuSo;
		this.diem = diem;
	}

	
}
