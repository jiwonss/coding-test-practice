def solution(s):
    answer = []
    for x in s:
        count, stack = 0, []
        for c in x:
            stack.append(c)
            if len(stack) >= 3 and stack[-3:] == ['1', '1', '0']:
                for _ in range(3):
                    stack.pop()
                count += 1
                
        base = "".join(stack)
        idx = "".join(stack).rfind('0')
        add = '110' * count
        
        if idx == -1:
            result = add + base
        else:
            result = base[:idx + 1] + add + base[idx + 1:]
        answer.append(result)
                
    return answer