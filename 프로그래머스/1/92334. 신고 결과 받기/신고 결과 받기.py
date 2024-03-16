from collections import defaultdict

def solution(id_list, report, k):
    answer = [0] * len(id_list)
    report_dict = defaultdict(set)  # 각 유저가 신고한 대상의 집합
    reported_count = defaultdict(int)  # 각 유저가 신고당한 횟수

    for r in report:
        reporter, reported = r.split()
        if reported not in report_dict[reporter]:
            report_dict[reporter].add(reported)
            reported_count[reported] += 1
    
    for reporter, reported_users in report_dict.items():
        for reported in reported_users:
            if reported_count[reported] >= k:
                answer[id_list.index(reporter)] += 1
                
    return answer
