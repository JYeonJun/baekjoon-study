def solution(price, money, count):
    answer = -1
    fee = 0
    
    for i in range(1, count + 1):
        print(f'i={i}')
        fee += price * i

    change = (money - fee)
    return 0 if change >= 0 else change * -1