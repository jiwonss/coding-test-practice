def solution(schedules, timelogs, startday):
    day = [i % 7 + 1 for i in range(startday - 1, startday + 7 - 1)]
    limit_schedules = []
    for schedule in schedules:
        if (schedule + 10) % 100 < 60:
            limit_schedules.append(schedule + 10)
        else:
            div, mod = divmod(schedule + 10, 100)
            limit_schedules.append((div + 1) * 100 + (mod % 60))

    answer = 0
    for i, timelog in enumerate(timelogs):
        for d, t in zip(day, timelog):
            if d in [6, 7]:
                continue
            if t > limit_schedules[i]:
                break
        else:
            answer += 1
    return answer