   package project.vo;

import java.util.ArrayList;


public class Database {

   /*유저 데이터*/
   public static ArrayList<UserData> tb_user = new ArrayList<UserData>();
   
   /*매뉴 데이터*/
   public static ArrayList<MenuData> tb_menu = new ArrayList<MenuData>(); 
   
   /*공지사항 데이터*/
   public static ArrayList<NoticeData> tb_notice = new ArrayList<NoticeData>(); 
   
   /*장바구니*/
   public static ArrayList<MenuData> tb_cart = new ArrayList<MenuData>();
   
   /*리뷰 데이터*/
   public static ArrayList<ReviewData> tb_review = new ArrayList<ReviewData>();
   
   /*주문내역*/
   public static ArrayList<Integer> item = new ArrayList<>();
   
   /*로그인 시 데이터 추가 = 로그아웃 시 데이터 삭제*/
   public static UserData loginUser = null;
   
   
}
