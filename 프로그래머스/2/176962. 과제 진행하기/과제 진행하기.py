def solution(plans):
    parsed_plans = []
    for name, start, playtime in plans:
        h, m = map(int, start.split(":"))
        parsed_plans.append([name, h * 60 + m, int(playtime)])
    parsed_plans.sort(key = lambda x : x[1])
    
    stack, answer = [], []
    for i in range(len(parsed_plans) - 1):
        name, start, playtime = parsed_plans[i]
        next_start = parsed_plans[i + 1][1]
        
        gap = next_start - start
        if playtime > gap:
            stack.append([name, playtime - gap])
        else:
            answer.append(name)
            remain_time = gap - playtime
            while remain_time > 0 and stack:
                if stack[-1][1] <= remain_time:
                    name, time = stack.pop()
                    remain_time -= time
                    answer.append(name)
                else:
                    stack[-1][1] -= remain_time
                    remain_time = 0
    
    answer.append(parsed_plans[-1][0])
    while stack:
        answer.append(stack.pop()[0])
    return answer