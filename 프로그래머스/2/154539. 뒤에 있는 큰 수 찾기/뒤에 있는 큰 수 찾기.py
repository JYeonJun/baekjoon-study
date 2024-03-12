def solution(numbers):
    stack = []
    len_numbers = len(numbers)
    answer = [-1] * len_numbers
    
    for i in range(len_numbers):
        while stack and numbers[stack[-1]] < numbers[i]:
            answer[stack.pop()] = numbers[i]
        stack.append(i)
    return answer