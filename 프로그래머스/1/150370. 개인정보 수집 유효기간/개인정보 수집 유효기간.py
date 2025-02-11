def solution(today, terms, privacies):
    y, m, d = map(int, today.split("."))
    today_result = y * 12 * 28 + m * 28 + d
    
    terms_info = {}
    for term in terms:
        a, b = term.split()
        terms_info[a] = int(b) * 28

    answer = []
    for i, privacy in enumerate(privacies):
        date, p_type = privacy.split()
        y, m, d = map(int, date.split("."))
        date_result = y * 12 * 28 + m * 28 + d
        if date_result + terms_info[p_type] <= today_result:
            answer.append(i + 1)
    return answer