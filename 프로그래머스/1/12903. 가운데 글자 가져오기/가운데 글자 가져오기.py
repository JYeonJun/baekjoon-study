def solution(s):
    len_s = len(s)
    is_even = len(s) & 1 == 0
    half_idx_s = len_s // 2
    return s[half_idx_s-1:half_idx_s + 1] if is_even else s[half_idx_s]