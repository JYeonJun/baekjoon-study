def solution(s):
    s_list = list(s)
    return ''.join(sorted(s_list, reverse=True))