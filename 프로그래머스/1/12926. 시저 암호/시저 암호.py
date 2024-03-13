def solution(s, n):
    
    A_ord, Z_ord, a_ord, z_ord = ord('A'), ord('Z'), ord('a'), ord('z')
    print(f'A_ord = {A_ord}, Z_ord = {Z_ord}')
    print(f'a_ord = {a_ord}, z_ord = {z_ord}')
    
    s_list = list(s)
    for i, ch in enumerate(s_list):
        if ch.isalpha():
            ch_ord = ord(ch)
            result_ord = ch_ord + n
            if ch.isupper() and result_ord > Z_ord: # 대문자인 경우
                result_ord = (result_ord - Z_ord - 1) + A_ord
            elif ch.islower() and result_ord > z_ord: # 소문자인 경우
                result_ord = (result_ord - z_ord - 1) + a_ord
            s_list[i] = chr(result_ord)
    
    return ''.join(s_list)