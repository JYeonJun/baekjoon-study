import math

def solution(fees, records):
    default_time = fees[0]
    default_fee = fees[1]
    unit_time = fees[2]
    unit_fee = fees[3]

    car = list(set(map(lambda x: x.split()[1], records)))
    total_fees = {k: 0 for k in car}
    check = {}

    for record in records:
        tmp = record.split(' ')
        if tmp[1] not in check.keys():
            check[tmp[1]] = tmp[0]
        else:
            if tmp[-1] == 'OUT':
                out_time = time_to_minutes(tmp[0])
                in_time = time_to_minutes(check[tmp[1]])
                total_fees[tmp[1]] += out_time - in_time
                del check[tmp[1]]

    if check:
        for i in check.keys():
            out_time = 1439
            in_time = time_to_minutes(check[i])
            total_fees[i] += out_time - in_time

    answer = []

    for i in total_fees.items():
        if i[1] <= default_time:
            answer.append((i[0], default_fee))
        else:
            answer.append((i[0], default_fee + (math.ceil((i[1] - default_time) / unit_time) * unit_fee)))
    return list(map(lambda x: x[1], sorted(answer)))

def time_to_minutes(time_str):
    return int(time_str.split(':')[0]) * 60 + int(time_str.split(':')[1])