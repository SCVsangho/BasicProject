package project.dao;

import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import project.vo.Database;

public class PayDaoImpl implements PayDao {

	public static int receiptPrice = 0;

	@Override
	public void receipt() {

		Date time = new Date();
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd | HH:mm:ss");

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
			fw.write("------------결제금액  : " + PayDaoImpl.receiptPrice + "\n");
			fw.write("====================================\n");
			;
			fw.write("결제 시간 : " + t.format(time) + "\n");
			fw.write("이름 : " + Database.loginUser.getName() + "\t");
			fw.write("계정 : " + Database.loginUser.getId() + "\n");
			fw.write("번호 : " + Database.loginUser.getTel() + "\n");
			fw.flush();

			fw.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Override
	public void unReceipt() {
		Date time = new Date();
		SimpleDateFormat t = new SimpleDateFormat("yyyy-MM-dd | HH:mm:ss");

		int receiptSize = Database.tb_order.size();

		String[] txtMenu = new String[receiptSize];
		int[] txtPrice = new int[receiptSize];

		for (int i = 0; i < receiptSize; i++) {
			txtMenu[i] = Database.tb_order.get(i).getMenuName();
			txtPrice[i] = Database.tb_order.get(i).getMenuPrice();
		}

		try {
			File file = new File("unReceipt.txt"); // Directory Workspace Origin package

			FileWriter fw = new FileWriter(file, true);

			fw.write("******[[  결 제 취 소 영 수 증  ]]******\n\n\n\n");
			fw.write(" ***" + Database.loginUser.getName() + " 님이 취소하신 내역 입니다. ***\n\n\n");
			fw.write("====================================\n\n");

			for (int i = 0; i < receiptSize; i++) {
				fw.write("결제 취소 품목  : " + txtMenu[i] + "         " + txtPrice[i] + "\n");

			}
			fw.write("====================================\n");
			fw.write("----------결제취소 금액  : " + PayDaoImpl.receiptPrice + "\n");
			fw.write("====================================\n");
			;
			fw.write("결제 시간 : " + t.format(time) + "\n");
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
