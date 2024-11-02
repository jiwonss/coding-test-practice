from sys import stdin

input = stdin.readline


def solve():
    T = int(input())
    for _ in range(T):
        sound = input().split()

        animal_sound = []
        while True:
            sound_input = input().strip()

            if sound_input == "what does the fox say?":
                break

            animal_sound.append(sound_input.split()[2])

        for s in sound:
            if s not in animal_sound:
                print(s, end=" ")
        print()


if __name__ == "__main__":
    solve()
