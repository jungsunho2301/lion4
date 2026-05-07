package class3.policy;

public class LionAssignmentPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return true;
    }
}