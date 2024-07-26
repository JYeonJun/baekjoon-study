import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private Set<Set<String>> result = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        backtrack(new HashSet<>(), user_id, banned_id, 0);
        return result.size();
    }

    private void backtrack(Set<String> currentSet, String[] user_id, String[] banned_id, int index) {
        if (index == banned_id.length) {
            result.add(new HashSet<>(currentSet));
            return;
        }

        String bannedPattern = banned_id[index];
        for (String user : user_id) {
            if (currentSet.contains(user)) continue;
            if (matches(user, bannedPattern)) {
                currentSet.add(user);
                backtrack(currentSet, user_id, banned_id, index + 1);
                currentSet.remove(user);
            }
        }
    }

    private boolean matches(String user, String pattern) {
        if (user.length() != pattern.length()) return false;
        for (int i = 0; i < user.length(); i++) {
            if (pattern.charAt(i) != '*' && user.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}