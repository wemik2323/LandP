#include <iostream>
#include <thread>
#include <mutex>
#include <random>
#include <chrono>

std::mutex mtx;
bool numberGuessed = false;
int secretNumber = 0;

void generateSecretNumber() {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> distr(1, 100);

    while (!numberGuessed) {
        std::unique_lock<std::mutex> lock(mtx);
        secretNumber = distr(gen);
        std::cout << "Thread 1: New secret number is generated: " << secretNumber << std::endl;
        lock.unlock();
        std::this_thread::sleep_for(std::chrono::seconds(2));
    }
}

void guessNumber() {
    std::random_device rd;
    std::mt19937 gen(rd());
    std::uniform_int_distribution<> distr(1, 100);

    while (!numberGuessed) {
        std::this_thread::sleep_for(std::chrono::milliseconds(500));

        std::unique_lock<std::mutex> lock(mtx);
        int guess = distr(gen);
        std::cout << "Thread 2: Guessing " << guess << std::endl;

        if (guess == secretNumber) {
            std::cout << "Thread 2: Guessed the number " << secretNumber << std::endl;
            numberGuessed = true;
        }
    }
}

int main() {
    std::thread generatorThread(generateSecretNumber);
    std::thread playerThread(guessNumber);

    generatorThread.join();
    playerThread.join();

    std::cout << "Game Over!" << std::endl;

    return 0;
}