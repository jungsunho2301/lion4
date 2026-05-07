package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.StaffAssignmentPolicy;

public class Staff extends User {
    private String role;

    public Staff(String name, String major, int generation, String part, String role) {
        super(name, major, generation, part);
        this.role = role;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new StaffAssignmentPolicy();
    }

    @Override
    public String getRoleName() {
        return "운영진";
    }

    @Override
    public String getDetails() {
        return String.format("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n⭐ 직책: %s",
                getName(), getMajor(), getGeneration(), getPart(), role);
    }
}