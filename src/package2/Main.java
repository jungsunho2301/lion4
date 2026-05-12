package package2;

import class3.role.*;
import java.util.*;

public class Main {
    private static List<User> memberList = new ArrayList<>();
    // 제약사항: 키는 파트명(String), 값은 해당 파트의 멤버 리스트(List<User>)
    private static Map<String, List<User>> partMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n========= 🦁 멤버 관리 시스템 (Step 2) =========");
            System.out.println("1. 멤버 등록\n2. 전체 멤버 조회\n3. 이름으로 검색\n4. 파트별 조회\n5. 종료");
            System.out.print("선택: ");

            String choice = sc.nextLine();
            if (choice.equals("5")) break;

            switch (choice) {
                case "1" -> registerMember();
                case "2" -> showAllMembers();
                case "3" -> searchByName();
                case "4" -> showByPart();
                default -> System.out.println("잘못된 입력입니다.");
            }
        }
    }

    private static void registerMember() {
        System.out.print("\n역할(1:아기사자, 2:운영진): ");
        String type = sc.nextLine();
        System.out.print("👤 이름: "); String name = sc.nextLine();

        for (User u : memberList) {
            if (u.getName().equals(name)) {
                System.out.println("❌ 등록 실패: 이미 존재하는 이름입니다.");
                return;
            }
        }

        System.out.print("🎓 전공: "); String major = sc.nextLine();
        System.out.print("📌 기수: "); int gen = Integer.parseInt(sc.nextLine());
        System.out.print("💻 파트: "); String part = sc.nextLine();

        User newUser;
        if (type.equals("1")) {
            System.out.print("🆔 학번: "); String studentId = sc.nextLine();
            newUser = new Lion(name, major, gen, part, studentId);
        } else {
            System.out.print("⭐ 직책: "); String staffRole = sc.nextLine();
            newUser = new Staff(name, major, gen, part, staffRole);
        }

        // 1. List에 추가
        memberList.add(newUser);

        // 2. Map에 파트별로 추가 (해당 파트 리스트가 없으면 새로 생성)
        partMap.computeIfAbsent(part, k -> new ArrayList<>()).add(newUser);

        System.out.println("✅ 등록 완료: " + name);
    }

    private static void showByPart() {
        System.out.println("\n--- 📂 파트별 조회 ---");
        if (partMap.isEmpty()) {
            System.out.println("등록된 데이터가 없습니다.");
            return;
        }
        System.out.println("📁 등록된 파트: " + partMap.keySet());
        System.out.print("조회할 파트명 입력: ");
        String partName = sc.nextLine();

        List<User> filteredList = partMap.get(partName);

        if (filteredList == null || filteredList.isEmpty()) {
            System.out.println("❌ 해당 파트에 속한 멤버가 없습니다.");
        } else {
            System.out.println("\n✨ [" + partName + " 파트 멤버]");
            for (int i = 0; i < filteredList.size(); i++) {
                User u = filteredList.get(i);
                System.out.printf("%d. %s (%s) - %d기\n", i + 1, u.getName(), u.getRoleName(), u.getGeneration());
            }
        }
    }

    // Step 1과 동일한 메서드들
    private static void showAllMembers() {
        System.out.println("\n--- 📋 전체 멤버 목록 ---");
        for (int i = 0; i < memberList.size(); i++) {
            User u = memberList.get(i);
            System.out.printf("%d. [%s] %s - %d기\n", i + 1, u.getRoleName(), u.getName(), u.getGeneration());
        }
        System.out.println("📊 총 " + memberList.size() + "명");
    }

    private static void searchByName() {
        System.out.print("\n🔍 검색할 이름: ");
        String name = sc.nextLine();
        for (User u : memberList) {
            if (u.getName().equals(name)) {
                u.printInfo();
                return;
            }
        }
        System.out.println("❌ 검색 결과가 없습니다.");
    }
}