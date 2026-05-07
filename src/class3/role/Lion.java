package class3.role;

import class3.policy.AssignmentPolicy;
import class3.policy.LionAssignmentPolicy;

public class Lion extends User {
    private String studentId;

    public Lion(String name, String major, int generation, String part, String studentId) {
        super(name, major, generation, part);
        this.studentId = studentId;
    }

    @Override
    public AssignmentPolicy getAssignmentPolicy() {
        return new LionAssignmentPolicy();
    }

    @Override
    public String getRoleName() {
        return "아기사자";
    }

    @Override
    public String getDetails() {
        return String.format("👤 이름: %s | 🎓 전공: %s | 📌 기수: %d | 💻 파트: %s\n🆔 학번: %s",
                getName(), getMajor(), getGeneration(), getPart(), studentId);
    }
}