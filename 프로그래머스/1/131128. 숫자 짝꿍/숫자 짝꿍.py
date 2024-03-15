def solution(X, Y):
    answer = ''
    for i in range(9, -1, -1):
        i_str = str(i)
        answer += (i_str * min(X.count(i_str), Y.count(i_str)))
    
    if answer == '':
       return '-1' 
    elif answer[0] == '0':
        return '0'
    else:
        return answer