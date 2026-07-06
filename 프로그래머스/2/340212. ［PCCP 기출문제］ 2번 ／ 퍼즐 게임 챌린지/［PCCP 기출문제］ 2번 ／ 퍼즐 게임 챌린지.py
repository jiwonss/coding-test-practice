def solution(diffs, times, limit):
    answer = 0
    
    start, end = 1, max(diffs)
    while start <= end:
        level = (start + end) // 2
        
        total_time, time_prev = 0, 0
        for diff, time_cur in zip(diffs, times):
            if diff <= level:
                total_time += time_cur
            else: 
                total_time += (diff - level) * (time_cur + time_prev) + time_cur
            time_prev = time_cur
        
        if total_time <= limit:
            answer = level
            end = level - 1
        else:
            start = level + 1
        
    return answer