package class3.policy;

public class StaffAssignmentPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return false;
    }
}