package Object;

public class DoiBong {
	String maDoiBong;
	int soTran=0;
	int thang=0;
	int thua=0;
	int hoa=0;
	int banThang=0;
	int banThua=0;
	int hieuSo=0;
	int diem=0;
	public DoiBong() {
		
	}
	public DoiBong(String maDoiBong, int soTran, int thang, int thua, int hoa, int banThang, int banThua, int hieuSo,
			int diem) {
		super();
		this.maDoiBong = maDoiBong;
		this.soTran = soTran;
		this.thang = thang;
		this.thua = thua;
		this.hoa = hoa;
		this.banThang = banThang;
		this.banThua = banThua;
		this.hieuSo = hieuSo;
		this.diem = diem;
	}
	public String getMaDoiBong() {
		return maDoiBong;
	}
	public void setMaDoiBong(String maDoiBong) {
		this.maDoiBong = maDoiBong;
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
	public int getThua() {
		return thua;
	}
	public void setThua(int thua) {
		this.thua = thua;
	}
	public int getHoa() {
		return hoa;
	}
	public void setHoa(int hoa) {
		this.hoa = hoa;
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
	
}
