package class3;

import class3.role.Lion;
import class3.role.Staff;
import class3.role.User;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("========== 🦁 아기사자 정보 입력 ==========");
        System.out.print("👤 이름: "); String lName = sc.nextLine();
        System.out.print("🎓 전공: "); String lMajor = sc.nextLine();
        System.out.print("📌 기수: "); int lGen = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String lPart = sc.nextLine();
        System.out.print("🆔 학번: "); String lId = sc.nextLine();

        User lion = new Lion(lName, lMajor, lGen, lPart, lId);

        System.out.println("\n========== 👨‍🏫 운영진 정보 입력 ==========");
        System.out.print("👤 이름: "); String sName = sc.nextLine();
        System.out.print("🎓 전공: "); String sMajor = sc.nextLine();
        System.out.print("📌 기수: "); int sGen = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트 (백엔드/프론트엔드/기획/디자인): "); String sPart = sc.nextLine();
        System.out.print("⭐ 직책 (대표/부대표/파트장/멘토): "); String sRole = sc.nextLine();

        User staff = new Staff(sName, sMajor, sGen, sPart, sRole);

        System.out.println("\n========== 📋 결과 출력 ==========");
        lion.printInfo();
        staff.printInfo();

        sc.close();
    }
}