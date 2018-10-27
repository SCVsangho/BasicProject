package project.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import project.vo.Database;

public class PayDaoImpl implements PayDao {

	public static int receiptPrice = 0;

	@Override
	public void receipt() {

		int receiptSize = Database.tb_cart.size();

		String[] txtMenu = new String[receiptSize];
		int[] txtPrice = new int[receiptSize];

		for (int i = 0; i < receiptSize; i++) {
			txtMenu[i] = Database.tb_cart.get(i).getMenuName();
			txtPrice[i] = Database.tb_cart.get(i).getMenuPrice();
		}

		try {
			File file = new File("Receipt.txt"); // Directory Workspace Origin package

			FileWriter fw = new FileWriter(file, true);

			fw.write("******[[ 영 수 증  ]]******\n\n\n\n");
			fw.write(" ***" + Database.loginUser.getName() + " 님이 결제하신 내역 입니다. ***\n\n\n");
			fw.write("====================================\n\n");

			for (int i = 0; i < receiptSize; i++) {
				fw.write("결제품목  : " + txtMenu[i] + "         " + txtPrice[i] + "\n");

			}
			fw.write("====================================\n");
			fw.write("------------결제금액  : " + PayDaoImpl.receiptPrice +"\n");
			fw.write("====================================\n");;
			fw.write("이름 : " + Database.loginUser.getName() + "\t");
			fw.write("계정 : " + Database.loginUser.getId() + "\n");
			fw.write("번호 : " + Database.loginUser.getTel() + "\n");
			fw.flush();

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
