#include <iostream>
#include <Windows.h>
#include <random>

CRITICAL_SECTION mtx;
bool numberGuessed = false;
int secretNumber = 0;

DWORD WINAPI generateSecretNumber(LPVOID lpParam) {
    while (!numberGuessed) {
        EnterCriticalSection(&mtx);
        secretNumber = rand() % 100 + 1;
        std::cout << "Thread 1: New secret number is generated: " << secretNumber << std::endl;
        LeaveCriticalSection(&mtx);
        Sleep(2000); 
    }
    return 0;
}

DWORD WINAPI guessNumber(LPVOID lpParam) {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> distr(1, 100);
    while (!numberGuessed) {
        Sleep(500); 

        EnterCriticalSection(&mtx);

        int guess = distr(gen);
        std::cout << "Thread 2: Guessing " << guess << std::endl;

        if (guess == secretNumber) {
            std::cout << "Thread 2: Guessed the number " << secretNumber << std::endl;
            numberGuessed = true;
        }
        LeaveCriticalSection(&mtx);
    }
    return 0;
}

int main() {
    srand(static_cast<unsigned>(time(nullptr)));
    InitializeCriticalSection(&mtx);

    HANDLE threads[2];
    threads[0] = CreateThread(nullptr, 0, generateSecretNumber, nullptr, 0, nullptr);
    threads[1] = CreateThread(nullptr, 0, guessNumber, nullptr, 0, nullptr);

    WaitForMultipleObjects(2, threads, TRUE, INFINITE);

    CloseHandle(threads[0]);
    CloseHandle(threads[1]);

    DeleteCriticalSection(&mtx);

    std::cout << "Game Over!" << std::endl;

    return 0;
}