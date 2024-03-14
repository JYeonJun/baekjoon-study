def solution(a, b, n):
    answer = 0
    
    while n >= a:
        # 교환으로 얻을 수 있는 콜라의 수
        k = n // a
        # 교환 후 남은 빈 병의 수
        n %= a
        # 교환으로 얻은 콜라 병을 answer에 추가
        answer += k * b
        # 교환으로 얻은 콜라 병을 다음 교환의 빈 병으로 추가
        n += k * b
    
    return answer