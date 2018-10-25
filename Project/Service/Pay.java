package project.service;

public interface Pay {
	
	
	/*tb_cart에 있는 MenuData를 결제하기*/ 
	void pay();
	
	/*결제 한 내역을 환불하기*/
	void returnpay();
	
	
}
