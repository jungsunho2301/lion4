package package1;

import class3.role.*;
import java.util.*;

public class Main {
    // 제약사항: List<User> 타입 선언 및 초기화
    private static List<User> memberList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= 🦁 멤버 관리 시스템 (Step 1) =========");
            System.out.println("1. 멤버 등록");
            System.out.println("2. 전체 멤버 조회");
            System.out.println("3. 이름으로 검색");
            System.out.println("4. 종료");
            System.out.print("선택: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> registerMember();
                case "2" -> showAllMembers();
                case "3" -> searchByName();
                case "4" -> {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }

    private static void registerMember() {
        System.out.println("\n--- 📝 멤버 등록 ---");
        System.out.print("역할 선택 (1: 아기사자, 2: 운영진): ");
        String type = sc.nextLine();

        System.out.print("👤 이름: ");
        String name = sc.nextLine();

        // 중복 검사: List를 순회하며 동일한 이름이 있는지 확인
        for (User user : memberList) {
            if (user.getName().equals(name)) {
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("🎓 전공: "); String major = sc.nextLine();
        System.out.print("📌 기수: "); int gen = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트: "); String part = sc.nextLine();

        if (type.equals("1")) {
            System.out.print("🆔 학번: "); String studentId = sc.nextLine();
            memberList.add(new Lion(name, major, gen, part, studentId));
        } else {
            System.out.print("⭐ 직책: "); String staffRole = sc.nextLine();
            memberList.add(new Staff(name, major, gen, part, staffRole));
        }
        System.out.println("✅ 등록 완료: " + name);
    }

    private static void showAllMembers() {
        System.out.println("\n--- 📋 전체 멤버 목록 ---");
        if (memberList.isEmpty()) {
            System.out.println("등록된 멤버가 없습니다.");
        } else {
            for (int i = 0; i < memberList.size(); i++) {
                User u = memberList.get(i);
                System.out.printf("%d. [%s] %s - %d기\n", i + 1, u.getRoleName(), u.getName(), u.getGeneration());
            }
            System.out.println("📊 총 " + memberList.size() + "명");
        }
    }

    private static void searchByName() {
        System.out.print("\n🔍 검색할 이름: ");
        String name = sc.nextLine();

        for (User user : memberList) {
            if (user.getName().equals(name)) {
                System.out.println("\n✨ [검색 결과]");
                user.printInfo(); // User 클래스에 정의된 상세 출력 메서드 호출
                return;
            }
        }
        System.out.println("❌ 해당 이름의 멤버를 찾을 수 없습니다.");
    }
}