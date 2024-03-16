def solution(today, terms, privacies):
    answer = []
    
    today_year, today_month, today_date = [int(x) for x in today.split('.')]
    terms_dic = {t.split()[0]: int(t.split()[1]) for t in terms}
    
    for idx, privacy in enumerate(privacies):
        collect_date, term = privacy.split()
        collect_year, collect_month, collect_day = [int(x) for x in collect_date.split('.')]
        
        period = terms_dic[term]
        # 유효기간을 더해서 연도와 월을 계산
        collect_year += (collect_month + period - 1) // 12
        collect_month = (collect_month + period - 1) % 12 + 1
        
        # 유효기간의 마지막 날 계산 (하루 빼기)
        if collect_day == 1:
            if collect_month == 1:
                collect_year -= 1
                collect_month = 12
                collect_day = 28
            else:
                collect_month -= 1
                collect_day = 28
        else:
            collect_day -= 1
        
        # 유효기간이 지난 정보를 확인
        if (collect_year < today_year or
            (collect_year == today_year and collect_month < today_month) or
            (collect_year == today_year and collect_month == today_month and collect_day < today_date)):
            answer.append(idx + 1)
    
    return answer
