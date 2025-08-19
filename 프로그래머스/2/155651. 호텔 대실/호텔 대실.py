def solution(book_time):
    total_minutes = 60 * 24
    time_table = [0 for _ in range(total_minutes)]
    for start, end in book_time:
        start_minutes = 60 * int(start[:2]) + int(start[3:])
        end_minutes = 60 * int(end[:2]) + int(end[3:]) + 10
        
        if end_minutes > total_minutes:
            end_minutes = total_minutes
        
        for time in range(start_minutes, end_minutes):
            time_table[time] += 1
    return max(time_table)