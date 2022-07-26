package kr.or.ddit.basic;



public class _0523EnumPlanetTest {
	public enum Planet {수성(2439),금성(6052),지구(6371),화성(3390),목성(69911),토성(58232),천왕성(25362),해왕성(24622);
		
		int KM;
		private Planet(int radius) {
			KM = radius;
		}
		
		public int getKM() {
			return KM;
		}
		
	}

	public static void main(String[] args) {
		System.out.println("행성의 면적");
		Planet[] enumArr = Planet.values();
		for(Planet s : enumArr) {
			System.out.println(s.name() + " : " + s.getKM() + "   면적 : " + s.getKM()*s.getKM()*Math.PI*4 +"Km²");
		}
	}
}