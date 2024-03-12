def solution(n):
    three_str = ten_to_three(n)
    return three_to_ten(three_str)

def ten_to_three(num):
    word = ''
    while num:
        word += str(num % 3)
        num //= 3
    return word

def three_to_ten(num):
    ten_num = 0
    len_num = len(num)
    for ch in num:
        ten_num += 3 ** (len_num - 1) * int(ch)
        len_num -= 1
    return ten_num