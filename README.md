Ітераційний метод розв'язку систем рівнянь

--- 
Дана програма може використовується для знаходження розв'язків систем рівнянь з 4 змінними.

Коефацієнти при невідових задані безпосередньо в програмі 
у вигляді дво-вимірного масиву array = {{5, 1, -1, 1}, {1, -4, 1, -1}, {-1, 1, 4, 1}, {1, 2, 1, -5}}.

Вектор, в якому задана права частина кожного з 4 рівнянь
заданий окремим масивом b = {3*m, m-6, 15-m, m+2};

Початкове приближення задаэться у вигляді масиву approach = {0.7*m, 1, 2, 0.5};

Результати кожної ітерації записуються в масив iterationResult.

Для веревірки точності обчислень, тобто порівняня і-тої ітерації з і-1 ітерацією 
введено масив iterationCheck.

Згадно алгоритму, спочатку визначається детермінант матриці array через утворення нулів
під нижньою діагоналлю та перемноження елементів по діагоналі. Якщо дискримінант > 0 - 
продовжуємо розрахунки. Функция для знаходження детермінанту є універсальною для будь-якої квадратної матриці.


Далі виконується перевірка сходимості, тобто перевіряється різниця між 
сумою модулів недіагональних елементів і значенням модуля діагонального
елементу. Якщо умова сходимості виконується, продовжуємо розрахунки.

Потім запускається цикл, де виконуються 9 ітерації, а також перевірка точності обчислень.
Точність обчислень не має бути нижчою за 0.005

Після останньої ітерації відбувається перевірка правильності обчислень, відповіді підставляються у
відповідні рівняння.
