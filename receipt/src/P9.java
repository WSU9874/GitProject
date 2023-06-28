import java.text.NumberFormat;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class P9 {

	public static void main(String[] args) {
		NumberFormat k20_df = NumberFormat.getNumberInstance(); // 3자리 마다 콤마찍는 클래스 선언
		Calendar k20_calt = Calendar.getInstance();
		// 캘린더 클래스를 불러온다
		SimpleDateFormat k20_sdt = new SimpleDateFormat("YYYY-MM-dd HH:mm"); // 캘린더 형식 정함
		SimpleDateFormat k20_sdt2 = new SimpleDateFormat("YYYYMMdd"); // 캘린더 형식 정함
		SimpleDateFormat k20_sdt3 = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss"); // 캘린더 형식 정함
		// simpledateformat클래스로 날짜 형식을 정한다

		String[] k20_itemname = { "해피 홈 SAFE365 핸드워시", "디즈니 빅사이즈 선물", "진로소주", "디즈니푸 틴케이스", "MJ스텐포크", "감자링", "빅힘찬스티커",
				"꼬깔콘", "아이스트레이20구", "다이제", "달고나", "굽은형점화라이터", "대형세탁비누", "몽쉘", "국플랩30cm", "A4용지", "토마토", "아이언맨티셔츠",
				"빼빼로", "동물의숲 냅킨", "상어밥", "콘푸로스트 씨리얼", "신지카토종이컵25p", "떠먹는 초코칩", "연양갱", "오예스", "가죽장갑", "죠리퐁",
				"떼어쓰는 마스킹 테이프", "포카칩" };
		// 뮨자열 배열 선언후 내용 삽입

		int[] k20_price = { 2000, 2500, 3300, 2500, 100, 50, 600, 800, 1000, 900, 400, 500, 1000, 2000, 5000, 2000,
				3000, 4000, 5000, 6000, 7000, 8000, 7000, 8000, 6000, 2000, 1000, 3000, 4000, 6000 };
		// 정수 배열 선언후 숫자넣음
		int[] k20_num = { 2, 4, 1, 1, 10, 5, 6, 4, 2, 6, 1, 2, 6, 4, 5, 4, 1, 2, 3, 4, 3, 4, 5, 1, 8, 6, 4, 1, 2, 5 };
		// 정수 배열 선언후 숫자넣음
		int k20_sum = 0;
		// 정수변수 선언후 0으로 초기화
		int k20_taxFreeSum = 0;
		// 정수변수 선언후 0으로 초기화

		for (int k20_i = 0; k20_i < k20_num.length; k20_i++) { // i가 0부터 num의 길이만큼 반복 i는 1씩증가
			k20_sum = k20_sum + k20_num[k20_i]; // i번째 num배열 누적
		}

		boolean[] k20_taxfree = { false, false, false, false, false, false, true, false, true, true, true, true, false,
				false, false, false, false, false, false, true, false, false, false, false, true, false, false, false,
				false, true };
		// 불리안 배열 선언후 값 입력

		int k20_iPrice = 0; // 정수변수 선언후 0으로 초기화

		System.out.printf("emart         이마트 죽전점(031)888-1234\n"); // 글자출력
		System.out.printf("              206-86-50913 강희석\n"); // 글자출력
		System.out.printf("              용인 수지구 포은대로 552\n"); // 글자출력
		System.out.println(); // 줄바꿈
		System.out.printf("영수증 미지참시 교환/환불 불가\n"); // 글자출력
		System.out.printf("정상상품에 한함, 30일 이내(신선 7일)\n"); // 글자출력
		System.out.printf("※일부 브랜드매장 제외(매장 고지물참조)\n"); // 글자출력
		System.out.printf("교환/환불 구매점에서 가능(결제카드 지참)\n"); // 글자출력
		System.out.printf("\n");// 줄바꿈
		System.out.printf("[구 매]%s     POS:0011-9861\n", k20_sdt.format(k20_calt.getTime()));
		// 글자출력후 sdt의 날짜 출력
		System.out.printf("-----------------------------------------\n"); // 선출력
		System.out.printf("  상 품 명         단  가  수량    금  액\n"); // 글자출력
		System.out.printf("-----------------------------------------\n"); // 선출력

		for (int k20_i = 0; k20_i < k20_itemname.length; k20_i++) { // i가 0부터 itemname의 길이만큼 반복 i는 1씩증가

			String k20_aa = k20_itemname[k20_i]; // 문자열 aa는 배열itemname의 i번째
			k20_aa = k20_aa + "                         "; // aa의 뒤에 공백추가
			byte[] k20_bb = k20_aa.getBytes(); // 문자열 aa을 바이트로 변환
			k20_aa = new String(k20_bb, 0, 14); // 위의 바이트배열을 14바이트로 자름

			int k20_cnt = 0; // 정수 cnt를 초기화

			for (int k20_j = 0; k20_j < 14; k20_j++) { // j는 0부터 13까지 반복 j는 루프마다 1씩 증가
				if (k20_bb[k20_j] < 0) { // 만약 j번째 바이트배열이 0보다 작으면
					k20_cnt++; // cnt를 1증가시킨다 -> 한글의 개수
				}
			}
			if (k20_cnt % 2 == 1) { // 만약 cnt가 2로 나눈값의 나머지가 1이면
				if (k20_bb[13] < 0) { // 만약 18번째 바이트배열이 0보다작으면
					k20_aa = new String(k20_bb, 0, 13) + " "; // 18번째에 공백추가
				} else { // 그게아니면 그냥 출력
					k20_aa = new String(k20_bb, 0, 13);

				}
			}

			if (k20_taxfree[k20_i] == true) { // i번째 불리안값이 트루면
				System.out.print("* "); // 별출력
			} else { // 아니면 공백출력
				System.out.print("  ");
			}

			System.out.printf("%s%11s%3s%11s\n", k20_aa, k20_df.format(k20_price[k20_i]), k20_df.format(k20_num[k20_i]),
					k20_df.format((k20_price[k20_i] * k20_num[k20_i]))); // 글자출력
			k20_iPrice = k20_iPrice + (k20_price[k20_i] * k20_num[k20_i]);

			if (k20_taxfree[k20_i] == true) {
				k20_taxFreeSum = k20_taxFreeSum + (k20_price[k20_i] * k20_num[k20_i]); ////////// 면세금액누적
			}

			if (k20_i % 5 == 4) { // 만약 나눈값의 나머지가 4이면
				System.out.printf("-----------------------------------------\n"); // 선출력
			}
		}
		// 세금은 올려받아야함
		// 세금 = 세후금액 - 세전금액(내림)
		double k20_tax = 0.1;
		int k20_priceTotal = (int) ((k20_iPrice - k20_taxFreeSum) / (1 + k20_tax));// 과세물품 = (총가격-면세) / 1+0.1

		System.out.println();
		System.out.printf("               총 품목 수량           %3d\n", k20_itemname.length); // 글자출력
		System.out.printf("            (*)면 세  물 품   %11s\n", k20_df.format(k20_taxFreeSum)); // 글자출력
		System.out.printf("               과 세  물 품   %11s\n", k20_df.format(k20_priceTotal)); // 글자출력
		System.out.printf("               부   가   세   %11s\n",
				k20_df.format(k20_iPrice - k20_priceTotal - k20_taxFreeSum));
		// 부가세 =총합계 -과세-면세
		System.out.printf("               합        계   %11s\n", k20_df.format(k20_iPrice)); // 글자출력
		System.out.printf("결 제 대 상 금 액             %11s\n", k20_df.format(k20_iPrice)); // 글자출력
		System.out.printf("-----------------------------------------\n"); // 선출력
		System.out.printf("0012 KEB 하나       541707**0484/35860658\n"); // 글자출력
		System.out.printf("카드결제(IC)          일시불 / %10s \n", k20_df.format(k20_iPrice)); // 글자출력
		System.out.printf("-----------------------------------------\n");// 선출력
		System.out.printf("           [신세계포인트 적립]\n"); // 글자출력
		System.out.printf("홍*두 고객님의 포인트 현황입니다.\n"); // 글자출력
		int point = (int) (k20_iPrice * 0.001); // 정수형 변수선언후 point는 총금액의 0.001배로함
		System.out.printf("금회발생포인트      9350**9995    %7s\n", k20_df.format(point)); // 글자출력
		System.out.printf("누계(가용)포인트     %8s(%10s)\n", k20_df.format(5473 + point), k20_df.format(5473));
		// 원래 포인트에서 위의 받은 포인트값 추가후 출력
		System.out.printf("*신세계포인트 유효기간은 2년입니다.\n"); // 글자출력
		System.out.printf("-----------------------------------------\n");// 선출력
		System.out.printf("    구매금액기준 무료주차시간 자동부여\n"); // 글자출력
		System.out.printf("차량번호 :                       34저****\n");// 선출력
		k20_calt.add(Calendar.HOUR_OF_DAY, -2);
		// 위의 날짜에서 2시간전으로 변경
		System.out.printf("입차시간 :            %s\n", k20_sdt3.format(k20_calt.getTime()));
		// 변경된 날짜 출력
		System.out.printf("-----------------------------------------\n"); // 선출력
		System.out.printf("캐셔:084599 양00                     1150\n"); // 글자출력
		System.out.printf("       %s/00119861/00164980/31\n", k20_sdt2.format(k20_calt.getTime()));
		// 글자출력후 sdt2날짜 출력

	}

}
