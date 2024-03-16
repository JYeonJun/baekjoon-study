def solution(s):
    arr = [int(s) for s in s.split()]
    return f'{min(arr)} {max(arr)}'