package practica3_cenafilosofos;

public class fork extends mutex{ 
		int available=0;
		public void takefork() { 
			available++;
			lock(); 
		}
		
		public void relasefork() { 
			if(available>0) {
				available--;
			}
			unlock();  
		}

		public boolean isavaliable() {  
				if(available==0) {
					return true;
				}else {
					return false;
				}
		}
}
