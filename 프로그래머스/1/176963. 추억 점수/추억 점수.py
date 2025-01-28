def solution(name, yearning, photo):
    answer = []
    score = {n : y for n, y in zip(name, yearning)}
    for p in photo:
        memory_score = 0
        for person in p:
            if not score.get(person):
                continue
            memory_score += score[person]
        answer.append(memory_score)
    return answer